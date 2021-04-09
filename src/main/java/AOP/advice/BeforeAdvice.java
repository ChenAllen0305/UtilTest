package AOP.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @title: BeforeAdvice
 * @Author
 * @Date: 2021/4/8
 */
public class BeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("前置通知before方法执行");
    }
}
