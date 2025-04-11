//18. 4Sum
//Solved
//Medium
//Topics
//Companies
//Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
//
//0 <= a, b, c, d < n
//a, b, c, and d are distinct.
//nums[a] + nums[b] + nums[c] + nums[d] == target
//You may return the answer in any order.
//
// 
//
//Example 1:
//
//Input: nums = [1,0,-1,0,-2,2], target = 0
//Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
//Example 2:
//
//Input: nums = [2,2,2,2,2], target = 8
//Output: [[2,2,2,2]]
// 
//
//Constraints:
//
//1 <= nums.length <= 200
//-109 <= nums[i] <= 109
//-109 <= target <= 109


package TwoPointers;
import java.util.*;
public class FourSum_18 {

//	brute force approch :
//	here we just create 4 nested loop each indivcationg one pointer
//	time complexity : O(n^4)
//	space complexity : O(n^4);
	    public static List<List<Integer>> fourSumBruteForce(int[] nums, int target) {
	    	int n = nums.length;
	    	List<List<Integer>> ans= new ArrayList();
	    	HashSet<List<Integer>> set= new HashSet<List<Integer>>();
	    	
	    	for(int i =0;i<n-3;i++) {
	    		for(int j=i+1;j<n-2;j++) {
	    			for(int k=j+1;k<n-1;k++) {
	    				for(int l=k+1;l<n;l++) {
	    					long sum  = (long)nums[i]+(long)nums[j]+(long)nums[k]+(long)nums[l];
	    					if(sum==target) {
	    						List<Integer> temp=new ArrayList(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));

	    						Collections.sort(temp);
	    						set.add(temp);
	    					}
	    				}
	    			}
	    		}
	    	}
	    	ans.addAll(set);
	        return ans;
	    }
//	Best approch :
//	here we sort the arra y and have 3 nested loop one head of each other
//	and we can use the 2 pointer algo to find the target whre we take 2 pointert
//	one at start one at end and we check if sum  of all == target  we will find next triplets
//	if its small we will increment the left
//	other wise right
//	time complexity : O(n^3)
//	space complexity : O(n^3);
	    public static List<List<Integer>> fourSumBest(int[] nums, int target) {
	    	Arrays.sort(nums);
	    	int i =0;
	    	int n = nums.length;
	    	List<List<Integer>> ans= new ArrayList();
	    	while(i<n-3){
	    		int j =i+1;
	    		while(j<n-2){
	    			int k =j+1;
	    			int l=n-1;
	    			while(k<l){
	    				long sum = (long)nums[i]+(long)nums[j]+(long)nums[k]+(long)nums[l];
	    				if(sum==(long)target){
	    					ans.add(new ArrayList(Arrays.asList(nums[i],nums[j],nums[k],nums[l])));
	    					int currk=nums[k];
	    					while(k<l && nums[k]==currk) k++;
	    					int currl=nums[l];
	    					while(k<l && nums[l]==currl) l--;
	    				}else if(sum<(long)target){
	    					int currk=nums[k];
	    					while(k<l && nums[k]==currk)k++;
	    				}else{
	    					int currl=nums[l];
	    					while(k<l && nums[l]==currl)l--;
	    				}
	    			}
	    			int currj=nums[j];
	    			while(j<n-2 && nums[j]==currj)j++;
	    		}
	    		int curri=nums[i];
	    		while(i<n-3 && curri==nums[i])i++;
	    	}
	    	
	    	return ans;
	    }

	    
	    public static boolean check(List<List<Integer>> ans, List<List<Integer>> output) {
	        if (ans.size() != output.size()) return false;

	        // Sort inner lists
	        for (List<Integer> list : ans) Collections.sort(list);
	        for (List<Integer> list : output) Collections.sort(list);

	        // Sort outer list with custom comparator
	        Comparator<List<Integer>> comp = (a, b) -> {
	            for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
	                int cmp = Integer.compare(a.get(i), b.get(i));
	                if (cmp != 0) return cmp;
	            }
	            return Integer.compare(a.size(), b.size());
	        };

	        Collections.sort(ans, comp);
	        Collections.sort(output, comp);

	        // Now compare sorted lists
	        for (int i = 0; i < ans.size(); i++) {
	            if (!ans.get(i).equals(output.get(i))) return false;
	        }

	        return true;
	    }

	public static void main(String[] args) {
		
		
		//Example 1:
	
		int [] nums1 = {1,0,-1,0,-2,2};
		int target1 = 0;
		List<List<Integer>> output1= new ArrayList<List<Integer>>(Arrays.asList(Arrays.asList(-2,-1,1,2),Arrays.asList(-2,0,0,2),Arrays.asList(-1,0,0,1)));

		//Example 2:
		//
		int [] nums2 = {2,2,2,2,2};
		int target2 = 8;
		List<List<Integer>> output2= new ArrayList<List<Integer>>(Arrays.asList(Arrays.asList(2,2,2,2)));
		
		System.out.println("Brute Force Approch :");
		
		List<List<Integer>> ans1 =fourSumBruteForce(nums1,target1);
		List<List<Integer>> ans2 =fourSumBruteForce(nums2,target2);
		
		 if(check(ans1,output1)) {
				System.out.println("Case 1 Passed ");
			}else {
				System.out.println("Case 1 Failed");
				System.out.println("Excepted Output : "+ (output1));
				System.out.println("Your Output : "+ (nums1));
			}
			if(check(ans2,output2)) {
				System.out.println("Case 2 Passed ");
			}else {
				System.out.println("Case 2 Failed");
				System.out.println("Excepted Output : "+ (output2));
				System.out.println("Your Output : "+ (nums2));
			}
			
			
			System.out.println("Better Force Approch :");
		
			ans1 =fourSumBest(nums1,target1);
			ans2 =fourSumBest(nums2,target2);
			
			
			if(check(ans1,output1)) {
				System.out.println("Case 1 Passed ");
			}else {
				System.out.println("Case 1 Failed");
				System.out.println("Excepted Output : "+ (output1));
				System.out.println("Your Output : "+ (nums1));
			}
			if(check(ans2,output2)) {
				System.out.println("Case 2 Passed ");
			}else {
				System.out.println("Case 2 Failed");
				System.out.println("Excepted Output : "+ (output2));
				System.out.println("Your Output : "+ (nums2));
			}
			
		
	}

}
