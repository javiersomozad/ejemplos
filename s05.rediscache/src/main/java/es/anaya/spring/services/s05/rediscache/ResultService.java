package es.anaya.spring.services.s05.rediscache;

import java.util.Date;
import java.util.List;

public interface ResultService {
	public List<Result> findAll ();
	public List<Result> findByEvent (String event);
	public List<Result> findByDate (Date date);
	public Result findById(Long id);
	public Result create (Result result);
	public Result update (Result result);
	public void   remove (Result result);	
}
