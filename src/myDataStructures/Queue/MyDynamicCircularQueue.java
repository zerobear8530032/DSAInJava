package myDataStructures.Queue;

import java.util.ArrayDeque;

import myDataStructures.LinkedList.MySinglyCircularLinkedList;


public class MyDynamicCircularQueue {
	MySinglyCircularLinkedList Queue;
	int size;
	public MyDynamicCircularQueue() {
		Queue = new MySinglyCircularLinkedList();	
		size=Queue.size();
	}
	
	public boolean isEmpty() {
		return Queue.isEmpty();
	}
	
	
	public void enQueue(int element) {
		Queue.insertAtTail(element);
		size=Queue.size();
	}
	public int deQueue() {
		if(isEmpty()) {
			throw new  IndexOutOfBoundsException();
		}
	
		int element= Queue.getTail().getValue();
		Queue.deleteAtHead();
		return element;		
	}
	public int peek() {
		return 	Queue.getTail().getValue();
	}
	
	public int getSize() {
		return Queue.size();
	}

	
	public void clear() {
		Queue.clear();
		
	}
	
	@Override
	public String toString() {
	  return Queue.toString();
	}
	

	public static void main(String[] args) {
		
		MyStaticQueue queue = new MyStaticQueue(5);
		System.out.println(queue);
		queue.enQueue(1);
		System.out.println(queue);
		queue.enQueue(2);
		System.out.println(queue);
		queue.enQueue(3);
		System.out.println(queue);
		queue.enQueue(4);
		System.out.println(queue);
		queue.enQueue(5);
		System.out.println(queue);
		
		queue.deQueue();
		System.out.println(queue);
		queue.deQueue();
		System.out.println(queue);
		queue.deQueue();
		System.out.println(queue);
		queue.deQueue();
		System.out.println(queue);
		queue.deQueue();
		System.out.println(queue);
				
	}
	

}
