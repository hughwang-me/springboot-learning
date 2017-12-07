package www.hughwang.me.springbootlearning.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import www.hughwang.me.springbootlearning.entities.User;
import www.hughwang.me.springbootlearning.repositorys.UserRepository;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void queryAll() throws Exception {
        log.warn("start");
        List<User> users = userRepository.findAll();
        log.warn("size : {}" , users.size());
        for (User user:users){
            log.warn("user => {}" ,user.toString());
        }

    }

    @Test
    public void insert() throws Exception{
        log.warn("start");
        User user = new User();
        Random random = new Random();
        int value = random.nextInt(20);
        user.setAge(value);
        user.setMark("mark");
        user.setName("王欢" + value);
        Calendar calendar = Calendar.getInstance();
        user.setTimestamp(new Timestamp(calendar.getTimeInMillis()));
        userRepository.save(user);
        log.warn("over");
    }

}