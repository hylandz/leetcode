package com.xlx.leetcode.other.inheritance;

import java.util.ArrayList;

/**
 * @author xielx on 2019/9/22
 */
public class User {
	
	private Integer id;
	private String name;
	
	public User(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public static void main(String[] args) {
		
		ArrayList arrayList = new ArrayList();
		
		System.out.println(new User(1, "user1") == new User(1, "user1"));
		System.out.println(new User(1, "user1").equals(new User(1, "user1")));
		System.out.println(new User(1, "user1").equals(new User(2, "user2")));
	}
	
	// 请在这里覆盖equals方法，使得两个相同ID的用户equals返回true
	
	/**
	 * 借鉴String类重写equals()方法
	 * String s1,s2;
	 * 1.s1==s2 return true
	 * 2.s1 instanceof s2 return
	 */
	@Override
	public boolean equals(Object obj) {
		//1.对象相等
		if (this == obj) {
			return true;
		}
		
		//2.类名相等
		if (!(obj instanceof User)) {
			return false;
		}
		//3.id相同
		User user = (User) obj;
		return user.id.equals(id);
	}
	
	
	@Override
	public int hashCode() {
		return this.id != null ? this.id.hashCode() : 0;
	}
}
