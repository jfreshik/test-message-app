package com.example.vuejs.security;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class SecurityChecker {

    @Pointcut("@annotation(SecurityCheck)")
    public void checkMethodSecurity() {}

    @Around("checkMethodSecurity()")
    public Object checkSecurity (ProceedingJoinPoint joinPoint) throws Throwable {
        log.debug("Checking method security...");
        // TODO check security
        Object result = joinPoint.proceed();
        return result;
    }
}
