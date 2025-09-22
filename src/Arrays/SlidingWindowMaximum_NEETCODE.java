//Sliding Window Maximum
//You are given an array of integers nums and an integer k. There is a sliding window of size k that starts at the left edge of the array. The window slides one position to the right until it reaches the right edge of the array.
//
//Return a list that contains the maximum element in the window at each step.
//
//Example 1:
//
//Input: nums = [1,2,1,0,4,2,6], k = 3
//
//Output: [2,2,4,4,6]
//
//Explanation:
//Window position            Max
//---------------           -----
//[1  2  1] 0  4  2  6        2
// 1 [2  1  0] 4  2  6        2
// 1  2 [1  0  4] 2  6        4
// 1  2  1 [0  4  2] 6        4
// 1  2  1  0 [4  2  6]       6
//Constraints:
//
//1 <= nums.length <= 1000
//-10,000 <= nums[i] <= 10,000
//1 <= k <= nums.length

package Arrays;

import java.util.Arrays;
import java.util.PriorityQueue;


class Pair implements Comparable<Pair>{
    int val;
    int index;

    public Pair(int val,int index){
        this.val=val;
        this.index=index;
    }

    @Override
    public int compareTo(Pair p){

        return p.val-this.val;
    }

    @Override
    public String toString(){
        StringBuilder res= new StringBuilder("[");
        res.append(val);
        res.append(",");
        res.append(index);
        res.append("]");
        return res.toString();
    }
}

// approch : we can use a sliding window where we can keep adding element at r in queue
// and when the size of the window reaches k we can check element in priority queue
// if the element is in range of l to r we can add it to res and break other wise
// we can poll the element so that we can check next untill queue become empty
// time complexity : O(n log n)
// space complexity : O(n)
public class SlidingWindowMaximum_NEETCODE {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Pair> queue =new  PriorityQueue();
        int l =0;
        int [] ans = new int [nums.length-k+1];
        int idx=0;
        for(int r=0;r<nums.length;r++){
            queue.add(new Pair(nums[r],r));
            int windowSize= r-l+1;
            if(windowSize==k){
                while(!queue.isEmpty()){
                    Pair pair = queue.peek();
                    if(pair!=null && pair.index>=l && pair.index<=r){
                        ans[idx]=pair.val;
                        idx++;
                        break;
                    }else{
                        queue.poll();
                    }
                }
                l++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        //Example 1:

        int [] nums1 = {1,2,1,0,4,2,6};
        int k1 = 3;
        int [] output1= {2,2,4,4,6};
        System.out.println(Arrays.toString(maxSlidingWindow(nums1,k1)));
    }
}
