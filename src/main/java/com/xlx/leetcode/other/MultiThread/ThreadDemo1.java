package com.xlx.leetcode.other.MultiThread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Callable实现多线程
 *
 * @author xielx at 2019/10/22 11:45
 */
public class ThreadDemo1 {
    
    
    public static void main(String[] args) {
        
        ThreadDemo1 td = new ThreadDemo1();
        FutureTask<Integer> futureTask = new FutureTask<Integer>((Callable<Integer>) () -> {
            int i = 0;
            for (; i < 100; i++ ){
            
            }
            return i;
        });
    

    }
    
}
