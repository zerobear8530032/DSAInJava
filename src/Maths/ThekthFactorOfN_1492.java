//1492. The kth Factor of n
//Solved
//Medium
//Topics
//Companies
//Hint
//You are given two positive integers n and k. A factor of an integer n is defined as an integer i where n % i == 0.
//
//Consider a list of all factors of n sorted in ascending order, return the kth factor in this list or return -1 if n has less than k factors.
//
// 
//
//Example 1:
//
//Input: n = 12, k = 3
//Output: 3
//Explanation: Factors list is [1, 2, 3, 4, 6, 12], the 3rd factor is 3.
//Example 2:
//
//Input: n = 7, k = 2
//Output: 7
//Explanation: Factors list is [1, 7], the 2nd factor is 7.
//Example 3:
//
//Input: n = 4, k = 4
//Output: -1
//Explanation: Factors list is [1, 2, 4], there is only 3 factors. We should return -1.
// 
//
//Constraints:
//
//1 <= k <= n <= 1000
// 
//
//Follow up:
//
//Could you solve this problem in less than O(n) complexity?
package Maths;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ThekthFactorOfN_1492 {
//	brute force approch :
//	first all the factors and add them in the list then 
//	just get the k-1 index factor as answer if it exists
//	other wise -1;
//	time complexity : O(n)
//	space complexity : O(n)
	    public static int kthFactorBruteForce(int n, int k) {
	        List<Integer> factors= new ArrayList<Integer>();
	        for(int i =1;i<=n;i++){
	            if(n%i==0){
	                factors.add(i);
	            }
	        }
	        if(k-1>=factors.size()) {
	        	return -1;
	       }
	        return factors.get(k-1);
	    }
	    
//	better force approch :
//	we does not need to put them inside the list we can just return them 
//	other wise -1;
//	time complexity : O(n)
//	space complexity : O(1)
	    public static int kthFactorBetter(int n, int k) {
	    	int counter=0;
	    	for(int i =1;i<=n;i++){
	    		if(n%i==0){
	    			counter++;
	    		}
	    		if(counter==k) {
	    			return i;
	    		}
	    		
	    	}
	    	
	    	return -1;
	    }
//	best approch :
//	we can find all factors in root time 
//	by eliminating the multiple checks 
//	by taking factors from 1 till i*i
//	    
//	other wise -1;
//	time complexity : O(root(n))
//	space complexity : O(root(n))
	    public static int kthFactorBest(int n, int k) {
	    	List<Integer> leftfactors = new ArrayList();
	    	List<Integer> rightfactors = new ArrayList();
	    	for(int i =1;i*i<=n;i++){
	    		if(n%i==0){
	    			
	    			leftfactors.add(i);
	    			if(i==(n/i)) {
	    				continue;
	    			}
	    			
	    			rightfactors.add(n/i);
	    		} 		
	    	}
	    	int leftsize=leftfactors.size();
	    	int rightsize=rightfactors.size();
	    	if(leftfactors.size()>k-1) {
	    		return leftfactors.get(k-1);
	    	}
	    	
	    	if(leftsize+rightsize>k-1) {
	    		return rightfactors.get((rightsize-1)-(k-1-leftsize));
	    	}

	    	
	    	return -1;
	    }
	
	public static void main(String[] args) {
		
		//Example 1:

		int n1 = 12, k1 = 3;
		int output1=3;
		
		//Example 2:
		
		int n2 = 7, k2 = 2;
		int output2=7;
		
		//Example 3:

		int n3 = 4, k3 = 4;
		int output3=-1;
		
		System.out.println("Brute Force Approch :");

		int ans1 = kthFactorBruteForce(n1,k1);
		int ans2 = kthFactorBruteForce(n2,k2);
		int ans3 = kthFactorBruteForce(n3,k3);
		
		
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
		if(output3==ans3) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Expected Ouput :"+ output3);
			System.out.println("Your Answer :"+ ans3);
		}
		
		System.out.println("Better Force Approch :");
		
		ans1 = kthFactorBetter(n1,k1);
		ans2 = kthFactorBetter(n2,k2);
		ans3 = kthFactorBetter(n3,k3);
		
		
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
		if(output3==ans3) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Expected Ouput :"+ output3);
			System.out.println("Your Answer :"+ ans3);
		}
		
		System.out.println("Best Force Approch :");
		
		ans1 = kthFactorBest(n1,k1);
		ans2 = kthFactorBest(n2,k2);
		ans3 = kthFactorBest(n3,k3);
		
		
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
		if(output3==ans3) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Expected Ouput :"+ output3);
			System.out.println("Your Answer :"+ ans3);
		}



	}

}
