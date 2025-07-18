package Queue.QueueUtils;

public class CreateQueue {
	int [] queue;
	int end ;
	private final int DEFAULT_SIZE=10;
	public CreateQueue() {
		queue= new int[DEFAULT_SIZE];
		end=-1;
	}
	public CreateQueue(int size) {
		queue= new int[size];
		end=-1;
	}
	
	
	public boolean insert(int val) {
		if(isFull()) {
			throw new RuntimeException("Queue is Full !");
		}
		end++;
		queue[end]=val;
		return true;
	}
	
	public int remove() {
		if(isEmpty()) {
			throw new RuntimeException("Queue is Empty!");
		}
		int val = queue[0];
//		shift the elements 
		for(int i=1;i<end;i++) {
			queue[i-1]=queue[i];
		}
		end--;
		return val;
	}
	
	public int peek() {
		if(isEmpty()) {
			throw new RuntimeException("Queue is Empty!");
		}
		return queue[0];
	}
	
	
	public boolean isFull() {
		return end==queue.length-1;		
	}
	
	public boolean isEmpty() {
		return end==-1;		
	}
	
	
	public static void main(String[] args) {
		
	}

}
