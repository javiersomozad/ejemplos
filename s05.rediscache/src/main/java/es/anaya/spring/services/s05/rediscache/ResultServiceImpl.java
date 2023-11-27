package es.anaya.spring.services.s05.rediscache;

import java.util.Date;
import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

@Service
public class ResultServiceImpl 
  implements ResultService {

  private ResultRepository resultRepository;
  
  public ResultServiceImpl(ResultRepository resultRepository) {
    this.resultRepository = resultRepository;
  }

  @Cacheable(value = "find-all")
  @Override
  public List<Result> findAll() {
    return (List<Result>) resultRepository.findAll();
  }

  @Cacheable(value = "result-by-event")
  @Override
  public List<Result> findByEvent(String event) {
    return (List<Result>) resultRepository.findByEvent(event);
  }

  @Cacheable(value = "result-by-date")
  @Override
  public List<Result> findByDate(Date date) {
    return (List<Result>) resultRepository.findByDate(date);
  }

  @Caching(evict= {
      @CacheEvict(value = "result", key = "#id"),
      @CacheEvict(value = "find-all", key = "#id"),
      @CacheEvict(value = "result-by-event", key = "#id"),
      @CacheEvict(value = "result-by-date", key = "#id"),
      })
  @Override
  public Result findById(Long id) {
    return resultRepository.findById(id).get();
  }

  @Override
  public Result create(Result result) {
    return resultRepository.save(result);
  }

  @Caching(evict= {
      @CacheEvict(value = "result", key = "#id"),
      @CacheEvict(value = "find-all", key = "#id"),
      @CacheEvict(value = "result-by-event", key = "#id"),
      @CacheEvict(value = "result-by-date", key = "#id"),
      })
  @Override
  public Result update(Result result) {
    return resultRepository.save(result);
  }

  @Caching(evict= {
      @CacheEvict(value = "result", key = "#id"),
      @CacheEvict(value = "find-all", key = "#id"),
      @CacheEvict(value = "result-by-event", key = "#id"),
      @CacheEvict(value = "result-by-date", key = "#id"),
      })
  @Override
  public void remove(Result result) {
    resultRepository.delete(result);
  }

}
