//3318. Find X-Sum of All K-Long Subarrays I
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Hint
//You are given an array nums of n integers and two integers k and x.
//
//The x-sum of an array is calculated by the following procedure:
//
//Count the occurrences of all elements in the array.
//Keep only the occurrences of the top x most frequent elements. If two elements have the same number of occurrences, the element with the bigger value is considered more frequent.
//Calculate the sum of the resulting array.
//Note that if an array has less than x distinct elements, its x-sum is the sum of the array.
//
//Return an integer array answer of length n - k + 1 where answer[i] is the x-sum of the subarray nums[i..i + k - 1].
//
//
//
//Example 1:
//
//Input: nums = [1,1,2,2,3,4,2,3], k = 6, x = 2
//
//Output: [6,10,12]
//
//Explanation:
//
//For subarray [1, 1, 2, 2, 3, 4], only elements 1 and 2 will be kept in the resulting array. Hence, answer[0] = 1 + 1 + 2 + 2.
//For subarray [1, 2, 2, 3, 4, 2], only elements 2 and 4 will be kept in the resulting array. Hence, answer[1] = 2 + 2 + 2 + 4. Note that 4 is kept in the array since it is bigger than 3 and 1 which occur the same number of times.
//For subarray [2, 2, 3, 4, 2, 3], only elements 2 and 3 are kept in the resulting array. Hence, answer[2] = 2 + 2 + 2 + 3 + 3.
//Example 2:
//
//Input: nums = [3,8,7,8,7,5], k = 2, x = 2
//
//Output: [11,15,15,15,12]
//
//Explanation:
//
//Since k == x, answer[i] is equal to the sum of the subarray nums[i..i + k - 1].
//
//
//
//Constraints:
//
//1 <= n == nums.length <= 50
//1 <= nums[i] <= 50
//1 <= x <= k <= nums.length
package heaps;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class FindXSumOfAllKLongSubarraysI_3318 {
    static class Entry{
        int val;
        int freq;
        public Entry(int val, int freq){
            this.val=val;
            this.freq=freq;
        }
        public String toString(){
            return "[ value : "+val+" , "+"freq : "+freq+" ]";
        }
    }
    public  static int[] findXSum(int[] nums, int k, int x) {
        HashMap<Integer,Entry> freqMap= new HashMap();
        int l=0;
        int [] res= new int [nums.length-k+1];
        int idx=0;
        for(int r=0;r<nums.length;r++){
            if(freqMap.containsKey(nums[r])){
                freqMap.get(nums[r]).freq++;
            }else{
                freqMap.put(nums[r],new Entry(nums[r],1));
            }
            while(r-l+1 >k){
                freqMap.get(nums[l]).freq--;
                if(freqMap.get(nums[l]).freq==0){
                    freqMap.remove(nums[l]);
                }
                l++;
            }
            if(r-l+1 == k){
                res[idx++]=sumTopFrequentElements(freqMap,x);
            }
        }
        return res;
    }
    public static int sumTopFrequentElements(HashMap<Integer,Entry> map, int k){
        PriorityQueue<Entry> queue = new PriorityQueue(new Comparator<Entry>(){
            @Override
            public int compare(Entry o1,Entry o2){
                if(o1.freq!=o2.freq){
                    return o1.freq-o2.freq;
                }
                return o1.val-o2.val;
            }
        });
        for(int key:map.keySet()){
            queue.add(map.get(key));
            if(queue.size()>k){
                queue.poll();
            }
        }
        int res= 0;
        while(!queue.isEmpty()){
            Entry e= queue.poll();
            res+= (e.val*e.freq);
        }
        return res;
    }

    public static void main(String[] args) {
        //Example 1:

        int [] nums1 = {1,1,2,2,3,4,2,3};
        int k1 = 6, x1 = 2;
        int [] output1= {6,10,12};

        //Example 2:

        int [] nums2 = {3,8,7,8,7,5};
        int k2 = 2, x2 = 2;
        int [] output2= {11,15,15,15,12};

        int [] ans1 = findXSum(nums1,k1,x1);
        int [] ans2 = findXSum(nums2,k2,x2);

        if(Arrays.equals(ans1,output1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+Arrays.toString (output1));
            System.out.println("Your Answer :"+Arrays.toString  (ans1));
        }
        if(Arrays.equals(ans2,output2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+Arrays.toString  (output2));
            System.out.println("Your Answer :"+Arrays.toString  (ans2));
        }




    }
}
