package yapp.buddycon.batch.quartz;

import static org.quartz.CronScheduleBuilder.cronSchedule;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import yapp.buddycon.batch.job.NotificationQuartzJob;

@Configuration
public class QuartzConfig {

  @Bean
  public JobDetail NotificationJobDetail() {
    return JobBuilder.newJob().ofType(NotificationQuartzJob.class)
        .storeDurably()
        .withIdentity("Notification Job Detail")
        .withDescription("Notification Job Detail Description")
        .build();
  }

  @Bean
  public Trigger customJobTrigger(JobDetail customJobDetail) {
    return TriggerBuilder.newTrigger().forJob(customJobDetail)
        .withIdentity("Notification Job Trigger")
        .withDescription("Notification Job Trigger Description")
        .withSchedule(cronSchedule("0 0 11 * * ?"))
        .build();
  }

}
