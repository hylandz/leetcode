package com.xlx.leetcode.proxy.statics;

/**
 * 代理者-小李
 *
 * @author xielx on 2019/9/19
 */
public class Proxy implements IProxy {
	
	//委托人
	private Target wu;
	
	public Proxy(Target wu) {
		this.wu = wu;
	}
	
	@Override
	public void sayHello() {
		this.wu.sayHello();
	}
	
	@Override
	public void sendFollowers() {
		this.wu.sendFollowers();
	}
}
