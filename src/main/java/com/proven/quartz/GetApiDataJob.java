package com.proven.quartz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.proven.base.vo.DataParam;

@Component
public class GetApiDataJob {
	private static final Logger logger = LoggerFactory.getLogger(GetApiDataJob.class);
	@Autowired
	private GetDataService GetDataService;
	
	@Scheduled(cron="0 0 23/23 * * ? ")
	public void execute(){
		DataParam param = new DataParam();
		//logger.info("scheduled job run!");
	}
}
