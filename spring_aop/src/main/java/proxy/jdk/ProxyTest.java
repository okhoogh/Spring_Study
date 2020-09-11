package proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        // 目标对象
        final Target target = new Target();

        // 增强对象
        final Advice advice = new Advice();

        // 返回值：动态代理对象
        TargetInterface proxy = (TargetInterface) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),      // 目标对象类加载器
                target.getClass().getInterfaces(),       // 目标对象接口字节码数组
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        advice.before();    // 前置增强
                        method.invoke(target, args);     // 执行目标方法
                        advice.after();     // 后置增强
                        return null;
                    }
                });

        proxy.save();
    }
}
