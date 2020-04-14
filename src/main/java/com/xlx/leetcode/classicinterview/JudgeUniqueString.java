package com.xlx.leetcode.classicinterview;

/**
 * 面试题 01.01. 判定字符是否唯一
 * Q: 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 * 示例 1：
 * 输入: s = "leetcode"
 * 输出: false
 * 示例 2：
 * 输入: s = "abc"
 * 输出: true
 * 限制：
 * 1. 0 <= len(s) <= 100
 * 2. 如果你不使用额外的数据结构，会很加分。
 *
 * @author xielx at 2020/4/14 16:40
 */
public class JudgeUniqueString {
    
    /**
     * 每个数与后面数比较,如此循环
     * eg: "abc"
     * 1.'a'与{'b','c'}
     * 2.'b'与{'c'}
     * 3.'c'与{},排到比较末尾数时,可以不用比较
     * @param astr 待比较字符串
     * @return  false:存在字符相同
     */
    public  static boolean isUnique(String astr) {
        
        int len = astr.length();
        
        if (len > 100) {
            return false;
        }
    
    
        //
        for (int i = 0; i < len - 1; i++) {
            for (int j = i; j < len - 1 - i; j++) {
                if (astr.charAt(i) == astr.charAt(j + 1)){
                        return false;
                }
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        String str = "leetcode";
        String str2 = "abc";
        System.out.println(str + ",is unique:" + isUnique(str2));
    }
}
