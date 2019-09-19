package com.xlx.leetcode.proxy.dynamic;

import java.lang.reflect.Proxy;

/**
 * 测试
 *
 * @author xielx on 2019/9/19
 */
public class DynamicTest {
	
	
	public static void main(String[] args) {
		//
		Target target = new Target("小王",20);
		//
		Proxyer proxy = new Proxyer(target);
		//委托类加载器,委托类的接口,代理类
		IProxy o = (IProxy) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), proxy);
		o.sayHello();
	}

	
}
