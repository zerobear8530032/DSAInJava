//432. All O`one Data Structure
//Attempted
//Hard
//Topics
//premium lock icon
//Companies
//Design a data structure to store the strings' count with the ability to return the strings with minimum and maximum counts.
//
//Implement the AllOne class:
//
//AllOne() Initializes the object of the data structure.
//inc(String key) Increments the count of the string key by 1. If key does not exist in the data structure, insert it with count 1.
//dec(String key) Decrements the count of the string key by 1. If the count of key is 0 after the decrement, remove it from the data structure. It is guaranteed that key exists in the data structure before the decrement.
//getMaxKey() Returns one of the keys with the maximal count. If no element exists, return an empty string "".
//getMinKey() Returns one of the keys with the minimum count. If no element exists, return an empty string "".
//Note that each function must run in O(1) average time complexity.
//
// 
//
//Example 1:
//
//Input
//["AllOne", "inc", "inc", "getMaxKey", "getMinKey", "inc", "getMaxKey", "getMinKey"]
//[[], ["hello"], ["hello"], [], [], ["leet"], [], []]
//Output
//[null, null, null, "hello", "hello", null, "hello", "leet"]
//
//Explanation
//AllOne allOne = new AllOne();
//allOne.inc("hello");
//allOne.inc("hello");
//allOne.getMaxKey(); // return "hello"
//allOne.getMinKey(); // return "hello"
//allOne.inc("leet");
//allOne.getMaxKey(); // return "hello"
//allOne.getMinKey(); // return "leet"
// 
//
//Constraints:
//
//1 <= key.length <= 10
//key consists of lowercase English letters.
//It is guaranteed that for each call to dec, key is existing in the data structure.
//At most 5 * 104 calls will be made to inc, dec, getMaxKey, and getMinKey

package LinkedList.Learning;

import java.util.HashMap;
import java.util.HashSet;


	
//	class Node {
//	    int count;
//	    HashSet<String> keys;
//	    Node next;
//	    Node prev;
//	    
//
//	    public Node(HashSet<String> keys, int count) {
//	        this.keys = keys;
//	        this.count = count;
//	        this.next=null;
//	        this.prev=null;
//	    }
//	}
//
//	class DLL {
//	    Node head;
//	    Node tail;
//	    int size;
//
//	    DLL() {
//	        size = 0;
//	        head = new Node(new HashSet(), -1);
//	        tail = new Node(new HashSet(), -1);
//	        head.next = tail;
//	        tail.prev = head;
//	    }
//
//	    public void addFirst(Node node) {
//	        Node next = head.next;
//	        head.next = node;
//	        node.prev = head;
//	        node.next = next;
//	        next.prev = node;
//	        size++;
//	    }
//
//	    public void addLast(Node node) {
//	        Node prev = tail.prev;
//	        prev.next = node;
//	        node.prev = prev;
//	        node.next = tail;
//	        tail.prev = node;
//	        size++;
//	    }
//
//	    public Node getHead() {
//	        return head.next;
//	    }
//
//	    public Node getTail() {
//	        return tail.prev;
//	    }
//	    public void addAfter(Node node,Node newnode){
//	        Node nodenext= node.next;
//	        node.next=newnode;
//	        newnode.prev=node;
//
//	        newnode.next=nodenext;
//	        nodenext.prev=newnode;
//	    }
//	    public void addBefore(Node node,Node newnode){
//	        Node nodeprev= node.prev;
//	        nodeprev.next=newnode;
//	        newnode.prev=nodeprev;
//
//	        newnode.next=node;
//	        node.prev=newnode;
//	    }
//	    public void remove(Node node) {
//	        System.out.println("["+node.keys + " " + node.count+"]");
//	        node.prev.next = node.next;
//	        node.next.prev = node.prev;
//	        node.prev = null;
//	        node.next = null;
//	        size--;
//	    }
//
//	    public void display(){
//	        Node ptr= head.next;
//	        while(ptr!=tail){
//	            System.out.print(ptr.keys+" "+ptr.count+"->");
//	            ptr=ptr.next;
//	        }
//	        System.out.println("null");
//	    }
//
//
//
//	}
//
//	class AllOne {
//	    HashMap<String, Node> map;
//	    DLL list;
//
//	    public AllOne() {
//	        map = new HashMap();
//	        list = new DLL();
//	    }
//	    public void inc(String key) {
//	        if(map.containsKey(key)){
//	            Node node = map.get(key);
//	            Node nodenext=node.next;
//	            int count = node.count+1;
//	            if(nodenext.count==count){
//	                node.keys.remove(key);
//	                nodenext.keys.add(key);
//	            }else{
//	            	HashSet<String> set= new HashSet();
//	            	set.add(key);
//	            	Node newnode = new Node(set,count);
//	                list.addAfter(node,newnode);
//	                map.put(key,newnode);
//	            }
//	            if(node.keys.size()==0){
//	                list.remove(node);
//	            }
//	        }else{
//	        	HashSet<String> set= new HashSet();
//	        	set.add(key);
//	            Node node = new Node(set,1);
//	            list.addFirst(node);
//	            map.put(key,node);
//	        }
//	    }
//
//	    public void dec(String key) {
//	        if(!map.containsKey(key)){
//	            return ;
//	        }
//	        Node node = map.get(key);
//	        Node prev = node.prev;
//	        int count = node.count-1;
//	        if(prev.count==node.count){
//	            node.keys.remove(key);
//	            prev.keys.add(key);
//	        }else if(count==0) {
//	            node.keys.remove(key);
//	        }else{
//	        	HashSet<String> set= new HashSet();
//	        	set.add(key);
//	            Node newnode = new Node(set,count);
//	            list.addBefore(node , newnode);
//
//	        }
//	        if(node.keys.size()==0){
//	            list.remove(node);
//	        }
//	        
//	    }
//
//	    public String getMaxKey() {
//	        Node tail= list.getTail();
//	        if(tail.keys.size()==0){
//	            return "";
//	        }else{
//	            for(String s:tail.keys){
//	                return s;
//	            }
//	        }
//	        return null;
//	    }
//
//	    public String getMinKey() {
//	        Node head= list.getHead(); 
//	        if(head.keys.size()==0){
//	            return "";
//	        }else{
//	            for(String s:head.keys){
//	                return s;
//	            }
//	        }
//	        return null;
//	    }
//	}

public class AllOoneDataStructure_432 {
	public static void main(String[] args) {

		
//		AllOne allOne = new AllOne();
//		allOne.inc("hello");
//		allOne.inc("hello");
//		System.out.println(allOne.getMaxKey()); // return "hello"
//		System.out.println(allOne.getMinKey()); // return "hello"
//		allOne.inc("leet");
//		System.out.println(allOne.getMaxKey()); // return "hello"
//		System.out.println(allOne.getMinKey()); // return "hello"
//

	}

}
