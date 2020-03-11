package com.xlx.leetcode.other.proxy.statics;

/**
 * 小吴-追求者
 *
 * @author xielx on 2019/9/19
 */
public class Target implements IProxy {
	
	private String name;
	private Integer age;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getAge() {
		return age;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public Target(String name, Integer age) {
		this.name = name;
		this.age = age;
	}
	
	//小李的想法
	@Override
	public void sayHello() {
		System.out.println(this.name + ":你好啊");
	}
	
	@Override
	public void sendFollowers() {
		System.out.println(this.name + ":明天一起去看电影吗?");
	}
}
