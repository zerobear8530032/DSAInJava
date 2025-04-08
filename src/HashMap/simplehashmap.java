package HashMap;

import java.util.HashMap;

public class simplehashmap {
	
	
public static void main(String[] args) {
//	*************************information source***********************************************
//	https://www.geeksforgeeks.org/java-util-hashmap-in-java-with-examples/ 	
//	*************************information source***********************************************
//	A HashMap is a data structure that is used to store and retrieve values based on keys. Some of the key characteristics of a hashmap include:
//Not ordered: HashMaps are not ordered, which means that the order in which elements are 
//	added to the map is not preserved. However, LinkedHashMap is a variation of HashMap that 
//	preserves the insertion order.
//Thread-unsafe: HashMaps are not thread-safe, which means that if multiple 
//	threads access the same hashmap simultaneously, it can lead to data inconsistencies. 
//	If thread safety is required, ConcurrentHashMap can be used.
//Capacity and load factor: HashMaps have a capacity, which is the number of elements 
//	that it can hold, and a load factor, which is the measure of how full the hashmap 
//	can be before it is resized.
	
//	
//	Operation   Best Case						Worst Case
//	Insert		O(1) (Direct bucket mapping)	O(log N) (Tree traversal in case of collisions)
//	Search		O(1) (Direct lookup)			O(log N) (Tree traversal in case of collisions)
//	Delete		O(1) (Direct removal)			O(log N) (Tree traversal in case of collisions)
	
	HashMap<Integer, Integer> map = new HashMap();
	
//	this is a simple hash map which uses only hashing the order of the elements are not preserve as we can see:
//	we insert 1,3,10,4,5,7,23,43 : 
	map.put(1,3);
	map.put(3,3);
	map.put(10,3);
	map.put(4,3);
	map.put(5,3);
	map.put(7,3);
	map.put(23,3);
	map.put(43,3);
	
//	does not means it always will be sorted like this 
	System.out.println(map);// : 1,3,4,5,7,10
//	 we can create a hashmap using other hash map :
	HashMap <Integer,Integer>map2 = new HashMap(map);
	System.out.println(map2);
}

}
