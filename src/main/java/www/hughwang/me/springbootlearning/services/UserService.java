package www.hughwang.me.springbootlearning.services;

import www.hughwang.me.springbootlearning.entities.User;

import java.util.List;

/**
 * @author hughwang
 * @date 2017/12/7 14:05
 */

public interface UserService {

     List<User> queryAll();

     User insert(User user);

}
