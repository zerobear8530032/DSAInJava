package TryHashMaps;

import java.util.LinkedHashMap;
import java.util.HashMap;

public class linkedHashMapDemo {
//	*************************info source**************************
//	https://www.geeksforgeeks.org/linkedhashmap-class-in-java/
//	*************************info source**************************
//	LinkedHashMap in Java implements the Map interface of the Collections Framework. It stores key-value pairs while maintaining the insertion order of the entries. It maintains the order in which elements are added.
//
//	Stores unique key-value pairs.
//	Maintains insertion order.
//	Allows one null key and multiple null values.
//	Fast performance for basic operations.
	
	
	
	public static void main(String[] args) {
		LinkedHashMap<Integer, Integer> map = new LinkedHashMap();
		
//		this is a linked hashmap which keep track of insertion order as a linked list :
//		means this take more space in memory by usiing a linked list
//		its better when we want to preserve insertion order :
		
// in java 8 + only:
//Operation	Best Case	Worst Case (With Red-Black Tree)
//Insert	O(1)		O(log n)
//Search	O(1)		O(log n)
//Delete	O(1)		O(log n)	

		
		
//		we insert 1,3,10,4,5,7,23,43 :
		map.put(1,3);
		map.put(3,3);
		map.put(10,3);
		map.put(4,3);
		map.put(5,3);
		map.put(7,3);
		map.put(23,3);
		map.put(43,3);
		
		System.out.println(map);// : 1,3,4,5,7,10
//		 we can create a hashmap using other hash map :
		HashMap <Integer,Integer>map2 = new HashMap(map);
		System.out.println(map2);
	}

}
