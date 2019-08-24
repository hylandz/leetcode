package com.xlx.leetcode.javajdk8;

/**
 * @author: xielx on 2019/8/23
 */
public interface ILambda {

	 void print(String msg);


	int add(int x);

	default int add(int x,int y){
		return x + y;
	}


}
