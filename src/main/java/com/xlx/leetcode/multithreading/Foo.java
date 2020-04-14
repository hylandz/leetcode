package com.xlx.leetcode.multithreading;

/**
 * 多线程按顺序打印
 *
 * @author xielx on 2019/8/28
 */
public class Foo {

	public Foo(){}

	public void first(Runnable printFirst) throws InterruptedException {

		// printFirst.run() outputs "first". Do not change or remove this line.
		printFirst.run();
	}

	public void second(Runnable printSecond) throws InterruptedException {

		// printSecond.run() outputs "second". Do not change or remove this line.
		printSecond.run();
	}

	public void third(Runnable printThird) throws InterruptedException {

		// printThird.run() outputs "third". Do not change or remove this line.
		printThird.run();
	}


	public void testPrintInOrder(){
		Foo foo = new Foo();

		Thread t1 = new Thread();
	}
}
