package myDataStructures.Queue;

import java.util.ArrayDeque;


public class MyStaticQueue {
	private int front ;
	private int rear ;
	private int[] Queue;
	private int size ;
	private int DEFAULT_INITIAL_SIZE=100;
	private int elements ;
	public MyStaticQueue() {
		front =-1;
		rear =-1;
		Queue = new int [DEFAULT_INITIAL_SIZE];	
		this.size=DEFAULT_INITIAL_SIZE;	
		elements=0;
	}
	public MyStaticQueue(int size) {
		front =-1;
		rear =-1;
		Queue = new int [size];	
		this.size=size;
		elements=0;
	}
	
	public boolean isEmpty() {
		return front==-1;
	}
	public boolean isFull() {
		return rear==Queue.length-1;
	}
	
	public void enQueue(int element) {
		if(isFull()) {
			throw new  ArrayIndexOutOfBoundsException();
		}
		if (front == -1) { // If queue is empty, initialize front to 0
            front = 0;
        }
		rear++;
		Queue[rear]=element;
		elements++;
	}
	public int deQueue() {
		if(isEmpty()) {
			throw new  ArrayIndexOutOfBoundsException();
		}
	
		int element= Queue[front];
		front++;
		elements--;
		if(front > rear) {
			rear=-1;
			front=-1;
		}
		return element;
		
		
	}
	public int peek() {
		return 	Queue[front];
	}
	
	public int getSize() {
		return size;
	}

	public int size() {
		return elements;
	}
	
	public boolean contains(int e) {
		if(isEmpty()) {return false;}
		for(int i=front;i<rear;i++) {
			if(e==Queue[i]) {
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
			for(int i =front;i<rear;i++) {
				str.append(Queue[i]).append(",");
			}
			str.append(Queue[rear]).append("]");
		
		
		return str.toString();
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
		System.out.println(queue.rear);
		
	}
	

}
