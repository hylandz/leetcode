package com.xlx.leetcode.other.proxy.statics;

/**
 * 测试
 *
 * 代理类只能服务于一个类型,
 * 代理类和被代理类都需要实现相同接口,
 * @author xielx on 2019/9/19
 */
public class StaticTest {
	
	public static void main(String[] args) {
		Target target = new Target("小李",18);
		Proxy proxy = new Proxy(target);
		
		proxy.sayHello();
		proxy.sendFollowers();
		
		
	}
}
