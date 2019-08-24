package com.xlx.leetcode.javajdk8;

/**
 * 性别枚举
 *
 * @author xielx on 2019/8/23
 */
public enum GenderEnum {

	//public static final GenderEnum MALE = new GenderEnum(1,"男");
	MALE(1,"男"),
	FEMALE(2,"女");

	private Integer num;
	private String sex;

	GenderEnum(Integer num,String sex){
		this.num = num;
		this.sex = sex;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public static void main(String[] args) {
		//上面2个枚举对象等价于

	}

}
