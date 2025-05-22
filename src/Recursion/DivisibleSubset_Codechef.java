//Divisible Subset
//Read problems statements in Mandarin Chinese and Russian.
//You are given a multiset of N integers. Please find such a nonempty subset of it that the sum of the subset's elements is divisible by N. Otherwise, state that this subset doesn't exist.
//
//Input
//The first line of the input contains an integer T denoting the number of test cases. The description of T test cases follows.
//The first line of each test consists of a single integer N - the size of the multiset.
//The second line of each test contains N single space separated integers - the multiset's elements.
//
//Output
//For each test case output:
//
//-1 if the required subset doesn't exist
//If the required subset exists, output two lines. Output the size of the subset on the first line and output the list of indices of the multiset's element that form the required subset. Of course, any number can be taken in the subset no more than once.
//If there are several such subsets, you can output any.
//Constraints
//
//1 <= The sum of N over all the test cases <= 105
//Each element of the multiset is a positive integer, not exceeding 109.
//1 <= N <= 15 : 37 points.
//1 <= N <= 1000 : 24 points.
//1 <= N <= 105 : 39 points.
//Example
//Input:
//1
//3
//4 6 10
//Output:
//1
//2
//
//
//Explanation
//We can pick {6} as the subset, then its sum is 6 and this is divisible by 3 - the size of the initial multiset.
//
//Did you like the problem statement?
//16 users found this helpful
//More Info
//Time limit1 secs
//Memory limit1.5 GB
//Source Limit50000 Bytes


package Recursion;
import java.util.*;
import java.lang.*;
import java.io.*;

public class DivisibleSubset_Codechef{
    
//	approch : geenrate all subsets 
//	and return which satisfy the condition
//	time complexity :O(2^n)
//	space complexity :O(2^n)
    public static void  subsets(List<Integer> process,int [] unprocess, int sum, int idxunprocess,List<List<Integer>> subset){
        if(idxunprocess==unprocess.length){
            if(sum != 0 && sum%unprocess.length==0){
                subset.add(new ArrayList(process));
            }
            return ;
        }
        //  take one 
        process.add(idxunprocess+1);
        subsets(process,unprocess,sum+ unprocess[idxunprocess],idxunprocess+1,subset);
        // back track
        process.remove(process.size()-1);
        // leave one
        subsets(process,unprocess,sum,idxunprocess+1,subset);
        
    }
    
    public static void findSubsets(int [] unprocess) throws java.lang.Exception{
	    
    	List<List<Integer>> subsets= new ArrayList();
	    subsets(new ArrayList(),unprocess,0,0,subsets);
	    if(subsets.size()!=0){
	        List<Integer> res= subsets.get(0);
	        System.out.println(res.size());
	        for(int i =0;i<res.size();i++){
	            System.out.print(res.get(i)+" ");
	        }
	    }else{
	        System.out.println(-1);
	    }
	}
    
	public static void main (String[] args) throws java.lang.Exception
	{
		
		int []multisets= {4,6,10};
		findSubsets(multisets);
	}
}
