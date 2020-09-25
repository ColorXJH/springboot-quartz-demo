package com.master.controller;

import com.master.service.JobService;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2020/9/25 9:32
 */
@RestController
public class TestController {
    @Autowired
    private JobService service;

    @GetMapping("/ready")
    public String getReady(){
        return "yes i am ready";
    }


    @GetMapping("/startJob")
    public String startQuartzJob() throws SchedulerException {
        service.startJob("colorxjh");
        return "the job has started";
    }

    @GetMapping("/endJob")
    public String endQuartzJob() throws SchedulerException {
        service.endJob();
        return "the job has been shutdown";
    }
}
