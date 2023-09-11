package com.gopal.Gzip.AOP;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* your.package..*.*(..))")
    public void logMethodEntry() {
        // Log method entry
        logger.info("Method entry: {}", getCurrentMethodName());
    }

    @AfterReturning(pointcut = "execution(* your.package..*.*(..))", returning = "result")
    public void logMethodExit(Object result) {
        // Log method exit
        logger.info("Method exit: {} with result: {}", getCurrentMethodName(), result);
    }

    private String getCurrentMethodName() {
        // Get the current method name
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length >= 4) {
            return stackTrace[3].getMethodName();
        }
        return "UnknownMethod";
    }
}

