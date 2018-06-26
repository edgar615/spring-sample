//package com.github.edgar615.spring.enable;
//
//import com.sun.activation.registries.LogSupport;
//
///**
// * 使用Cglib的方式实现代理
// *
// * @author cml
// *
// * @param <T>
// */
//public class MyLogFactoryBeanInCglib<T> extends AbstractMyLogFactoryBean<T> implements MethodInterceptor {
//
//@SuppressWarnings("unchecked")
//@Override
//public void afterPropertiesSet() throws Exception {
//    Enhancer enhancer = new Enhancer();
//    enhancer.setCallback(this);
//    enhancer.setSuperclass(getMapperInterface());
//    setProxyTarget((T) enhancer.create());
//}
//
//@Override
//public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
//    return "CGLIB:" + getLogSupport().invoke(method, args);
//}
//
//}
//
////LogSupport的实现类
//public class DefaultLogSupport implements LogSupport {
//public Object invoke(Method method, Object[] args) {
//
//    MyLog myLog = method.getAnnotation(MyLog.class);
//
//    // 没有数据返回
//    if (null == myLog) {
//        return null;
//    }
//    String log = myLog.log();
//    if (null != args && args.length == 1) {
//        log += ":" + args[0];
//    }
//    System.out.println(log);
//    if (method.getReturnType() == String.class || method.getReturnType() == Object.class) {
//        return log;
//    }
//    return null;
//
//}
//}