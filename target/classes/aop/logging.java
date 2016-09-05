package aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class logging {
	
	
	@Before("execution(* dao.FilmDao.addFilm(..))")
	public void dobefore(){
		System.out.println("Before Insert Film Data");
	}
	
	@After("execution(* dao.FilmDao.addFilm(..))")
	public void doafter(){
		System.out.println("After Insert Film Data");
	}
	
}

