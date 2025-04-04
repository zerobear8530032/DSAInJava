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
//	brute force apprpch :
//	this is all similar to hashset implmentation
//	ew created a max size array and to handle collision we used a method called caahning
    LinkedList<Integer>[]set;
    int MAXSIZE=10000;
    public MyHashSet() {
    	// initialize the array of linked list
        set= new LinkedList [MAXSIZE];
    }
    
    public void add(int key) {
        int index= key%MAXSIZE;// fnd the map index
        if(set[index]==null){// it its null means we need to crete a linke list here 
            set[index]= new LinkedList();
            set[index].add(key);
        }else{// it not null means collision we can add a new node in linked list
            if(set[index].contains(key)){// but first check the key already exits or not 
                return ;
            }
            set[index].add(key);
        }
    }
    
    public void remove(int key) {// remove
        int index= key%MAXSIZE;// map index
        if(set[index]==null){// check null node 
            return ;
        }else{
            if(set[index].contains(key)){// if the list contains key we can remove it  other wise we canot
                set[index].remove(new Integer(key));
            }
        }

    }
    
    public boolean contains(int key) {
        int index= key%MAXSIZE;// get map index
        if(set[index]==null){// if index not present then key cannot be there
            return false;
        }else{
            for(int i =0;i<set[index].size();i++){// check in the linked list to find the element
                if(set[index].get(i)==key){
                    return true;// true if presetnt
                }
            }
            return false;// false if not 
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