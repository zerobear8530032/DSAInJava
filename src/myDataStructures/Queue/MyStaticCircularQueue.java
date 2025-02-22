package myDataStructures.Queue;

import java.security.DrbgParameters.Capability;
import java.util.ArrayDeque;


public class MyStaticCircularQueue {
	private int front ;
	private int rear ;
	private int[] circularQueue;
	private int size ;
	private int DEFAULT_INITIAL_SIZE=100;
	private int elements ;
	public MyStaticCircularQueue() {
		front =-1;
		rear =-1;
		circularQueue = new int [DEFAULT_INITIAL_SIZE];	
		this.size=DEFAULT_INITIAL_SIZE;	
		elements=0;
	}
	public MyStaticCircularQueue(int size) {
		front =-1;
		rear =-1;
		circularQueue = new int [size];	
		this.size=size;
		elements=0;
	}
	
	public boolean isEmpty() {
		return front==-1 ;
	}
	public boolean isFull() {
		return (rear+1)%size==front;
	}
	
	public void enQueue(int element) {
		if(isFull()) {
			throw new  ArrayIndexOutOfBoundsException();
		}else if(isEmpty()) {// here we check both index are at -1 so that we can insert at 0 inde 
			rear=0;
			front=0;
			circularQueue[rear]=element;
		}else {
			rear=(rear+1)%size;// ciruclarly increment index
			circularQueue[rear]=element;
		}
		element++;		
	}
	public int deQueue() {
		if(isEmpty()) {
			throw new  ArrayIndexOutOfBoundsException();
		}else if(rear==front) {// if both are at same position means there is a single element in the  queue
//			remove it and we got empty queue;
			int val = circularQueue[front];
			rear=front=-1;
			return val;
		}else {
			int val = circularQueue[front];
			front=(front+1)%size;
			return val;
		}
	}
	public int peek() {
		return 	circularQueue[front];
	}
	
	public int capacity() {
		return size;
	}

	public int size() {
		return elements;
	}
	
	public boolean contains(int e) {
		if(isEmpty()) {return false;}
		for(int i=front;i<rear;i++) {
			if(e==circularQueue[i]) {
				return true;
			}
		}
		return false;
	}
	public void clear() {
		front =-1;
		rear=-1;
		elements=0;
	}

     
	
	@Override
	public String toString() {
		if(isEmpty()) {
			return "[]";
		}
			StringBuilder str = new StringBuilder("[");
			for(int i =front;i!=rear;i=(i+1)%size) {
				str.append(circularQueue[i]).append(",");
			}
			str.append(circularQueue[rear]).append("]");
		
		
		return str.toString();
	}
	

	public static void main(String[] args) {
		
		MyStaticCircularQueue queue = new MyStaticCircularQueue(5);
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
		System.out.println(queue);
		queue.deQueue();
		System.out.println(queue);
		queue.deQueue();
		System.out.println(queue);
		queue.deQueue();
		System.out.println(queue);
		queue.deQueue();
		System.out.println(queue);
		queue.enQueue(2);
		System.out.println(queue);
		queue.deQueue();
		System.out.println(queue);
		queue.deQueue();
		System.out.println(queue);
		
		
	}
	

}
