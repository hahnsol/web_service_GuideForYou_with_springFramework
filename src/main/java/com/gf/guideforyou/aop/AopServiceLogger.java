package com.gf.guideforyou.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AopServiceLogger {

	@Pointcut("execution(* com.gf.guide_for_you.service..*Impl.*(..))")
	public void servicePointCut() {}
	
	@Around("servicePointCut()")
	public Object printLog(ProceedingJoinPoint pjp) throws Throwable {
		
		String logText = "=====" + pjp.getSignature().getName() + " 실행 시작 =====";
		System.out.println(logText);
		
		Object obj = pjp.proceed();
		
		logText = "=====" + pjp.getSignature().getName() + " 실행 완료 =====";
		System.out.println(logText);

		return obj;
	}
}
