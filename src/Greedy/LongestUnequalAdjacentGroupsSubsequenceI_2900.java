//2900. Longest Unequal Adjacent Groups Subsequence I
//Solved
//Easy
//Topics
//Companies
//Hint
//You are given a string array words and a binary array groups both of length n, where words[i] is associated with groups[i].
//
//Your task is to select the longest alternating subsequence from words. A subsequence of words is alternating if for any two consecutive strings in the sequence, their corresponding elements in the binary array groups differ. Essentially, you are to choose strings such that adjacent elements have non-matching corresponding bits in the groups array.
//
//Formally, you need to find the longest subsequence of an array of indices [0, 1, ..., n - 1] denoted as [i0, i1, ..., ik-1], such that groups[ij] != groups[ij+1] for each 0 <= j < k - 1 and then find the words corresponding to these indices.
//
//Return the selected subsequence. If there are multiple answers, return any of them.
//
//Note: The elements in words are distinct.
//
// 
//
//Example 1:
//
//Input: words = ["e","a","b"], groups = [0,0,1]
//
//Output: ["e","b"]
//
//Explanation: A subsequence that can be selected is ["e","b"] because groups[0] != groups[2]. Another subsequence that can be selected is ["a","b"] because groups[1] != groups[2]. It can be demonstrated that the length of the longest subsequence of indices that satisfies the condition is 2.
//
//Example 2:
//
//Input: words = ["a","b","c","d"], groups = [1,0,1,1]
//
//Output: ["a","b","c"]
//
//Explanation: A subsequence that can be selected is ["a","b","c"] because groups[0] != groups[1] and groups[1] != groups[2]. Another subsequence that can be selected is ["a","b","d"] because groups[0] != groups[1] and groups[1] != groups[3]. It can be shown that the length of the longest subsequence of indices that satisfies the condition is 3.
//
// 
//
//Constraints:
//
//1 <= n == words.length == groups.length <= 100
//1 <= words[i].length <= 10
//groups[i] is either 0 or 1.
//words consists of distinct strings.
//words[i] consists of lowercase English letters.

package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestUnequalAdjacentGroupsSubsequenceI_2900 {
	
//	greedy approch 
//	take first element as innital answer and 
//	find the next element with aletring number in group
//	like if current l =0 find next element whihc have group 1
//	and vice verse in tthe entire array 
//	time complexity :O(n)
//	space complexity :O(n)
	   public static List<String> getLongestSubsequence(String[] words, int[] groups) {
	        List<String> res= new ArrayList<String>();
	        int l=0;
	        int r= 1;
	        int n = groups.length;
	        res.add(words[0]);
	        while(r<n){
	            while(r<n && groups[r]==groups[l]){
	                r++;
	            }
	            if(r<n){
	            res.add(words[r]);
	            l=r;
	            }
	            r++;
	        }

	        return res;

	    }



	public static void main(String[] args) {
		
		//Example 1:

		String []words1 = {"e","a","b"};
		int [] groups1 = {0,0,1};
		List<String> output1= new ArrayList(Arrays.asList("e","b"));

		//Example 2:

		String []words2 = {"a","b","c","d"};
		int [] groups2 = {1,0,1,1};
		List<String> output2= new ArrayList(Arrays.asList("a","b","c"));
		
		List<String> ans1= getLongestSubsequence(words1, groups1);
		List<String> ans2= getLongestSubsequence(words2, groups2);

		if(output1.equals(ans1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output :"+output1 );
			System.out.println("Your Output :"+ans1);
		}
		if(output2.equals(ans2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Actual Output :"+output2 );
			System.out.println("Your Output :"+ans2);
		}

	}

}
