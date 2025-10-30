package heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class MedianFinder {
    PriorityQueue<Double> minHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue();
    }
    
    public void addNum(int num) {
        double x= num;
        minHeap.add(x);
    }
    
    public double findMedian() {
        List<Double> elem = new ArrayList<>();
        if(minHeap.size()==1){
            return minHeap.peek();
        }
        while(!minHeap.isEmpty()){
            elem.add(minHeap.remove());
        }

        System.out.println(elem);
        for(double x:elem){
            minHeap.add(x);
        }
        int n = elem.size();
        if(n%2==0){
            double n1 = elem.get(n/2-1);
            double n2 = elem.get((n/2));
            return (n1+n2)/2;
        }else{
            return elem.get(n/2);
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);    // arr = [1]
        medianFinder.findMedian(); // return 1.0
        medianFinder.addNum(3);    // arr = [1, 3]
        medianFinder.findMedian(); // return 2.0
        medianFinder.addNum(2);    // arr[1, 2, 3]
        medianFinder.findMedian(); // return 2.0
    }
}
