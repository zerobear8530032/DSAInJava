package HashMap;

import java.util.LinkedHashMap;
import java.util.Map;

import java.util.HashMap;

class DNode {
    int key;
    int val;
    DNode prev;
    DNode next;

    public DNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class DLL {
    DNode head;
    DNode tail;

    public DLL() {
        head = new DNode(0, 0);  // dummy head
        tail = new DNode(0, 0);  // dummy tail
        head.next = tail;
        tail.prev = head;
    }

    public void addToHead(DNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    public void remove(DNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public DNode removeTail() {
        DNode node = tail.prev;
        remove(node);
        return node;
    }
}

class LRUCache {
    private int capacity;
    private HashMap<Integer, DNode> map;
    private DLL dll;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.dll = new DLL();
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        DNode node = map.get(key);
        dll.remove(node);
        dll.addToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DNode node = map.get(key);
            node.val = value;
            dll.remove(node);
            dll.addToHead(node);
        } else {
            if (map.size() == capacity) {
                DNode tail = dll.removeTail();
                map.remove(tail.key);
            }
            DNode newNode = new DNode(key, value);
            dll.addToHead(newNode);
            map.put(key, newNode);
        }
   
}

    public static void main(String[] args) {
    	LRUCache lRUCache = new LRUCache(1);
    	lRUCache.put(2, 1);
    	System.out.println(lRUCache.get(2));
    	}
}
