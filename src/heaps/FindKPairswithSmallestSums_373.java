//Q2. Find K Pairs with Smallest Sums
//Medium
//Topics
//premium lock icon
//Companies
//You are given two integer arrays nums1 and nums2 sorted in non-decreasing order and an integer k.
//
//Define a pair (u, v) which consists of one element from the first array and one element from the second array.
//
//Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.
//
//
//
//Example 1:
//
//Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
//Output: [[1,2],[1,4],[1,6]]
//Explanation: The first 3 pairs are returned from the sequence: [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
//Example 2:
//
//Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
//Output: [[1,1],[1,1]]
//Explanation: The first 2 pairs are returned from the sequence: [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
//
//
//Constraints:
//
//1 <= nums1.length, nums2.length <= 105
//-109 <= nums1[i], nums2[i] <= 109
//nums1 and nums2 both are sorted in non-decreasing order.
//1 <= k <= 104
//k <= nums1.length * nums2.length
package heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class FindKPairswithSmallestSums_373 {
//    we cn use a bfs with priority queue
//    where we can form from one index i to next index j+1
//    time compelxity : O(n*n *log k)
//    space compelxity : O(k)
    static class Entry {
        int i, j, sum;
        Entry(int i, int j, int sum) {
            this.i = i;
            this.j = j;
            this.sum = sum;
        }
    }

    public  static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return res;
        PriorityQueue<Entry> pq = new PriorityQueue<>(
            (a, b) -> a.sum - b.sum
        );

        // push first column (0,0)
        pq.add(new Entry(0, 0, nums1[0] + nums2[0]));

        while (!pq.isEmpty() && res.size() < k) {
            Entry e = pq.poll();
            int i = e.i;
            int j = e.j;

            res.add(Arrays.asList(nums1[i], nums2[j]));

            // push (i, j+1)
            if (j + 1 < nums2.length) {
                pq.add(new Entry(i, j + 1, nums1[i] + nums2[j + 1]));
            }

            // push (i+1, j) ONLY if j == 0
            if (j == 0 && i + 1 < nums1.length) {
                pq.add(new Entry(i + 1, j, nums1[i + 1] + nums2[j]));
            }
        }

        return res;
    }

    public static void main(String[] args) {
        //Example 1:

        int [] nums11 = {1,7,11}, nums12 = {2,4,6};
        int k1 = 3;

        List<List<Integer>> output1 = new ArrayList<>(
        Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(1, 4),
                Arrays.asList(1, 6)
        ));

        //Example 2:

        int [] nums21 = {1,1,2}, nums22 = {1,2,3};
        int k2 = 2;
        List<List<Integer>> output2 = new ArrayList<>(
        Arrays.asList(
                Arrays.asList(1, 1),
                Arrays.asList(1, 1)
        ));

        List<List<Integer>> ans1= kSmallestPairs(nums11,nums12,k1);
        List<List<Integer>> ans2= kSmallestPairs(nums21,nums22,k2);
        if(ans1.equals(output1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+(output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(ans2.equals(output2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+(output2));
            System.out.println("Your Answer :"+ (ans2));
        }



    }
}
