package com.xlx.leetcode.problems.algorithms;

/**
 * 9.[回文数]
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 示例1:
 *   输入: 121
 *   输出: true
 * 示例2:
 *   输入: -121
 *   输出: false
 *   解释: 左边-121,右边121-
 * 示例3:
 *   输入: 10
 *   输出: false
 *   解释: 左边10,右边01
 * 备注:你能不将整数转为字符串来解决这个问题吗？
 * @author xielx on 2019/8/23
 */
public class PalindromeNumber {

	/**
	 * 思路:
	 *
	 * @param x 整数
	 * @return boolean
	 */
	public boolean isPalindrome(int x) {
		int rev = 0;

		int origin = x;

		while (x > 0){
			//获取尾数值
			int tail = x % 10;

			rev = rev * 10 + tail;

			x /= 10;
		}

		if (rev == origin){
			return true;
		}
		return false;
	}


	/**
	 * 转换字符串处理
	 */
	public boolean isPalindromeByString(int x) {
		String strX = String.valueOf(x);
		StringBuilder builder = new StringBuilder(strX);
		String rev = builder.reverse().toString();
		if (strX.equals(rev)){
			return true;
		}
		return false;
	}


	public static void main(String[] args) {
		PalindromeNumber pn = new PalindromeNumber();
		System.out.println(pn.isPalindromeByString(-121));
		System.out.println(pn.isPalindrome(10));

	}
}
