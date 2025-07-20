package Queue.QueueUtils;

public class CircularArrQueue {
	protected int [] queue;
	protected int end ;
	protected int front;
	private final int DEFAULT_SIZE=10;
	int size;
	public CircularArrQueue() {
		end=0;
		front=0;
		queue= new int[DEFAULT_SIZE];
	}
	public CircularArrQueue(int size) {
		end=0;
		front=0;
		queue= new int[size];
	}
	
	
	public boolean insert(int val) {
		if(isFull()) {
			throw new RuntimeException("Queue is Full !");
		}
		queue[end]=val;
		end+=1;
		end=end%queue.length;
		size++;
		return true;
	}
	
	public int remove() {
		if(isEmpty()) {
			throw new RuntimeException("Queue is Empty!");
		}
		int val = queue[front];
		front+=1;
		front=front%queue.length;
		size--;
		return val;
	}
	
	public int peek() {
		if(isEmpty()) {
			throw new RuntimeException("Queue is Empty!");
		}
		return queue[front];
	}
	
	
	public boolean isFull() {
		return size==queue.length;		
	}
	
	public boolean isEmpty() {
		return size==0;		
	}
	
	public void disaplay() {
		if(isEmpty()) {
			System.out.println("[]");
		}
		int f= front;
		int e=end;
		System.out.print("[");
		
		for(int i =0;i<size;i++) {
			System.out.print(queue[f+i%queue.length]+"   ");
		}
		System.out.print("]");

		System.out.println();
		
	}
	
}
