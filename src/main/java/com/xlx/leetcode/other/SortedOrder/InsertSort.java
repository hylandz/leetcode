package com.xlx.leetcode.other.SortedOrder;
import java.util.Arrays;
/**
 * 插入排序
 * 未排序的数,向后依次与排序好的数比较
 * 例如: int{1,12,5,4,9,6}
 * 由于1处于第一个,可作为已排好的数 {1,}
 * 12和{1}比较,排序{1,12}
 * 5和{1,12}比较,排序{1,5,12}
 * 4和{1,5,12}比较,排序{1,4,5,12}
 * 9和{1,4,5,12}比较,排序{1,4,5,9,12}
 * 6和{1,4,5,12}比较,排序{1,4,5,6,12}
 *
 * @author xielx at 2020/3/11 16:16
 */
public class InsertSort {
    
    /**
     * 关键就是如何将未排序的数值与排序的数值比较,如5,{1,3}
     * @param array 待排序的数组
     * @return Array
     */
    public static int[] fastSorted(int[] array){
        // 待排序是数值
        int target;
        // 需要比较n-1次
        for (int i = 0; i < array.length - 1; i++) {
            // 待排序数值下标(首起值第一个,认为排好序的,未排序就是+1了)
            int j = i + 1;
            // 待排序值
            target = array[j];
            // 待排序值与排好的所有值比较,如3,{1,4,7}
            while (j > 0 && target < array[j - 1]){
             // 待排序值要比它前面值(已排序里面的)小,就要移位往前插(小的靠前,大的靠后)
             array[j] = array [j - 1];
             // 需要与排序好的值循环比较,如3,{1,4,7}
             // 3和7,{1,4,3,7} -> 3和4,{1,3,4,7} -> 3和1(不满足条件,不移动)
             j--;
            }
            array[j] = target;
	    System.out.println("第" + (i+1) +"次遍历的结果:" + Arrays.toString(array));
        }
        return array;
    }
    
    
    public static void main(String[] args) {
       int[] array ={1,12,5,4,9,6};
        final int[] sorted = fastSorted(array);
        System.out.println("排序完成的数组:" + Arrays.toString(array));
        
    }
}
