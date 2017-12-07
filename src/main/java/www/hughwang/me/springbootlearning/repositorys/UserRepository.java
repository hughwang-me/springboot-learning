package www.hughwang.me.springbootlearning.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import www.hughwang.me.springbootlearning.entities.User;

/**
 * @author hughwang
 * @date 2017/12/7 14:04
 */
public interface UserRepository extends JpaRepository<User , Integer> {
}
