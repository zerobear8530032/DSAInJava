//279. Perfect Squares
//Medium
//Topics
//Companies
//Given an integer n, return the least number of perfect square numbers that sum to n.
//
//A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
//
// 
//
//Example 1:
//
//Input: n = 12
//Output: 3
//Explanation: 12 = 4 + 4 + 4.
//Example 2:
//
//Input: n = 13
//Output: 2
//Explanation: 13 = 4 + 9.
// 
//
//Constraints:
//
//1 <= n <= 104
package Maths;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PerfectSquares_279 {
	
//	brute force approch :
//	first find all the perfect square 
//	then out of that we then we will chose the number of perfect square using recursion DP
	public static int numSquares(int n) {
		List<Integer> perfectSquare = new ArrayList<Integer>();
		for(int i =1;i<=n;i++) {
			if(i*i>n) {
				break;
			}
			perfectSquare.add(i*i);
		}
		return findLeastSquareSum(n, perfectSquare, 0);
	}
	public static int findLeastSquareSum(int  n,List<Integer>perfectSquares, int count) {
		  if (n == 0) return count;
		  int min= Integer.MAX_VALUE;
		  for(int i=0;i<perfectSquares.size();i++) {
			  int x = perfectSquares.get(i);
			  if(n-x<0) {
				  continue;
			  }
			  int res=findLeastSquareSum(n-x, perfectSquares, count+1);
			  min=Math.min(min,res);
		  }
		  return min;
		
	}
	
//	memo approch :
//	first find all the perfect square 
//	then out of that we then we will chose the number of perfect square using recursion DP
//	using memeorization
	public static int numSquaresMemo(int n) {
		List<Integer> perfectSquare = new ArrayList<Integer>();
		for(int i =1;i<=n;i++) {
			if(i*i>n) {
				break;
			}
			perfectSquare.add(i*i);
		}
		HashMap<Integer,Integer> map= new HashMap();
		return findLeastSquareSumMemo(n, perfectSquare, map);
	}
	public static int findLeastSquareSumMemo(int  n,List<Integer>perfectSquares, HashMap<Integer,Integer>  map) {
	       if (n == 0) return 0;
	        if (map.containsKey(n)) return map.get(n);

	        int min = Integer.MAX_VALUE;
	        for (int square : perfectSquares) {
	            if (n - square >= 0) {
	                int res = findLeastSquareSumMemo(n - square, perfectSquares, map);
	                if (res != Integer.MAX_VALUE) {
	                    min = Math.min(min, res + 1);
	                }
	            }
	        }

	        map.put(n, min);
	        return min;
	    
	}



	public static void main(String[] args) {
		
		
		//Example 1:

		int n1 = 12;
		int output1=3;

		//Example 2:

		int n2 = 13;
		int output2=2;
		
		
		System.out.println("Brute Force Approch :");
		
		int ans1 = numSquares(n1);
		int ans2 = numSquares(n2);
		
		if(output1==ans1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ output1);
			System.out.println("Your Answer :"+ ans1);
		}
		if(output2==ans2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ output2);
			System.out.println("Your Answer :"+ ans2);
		}
		
		System.out.println("Memorization Approch :");
		
		ans1 = numSquaresMemo(n1);
		ans2 = numSquaresMemo(n2);
		
		if(output1==ans1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ output1);
			System.out.println("Your Answer :"+ ans1);
		}
		if(output2==ans2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ output2);
			System.out.println("Your Answer :"+ ans2);
		}



	}

}
