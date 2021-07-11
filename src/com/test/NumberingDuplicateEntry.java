package com.test;
import java.util.*;

public class NumberingDuplicateEntry {
	
	public static void main(String[] args) {
		String s[] ={"arr","alan","milan","arr","uni","uni","uni","uni","uni","alan"};
		Set<String> set = new LinkedHashSet<>();
						
		for(int i=0 ; i<s.length;i++)
		{
			int count = 1;
			String val = s[i];
			if(set.contains(val))
			{  
				String v = val+count;
				while(set.contains(v))
				{
					count++;
					v = val+count;
				}
				set.add(v);
			}else{
				set.add(val);
			}
		}
		System.out.println(set);
	}
}
