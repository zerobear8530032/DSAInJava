//Kth Largest Element in a Stream
//Solved
//Design a class to find the kth largest integer in a stream of values, including duplicates. E.g. the 2nd largest from [1, 2, 3, 3] is 3. The stream is not necessarily sorted.
//
//Implement the following methods:
//
//constructor(int k, int[] nums) Initializes the object given an integer k and the stream of integers nums.
//int add(int val) Adds the integer val to the stream and returns the kth largest integer in the stream.
//Example 1:
//
//Input:
//["KthLargest", [3, [1, 2, 3, 3]], "add", [3], "add", [5], "add", [6], "add", [7], "add", [8]]
//
//Output:
//[null, 3, 3, 3, 5, 6]
//
//Explanation:
//KthLargest kthLargest = new KthLargest(3, [1, 2, 3, 3]);
//kthLargest.add(3);   // return 3
//kthLargest.add(5);   // return 3
//kthLargest.add(6);   // return 3
//kthLargest.add(7);   // return 5
//kthLargest.add(8);   // return 6
//Constraints:
//
//1 <= k <= 1000
//0 <= nums.length <= 1000
//-1000 <= nums[i] <= 1000
//-1000 <= val <= 1000
//There will always be at least k integers in the stream when you search for the kth integer.
package heaps;

import java.util.PriorityQueue;

class KthLargest {
    PriorityQueue<Integer> minHeap;
    int cap ;
    public KthLargest(int k, int[] nums) {
        minHeap= new PriorityQueue();
        cap=k;
        for(int x:nums){
            minHeap.add(x);
            if(minHeap.size()>k){
                minHeap.remove();
            }
        }
    }

    public int add(int val) {
        minHeap.add(val);
        if(minHeap.size()>cap){
            minHeap.remove();
        }
        return minHeap.peek();
    }
}

public class KthLargestElementInAStream_NEETCODE {
    public static void main(String[] args) {

        KthLargest kthLargest = new KthLargest(3, new int [] {1, 2, 3, 3});
        kthLargest.add(3);   // return 3
        kthLargest.add(5);   // return 3
        kthLargest.add(6);   // return 3
        kthLargest.add(7);   // return 5
        kthLargest.add(8);   // return 6

    }
}
