package com.xlx.leetcode.other.javajdk8.MapSource;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * hashMAp
 *
 * @author xielx on 2019/9/15
 */
public class HashMapDemo {
	
	public static void main(String[] args) {
		HashMap<String,Object> hashMap = new HashMap<>();
		hashMap.put("第一",1);
		hashMap.put("第二",2);
		hashMap.put("第三",3);
		
		Set<Map.Entry<String, Object>> entries = hashMap.entrySet();
		Iterator<Map.Entry<String, Object>> iterator = entries.iterator();
		while (iterator.hasNext()){
			System.out.println(iterator.next());
			hashMap.put("第四",4);
			System.out.println("size=" + hashMap.size());
		}
	}
}
