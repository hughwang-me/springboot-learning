package www.hughwang.me.springbootlearning.services;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.*;

/**
 * @author hughwang
 * @date 2017/12/4 16:20
 */
@Service
public class RedisService {

    @Autowired
    StringRedisTemplate redisTemplate;

    public boolean set(String key, String value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public String get(String key) {
        try {
            return redisTemplate.opsForValue().get(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> keys(String pattern) {
        try {
            Set<String> set = redisTemplate.keys(pattern);
            return Lists.newArrayList(set);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean hasKey(String key){
        try {
            return redisTemplate.hasKey(key);
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean del(String key){
        try {
            redisTemplate.delete(key);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean del(Collection<String> keys){
        try {
            redisTemplate.delete(keys);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean expire(String key){
        try{
            redisTemplate.delete(key);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean expire(Collection<String> keys){
        try{
            redisTemplate.delete(keys);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean hSet(String key , String field , String value){
        try {
            redisTemplate.opsForHash().put(key , field , value);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public String hGet(String key , String field){
        try {
            return redisTemplate.opsForHash().get(key , field).toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public List<String> hKeys(String pattern){
        try {
            Set<Object> set = redisTemplate.opsForHash().keys(pattern);
            Iterator<Object> iterator = set.iterator();
            List<String> list = Lists.newArrayList();
            while (iterator.hasNext()){
                list.add(iterator.next().toString());
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public List<String> hValues(String key){
        try {
            List<Object> values = redisTemplate.opsForHash().values(key);
            List<String> list = Lists.newArrayList();
            for (Object obj:values){
                list.add(obj.toString());
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public long hLen(String key){
        try {
            return redisTemplate.opsForHash().size(key);
        }catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }

    public boolean hKeyHas(String key , String field){
        try{
            return redisTemplate.opsForHash().hasKey(key , field);
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public long increment(String key , long length){
        try{
            return redisTemplate.opsForValue().increment(key , length);
        }catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }

    public long increment(String key , String field , long length){
        try{
            return redisTemplate.opsForHash().increment(key , field , length);
        }catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }
}
