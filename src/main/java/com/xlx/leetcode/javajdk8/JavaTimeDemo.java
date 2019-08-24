package com.xlx.leetcode.javajdk8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

/**
 * Java 8 日期时间 API
 * 以往:
 * java.util.Date:线程不安全,国际化处理麻烦,不支持时区
 * java8的java.time:
 * 1.Local(本地) − 简化了日期时间的处理，没有时区的问题。
 * 2.Zoned(时区) − 通过制定的时区处理日期时间
 *
 * @author xielx on 2019/8/24
 */
public class JavaTimeDemo {

	public static void main(String[] args) {

		//获取当前时间
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println("获取当前时间" + localDateTime);

		LocalDate date = localDateTime.toLocalDate();
		System.out.println("date:" + date);

		Month month = localDateTime.getMonth();
		int day = localDateTime.getDayOfMonth();
		System.out.println("月:" + month + "日:" + day);

		LocalTime localTime = LocalTime.parse("13:40:25");
		System.out.println("格式化时间:" + localTime);


	}
}
