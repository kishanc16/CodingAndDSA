package com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapSortByValye {

	public static void main(String[] args) {
	
		String str = "1 1 1 1 3 3 4 4 4 4 4 5 5 5 2 2 2 2 2";
		String s[] = str.split(" ");
		String  result1 = mapSortByValue(s);
		System.out.println(result1);
	}

	private static String mapSortByValue(String[] s) {
		Map<String, Integer> map = new HashMap<>();
		
		for(int i=0 ;i<s.length; i++){
			if(map.containsKey(s[i])){
				map.put(s[i],map.get(s[i])+1);
			}else{
				map.put(s[i], 1);
			}
		}
        Set<Entry<String, Integer>> entries = map.entrySet();
		Comparator<Entry<String,Integer>> valueComparator  = new Comparator<Entry<String,Integer>>() {

			@Override
			public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) {
				int val1 = e1.getValue(); 
				int val2 = e2.getValue();
				return val2-val1;
			}
		};
		List<Entry<String, Integer>> listOfEntries = new ArrayList<Entry<String, Integer>>(entries);
		Collections.sort(listOfEntries,valueComparator);
		
		String result ="";
		for(Entry<String,Integer> m : listOfEntries)
		{
			for(int i=1; i<=m.getValue(); i++)
			{
				result += m.getKey()+" ";
			}
		}
		return result;
	}

	
}

