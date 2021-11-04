package app.core.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {

	@Before("div()")
	public void beforeDiv(JoinPoint jp) {
		System.out.println("@Before: " + jp.getSignature().getName());
	}

	@After("div()")
	public void afterDiv(JoinPoint jp) {
		System.out.println("@After: " + jp.getSignature().getName());
	}

	@Pointcut("execution(String div(int, int))")
	public void div() {

	}

}
