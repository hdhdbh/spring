package com.dynamicproxy.update;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

public class MyInterceptor implements InvocationHandler {
    private Object target;
    private List<Interceptor> interceptors;

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public List<Interceptor> getInterceptors() {
        return interceptors;
    }

    public void setInterceptors(List<Interceptor> interceptors) {
        this.interceptors = interceptors;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        for (Interceptor interceptor : interceptors) {
            interceptor.before();
        }
        method.invoke(this.target, args);
        for (Interceptor interceptor : interceptors) {
            interceptor.after();
        }
        return null;
    }
}
