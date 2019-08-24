package com.xlx.leetcode.javajdk8;

import java.util.Optional;

/**
 * Optional类
 *
 * @author xielx on 2019/8/24
 */
public class OptionalDemo {

	public static Integer sum(Optional<Integer> a,Optional<Integer> b){
		System.out.println("第一个参数值存在:" + a.isPresent());
		System.out.println("第二个参数值存在:" + b.isPresent());

		//orElse(default),值存在返回该值,不存在返回默认值
		Integer v3 = a.orElse(new Integer(0));

		//get(),获取值,值必须存在
		Integer v4 = b.get();
		return v3 + v4;
	}

	public static void main(String[] args) {
		Integer v1 = null;
		Integer v2 = new Integer(10);

		//ofNullable()允许传入null值
		Optional<Integer> op1 = Optional.ofNullable(v1);

		//of()不允许传入null
		Optional<Integer> op2 = Optional.of(v2);

		System.out.println(sum(op1,op2));
	}
}
