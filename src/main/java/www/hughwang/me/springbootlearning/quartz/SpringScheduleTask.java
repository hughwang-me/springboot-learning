package www.hughwang.me.springbootlearning.quartz;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import www.hughwang.me.springbootlearning.utils.DateUtil;

/**
 * @author hughwang
 * @date 2017/12/4 14:39
 */
//@Component
//@EnableScheduling //需要打开
@Slf4j
public class SpringScheduleTask {

    @Scheduled(fixedRate = 1000 * 20)
    public void simpleTask(){
        log.warn(" --- simpleTask thread = {}  | time : {} " ,Thread.currentThread().getId(),  DateUtil.currentFormatted());
    }

    @Scheduled(fixedDelay = 1000 * 30)
    public void simpleDelayTask(){
        log.warn(" === simpleDelayTask thread = {}  | time : {} " ,Thread.currentThread().getId(),  DateUtil.currentFormatted());
    }

    @Scheduled(fixedRate = 1000 * 30)
    public void simpleDelayCoTask(){
        log.warn(" @@@ simpleDelayCoTask thread = {}  | start time : {} " ,Thread.currentThread().getId(),  DateUtil.currentFormatted());
        try {
            Thread.sleep(40 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.warn(" @@@ simpleDelayCoTask thread = {}  | end time : {} " ,Thread.currentThread().getId(),  DateUtil.currentFormatted());
    }

    @Scheduled(cron = "10 */1 * * * ?")
    public void cronTask(){
        log.error(" $$$ cronTask thread = {}  | time : {} " ,Thread.currentThread().getId(),  DateUtil.currentFormatted());
    }

}
