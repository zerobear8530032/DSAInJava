package heaps;

import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {
//    here we can crete 2 heap one hold smaller values and sorted in descending order
//    one holding greater values and sorted in incresing order
//    now when we add a number we can add it to smaller heap if number is smaller then top
//    other wise we store it in the greate heap
//    if greater heap  and smaller heap size  difference absolute value become greater then 2
//    we can pop from greter size heap and push is smaller heap
//    to find median we can see if the size of both heap is equal we can get top of both heap
//    and verage it
//    other wise the heap with larger size holds the mid value or median
//    time complexity : O(N log n)
//    space complexity : O(n)
    PriorityQueue<Double> smaller;
    PriorityQueue<Double> greater;
    int size;
    public MedianFinder() {
        smaller= new PriorityQueue<>(Collections.reverseOrder());
        greater= new PriorityQueue<>();
        size=0;
    }

    public void addNum(int n) {
        size++;
        double num = n;
        if(smaller.isEmpty() && greater.isEmpty()){
            smaller.add(num);
            return;
        }
        if(num>smaller.peek()){
            greater.add(num);
        }else{
            smaller.add(num);
        }

        if(greater.size()==smaller.size()){
            return ;
        }

        if(Math.abs(greater.size()-smaller.size())>1){
            if(greater.size()<smaller.size()){
                greater.add(smaller.poll());
            }else{
                smaller.add(greater.poll());
            }
        }
    }

//    time complexity : O(1)
    public double findMedian() {
        // System.out.println(smaller+" "+greater);
        if(size%2==0){
            return (smaller.peek()+greater.peek())/2.0;
        }
        if(greater.size()>smaller.size()){
            return greater.peek();
        }else{
            return smaller.peek();
        }
    }
}

public class FindMedianFromDataStream_295 {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);    // arr = [1]
        medianFinder.addNum(2);    // arr = [1, 2]
        medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
        medianFinder.addNum(3);    // arr[1, 2, 3]
        medianFinder.findMedian(); // return 2.0
    }

}
