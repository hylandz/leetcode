package com.xlx.leetcode.other.CollectionSource;

/**
 * ThreadLocal
 *
 * @author xielx at 2020/3/13 13:51
 */
public class ThreadLocalDemo {
    
    static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    
    static void print(String str){
        // 打印当前线程变量存储的值
        System.out.println(str + ":" + threadLocal.get());
        threadLocal.remove();
    }
    public static void main(String[] args) {
    
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                // 线程1存储变量值localVar1
                threadLocal.set("localVar1");
                print("thread1");
                // 打印删除后的值
                System.out.println("after remove :" + threadLocal.get());
            }
        });
    
        Thread t2 = new Thread(() -> {
            threadLocal.set("localVar2");
            print("thread2");
            System.out.println("after remove :" + threadLocal.get());
        });
        
        t1.start();
        t2.start();
    }
}
