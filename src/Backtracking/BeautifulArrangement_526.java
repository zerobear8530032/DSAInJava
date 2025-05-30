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
package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BeautifulArrangement_526 {
	
	
//	brute Force Approch :
//	we can   get all the permutation of 1 to n elements and check each permutation 
//	which satisfy the beautiful arrangment conditions
//	time complexity : O(n!)
//	space complexity : O(n!)
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

//	Better Approch :
//	 we cab try making beutify arrangement by taking only possible integer which could come on that position
//	means we put only element which satisfy perm[i]%i==0 || i%perm[i]
//	and back track to try every single number possible 
//	time complexity : O(n!)
//	space complexity : O(n!)
public static int countArrangementBetter(int n) {
    boolean[] used = new boolean[n + 1];  // index 1 to n
    return backtrack(n, 1, used);
}

private static int backtrack(int n, int pos, boolean[] used) {
    if (pos > n) return 1; 
    int count = 0;
    for (int i = 1; i <= n; i++) {
        if (!used[i] && (i % pos == 0 || pos % i == 0)) {
            used[i] = true;
            count += backtrack(n, pos + 1, used);
            used[i] = false;
        }
    }
    return count;
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
		
		System.out.println("Brute Force Approch :");
		
		int ans1=countArrangementBruteForce(n1);
		int ans2=countArrangementBruteForce(n2);
		int ans3=countArrangementBruteForce(n3);
		
		if(output1==ans1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output :"+output1 );
			System.out.println("Your Output :"+ans1);
		}
		if(output2==ans2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Actual Output :"+output2 );
			System.out.println("Your Output :"+ans2);
		}
		if(output3==ans3) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Actual Output :"+output3);
			System.out.println("Your Output :"+ans3);
		}
		
		System.out.println("Better Approch :");
		
		ans1=countArrangementBruteForce(n1);
		ans2=countArrangementBruteForce(n2);
		ans3=countArrangementBruteForce(n3);
		
		if(output1==ans1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output :"+output1 );
			System.out.println("Your Output :"+ans1);
		}
		if(output2==ans2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Actual Output :"+output2 );
			System.out.println("Your Output :"+ans2);
		}
		if(output3==ans3) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Actual Output :"+output3);
			System.out.println("Your Output :"+ans3);
		}


		
		



	}

}
