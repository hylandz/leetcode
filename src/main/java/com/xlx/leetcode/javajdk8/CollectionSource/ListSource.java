package com.xlx.leetcode.javajdk8.CollectionSource;

import javax.jws.Oneway;
import java.util.*;

/**
 * List集合
 *
 * @author xielx on 2019/9/15
 */
public class ListSource implements Cloneable{
	
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	public static void main(String[] args) {
		//List<E>
		ArrayList<Integer> list = new ArrayList<>();
		LinkedList<Integer> linkedList = new LinkedList<>();
		Queue<Integer> queue = new PriorityQueue<>();
		queue.element();
		queue.add(1);
		//获取头
		queue.peek();
		//获取并删除头
		queue.poll();
		
		//Set<E>
		HashSet<String> hashSet = new HashSet<>();
		TreeSet<Integer> treeSet = new TreeSet<>();
	
		//Map<k,v>
		HashMap<String, Object> hashMap = new HashMap<>();
		Hashtable<String,String> hashtable = new Hashtable<>();
		TreeMap<Integer,String> treeMap = new TreeMap<>();
	}
}
