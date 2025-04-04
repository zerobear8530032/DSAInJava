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
//	approch :
//	create a array of certain size here i take 1000
//	hash function used is k%maxsize : k is key and max size is 1k
//	intitalize an array of max size map key with th hash funtion where each index 
//	is a linked list to handle colletion each linked list node is a
//	2 length array which hold key , value pairs
    LinkedList<int []> [] hashmap;
    int MAXSIZE=1000;// hashmap of size 1k
    public MyHashMap() {
        hashmap = new LinkedList [MAXSIZE];
    }
    
    public void put(int key, int value) {
     int index= key%MAXSIZE;// get map index
     if(hashmap[index]==null){// check current node is present 
        hashmap[index]= new LinkedList();// if not we created it 
        hashmap[index].add(new int [] {key,value});// put the values
     }else{
        for(int i =0;i<hashmap[index].size();i++){// if already present 
            if(hashmap[index].get(i)[0]==key){// check key already exists in here or not
//            	cause if key exists we can put the value in this key without creating a new node
                hashmap[index].get(i)[1]=value;//put the values on present key
                return ;// exit
            }
        }
        hashmap[index].add(new int [] {key,value});// if the loop exits we can say the key does not exits we unsert the new noode 
     }

    }
    
    public int get(int key) {// get the value
        int index= key%MAXSIZE;// map index
        if(hashmap[index]==null) return -1;// if node does not exists on that index that means we does not have that key
        for(int i =0;i<hashmap[index].size();i++){// heere we check for key in linked list at map index
            if(hashmap[index].get(i)[0]==key){// if fodun return value 
                return hashmap[index].get(i)[1];
            }
        }
        return -1;// default -1
    }
    
    public void remove(int key) {// remove element
        int index= key%MAXSIZE;// map index
        if(hashmap[index]==null) return ;// if the node does not exists means key never exists there 
        for(int i =0;i<hashmap[index].size();i++){//find the index off the key
            if(hashmap[index].get(i)[0]==key){
                hashmap[index].remove(i);// remove it from linked list
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