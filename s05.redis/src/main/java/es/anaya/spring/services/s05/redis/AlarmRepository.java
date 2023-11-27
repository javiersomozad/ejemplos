package es.anaya.spring.services.s05.redis;

import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AlarmRepository {
 
    private static final String KEY = "Alarm";
 
    @Autowired
    private RedisTemplate<String, Alarm> redisTemplate;
    
    private HashOperations hashOps;
 
    public AlarmRepository () {
    }
 
    @PostConstruct
    private void init() {
        hashOps = redisTemplate.opsForHash();
    }
     
    public void save(Alarm alarm) {
        hashOps.put(KEY, alarm.getId(), alarm);
    }
 
    public void update(Alarm alarm) {
        hashOps.put(KEY, alarm.getId(), alarm);
    }
 
    public Alarm findById(String id) {
        return (Alarm) hashOps.get(KEY, id);
    }
 
    public Map<String, Alarm> findAll() {
        return hashOps.entries(KEY);
    }
 
    public void delete(String id) {
        hashOps.delete(KEY, id);
    }
}