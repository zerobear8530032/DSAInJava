package TryHashMaps;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class TreeMapDemo {
	public static void main(String[] args) {
		HashMap<Integer, Integer> map = new HashMap();
//		in java tree map use a red black tree to maintain the sorted order of the key of hashmap
//		this uses extra space in memeory :
		
		map.put(1,3);
		map.put(3,3);
		map.put(10,3);
		map.put(4,3);
		map.put(5,3);
		map.put(7,3);
		map.put(23,3);
		map.put(43,3);		
		
		TreeMap<Integer, Integer> treemap = new TreeMap<Integer, Integer>(map);
		LinkedHashMap< Integer, Integer>llmap= new LinkedHashMap<Integer, Integer>(map);
		
		System.out.println("Tree map "+treemap);
		System.out.println("HashMap map "+map);
		System.out.println("linked  map "+llmap);
	}
}
