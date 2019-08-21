package com.xlx.leetcode.problems.algorithms;

/**
 * 7.[整数反转]
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转
 * 示例1:
 *    输入: 123,输出:321
 * 示例2:
 *    输入: -123,输出:-321
 * 示例3:
 *    输入: 120,输出:21
 * 注意:假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。
 * 请根据这个假设，如果反转后整数溢出那么就返回 0
 * @author xielx on 2019/8/21
 */
public class ReverseInteger {


	/**
	 * 思路:
	 *
	 * @param x 整数
	 * @return int
	 */
	public int reverse(int x) {
		int rev = 0;
		String strX = String.valueOf(x);
		//反转
		if (x >= 0){
			//正整数:123
			String str = new StringBuilder(strX).reverse().toString();
			rev = 0;
		}else if (x < 0){
			//负整数 -123
			String trim = strX.substring(1);
			String str = new StringBuilder(trim).reverse().toString();
			rev = 0;
		}

		//反转值的范围
		if (rev < -231 || rev > 230){
			return 0;
		}
		return rev;
	}


	public static void main(String[] args) {
		ReverseInteger ri = new ReverseInteger();
		int x = 1534236469;
		System.out.println(ri.reverse(x));
	}
}
