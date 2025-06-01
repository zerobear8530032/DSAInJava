//Prime numbers after prime P with sum S
//Last Updated : 23 Jan, 2023
//Given three numbers sum S, prime P, and N, find all N prime numbers after prime P such that their sum is equal to S.
//Examples : 

//Input :  N = 2, P = 7, S = 28 
//Output : 11 17
//Explanation : 11 and 17 are primes after
//prime 7 and (11 + 17 = 28) 
//
//Input :  N = 3, P = 2, S = 23 
//Output : 3 7 13
//         5 7 11
//Explanation : 3, 5, 7, 11 and 13 are primes 
//after prime 2. And (3 + 7 + 13 = 5 + 7 + 11 
//= 23) 
//
//Input :  N = 4, P = 3, S = 54
//Output : 5 7 11 31 
//         5 7 13 29 
//         5 7 19 23 
//         5 13 17 19 
//         7 11 13 23 
//         7 11 17 19 
//Explanation : All are prime numbers and 
//their sum is 54

package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeNumbersAfterPrimePWithSumS_GFG {
	
//	approch : use scieve of estrossa to find all the prime number from  p+1 till sum
//	now use back tracking and recusion to find all possible valid numbers which sum up to target 
	public static void printSum(int n, int p, int s) {
		List<List<Integer>> res= new ArrayList<List<Integer>>();
		List<Integer> primes = primeNumber(p+1, s);
		List<Integer> curr = new ArrayList();
		helper(s, res,curr, n,primes,0);
		 // Print each result nicely
        for (List<Integer> combination : res) {
            for (int num : combination) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
	}
	public static void helper(int remainingSum ,List<List<Integer>> res,List<Integer> curroutput,int targetSize, List<Integer> primes, int idx) {
		if(remainingSum==0 && curroutput.size()==targetSize) {
			res.add(new ArrayList(curroutput));
			return ;
		}
		if(remainingSum<0 || curroutput.size() > targetSize) {
			return ;
		}

		for(int i =idx;i<primes.size();i++) {
			int prime =primes.get(i);
			if(remainingSum<prime) {
				break;
			}
			int sum= remainingSum-prime;
			curroutput.add(prime);
			helper(sum,res,curroutput,targetSize,primes,i+1);
			curroutput.remove(curroutput.size()-1);
		}
	}
	
	public static List<Integer> primeNumber(int s, int e){
		boolean [] arr= new boolean[e+1];
		Arrays.fill(arr, true);
		arr[0]=false;
		arr[1]=false;
		for(int i =2;i*i<=e;i++) {
			if (arr[i]) {
		        for(int j = i * i; j <= e; j += i) {
		            arr[j] = false;
		        }
		    }
		}
		
	
		List<Integer> res = new ArrayList<Integer>();
 		for(int i=s;i<arr.length;i++) {
			if(arr[i]) {
				res.add(i);
			}
		}
 		return res;
	}
	

	public static void main(String[] args) {

		//	Example 1:	
		int N1= 2, P1 = 7, S1 = 28;
		
		//	Example 2:	
		int N2= 3, P2 = 2, S2 = 23;
		
		//	Example 3:	
		int N3= 4, P3 = 3, S3 = 54;
		
		System.out.println("Case 1 :");
		printSum(N1, P1, S1);
		System.out.println("Case 2 :");
		printSum(N2, P2, S2);
		System.out.println("Case 3 :");
		printSum(N3, P3, S3);

	}

}
