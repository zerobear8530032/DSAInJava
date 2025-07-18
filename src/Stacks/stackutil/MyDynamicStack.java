package Stacks.stackutil;

import java.util.Stack;

public class MyDynamicStack  extends MyStack{
	
	public MyDynamicStack() {
		super();
	}
	
	
	@Override
	public boolean push(int val) {
//		this took care of the storage 
		if(this.isFull()) {
//			double the array size :
			int size = this.stack.length;
			int [] biggerstack =  new int [size*2];
			for(int i =0;i<this.stack.length;i++) {
				biggerstack[i]=stack[i];
			}
			stack=biggerstack;
		}
//		we can call the original push of the static class :
		return super.push(val);
	}
}
