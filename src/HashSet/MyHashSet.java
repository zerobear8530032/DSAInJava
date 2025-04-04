//
//705. Design HashSet
//Solved
//Easy
//Topics
//Companies
//Design a HashSet without using any built-in hash table libraries.
//
//Implement MyHashSet class:
//
//void add(key) Inserts the value key into the HashSet.
//bool contains(key) Returns whether the value key exists in the HashSet or not.
//void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.
// 
//
//Example 1:
//
//Input
//["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
//[[], [1], [2], [1], [3], [2], [2], [2], [2]]
//Output
//[null, null, null, true, false, null, true, null, false]
//
//Explanation
//MyHashSet myHashSet = new MyHashSet();
//myHashSet.add(1);      // set = [1]
//myHashSet.add(2);      // set = [1, 2]
//myHashSet.contains(1); // return True
//myHashSet.contains(3); // return False, (not found)
//myHashSet.add(2);      // set = [1, 2]
//myHashSet.contains(2); // return True
//myHashSet.remove(2);   // set = [1]
//myHashSet.contains(2); // return False, (already removed)
// 
//
//Constraints:
//
//0 <= key <= 106
//At most 104 calls will be made to add, remove, and contains


package HashSet;
import java.util.*;
class MyHashSet {
    LinkedList<Integer>[]set;
    int MAXSIZE=10000;
    public MyHashSet() {
        set= new LinkedList [MAXSIZE];
    }
    
    public void add(int key) {
        int index= key%MAXSIZE;
        if(set[index]==null){
            set[index]= new LinkedList();
            set[index].add(key);
        }else{
            if(set[index].contains(key)){
                return ;
            }
            set[index].add(key);
        }
    }
    
    public void remove(int key) {
        int index= key%MAXSIZE;
        if(set[index]==null){
            return ;
        }else{
            if(set[index].contains(key)){
                set[index].remove(new Integer(key));
            }
        }

    }
    
    public boolean contains(int key) {
        int index= key%MAXSIZE;
        if(set[index]==null){
            return false;
        }else{
            for(int i =0;i<set[index].size();i++){
                if(set[index].get(i)==key){
                    return true;
                }
            }
            return false;
        }
    }
    public static void main(String[] args) {
    	MyHashSet myHashSet = new MyHashSet();
    	myHashSet.add(1);      // set = [1]
    	myHashSet.add(2);      // set = [1, 2]
    	myHashSet.contains(1); // return True
    	myHashSet.contains(3); // return False, (not found)
    	myHashSet.add(2);      // set = [1, 2]
    	myHashSet.contains(2); // return True
    	myHashSet.remove(2);   // set = [1]
    	myHashSet.contains(2); // return False, (already removed)

	}
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */