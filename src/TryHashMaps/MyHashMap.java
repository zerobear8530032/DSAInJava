//706. Design HashMap
//Solved
//Easy
//Topics
//Companies
//Design a HashMap without using any built-in hash table libraries.
//
//Implement the MyHashMap class:
//
//MyHashMap() initializes the object with an empty map.
//void put(int key, int value) inserts a (key, value) pair into the HashMap. If the key already exists in the map, update the corresponding value.
//int get(int key) returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
//void remove(key) removes the key and its corresponding value if the map contains the mapping for the key.
// 
//
//Example 1:
//
//Input
//["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
//[[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
//Output
//[null, null, null, 1, -1, null, 1, null, -1]
//
//Explanation
//MyHashMap myHashMap = new MyHashMap();
//myHashMap.put(1, 1); // The map is now [[1,1]]
//myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
//myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]
//myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
//myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
//myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
//myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
//myHashMap.get(2);    // return -1 (i.e., not found), The map is now [[1,1]]
// 
//
//Constraints:
//
//0 <= key, value <= 106
//At most 104 calls will be made to put, get, and remove.


package TryHashMaps;

import java.util.LinkedList;

class MyHashMap {
    LinkedList<int []> [] hashmap;
    int MAXSIZE=1000;
    public MyHashMap() {
        hashmap = new LinkedList [MAXSIZE];
    }
    
    public void put(int key, int value) {
     int index= key%MAXSIZE;
     if(hashmap[index]==null){
        hashmap[index]= new LinkedList();
        hashmap[index].add(new int [] {key,value});
     }else{
        for(int i =0;i<hashmap[index].size();i++){
            if(hashmap[index].get(i)[0]==key){
                hashmap[index].get(i)[1]=value;
                return ;
            }
        }
        hashmap[index].add(new int [] {key,value});
     }

    }
    
    public int get(int key) {
        int index= key%MAXSIZE;
        if(hashmap[index]==null) return -1;
        for(int i =0;i<hashmap[index].size();i++){
            if(hashmap[index].get(i)[0]==key){
                return hashmap[index].get(i)[1];
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        int index= key%MAXSIZE;
        if(hashmap[index]==null) return ;
        for(int i =0;i<hashmap[index].size();i++){
            if(hashmap[index].get(i)[0]==key){
                hashmap[index].remove(i);
            }
        }
    }
    
    public static void main(String[] args) {
    	//Explanation
    	MyHashMap myHashMap = new MyHashMap();
    	myHashMap.put(1, 1); // The map is now [[1,1]]
    	myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
    	myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]
    	myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
    	myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
    	myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
    	myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
    	myHashMap.get(2);    // return -1 (i.e., not found), The map is now [[1,1]]

	}
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */