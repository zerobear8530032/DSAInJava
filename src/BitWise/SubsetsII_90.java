//90. Subsets II
//Medium
//Topics
//Companies
//Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
//
//The solution set must not contain duplicate subsets. Return the solution in any order.
//
// 
//
//Example 1:
//
//Input: nums = [1,2,2]
//Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
//Example 2:
//
//Input: nums = [0]
//Output: [[],[0]]
// 
//
//Constraints:
//
//1 <= nums.length <= 10
//-10 <= nums[i] <= 10

package BitWise;
import java.util.List;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Arrays;
class SubsetsII_90 {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
    	Arrays.sort(nums);
        double end = Math.pow(2,nums.length);
        HashSet<List<Integer>> set= new HashSet();
        int n=nums.length;
        List<List<Integer>> ans  = new ArrayList();
        ans.add(new ArrayList());// for no value sub set
        for(int i=1;i<end;i++){
            String x =Integer.toBinaryString(i);
            
            List<Integer> temp = new ArrayList();
            int index=0;
            for(int j =x.length()-1;j>=0;j--) {
            	if(x.charAt(j)=='1') {
            		temp.add(nums[index]);
            	}
            	index++;
            }
            set.add(temp);
        }
        ans.addAll(set);
        return ans;
        		
    }
    public static void main(String[] args) {
    	
    	//Example 1:

    	int [] nums1 = {1,2,2};
    	int [] nums2 = {0};
    	
    	
    	System.out.println(subsetsWithDup(nums1));
    	//Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
    	//Example 2:
    	//
    	//Input: nums = [0]
    	//Output: [[],[0]]

		
	}
}