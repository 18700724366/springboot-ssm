package xian.woniuxy.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyFirstJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sdf.format(new Date());
//        System.out.println(format);
    }
}
