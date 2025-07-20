package Queue.QueueUtils;

import java.util.Arrays;

public class DynamicQueue extends CircularArrQueue {
	public DynamicQueue() {
		super();
	}
	public DynamicQueue(int size) {
		super(size);
	}
	
	@Override
	public boolean insert(int val) {
		if(isFull()) {
			int[] newqueue = new int[queue.length*2];
			for(int i=0;i<queue.length;i++) {
				newqueue[i]=queue[(front+i)%queue.length];
			}
			front=0;
			end=queue.length;
			queue=newqueue;
		}
		return super.insert(val);
	}

}
