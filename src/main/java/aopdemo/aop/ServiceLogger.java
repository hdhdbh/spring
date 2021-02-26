package aopdemo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class ServiceLogger {
    public void before(JoinPoint jp) {
        System.out.println("前置增强被执行");
        System.out.println("连接点对象: " + jp.getTarget().getClass().getName());
        System.out.println("连接点方法: " + jp.getSignature());
        System.out.println("连接点方法参数: ");
        Object[] arr = jp.getArgs();
        for (Object o : arr) {
            System.out.println("参数" + o);
        }
        System.out.println("前置增强结束");
    }

    public void after(JoinPoint jp) {
        System.out.println("后置最终增强被执行");
        System.out.println("前置最终增强结束");
    }

    public void afterReturn(Object ret) {
        System.out.println("后置增强被执行");
        System.out.println("后置增强结束");
    }

    public void afterThrow(Exception ex) {
        System.out.println("后置增强被执行,业务方法抛出异常");
        System.out.println("后置异常增强被执行" + ex.getMessage());
    }

    public boolean around(ProceedingJoinPoint ex) throws Throwable {
        System.out.println("环绕通知,目标方法植入织植入代码");
        boolean b = (boolean) ex.proceed(ex.getArgs());
        System.out.println("环绕通知,目标方法植入后织植入代码");
        return b;
    }
}
