package com.master.job;

import com.master.dao.jobMapperDao;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2020/9/25 15:40
 */
@Component
public class DataInsertJob  extends QuartzJobBean {
    @Autowired
    private jobMapperDao dao;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        dao.insertRecordByJob("xjh");
    }
}
