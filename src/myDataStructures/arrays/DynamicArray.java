package myDataStructures.arrays;

import java.util.Arrays;

public class DynamicArray {
	private	int [] arr ;
	private	int size;
	private int capacity;
	final private int DEFAULT_CAPACITY=5;

	public DynamicArray(int size) {// intitial size constructor
		arr= new int[size];
		this.size=0;
		this.capacity=size;
	}
	public DynamicArray() {// default constructor
		arr= new int[DEFAULT_CAPACITY];
		this.size=0;
		this.capacity=DEFAULT_CAPACITY;
	}
	public void insert(int index, int element) {// insert element at index
		if(size==capacity) {
			resize();
		}
		for(int i =size;i>index;i--) {
			arr[i]=arr[i-1];
		}
		arr[index]=element;
		size++;
	}
	public void add(int element) {// add element;
		if(size==capacity) {// check first can we add the element other if not resize it
			resize();
		}
		arr[size]=element;
		size++;
	}
	public int get(int index) {// return the element at index
		 if (index < 0 || index >= size) {
		        throw new IndexOutOfBoundsException("Index out of range");
		    }
		return arr[index];
	}
	public void set(int index,int element) {// set the element at index
		 if (index < 0 || index >= size) {
		        throw new IndexOutOfBoundsException("Index out of range");
		    }
		arr[index]=element;
	}
	public int capacity() {// return capacity of array 
		return capacity;
	}
	public boolean isEmpty() {// return false if array have element other wise return true
		return size==0;
	}
	public void clear() {// this clear the array only 
		 this.size=0;
	}
	public void removeAll() {// clear every thing and return to intial state
		arr= new int [DEFAULT_CAPACITY];
		size=0;
		capacity=DEFAULT_CAPACITY;
	}
	private  void resize() {// double the size	
		int newcap = 2*this.capacity;
		int oldarr []= arr;
		this.arr= new int [newcap];
		for(int i =0;i<oldarr.length;i++) {
			arr[i]=oldarr[i];
		}
		this.capacity= newcap;
	}
	public void remove(int index) {// remove element at index 
		   if (index < 0 || index >= size) { // Validate index
		        throw new IndexOutOfBoundsException("Index out of range");
		    }
		for(int i=index;i<size;i++) {// shift 
			arr[i]=arr[i+1];
		}
		size--;
		if(size==capacity/4) {
			shrink();
		}
	}
	public int indexOf(int element) {// return index of elemtn
		for(int i =0;i<size;i++) {
			if(arr[i]==element) {
				return i;
			}
		}
		return -1;
	}
	public  int size() {// this return size
		return size;
	}
	
	public boolean contains(int element) {// this return true or false on the basic of element present or not
		return indexOf(element)>=0;
	}
	
	public void sort() {// this is like this because right now i am focus on array not algos 
		    Arrays.sort(arr, 0, size);

	}
	private  void shrink() {// double the size	
		int newcap = this.capacity/2;
		int oldarr []= arr;
		this.arr= new int [newcap];
		for(int i =0;i<size;i++) {
			arr[i]=oldarr[i];
		}
		this.capacity= newcap;
	}
	@Override
	public String toString() {
		if(size==0) {
			return "[]";
		}
		StringBuilder str = new StringBuilder("[");
		
		 for (int i = 0; i < size - 1; i++) {
		        str.append(arr[i]).append(", ");
		    }
		    str.append(arr[size - 1]).append("]");
		    return str.toString();
	}	

}
