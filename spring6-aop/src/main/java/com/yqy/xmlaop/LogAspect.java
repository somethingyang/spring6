package com.yqy.xmlaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//切面类
@Component(value = "logAspect") //表示当前类是一个组件，交给Spring容器管理
public class LogAspect {
    //前置通知
    @Before(value = "execution(* com.yqy.xmlaop.CalculatorImpl.*(..))")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("Logger-->前置通知,方法名称：" + methodName + ",参数：" + Arrays.toString(args));
    }

    //后置通知
    @After(value = "pointCut()")
    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger-->后置通知,方法名称："+ methodName);
    }

    //返回通知
    @AfterReturning(value = "execution(* com.yqy.xmlaop.CalculatorImpl.*(..))",returning = "result")
    public void afterReturningMethod(JoinPoint joinPoint,Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger-->返回通知,方法名称：" + methodName + "，返回结果：" + result);
    }

    //异常通知
    @AfterThrowing(value = "execution(* com.yqy.xmlaop.CalculatorImpl.*(..))",throwing = "e")
    public void afterThrowingMethod(JoinPoint joinPoint,Exception e) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger-->异常通知,方法名称：" + methodName + "，异常信息：" + e);
    }

    //环绕通知
    @Around(value = "com.yqy.xmlaop.LogAspect.pointCut()")
    public Object aroundMethod(ProceedingJoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        String argString = Arrays.toString(args);
        Object result = null;
        try {
            System.out.println("环绕通知==目标方法之前执行");

            //调用目标方法
            result = joinPoint.proceed();

            System.out.println("环绕通知==目标方法之后执行");
        }catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("环绕通知==目标方法抛出异常");
        }finally {
            System.out.println("环绕通知==目标方法执行结束");
        }
        return result;
    }

    //重用切入点表达式
    @Pointcut(value = "execution(* com.yqy.xmlaop.CalculatorImpl.*(..))")
    public void pointCut() {}
}
