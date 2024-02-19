package com.vtxlab.bootcamp.bootcampsbforum.config;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class ScheduledConfig {

  // @Scheduled(fixedRate = 2000)
  public void fixedRateTask() throws InterruptedException {
    System.out.println("start");
    Thread.sleep(1000);
    System.out.println("end");
  }

  // @Scheduled(fixedDelay = 2000)
  public void fixedDelayTask() throws InterruptedException {
    System.out.println("start: fixedDelayTask" + System.currentTimeMillis());
    Thread.sleep(1000);
    System.out.println("end: fixedDelayTask" + System.currentTimeMillis());
  }

  // @Scheduled(cron = "*/5 * * * * ?") // every 5 sec, similar to fixedDelay
  @Scheduled(cron = "5 * * * * ?") // every 5 sec, similar to fixedDelay
  public void cronTask5() throws InterruptedException {
    System.out.println("hello world 5");
  }

  @Scheduled(cron = "10 * * * * ?") // every 5 sec, similar to fixedDelay
  public void cronTask10() throws InterruptedException {
    System.out.println("hello world");
  }

}
