package www.hughwang.me.springbootlearning.quartz;

import lombok.extern.slf4j.Slf4j;
import www.hughwang.me.springbootlearning.utils.DateUtil;

/**
 * @author hughwang
 * @date 2017/12/4 15:31
 */
@Slf4j
public class ConfigTask {

    public void jobStart(){
        log.error(" ### ConfigTask jobStart thread = {}  | time : {} " ,Thread.currentThread().getId(),  DateUtil.currentFormatted());
    }

}
