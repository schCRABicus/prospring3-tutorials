package com.gmail.schcrabicus.prospring3.tutorials.ch7.introductions;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 21.01.13
 * Time: 8:06
 * To change this template use File | Settings | File Templates.
 */
public class IsModifiedMixin extends DelegatingIntroductionInterceptor implements IsModified {

    private boolean isModified;

    private Map<Method, Method> methodCache = new HashMap<Method, Method>();

    @Override
    public boolean isModified() {
        return isModified;
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        if (!isModified) {
            if ((invocation.getMethod().getName().startsWith("set"))
                    && (invocation.getArguments().length == 1)) {
                // invoke the corresponding get method to see
                // if the value has actually changed
                Method getter = getGetter(invocation.getMethod());
                if (getter != null) {

                    // modification check is unimportant
                    // for write only methods
                    Object newVal = invocation.getArguments()[0];
                    Object oldVal = getter.invoke(invocation.getThis(), null);
                    if((newVal == null) && (oldVal == null)) {
                        isModified = false;
                    } else if((newVal == null) && (oldVal != null)) {
                        isModified = true;
                    } else if((newVal != null) && (oldVal == null)) {
                        isModified = true;
                    } else {
                        isModified = (!newVal.equals(oldVal));
                    }
                }
            }
        }
        return super.invoke(invocation);
    }

    private Method getGetter(Method setter) {
        Method getter = null;
        // attempt cache retrieval.
        getter = (Method) methodCache.get(setter);
        if (getter != null) {
            return getter;
        }
        String getterName = setter.getName().replaceFirst("set", "get");
        try {
            getter = setter.getDeclaringClass().getMethod(getterName, null);
            // cache getter
            synchronized (methodCache) {
                methodCache.put(setter, getter);
            }
            return getter;
        } catch (NoSuchMethodException ex) {
            // must be write only
            return null;
        }
    }
}
