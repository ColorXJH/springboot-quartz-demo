package com.master.service;

import com.master.dao.jobMapperDao;
import com.master.job.DataInsertJob;
import com.master.job.MyFactory;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2020/9/25 9:29
 */
@Service
public class JobService {
    private static final int TIME = 2;
    Scheduler scheduler= null;

    @Autowired
    private MyFactory myFactory;

    //创建全局scheduler
    @PostConstruct
    public void createFactory() throws SchedulerException {
        scheduler= StdSchedulerFactory.getDefaultScheduler();
        //自定义myFactory防止实例化job注入属性失败
        scheduler.setJobFactory(myFactory);
    }
    public void startJob(String name) throws SchedulerException {
        /*
         *在 Quartz 中， scheduler 由 scheduler 工厂创建：DirectSchedulerFactory 或者 StdSchedulerFactory。第二种工厂 StdSchedulerFactory 使用较多，
         *因为 DirectSchedulerFactory 使用起来不够方便，需要作许多详细的手工编码设置。
         */
        // 获取Scheduler实例
        //Scheduler scheduler= StdSchedulerFactory.getDefaultScheduler();
        scheduler.start();
        System.out.println("--------scheduler.start---------");
        //具体任务
        //默认的jobfactory创建job时不会将其以来的属性自动注入，需要自己重写一个jobfactory
        JobDetail jobDetail= JobBuilder.newJob(DataInsertJob.class).withIdentity("job1","group1").build();
        //触发时间，每5s执行一次
        SimpleScheduleBuilder simpleScheduleBuilder=SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(10).repeatForever();
        Trigger trigger=TriggerBuilder.newTrigger().withIdentity("trigger1","group1").startNow().withSchedule(simpleScheduleBuilder).build();
        //交由scheduler安排触发
        scheduler.scheduleJob(jobDetail,trigger);

    }


    public String endJob() throws SchedulerException {
        scheduler.shutdown();
        return "shutdown-now";
    }

}
