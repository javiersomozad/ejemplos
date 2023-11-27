package es.anaya.spring.web.s04.interceptors;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
 
@Component
public class SpyInterceptor implements HandlerInterceptor {
 
	Logger log = org.slf4j.LoggerFactory.getLogger(this.getClass());
  
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		System.out.println("PreHandle> Before Controller method call.");
		showParameters(request, response, object);	
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView model)
			throws Exception {
		System.out.println("PostHandle> Controller method Completed!");
		showParameters(request, response, object);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception arg3)
			throws Exception {
		System.out.println("After> Request Completed!");
		showParameters(request, response, object);
	}
	
	private void showParameters(HttpServletRequest request, HttpServletResponse response, Object object) {
		System.out.println("Request> " + request.getMethod()
								+ ": " + request.getRequestURL());
		if (request.getMethod().equals("POST")) {
			System.out.println("Request> " + request.getAttribute("comment"));
		}
		System.out.println("Response> " + response);
		System.out.println("Object> " + object);
	}
	
 
}