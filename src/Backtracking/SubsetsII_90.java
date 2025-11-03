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

package Backtracking;

import java.util.*;

class SubsetsII_90 {
    public static List<List<Integer>> subsetsWithDupBruteForce(int[] nums) {
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

// time complexity : O (n* 2*n)
// space complexity : O (n)
public static List<List<Integer>> subsetsWithDupRec(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> res= new ArrayList();
    helperRec(0,nums,res,new ArrayList());
    return res;
}

    public static void helperRec(int idx, int [] nums , List<List<Integer>> res, List<Integer> curr){
        if(idx==nums.length){
            res.add(new ArrayList(curr));
            return ;
        }
        //  select the element :
        curr.add(nums[idx]);
        helperRec(idx+1,nums,res,curr);
        curr.remove(curr.size()-1);
        //  skip all the elements :
        while(idx+1< nums.length && nums[idx]==nums[idx+1]){
            idx++;
        }
        helperRec(idx+1,nums,res,curr);
    }

    public static boolean check(List<List<Integer>> res, List<List<Integer>> output) {
        if(res.size()!= output.size()){
            return false;
        }
        List<List<Integer>> a = new ArrayList<>();
        for(List<Integer> l: res){
            a.add(new ArrayList<>(l));
        }
        List<List<Integer>> b = new ArrayList<>();
        for(List<Integer> l: res){
            b.add(new ArrayList<>(l));
        }
        for(int i =0;i<a.size();i++){
            boolean ispresent= false;
            for(int j=0;j<b.size();j++){
                if(a.get(i).equals(b.get(j))){
                    ispresent=true;
                }
            }
            if(ispresent==false){
                return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {
    	
    	//Example 1:

    	int [] nums1 = {1,2,1};
        List<List<Integer>> output1= new ArrayList<>(
                Arrays.asList(
                        Arrays.asList(),
                        Arrays.asList(1),
                        Arrays.asList(1,2),
                        Arrays.asList(1,1),
                        Arrays.asList(1,2,1),
                        Arrays.asList(2)
                )
        );

    	int [] nums2 = {0};

        List<List<Integer>> output2= new ArrayList<>(
                Arrays.asList(
                        Arrays.asList(),
                        Arrays.asList(0)
                )
        );
        List<List<Integer>> ans1 = subsetsWithDupBruteForce(nums1);
        List<List<Integer>> ans2 = subsetsWithDupBruteForce(nums2);
        System.out.println("Iterative Approch :");

        if(check(output1,ans1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ output1);
            System.out.println("Your Answer :"+ ans1);
        }

        if(check(output2,ans2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ output2);
            System.out.println("Your Answer :"+ ans2);
        }



       ans1 = subsetsWithDupRec(nums1);
        ans2 = subsetsWithDupRec(nums2);

        System.out.println("Recursion Approch :");

        if(check(output1,ans1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ output1);
            System.out.println("Your Answer :"+ ans1);
        }

        if(check(output2,ans2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ output2);
            System.out.println("Your Answer :"+ ans2);
        }





    }
}