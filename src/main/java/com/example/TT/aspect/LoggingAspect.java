package com.example.TT.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
@Slf4j
public class LoggingAspect {

    @Pointcut("within(com.example.TT.controller.impl.*)")
    public void pointCut() {
    }

    @Around("pointCut()")
    public Object logAround(ProceedingJoinPoint point) throws Throwable {
        long time = System.nanoTime();

        log.info("Начало работы метода {}", point.getSignature().getName());

        log.debug("Вход: {}.{}() с аргументами = {}", point.getSignature().getDeclaringTypeName(),
                point.getSignature().getName(), Arrays.toString(point.getArgs()));

        try {
            Object result = point.proceed();
            time = System.nanoTime() - time;

            log.debug("Выход: {}.{}() с результатом = {}", point.getSignature().getDeclaringTypeName(),
                    point.getSignature().getName(), result);

            log.info("Конец работы метода {}. Время выполнения: {}", point.getSignature().getName(), time);

            return result;
        } catch (IllegalArgumentException e) {
            log.error("Недопустимый аргумент: {} в {}.{}()", Arrays.toString(point.getArgs()),
                    point.getSignature().getDeclaringTypeName(), point.getSignature().getName());
            throw e;
        }
    }

    @AfterThrowing(pointcut = "pointCut()", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
        log.error("ОШИБКА В {}.{}() С ПРИЧИНОЙ = {}", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(), e.getCause() != null ? e.getCause() : "NULL");
    }

}