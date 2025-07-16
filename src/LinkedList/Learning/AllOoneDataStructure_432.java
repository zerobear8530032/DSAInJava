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

import java.util.*;




class AllOne {
	
	static class Node {
	    String key;
	    int freq;
	    Node next;
	    Node prev;

	    public Node(String key, int freq){
	        this.key=key;
	        this.freq=freq;
	        this.next=null;
	        this.prev=null;
	    }

	    public String toString(){
	        StringBuilder str= new StringBuilder();
	        str.append("["+key+","+freq+"]");
	        return str.toString();
	    }
	}

	static class DLL{
	    Node head;
	    Node tail;
	    int size;

	    
	    public DLL(){
	        size=0;
	        head=new Node("-1",-1);
	        tail=new Node("-1",-1);
	        head.next=tail;
	        tail.prev=head;
	    }

	    public Node getHead(){
	        return head.next!=tail?  head.next: null;
	    }

	    public Node getTail(){
	        return tail.prev!=head?  tail.prev: null;
	    }

	// adding at the end of the linked list 
	    public void add(Node node){
	        Node prev = tail.prev;
	        prev.next=node;
	        node.prev=prev;

	        node.next=tail;
	        tail.prev=node;
	        size++;
	    }

	    public void remove(Node node){
	        Node prev= node.prev;
	        Node next= node.next;
	        prev.next=next;
	        next.prev=prev;
	        node.next=null;
	        node.prev=null;
	        size--;
	    }

	    public String toString(){
	        Node ptr=head.next;
	        StringBuilder res= new StringBuilder("[");
	        while(ptr!=tail){
	            res.append(ptr).append(",");
	            ptr=ptr.next;
	        }
	        res.setCharAt(res.length()-1,']');
	        return res.toString();
	    }
	}  


    HashMap<String,Node> nodemap ;
    TreeMap<Integer,DLL> freqmap ;

    public AllOne() {
        nodemap = new HashMap();
        freqmap = new TreeMap();
    }
    
    public void inc(String key) {
        // System.out.println("brefore inc :");
        // System.out.println("nodemap : "+nodemap);
        // System.out.println("freqmap : "+freqmap);
        if(nodemap.containsKey(key)){
            Node node =nodemap.get(key);
            int oldfreq=node.freq;
            // removing to old frequncy list :
            freqmap.get(oldfreq).remove(node);
            // increasing node freq;
            node.freq++;
            int newfreq=node.freq;
            // after remove we will insert it into the new entry list
            if(freqmap.containsKey(newfreq)){
                // if the entry exists we can add to existing DLL there 
                freqmap.get(newfreq).add(node);
            }else{
                // if not we will create a entry
                DLL dll = new DLL();
                dll.add(node);
                freqmap.put(newfreq,dll);
            }
            // remove the freq map entry where there is not a single node in  the dll
            if(freqmap.get(oldfreq).size==0){
                freqmap.remove(oldfreq);
            }
        }else{
            int freq=1;
            Node node = new Node(key,freq);
            nodemap.put(key,node);
            if(freqmap.containsKey(freq)){
                // if the entry exists we can add to existing DLL there 
                freqmap.get(freq).add(node);
            }else{
                // if not we will create a entry
                DLL dll = new DLL();
                dll.add(node);
                freqmap.put(freq,dll);
            }
        }
        // System.out.println("after inc :");
        // System.out.println("nodemap : "+nodemap);
        // System.out.println("freqmap : "+freqmap);
    }
    
    public void dec(String key) {
        
        // System.out.println("brefore dec :");
        // System.out.println("nodemap : "+nodemap);
        // System.out.println("freqmap : "+freqmap);
          if(nodemap.containsKey(key)){
            Node node =nodemap.get(key);
            int oldfreq=node.freq;
            // removing to old frequncy list :
            freqmap.get(oldfreq).remove(node);
            // increasing node freq;
            node.freq--;
            int newfreq=node.freq;
            // after remove we will insert it into the new entry list
            if(newfreq==0){
                // remove from node map
                nodemap.remove(node.key);
            }else if( freqmap.containsKey(newfreq)){
                // if the entry exists we can add to existing DLL there 
                freqmap.get(newfreq).add(node);
            }else{
                // if not we will create a entry
                DLL dll = new DLL();
                dll.add(node);
                freqmap.put(newfreq,dll);
            }
            // remove the freq map entry where there is not a single node in  the dll
            if(freqmap.get(oldfreq).size==0){
                freqmap.remove(oldfreq);
            }
        }else{
            // for debugging :
          System.out.println("Key Does not exist");  
        }
        
        // System.out.println("after inc :");
        // System.out.println("nodemap : "+nodemap);
        // System.out.println("freqmap : "+freqmap);
    }
    
    public String getMaxKey() {
        // System.out.println(freqmap);
        if(freqmap.size()==0){
            return "";
        }else{
            int key= freqmap.lastKey();
            Node node = freqmap.get(key).getHead();
            return node.key;
        }
    }
    
    public String getMinKey() {
        // System.out.println(freqmap);
        if(freqmap.size()==0){
            return "";
        }else{
            int key= freqmap.firstKey();
            Node node = freqmap.get(key).getHead();
            return node.key;
        }
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */

public class AllOoneDataStructure_432 {
	public static void main(String[] args) {

		
		AllOne allOne = new AllOne();
		allOne.inc("hello");
		allOne.inc("hello");
		System.out.println(allOne.getMaxKey()); // return "hello"
		System.out.println(allOne.getMinKey()); // return "hello"
		allOne.inc("leet");
		System.out.println(allOne.getMaxKey()); // return "hello"
		System.out.println(allOne.getMinKey()); // return "hello"


	}

}
