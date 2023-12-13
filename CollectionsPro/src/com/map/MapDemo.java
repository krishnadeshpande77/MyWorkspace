package com.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapDemo 
{
	public static void main(String[] args)
	{
		Map<String, String> m = new HashMap<>();
		m.put("1", "Krishna");
		m.put("2", "Gaju");
		m.put("3", "Pawan");
		m.put("4", "Mukesh");
		Set<String> s = m.keySet();
		Iterator< String> itr = s.iterator();
		while(itr.hasNext())
		{
			String ss= itr.next();
			System.out.println(" "+ss+"  "+m.get(ss));
			
		}
	}
}
