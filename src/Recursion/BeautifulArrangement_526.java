//526. Beautiful Arrangement
//Medium
//Topics
//premium lock icon
//Companies
//Suppose you have n integers labeled 1 through n. A permutation of those n integers perm (1-indexed) is considered a beautiful arrangement if for every i (1 <= i <= n), either of the following is true:
//
//perm[i] is divisible by i.
//i is divisible by perm[i].
//Given an integer n, return the number of the beautiful arrangements that you can construct.
//
//Example 1:
//
//Input: n = 2
//Output: 2
//Explanation: 
//The first beautiful arrangement is [1,2]:
//    - perm[1] = 1 is divisible by i = 1
//    - perm[2] = 2 is divisible by i = 2
//The second beautiful arrangement is [2,1]:
//    - perm[1] = 2 is divisible by i = 1
//    - i = 2 is divisible by perm[2] = 1
//Example 2:
//
//Input: n = 1
//Output: 1
// 
//
//Constraints:
//
//1 <= n <= 15
package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BeautifulArrangement_526 {
	
	public static  int countArrangementBruteForce(int n) {
		List<Integer> arr = new ArrayList<Integer>();
		for(int i =1;i<=n;i++) {
			arr.add(i);
		}
		
        return helper(new ArrayList(),arr);
    }
	
	public static int helper(List<Integer> p, List<Integer> unp) {
		if(unp.size()==0) {
			if(isBeautiful(p)) {
				return 1;				
			}
			return 0;
			}
		int mid =unp.get(0);
		int res=0;
		for(int i =0;i<=p.size();i++) {
			List<Integer> left= p.subList(0, i);
			List<Integer> right= p.subList(i, p.size());
			List<Integer> processed=  new ArrayList(left);
			processed.add(mid);
			processed.addAll(right);
			List<Integer> unprocessed=  unp.subList(1,unp.size());
			res += helper(processed,unprocessed);
		}
		return res;
	}

	
	
	public static boolean isBeautiful(List<Integer>arr) {
		for(int i =0;i<arr.size();i++) {
			int n = arr.get(i);
			if((i+1)%n!=0 && n%(i+1)!=0 ) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		
		//Example 1:

		int n1 = 2;
		int output1=2;

		//Example 2:

		int n2 = 1;
		int output2=1;

		//Example 3:
		
		int n3 = 3;
		int output3=3;


		
		



	}

}
