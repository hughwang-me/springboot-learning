package www.hughwang.me.springbootlearning.services;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisServiceTest {

    @Autowired
    RedisService redisService;

    @Test
    public void test1() throws Exception {
        log.warn("start test");
        redisService.hSet("hlist", "key1", "val1");
        redisService.hSet("hlist", "key2", "val2");
        List<String> list = redisService.hKeys("hlist");
        log.warn(list.toString());

        log.warn("increment={}", redisService.increment("increment", 1));
        log.error("increment val={}" , redisService.get("increment"));
        log.warn("h_increment={}", redisService.increment("h_increment","increment", 1));
        log.error("h_increment hval={}" , redisService.hGet("h_increment","increment"));
    }


}