package TryHashMaps;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {
//	here we use linked hash map so that the order of insertion if preserved
    static LinkedHashMap<Integer, Integer> map;
   static int capacity;

    public  LRUCache(int cap) {
        map= new LinkedHashMap();
        this.capacity=cap;// inital cap
    }
    
    public static int get(int key) {
//    	this is a edge case where when use a simple linked hash set it only store insertion 
//    	order not operations order means the order remain static once we insert no change in order
//    	we can manage then when we use get operation we remove the element from the hashset and 
//    	reinsert it 
    	 if(map.containsKey(key)){// check value exists
             int val = map.get(key);// here
             map.remove(key);
             map.put(key,val);
             return val;
         }else{
             return -1;
         }
    }
    
    public static void put(int key, int value) {

        if (map.containsKey(key)) {// check the current key avaible then put
            map.remove(key);
            map.put(key, value);
        } else {
            if (map.size() == capacity) {// apply remove when only capacity reach max
//            	here insertion order remains means the first key is inserted is always at first index 
            	int firstkey=map.keySet().iterator().next();// get first key using iterator
            	map.remove(firstkey);// remove first key
            }
            map.put(key, value);// last put the current values
        }

    }
    public static void main(String[] args) {
    	LRUCache lRUCache = new LRUCache(1);
    	lRUCache.put(2, 1);
    	System.out.println(lRUCache.get(2));
    	}
}
