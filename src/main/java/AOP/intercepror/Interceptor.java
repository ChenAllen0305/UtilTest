package AOP.intercepror;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @title: Interceptor
 * @Author
 * @Date: 2021/4/8
 */
public class Interceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("环绕通知before");
        Object resource = invocation.proceed();
        if (resource != null) {
            resource = ((String) resource).toUpperCase();
        }
        System.out.println("环绕通知After");
        return resource;
    }
}
