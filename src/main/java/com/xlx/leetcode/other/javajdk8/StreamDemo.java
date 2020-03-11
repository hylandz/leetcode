package com.xlx.leetcode.other.javajdk8;

import java.util.*;
import java.util.stream.Collectors;

/**
 * stream串行流:filter,sorted,map,collect
 * parallelStream并行流:
 * @author xielx on 2019/8/23
 */
public class StreamDemo {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("view","delete","create","update",null);
		//stream串行流:集合->流-->过滤-->流转换为集合
		List<String> per =  list.stream().filter(s -> s!=null).collect(Collectors.toList());
		//per.forEach(s -> System.out.println(s));
		per.forEach(System.out::println);

		//map用于映射每个元素到对应的结果
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		numbers.stream().map(i -> i *i).distinct().collect(Collectors.toList());


		//filter方法用于通过设置的条件过滤出元素
		List<String>strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
		Long count = strings.stream().filter(s -> s.isEmpty()).count();

		System.out.println("串行流:" + count);
		//limit方法用于获取指定数量的流
		Random random = new Random();
		random.ints().limit(10).forEach(System.out::println);
		//sorted 方法用于对流进行排序
		random.ints().limit(10).sorted().forEach(System.out::println);

		//parallelStream并行流
		Long paraCount = strings.parallelStream().filter(str -> str.isEmpty()).count();
		System.out.println("并行流:" + paraCount);

		//统计
		List<Integer> number = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		IntSummaryStatistics stat = number.stream().mapToInt(x -> x).summaryStatistics();
		System.out.println("最大数:" + stat.getMax());
		System.out.println("最小数:" + stat.getMin());
		System.out.println("和:" + stat.getSum());
		System.out.println("平均数:" + stat.getAverage());
	}
}
