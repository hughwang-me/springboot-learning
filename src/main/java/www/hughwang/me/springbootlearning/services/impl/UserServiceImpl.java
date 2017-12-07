package www.hughwang.me.springbootlearning.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import www.hughwang.me.springbootlearning.entities.User;
import www.hughwang.me.springbootlearning.repositorys.UserRepository;
import www.hughwang.me.springbootlearning.services.UserService;

import java.util.List;

/**
 * @author hughwang
 * @date 2017/12/7 14:05
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> queryAll() {
        return userRepository.findAll();
    }

    @Override
    public User insert(User user) {
        return userRepository.save(user);
    }
}
