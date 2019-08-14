package com.xlx.leetcode.problems.algorithms;

import org.junit.jupiter.api.Test;

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

	@Test
	public int[] solution(int[] nums, int target) {
		int[] arry = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			for (int j = 1; j < nums.length - i; j++) {
				int result = nums[i] + nums[j];
				if (result == target){
					System.out.println("符合目标的数值:" + nums[i] + "," + nums[j]);
					return  arry;
				}
			}
		}
		return null;
	}
}
