package www.hughwang.me.springbootlearning.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @author hughwang
 * @date 2017/12/7 14:12
 */
@Entity
@Data
public class User {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private int age;

    private String mark;

    private Timestamp timestamp;

}
