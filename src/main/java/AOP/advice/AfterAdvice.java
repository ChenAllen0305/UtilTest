package AOP.advice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @title: AfterAdvice
 * @Author
 * @Date: 2021/4/8
 */
public class AfterAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("后置通知after方法执行");
    }
}
