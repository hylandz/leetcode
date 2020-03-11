package com.xlx.leetcode.other.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 代理类
 *
 * @author xielx on 2019/9/19
 */
public class Proxyer implements InvocationHandler {
	
	//任意委托类型
	private Object target;
	
	public Proxyer(Object target) {
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("Object[] args=" + Arrays.deepToString(args));
		System.out.println("Method method=" + method.getName());
		
		Object invoke = method.invoke(target, args);
		return null;
	}
}
