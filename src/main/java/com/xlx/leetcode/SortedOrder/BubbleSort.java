package com.xlx.leetcode.SortedOrder;

/**
 * 冒泡排序
 *
 * @author xielx at 2019/10/16 13:26
 */
public class BubbleSort {
    
    
    /**
     * 冒泡排序
     * @param nums int数组
     */
    public static int[] bubbleSorted(int[] nums){
    
        for (int i = 0; i < nums.length; i++) {// 数组每个元素依次与其他元素比较
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]){ // from small to large
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] =temp;
                }
            }
        }
    
        return nums;
    }
    
    public static void main(String[] args) {
        int[] arry = {31,21,3,22,45,100,1};
        int[] ints = bubbleSorted(arry);
        for (int i : ints){
            System.out.print(i + " ");
        }
    }
}
