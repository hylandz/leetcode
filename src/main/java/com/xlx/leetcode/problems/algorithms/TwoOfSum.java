package com.xlx.leetcode.problems.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * 两数之和:
 * 给定一个整数数组 nums 和一个目标值 target,
 * 请你在该数组中找出和为目标值的那两个整数,并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9 所以返回 [0, 1]
 * @author xielx on 2019/8/14
 */
public class TwoOfSum {

	/**
	 * 思路:
	 *     数组的每个数字和后面的所有数字相加,然后和target比较
	 * 需要2轮循环,第一轮循环数组的每个数字(n次),第二轮循环(不包含第一轮的数字)其他数字(n次)
	 * 在第二轮中判断第一轮数字和第二轮数字相加的结果是否==target,相等将下标存入集合
	 * @param nums 数组
	 * @param target 目标
	 */
	public static int[] solution(int[] nums, int target) {
		List<Integer> list = new ArrayList<>(nums.length);
		//
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				int result = nums[i] + nums[j];
				if (result == target){
					list.add(i);
					list.add(j);
				}
			}
		}

		//集合
		int[] a = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			a[i] = list.get(i);
		}
		return a;
	}

	public static void main(String[] args) {
		int[] nums = {2, 7, 7,11, 15,4,5};
		int target = 9;
		int[] r = TwoOfSum.solution(nums,target);
		for (int i :r) {
			System.out.println(i);

		}

	}
}
