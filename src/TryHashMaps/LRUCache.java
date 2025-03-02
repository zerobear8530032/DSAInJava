package TryHashMaps;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {
    static LinkedHashMap<Integer, Integer> map;
   static int capacity;

    public  LRUCache(int cap) {
        map= new LinkedHashMap();
        this.capacity=cap;
    }
    
    public static int get(int key) {
    	 if(map.containsKey(key)){
             int val = map.get(key);
             map.remove(key);
             map.put(key,val);
             return val;
         }else{
             return -1;
         }
    }
    
    public static void put(int key, int value) {

        if (map.containsKey(key)) {
            map.remove(key);
            map.put(key, value);
        } else {
            if (map.size() == capacity) {
            	int firstkey=map.keySet().iterator().next();
            	map.remove(firstkey);
            }
            map.put(key, value);
        }

    }
    public static void main(String[] args) {
    	LRUCache lRUCache = new LRUCache(1);
    	lRUCache.put(2, 1);
    	System.out.println(lRUCache.get(2));
    	}
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */