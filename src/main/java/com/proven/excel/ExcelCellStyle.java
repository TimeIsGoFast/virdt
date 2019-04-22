/**  
* @Title: ExcelCellStyle.java  
* @Package com.proven.excel  
* @Description: TODO(用一句话描述该文件做什么)  
* @author Administrator  
* @date 2019年4月22日  
* @version V1.0  
*/ 
package com.proven.excel;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFDataFormat;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**  
* @ClassName: ExcelCellStyle  
* @Description: TODO(这里用一句话描述这个类的作用)  
* @author Administrator  
* @date 2019年4月22日  
*    
*/
public class ExcelCellStyle {
	public static XSSFCellStyle getXSSFCellStyle(XSSFWorkbook wb){
		
		XSSFCellStyle style = wb.createCellStyle();
		//设置边框
		style.setBorderBottom(BorderStyle.THIN); //下边框
		style.setBorderLeft(BorderStyle.THIN);//左边框
		style.setBorderTop(BorderStyle.THIN);//上边框
		style.setBorderRight(BorderStyle.THIN);//右边框
		
		return style;
		
	}
	
	//date format style
	public static XSSFCellStyle getDateFormatCellStyle(XSSFWorkbook wb){
		XSSFCellStyle style = wb.createCellStyle();
		//设置边框
		style.setBorderBottom(BorderStyle.THIN); //下边框
		style.setBorderLeft(BorderStyle.THIN);//左边框
		style.setBorderTop(BorderStyle.THIN);//上边框
		style.setBorderRight(BorderStyle.THIN);//右边框
		
        XSSFDataFormat format= wb.createDataFormat();
        style.setDataFormat(format.getFormat("yyyy年m月d日"));
		
		return style;
	}
}
