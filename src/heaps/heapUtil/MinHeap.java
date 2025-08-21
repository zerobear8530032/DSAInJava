package heaps.heapUtil;

import java.util.ArrayList;
import java.util.List;

public class MinHeap <T extends Comparable<T>> {

    private List<T> heap ;
    public MinHeap(){
        heap= new ArrayList<>();
    }

    public void insert(T val){
        heap.add(val);
        upheap(heap.size()-1);
    }

    public void upheap(int idx){
        if(idx==0){return;}
            int parentidx= parent(idx);
            if(heap.get(idx).compareTo(heap.get(parentidx))<0){// this means swap\
                swap(parentidx,idx);
                upheap(parentidx);
            }
    }

    public boolean isEmpty(){
        return heap.size()==0;
    }

    public T remove() throws RuntimeException{
        if(isEmpty()){
            throw new RuntimeException("Heap is Empty");
        }
        T remove = heap.get(0);
        T last = heap.remove(heap.size()-1);
        if(!heap.isEmpty()){
            heap.set(0,last);
            downheap(0);
        }
        return remove;
    }


    public T peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("Heap is Empty");
        }
        return heap.get(0);
    }

    public int size() {
        return heap.size();
    }

    private void downheap(int idx){
        int min = idx;
        int left = leftChild(idx);
        int right= rightChild(idx);
        if(left < heap.size() && heap.get(min).compareTo(heap.get(left))>0){
            min =left;
        }
        if(right < heap.size() && heap.get(min).compareTo(heap.get(right))>0){
            min =right;
        }
        if(min!=idx){
            swap(min,idx);
            downheap(min);
        }
    }

    private int parent(int idx){return (idx-1)/2;}
    private int leftChild(int idx){return idx*2+1;}
    private int rightChild(int idx){return idx*2+2;}

    private void swap(int f, int s){
        T temp = heap.get(f);
        heap.set(f,heap.get(s));
        heap.set(s,temp);
    }
}
