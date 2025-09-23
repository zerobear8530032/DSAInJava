//3690. Split and Merge Array Transformation
//Medium
//premium lock icon
//Companies
//Hint
//You are given two integer arrays nums1 and nums2, each of length n. You may perform the following split-and-merge operation on nums1 any number of times:
//
//Choose a subarray nums1[L..R].
//Remove that subarray, leaving the prefix nums1[0..L-1] (empty if L = 0) and the suffix nums1[R+1..n-1] (empty if R = n - 1).
//Re-insert the removed subarray (in its original order) at any position in the remaining array (i.e., between any two elements, at the very start, or at the very end).
//Return the minimum number of split-and-merge operations needed to transform nums1 into nums2.
//
//
//
//Example 1:
//
//Input: nums1 = [3,1,2], nums2 = [1,2,3]
//
//Output: 1
//
//Explanation:
//
//Split out the subarray [3] (L = 0, R = 0); the remaining array is [1,2].
//Insert [3] at the end; the array becomes [1,2,3].
//Example 2:
//
//Input: nums1 = [1,1,2,3,4,5], nums2 = [5,4,3,2,1,1]
//
//Output: 3
//
//Explanation:
//
//Remove [1,1,2] at indices 0 - 2; remaining is [3,4,5]; insert [1,1,2] at position 2, resulting in [3,4,1,1,2,5].
//Remove [4,1,1] at indices 1 - 3; remaining is [3,2,5]; insert [4,1,1] at position 3, resulting in [3,2,5,4,1,1].
//Remove [3,2] at indices 0 - 1; remaining is [5,4,1,1]; insert [3,2] at position 2, resulting in [5,4,3,2,1,1].
//
//
//Constraints:
//
//2 <= n == nums1.length == nums2.length <= 6
//-105 <= nums1[i], nums2[i] <= 105
//nums2 is a permutation of nums1.


package DynamicProgramming;

import java.util.*;

public class SplitAndMergeArrayTransformation_3690 {
//    use bfs to try every single possible merge and split to get the answer
//    bfs will always get the fastest answer so we does not need to compare it with other routes
//    time complexity : O(n!⋅n3)
//    space complexity : O(n!⋅n3)
    public static int minSplitMerge(int[] nums1, int[] nums2) {
        Queue<List<Integer>> queue = new LinkedList<>();
        List<Integer> nums1list = new ArrayList<>();
        List<Integer> target = new ArrayList<>();
        HashSet<String> seen = new HashSet<>();
        for (int x : nums1) {
            nums1list.add(x);
        }
        for (int x : nums2) {
            target.add(x);
        }
        if(target.equals(nums1list)){
            return 0;
        }
        queue.add(nums1list);
        int count =1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int iteration =0;iteration<size;iteration++){
                List<Integer> poped = queue.remove();
                String combstr = poped.toString();
                if (seen.contains(combstr)) {
                    continue;
                } else {
                    seen.add(combstr);
                }
                for (int i = 0; i < poped.size(); i++) {
                    for (int j = i + 1; j < poped.size() + 1; j++) {
                        List<Integer> sublist = copyRange(poped, i, j);
                        List<Integer> deleted = deleteRange(poped, i, j);
                        for (int index = 0; index <= deleted.size(); index++) {
                            List<Integer> combination = new ArrayList<>(deleted);
                            combination.addAll(index, sublist);
                            queue.add(combination);
                            if (combination.equals(target)) {
                                return count;
                            }
                        }
                    }
                }
            }
            count++;
        }
        return -1;
    }
    public static List<Integer> copyRange(List<Integer> list, int s, int e){
        if(s<0 || e<0 || s>list.size() || e>list.size()){
            throw new IndexOutOfBoundsException("list size :"+list.size()+" but index were given s:"+s+" e:"+e);
        }
        List<Integer> copyList= new ArrayList<>();
        for(int i=s;i<e;i++){
            copyList.add(list.get(i));
        }
        return copyList;
    }

    public static List<Integer> deleteRange(List<Integer> list, int s, int e){
        if(s<0 || e<0 || s>list.size() || e>list.size()) {
            throw new IndexOutOfBoundsException("list size :" + list.size() + " but index were given s:" + s + " e:" + e);
        }
        List<Integer> output= new ArrayList<>();
        for(int i =0;i<list.size();i++){
            if(i>=s && i<e){
                continue;
            }
            output.add(list.get(i));
        }
        return output;
    }
    public static void main(String[] args) {
        //Example 1:

        int [] nums11 = {3,1,2}, nums12 = {1,2,3};
        int output1=1;

        //Example 2:

        int [] nums21 = {1,1,2,3,4,5}, nums22 = {5,4,3,2,1,1};
        int output2=3;

        System.out.println(minSplitMerge(nums11,nums12));
        System.out.println(minSplitMerge(nums21,nums22));
    }
}