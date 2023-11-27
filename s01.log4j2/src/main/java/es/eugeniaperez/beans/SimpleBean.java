package es.eugeniaperez.beans;

import org.springframework.stereotype.Component;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Component
public class SimpleBean {
    private static final Logger logger = LogManager.getLogger(SimpleBean.class);
    
	public SimpleBean () {}
	
	public void doSomething () {
		 	logger.debug("Bean(Debug)> debug level message");
	        logger.info("Bean(Info)> info level message");
	        logger.warn("Bean(Warn)> warn level message");
	        logger.error("Bean(Error)> error level message");
	        logger.fatal("Bean(Fatal)> fatal level message");
	        System.out.println("Current level is: " + logger.getLevel().toString());
	}
}
