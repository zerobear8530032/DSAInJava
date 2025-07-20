package Queue;

import Queue.QueueUtils.CircularArrQueue;

public class QueueMain {
	
	public static void main(String[] args) {


		CircularArrQueue queue = new CircularArrQueue(14);

		queue.insert(1);
		queue.insert(2);
		queue.insert(3);
		queue.insert(4);
		queue.insert(5);
		queue.insert(6);
		queue.insert(7);
		queue.insert(8);
		queue.insert(9);
		queue.insert(10);
		queue.insert(11);
		queue.insert(12);
		queue.insert(13);
		queue.insert(14);
		
		queue.disaplay();
		System.out.println("pop elements ");
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.peek());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		
	}

}
