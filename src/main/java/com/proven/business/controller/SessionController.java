package com.proven.business.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.proven.base.vo.BarData;
import com.proven.business.model.DeskUser;
import com.proven.business.model.SessionView;
import com.proven.business.service.DeskUserService;
import com.proven.business.service.MachineService;
import com.proven.business.service.SessionViewService;
import com.proven.excel.ExcelCellStyle;
import com.proven.parambean.SessionParam;
import com.proven.quartz.GetDataService;
import com.proven.system.model.User;
import com.proven.utils.SpringUtil;
import com.proven.utils.VirdtUtils;

@Controller
@RequestMapping("/session")
public class SessionController {
	
	private static final Logger logger = Logger.getLogger(SessionController.class);
	
	
	
	@Autowired
	private GetDataService getDataService;
	
	@Autowired
	private SessionViewService sessionViewService;
	
	@Autowired
	private DeskUserService deskUserService;
	
	@Autowired
	private MachineService machineService;
	/**
	 * get session index page
	 * @param model
	 * @return
	 */
	@RequestMapping("/render")
	public String render(Model model,SessionParam sessionParam){
		//according to time that transfer from front to select data
		/*List<SessionView> slist = new ArrayList<>();
		logger.info("deskgroupId="+sessionParam.getDeskgroupId()+",passTime="+sessionParam.getPassTime());
		
		slist = sessionViewService.selectByDeskgroupIdAndPassTime(sessionParam.getDeskgroupId(),sessionParam.getPassTime());
		//slist = sessionViewService.selectAllOrderByEndDate();
		//if end date is null,means the status is running,so set different time
		slist.stream().filter(session->("".equals(session.getEndDate())||session.getEndDate()==null)
				&&(!"".equals(session.getFailureDate())||session.getFailureDate()!=null))
		.forEach(se->se.setTimeDiff(DateFormatUtil.getTimeDiff(se.getStartDate(), new Date())));

		model.addAttribute("list", slist);*/
		if(StringUtils.isEmpty(sessionParam.getDeskgroupId())){
			sessionParam.setDeskgroupId("all");
			model.addAttribute("deskgroupId", "all");
		}
		if(StringUtils.isEmpty(sessionParam.getPassTime())){
			sessionParam.setPassTime("7d");
			model.addAttribute("passTime", "7d");
		}
		SpringUtil.setSession("sessionParam", sessionParam);
		model.addAttribute("deskgroupId", sessionParam.getDeskgroupId());
		model.addAttribute("passTime", sessionParam.getPassTime());
		return "business/session/session";
	}
	
	@RequestMapping("/refresh")
	@ResponseBody
	public void refresh(){
		getDataService.getUserData(null);
	}
	
	/**
	 * get current status
	 */
	@RequestMapping("/current")
	public String getCurrentStatus(Model model){
		String filter = "EndDate eq null";
		List<SessionView> list = getDataService.getCurrentStatus(filter);
		List<SessionView> newSessionViewList = new ArrayList<>();
		//获取当前的用户信息，用来filter该用户下面的交付组使用情况
		User currentUser = SpringUtil.getCurrentUser();		
		DeskUser duser = deskUserService.selectByKey(currentUser.getDeskUserId());
		String upn = duser.getUpn();
		List<String> groupsIdList = machineService.selectByUpn(upn);
		for (String str : groupsIdList) {
			if(!StringUtils.isEmpty(str)){
				List<SessionView> sessionList = list.stream()
						.filter(sessionView->str.equals(sessionView.getDesktopGroupId()))
						.collect(Collectors.toList());
				VirdtUtils.transferSessionViewBean(sessionList,newSessionViewList);
			}
			
		}
		//list.stream().filter(sessionView->sessionView.get)
		model.addAttribute("list", newSessionViewList);
		return "business/session/current_run_session";
	}
	//得到柱状图中的数据
	
	@RequestMapping("/refershBarData")
	@ResponseBody
	public BarData refershBarData(String date){
		/*String categore = "衬衫,羊毛衫,雪纺衫,裤子,高跟鞋,袜子";
		String data = "5, 20, 36, 10, 10, 20";
		logger.info("categore="+categore+",data="+data);
		*/
		return sessionViewService.refershBarData(date);
		
	}
	/**
	 * 
	* @Title: getPage  
	* @Description:  
	* @return PageInfo<SessionView> 
	* @throws
	* Author:Zeng,weilong
	* @date 2019年4月21日
	 */
	@RequestMapping("/getPage")
	@ResponseBody
	public PageInfo<SessionView> getPage(int row,int page,String search){
		SessionParam sessionParam = (SessionParam) SpringUtil.getObject("sessionParam");
		logger.info("sessionParam infomation passtime is"+sessionParam.getPassTime()+" groupId="+sessionParam.getDeskgroupId());
	    PageInfo<SessionView> pageInfo = sessionViewService.getPageData( row, page, search,sessionParam);
		return pageInfo;
	}
	
	/**
	 * 
	* @Title: getSesionTable  
	* @Description: 图表界面  
	* @return String 
	* @throws
	* Author:Zeng,weilong
	* @date 2019年4月21日
	 */
	@RequestMapping("/getSessionTable")
	public String getSesionTable(Model model){
		 return "business/session/sessionTable";
	}

	@RequestMapping("/export")
	public void exportExcel(HttpServletRequest request,HttpServletResponse res,SessionParam sessionParam) throws IOException{

		//get url of template.xlsx
		String path = SessionController.class.getClassLoader().getResource("templates/template.xlsx").getPath();
		logger.info("template.xlsx path= "+path);
		File templateFile = new File(path);
		InputStream in = new FileInputStream(templateFile);
		ServletOutputStream  out =  null;
		try {
			//get data from schema
			List<SessionView> svList = sessionViewService.getSessionDataByParam(sessionParam);
			XSSFWorkbook wb = new XSSFWorkbook(in);
			XSSFSheet sheet = wb.getSheetAt(0);
			//get cell style
			XSSFCellStyle style = ExcelCellStyle.getXSSFCellStyle(wb);
			XSSFCellStyle dateStyle = ExcelCellStyle.getDateFormatCellStyle(wb);
			int count=1;
			//fill the data to excel
			for(SessionView sv:svList){
				XSSFRow row = sheet.createRow(count);
				row.createCell(0).setCellValue(sv.getUserName());
				row.createCell(1).setCellValue(sv.getFullName());
				row.createCell(2).setCellValue(sv.getComputerName());
				row.createCell(3).setCellValue(sv.getMachineName());
				row.createCell(4).setCellValue(sv.getStartDate());
				row.createCell(5).setCellValue(sv.getEndDate());
				row.createCell(6).setCellValue(sv.getTimeDiff());
				
				row.getCell(0).setCellStyle(style);
				row.getCell(1).setCellStyle(style);
				row.getCell(2).setCellStyle(style);
				row.getCell(3).setCellStyle(style);
				row.getCell(4).setCellStyle(dateStyle);
				row.getCell(5).setCellStyle(dateStyle);
				row.getCell(6).setCellStyle(style);
				count++;
			}
			
			
			res.reset();
			res.setCharacterEncoding("utf-8");
			res.setContentType("application/vnd.ms-excel");  
			res.setHeader("Content-disposition", "attachment;filename=session.xlsx");
			out = res.getOutputStream();
			wb.write(out);
			out.flush();
			wb.close();
		}catch(Exception e){
			logger.info("export excel faild",e);
		}finally {
			
			if(out!=null){
				out.close();
			}
			
		}
	}
}
