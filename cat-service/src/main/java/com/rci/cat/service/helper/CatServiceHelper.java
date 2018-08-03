package com.rci.cat.service.helper;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeSet;

public class CatServiceHelper {
	
	public static Map<String, String> getSortedMembershipTypes() {
		Map<String,String> membershipTypesSorted = new LinkedHashMap<String, String>();
		Map<String,String> membershipTypes = new HashMap<String, String>();
		membershipTypes.put("WKS", "WKS");
		membershipTypes.put("PTS", "PTS");
		membershipTypes.put("CBS", "CBS");
		TreeSet<String> sortedSet = new TreeSet<String>(membershipTypes.values());
		Object[] sortedArray = sortedSet.toArray();
		int size = sortedArray.length;	
		for (int i=size-1; i>=0;i--)
		{
			if(i != 0 )
				membershipTypesSorted.put((String)sortedArray[i], (String)sortedArray[i]);
			else
				membershipTypesSorted.put((String)sortedArray[0], (String)sortedArray[0]);
		}
		return membershipTypesSorted;
	}
}
