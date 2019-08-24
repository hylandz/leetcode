package com.xlx.leetcode.javajdk8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Lambda语法
 *
 * @author xielx on 2019/8/23
 */
public class LambdaDemo{

	/**
	 * 集合排序
	 */
	public void sortjava7(List<String> list){
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});

		//String s1="";
		//Lambda语法
		Collections.sort(list,(s1,s2) -> s1.compareTo(s2));

	}

  public static int re(){
		return 0;
	}


	public static void main(String[] args) {
		List<String> names1 = new ArrayList<String>();
		names1.add("Google ");
		names1.add("Runoob ");
		names1.add("Taobao ");
		names1.add("Baidu ");
		names1.add("Sina ");

		names1.forEach(s -> System.out.println(s));
		//多线程
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("当前线程:" + Thread.currentThread().getName());
			}
		}).start();

		//多线程lambda写法
		new Thread(() -> System.out.println("当前线程:" + Thread.currentThread().getName())).start();

	}

}
