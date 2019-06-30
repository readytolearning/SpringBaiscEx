package com.pvc;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
public class Schedulers {
    @Scheduled(fixedDelay = 10000)
    public void fixedDelay() {
        System.out.println("Fixed Delay - 10000 - Current time is :: " + Calendar.getInstance().getTime());
    }

    @Scheduled(fixedDelayString = "${scheduler.fixedDelay}000")
    public void fixedDelayWithProperty() {
        System.out.println("every 15 seconds Current time is :: " + Calendar.getInstance().getTime());
    }

    @Scheduled(fixedDelayString = "${scheduler.fixedDelay:40}000")
    public void fixedDelayWithPropertyDefaultValue() {
        System.out.println("every 15 seconds Current time is :: " + Calendar.getInstance().getTime());
    }

    @Scheduled(initialDelay = 1000, fixedRate = 10000)
    public void initialDelayWithFixedRate() {
        System.out.println("initialDelay 1000 and fixedRate - 10000 Current time is :: " + Calendar.getInstance().getTime());
    }

    @Scheduled(cron = "0/30 * * * * ?")
    public void cronWithHardCodedValues() {
        System.out.println("every 30 seconds Current time is :: " + Calendar.getInstance().getTime());
    }

    @Scheduled(cron = "${scheduler.job}")
    public void cronWithPropertyValues() {
        System.out.println("every 10 seconds Current time is :: " + Calendar.getInstance().getTime());
    }

    @Scheduled(fixedRateString = "#{@getConfigRefreshValue}")
    public void loadConfigurations() {
        System.out.println("every 12 seconds");
    }

    @Bean
    public String getConfigRefreshValue() {
        System.out.println("getConfigRefreshValue refreshed");
        return "12000";
    }

}
