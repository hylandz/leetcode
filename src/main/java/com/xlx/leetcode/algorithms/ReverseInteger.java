package com.xlx.leetcode.algorithms;

/**
 * 7.[整数反转]
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转
 * 示例1:
 * 输入: 123,输出:321
 * 示例2:
 * 输入: -123,输出:-321
 * 示例3:
 * 输入: 120,输出:21
 * 注意:假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。
 * 请根据这个假设，如果反转后整数溢出那么就返回 0
 *
 * @author xielx on 2019/8/21
 */
public class ReverseInteger {


	/**
	 * 思路:
	 * 判断正负数,
	 * 1.正数:转为String类型,使用StringBuilder方法反转,<b>再转为int类型</b>
	 * 2.负数:转为String类型,字符截取开头的符号(-),使用StringBuilder方法反转,再添加符号(-),<b>再转为int类型</b>
	 * 判断反转数的数值范围
	 * 1.正数:超过2^31 -1 =2147483647(Integer.MAX_VALUE),反转数置为0
	 * 2.负数:超过2^-31 = -2147483648(Integer.MIN_VALUE),反转数置为0
	 *
	 * @param x 整数
	 * @return int
	 */
	public int reverse(int x) {
		int rev = 0;
		String strX = String.valueOf(x);
		//反转
		if (x >= 0) {
			//正整数:123
			StringBuilder builder = new StringBuilder(strX).reverse();
			rev = Integer.parseInt(builder.toString());
		} else if (x < 0) {
			//负整数 -123
			String trim = strX.substring(1);
			StringBuilder builder = new StringBuilder(trim).reverse();
			rev = Integer.parseInt("-" + builder.toString());
		}

		//反转值的范围
		if (rev < -2147483648 || rev > 2147483647) {//563847412
			return 0;
		}
		return rev;
	}

	/**
	 * 解法二:使用除法取位数[官方]
	 * 思路:
	 * 举例:123
	 * 第一次:尾数3,0 * 10 + 3 = 3
	 * 第二次:尾数2,3 * 10 + 2 = 32
	 * 第三次:尾数1,32 * 10 + 1 = 321
	 *
	 * @param x 整数
	 * @return int
	 */
	public int solution(int x) {
		//反转数
		int rev = 0;

		while (x != 0) {
			//获取x的最后位数,也是反转数值的首位数
			int pop = x % 10;

			//除去x的最后位数
			x = x / 10;

			/**
			 * 反转值溢出处理: 在int数值范围内[-2147483648,-2147483647]
			 * 1. rev > 214748364(Integer.MAX_VALUE / 10),那么后续的rev = rev * 10 + pop;会溢出
			 * 2. rev刚好等于2147483647(Integer.MAX_VALUE)且pop>7(pop<-8),那么后续的rev = rev * 10 + pop;必会溢出
			 */
			//
			if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > Integer.MAX_VALUE % 10)) {
				rev = 0;
				return rev;
			}
			//反转值的首位数
			if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < Integer.MIN_VALUE % 10)) {
				rev = 0;
				return rev;
			}
			//反转
			rev = rev * 10 + pop;
		}

		return rev;
	}

	public static void main(String[] args) {
		/*ReverseInteger ri = new ReverseInteger();
		int x = 1534236469;
		System.out.println(ri.reverse(x));*/

		System.out.println("rev=" + new ReverseInteger().solution(-120));

	}
}
