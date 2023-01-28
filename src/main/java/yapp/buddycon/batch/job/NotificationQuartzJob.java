package yapp.buddycon.batch.job;

import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import yapp.buddycon.config.BeanUtil;

@PersistJobDataAfterExecution
@DisallowConcurrentExecution
@RequiredArgsConstructor
public class NotificationQuartzJob implements Job {

  private final JobLauncher jobLauncher;
  private final BeanUtil beanUtil;

  @SneakyThrows
  @Override
  public void execute(JobExecutionContext context) throws JobExecutionException {
    String now = LocalDateTime.now().toString();
    System.out.println("Notification_Quartz_Job Start : " + now);

    JobParameters parameters = new JobParametersBuilder()
        .addString("requestDate", now)
        .toJobParameters();

    org.springframework.batch.core.Job job =
        (org.springframework.batch.core.Job) beanUtil.getBean("simpleNotificationChunkJob");

    jobLauncher.run(job, parameters);
  }
}
