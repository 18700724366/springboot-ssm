package xian.woniuxy.config.web;


import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import xian.woniuxy.job.MyFirstJob;

@Configuration
public class QuartzConfig {
    @Bean
    public JobDetail jobDetail(){
        return JobBuilder.newJob(MyFirstJob.class).storeDurably().build();
    }

    @Bean
    public Trigger trigger(){
        return TriggerBuilder.newTrigger()
                .withIdentity("trigger","group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("30/5 * * * * ?"))
                .forJob(jobDetail())
                .build();
    }
}
