package com.example.veterinaria.annotations;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Aspect
@Component
public class CustomAnnotationResolver {

    @Around("@annotation(CustomAnnotation)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        var httpServletRequest = obtenerHttpServletRequest(joinPoint.getArgs());
        String authorization = httpServletRequest.getHeader("Authorization");
        if (authorization == null) {
            System.out.println("horror");
        }
        Object result = joinPoint.proceed(); // Execute the annotated method
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println(joinPoint.getSignature() + " executed in " + executionTime + "ms");
        return result;
    }

    private HttpServletRequest obtenerHttpServletRequest(Object [] args) {

        return (HttpServletRequest) Stream.of(args)
                .filter(arg -> arg instanceof HttpServletRequest)
                .findFirst()
                .get();
    }
}