//460. LFU Cache
//Solved
//Hard
//Topics
//premium lock icon
//Companies
//Design and implement a data structure for a Least Frequently Used (LFU) cache.
//
//Implement the LFUCache class:
//
//LFUCache(int capacity) Initializes the object with the capacity of the data structure.
//int get(int key) Gets the value of the key if the key exists in the cache. Otherwise, returns -1.
//void put(int key, int value) Update the value of the key if present, or inserts the key if not already present. When the cache reaches its capacity, it should invalidate and remove the least frequently used key before inserting a new item. For this problem, when there is a tie (i.e., two or more keys with the same frequency), the least recently used key would be invalidated.
//To determine the least frequently used key, a use counter is maintained for each key in the cache. The key with the smallest use counter is the least frequently used key.
//
//When a key is first inserted into the cache, its use counter is set to 1 (due to the put operation). The use counter for a key in the cache is incremented either a get or put operation is called on it.
//
//The functions get and put must each run in O(1) average time complexity.
//
// 
//
//Example 1:
//
//Input
//["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
//Output
//[null, null, null, 1, null, -1, 3, null, -1, 3, 4]
//
//Explanation
//// cnt(x) = the use counter for key x
//// cache=[] will show the last used order for tiebreakers (leftmost element is  most recent)
//LFUCache lfu = new LFUCache(2);
//lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
//lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
//lfu.get(1);      // return 1
//                 // cache=[1,2], cnt(2)=1, cnt(1)=2
//lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
//                 // cache=[3,1], cnt(3)=1, cnt(1)=2
//lfu.get(2);      // return -1 (not found)
//lfu.get(3);      // return 3
//                 // cache=[3,1], cnt(3)=2, cnt(1)=2
//lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
//                 // cache=[4,3], cnt(4)=1, cnt(3)=2
//lfu.get(1);      // return -1 (not found)
//lfu.get(3);      // return 3
//                 // cache=[3,4], cnt(4)=1, cnt(3)=3
//lfu.get(4);      // return 4
//                 // cache=[4,3], cnt(4)=2, cnt(3)=3
// 
//
//Constraints:
//
//1 <= capacity <= 104
//0 <= key <= 105
//0 <= value <= 109
//At most 2 * 105 calls will be made to get and put.
package LinkedList.Learning;
import java.util.*;

//approch :
// we will have 2 hashmap 
// one will map the key to the node address
// second will map the frequency of node to a dll where the node resides in 
// a ascending order of most recently used to most frequently used 
// DLL implements every thing in O(1)
public class LFUCache_460 {
	
	static  class Node {
	    int freq;
	    int val;
	    int key;
	    Node next;
	    Node prev;

	    public Node(int key, int val, int freq) {
	        this.key = key;
	        this.freq = freq;
	        this.val = val;
	        next = null;
	        prev = null;
	    }


	    public String  toString(){
	        StringBuilder str= new StringBuilder();
	        str.append("["+key+","+val+","+freq+"]");
	        return str.toString();
	    }

	}

	static class DLL {
	    Node head;
	    Node tail;
	    int size;

	    public DLL() {
	        size = 0;
	        this.head = new Node(-1, -1, -1);
	        this.tail = new Node(-1, -1, -1);
	        head.next=tail;
	        tail.prev=head;
	    }

	    public String toString(){
	        StringBuilder res= new StringBuilder();
	        Node ptr = this.getHead();
	        while(ptr!=tail){
	            res.append(ptr).append(",");
	            ptr=ptr.next;
	        }
	        res.deleteCharAt(res.length()-1);
	        return res.toString();
	    }
	    public void addFirst(Node node) {
	        Node next = head.next;
	        // cconnect after head
	        head.next = node;
	        node.prev = head;

	        // connect previous next 
	        next.prev = node;
	        node.next = next;
	        size++;
	    }

	    public void addLast(Node node) {
	        Node prev = tail.prev;
	        // connect before node
	        prev.next = node;
	        node.prev = prev;
	        // connect with tail
	        tail.prev = node;
	        node.next = tail;
	        size++;
	    }

	    public void remove(Node node) {
	        Node prev = node.prev;
	        Node next = node.next;

	        prev.next = next;
	        next.prev = prev;
	        node.next = null;
	        node.prev = null;
	        size--;
	    }

	    public Node getHead() {
	        return size == 0 ? null : head.next;
	    }

	    public Node getTail() {
	        return size == 0 ? null : tail.prev;
	    }
	}

	static class LFUCache {
	    TreeMap<Integer, DLL> fmap;
	    HashMap<Integer, Node> nodemap = new HashMap();
	    int capacity;

	    public LFUCache(int capacity) {
	        this.capacity = capacity;
	        fmap = new TreeMap();
	        nodemap = new HashMap();
	    }

	    public int get(int key) {
	        if(nodemap.containsKey(key)){
	            Node node = nodemap.get(key);

	            int val = node.val;
	            int oldfreq= node.freq;
	            DLL list = fmap.get(oldfreq);
	            list.remove(node);
	            // update node :
	            node.freq++;
	            int freq= node.freq;
	            if(fmap.containsKey(freq)){
	                DLL dll = fmap.get(freq);
	                dll.addFirst(node);
	            }else{
	                DLL dll = new DLL();
	                dll.addFirst(node);
	                fmap.put(freq,dll);
	            }
	            if(list.size==0){
	                fmap.remove(oldfreq);
	            }
	            return val;
	        }else{

	            return -1;
	        }
	    }

	    public void put(int key, int value) {
	        // System.out.println("before put :"+key+" , "+value);
	        // System.out.println(nodemap);
	        // System.out.println(fmap);
	        if (nodemap.containsKey(key)) {
	            Node node = nodemap.get(key);
	            int oldfreq = node.freq;
	            // remove the node from the current freq list 
	            DLL dll = fmap.get(oldfreq);
	            dll.remove(node);

	            // update the node
	            node.freq++;
	            node.val = value;

	            int freq = node.freq;
	            // if that freq exists we can put it to there lists 
	            if (fmap.containsKey(freq)) {
	                DLL list = fmap.get(freq);
	                list.addFirst(node);
	            } else {
	                // other wise we will create the entry;
	                DLL list = new DLL();
	                list.addFirst(node);
	                fmap.put(freq, list);
	            }
	            if (dll.size == 0) {
	                fmap.remove(oldfreq);
	            }
	        } else {
	            if (nodemap.size() == capacity) {
	                Map.Entry<Integer,DLL> first = fmap.firstEntry();
	                if(first==null){
	                    // System.out.println("Some thing is wrong :");
	                }
	                DLL list = first.getValue();
	                Node tail = list.getTail();
	                list.remove(tail);
	                int k = tail.key;
	                nodemap.remove(k);
	                Node node = new Node(key,value,1);
	                nodemap.put(key,node);
	                if (fmap.containsKey(node.freq)) {
	                    fmap.get(node.freq).addFirst(node);
	                } else {
	                    DLL dll = new DLL();
	                    dll.addFirst(node);
	                    fmap.put(node.freq, dll);
	                }       
	            } else {
	                Node node = new Node(key, value, 1);
	                nodemap.put(key, node);
	                if (fmap.containsKey(node.freq)) {
	                    fmap.get(node.freq).addFirst(node);
	                } else {
	                    DLL list = new DLL();
	                    list.addFirst(node);
	                    fmap.put(node.freq, list);
	                }
	            }
	        }
	        // System.out.println("after put :"+key+" , "+value);
	        // System.out.println(nodemap);
	        // System.out.println(fmap);
	    }
	}

	/**
	 * Your LFUCache object will be instantiated and called as such:
	 * LFUCache obj = new LFUCache(capacity);
	 * int param_1 = obj.get(key);
	 * obj.put(key,value);
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LFUCache lfu = new LFUCache(2);
		lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
		lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
		System.out.println(lfu.get(1));
		                 // cache=[1,2], cnt(2)=1, cnt(1)=2
		lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
		                 // cache=[3,1], cnt(3)=1, cnt(1)=2
//		lfu.get(2);      // return -1 (not found)
		System.out.println(lfu.get(2));
		System.out.println(lfu.get(3));
//		lfu.get(3);      // return 3
		                 // cache=[3,1], cnt(3)=2, cnt(1)=2
		lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
		                 // cache=[4,3], cnt(4)=1, cnt(3)=2
//		lfu.get(1);      // return -1 (not found)
//		lfu.get(3);      // return 3
		System.out.println(lfu.get(1));
		System.out.println(lfu.get(3));
		System.out.println(lfu.get(4));
		                 // cache=[3,4], cnt(4)=1, cnt(3)=3
//		lfu.get(4);      // return 4
		                 // cache=[4,3], cnt(4)=2, cnt(3)=3
	}

}
