package com.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapWithEntrySet 
{
	public static void main(String[] args)
	{
		Map<Integer, String> m = new HashMap<Integer, String>();
		m.put(1, "Krishna");
		m.put(2, "Gaju");
		m.put(3, "Pawan");
		m.put(4, "Mukesh");
		//Set s = m.keySet();
		Set s1 = m.entrySet();
		Iterator itr = s1.iterator();
		while(itr.hasNext())
		{
			Map.Entry m1 = (Entry) itr.next();
			System.out.println(m1.getKey()+"    "+m1.getValue());
		}
	}
}
