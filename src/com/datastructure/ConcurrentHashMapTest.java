package com.datastructure;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {

	public static void main(String[] args) {
	
		ConcurrentHashMap<Integer, String> concurrHashMap = new ConcurrentHashMap<>();
		concurrHashMap.put(1,"Kishan");
		concurrHashMap.put(3, "Anil");
		concurrHashMap.put(2, "Lal");
		
		System.out.println(concurrHashMap);
		
		synchronized (concurrHashMap) {
			for (Map.Entry<Integer, String> m : concurrHashMap.entrySet()){
				
				   System.out.println(m.getKey()+" "+  m.getValue());
			}
		}
		
		Map<Integer,String> map = Collections.synchronizedMap(new HashMap<>());
		map.put(2, "Hello");
		map.put(1, "My");
		map.put(3, "Anil");
		map.put(2, "Lal");
		synchronized (map) {	
		
			for(Map.Entry<Integer, String> m : map.entrySet()){
				System.out.println(m.getValue());
			}
			System.out.println(map);
		}
	}
}
