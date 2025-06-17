//At the time when Pythagoreanism was prevalent, people were also focused on different ways to factorize a number. In one class, Pythagoras asked his disciples to solve one such problem, Reverse Factorization. They were given a set of integer, , and an integer . They need to find the a way to reach , starting from , and at each step multiplying current value by any element of . But soon they realised that there may exist more than one way to reach . So they decided to find a way in which number of states are least. All of sudden they started on this new problem. People solved it and then started shouting their answer. CRAP!!!. There still exists multiple answers. So finally after much consideration, they settled on the lexicographically smallest series among those solutions which contains the least number of states.
//
//For example, if  and  then following ways exists
//
//(a) 1  ->  2  ->  4  ->  12
//       x2     x2     x3
//
//(b) 1  ->  4  ->  12
//       x4     x3
//
//(c) 1  ->  3  ->  12
//       x3     x4
//Here (a) is not the minimal state, as it has  states in total. While (b) and (c) are contenders for answer, both having 3 states, (c) is lexicographically smaller than (b) so it is the answer. In this case you have to print 1 3 12. If there exists no way to reach  print -1.
//
//Input Format
//
//Input contains two lines where first line contains two space separated integer,  and , representing the final value to reach and the size of set , respectively. Next line contains K space integers representing the set .
//
//Constraints
//
//, where 
//, where  AND 
//Note:
//
//Lexicographical order: If  and  are two ordered lists, then  is lexicographically smaller than  if any one of the following condition satisfies.
//
// AND .
// AND  AND .
//You need to find the lexigraphically smallest series among those solutions which contains the least number of states.
//
//Output Format
//
//Print the steps to reach  if it exists. Otherwise print -1.
//
//Sample Input 0
//
//12 3
//2 3 4
//Sample Output 0
//
//1 3 12
//Explanation 0
//
//This is the same case which is explaned above.
//
//Sample Input 1
//
//15 5
//2 10 6 9 11
//Sample Output 1
//
//-1
//Explanation 1
//
//Here no way exists so that we can reach  starting from .
//
//Sample Input 2
//
//72 9
//2 4 6 9 3 7 16 10 5
//Sample Output 2
//
//1 2 8 72
//Explanation 2
//
//There are multiple ways to reach 72 using these 8 numbers. Out of which following 6 ways consists of minimal states (4).
//
//States          =>  Multiplication operation
// 1   9  18  72  =>      (x9, x2, x4)
// 1   4  36  72  =>      (x4, x9, x2)
// 1   2   8  72  =>      (x2, x4, x9)
// 1   2  18  72  =>      (x2, x9, x4)
// 1   4   8  72  =>      (x4, x2, x9)
// 1   9  36  72  =>      (x9, x4, x2)
//As series 1 2 8 72 is lexicographically smallest, it is the answer.
package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KFactorization_HackerRank {
	
//	approh : brute force approch here we explore each and every possible way to get 
//	the target and choose the best one possible
//	time complexity : O(N^L) n is max rec depth and L is the size of list A
//	space complexity : O(N) n is max rec depth
	  public static List<Integer> kFactorizationBruteForce(int n, List<Integer> A) {
		    // Write your code here
		    Collections.sort(A);// we sort tthe list f a to get always lexogrphical correct order of elements 
		    List<Integer> localres= new ArrayList();
		    localres.add(1);
		    List<Integer> bestres= new ArrayList();
		    helperBruteForce(1,n,A,localres,bestres);
		    return bestres;		    
		    }

		    public static void helperBruteForce(int currnum, int target, List<Integer> nums,List<Integer> res,List<Integer> bestres){
		        if(currnum>target || currnum<0){
		                return ;
		        }
		        if(currnum==target){
		        	
		        if(bestres.size()==0){
		                bestres.addAll(res);
		        }
		        if(bestres.size()>res.size()){
		        	bestres.clear();
		        	bestres.addAll(res);
		        }else if(bestres.size()==res.size()) {
		        	for(int i =0;i<res.size();i++) {
		        		if(res.get(i)<bestres.get(i)) {
		        			bestres.clear();
		        			bestres.addAll(res);
		        			break;
		        		}
		        		if(res.get(i)>bestres.get(i)) {
		        			break;
		        		}
		        	}
		        }

		                return ;
		        }
		        for(int num: nums){
		        int nextnum = num*currnum;
		        if(nextnum<=target){
		                res.add(nextnum);
		                if(bestres.size()!=0 && bestres.size()>res.size()) {
		                	helperBruteForce(nextnum,target,nums,res,bestres);               		                	
		                }
		                res.remove(res.size()-1);
		        }
		        }
		    } 
		    

//approh : here we prune the paths which might not reach the output
// each num we make we check either our result is divisible by thta or not if yes then only
// we take it other wise we skip it over 
//time complexity : O(N^L) n is max rec depth and L is the size of list A
//space complexity : O(N) n is max rec depth
public static List<Integer> kFactorizationBetter(int n, List<Integer> A) {
	Collections.sort(A);
	List<Integer> curres = new ArrayList();
	curres.add(1);
	List<Integer> finalres = new ArrayList();
	helperBetter(1,n,A,curres,finalres,0);
	if(finalres.size()==0) {
		finalres.add(-1);
	}
	return finalres;
}


		    
public static void helperBetter(int currnum, int target, List<Integer> nums,List<Integer> res,List<Integer> bestres, int idx){
	if(currnum==target) {
		if(bestres.size()==0) {
			bestres.addAll(res);
		}else if(bestres.size()>res.size()) {
			bestres.clear();
			bestres.addAll(res);
		}else if(bestres.size()==res.size()) {
			for(int i =0;i<res.size();i++) {
				if(res.get(i)<bestres.get(i)) {
					bestres.clear();
					bestres.addAll(res);					
					break;
				}else if(res.get(i)>bestres.get(i)) {
					break;
				}
			}
		}
	}
	
	for(int i = idx;i<nums.size();i++) {
		int nextnum = nums.get(i)*currnum;
		if(nextnum<=0) {
			continue;
		}
//		this will allow us to prune the paths much more easily 
//		the first condition allow only factors of target to go next next call
//		and nextnum== target is because we want the target to reach the output and its happening in the starting of function call 
		if (target % nextnum != 0 && nextnum != target) continue;
		if(nextnum<=target) {
			res.add(nextnum);
			helperBetter(nextnum,target,nums,res,bestres,i);
			res.remove(res.size()-1);
		}
	}	
} 

public static void main(String[] args) {

	//Example 1:
	int num1 =12;

	List<Integer> A1= new ArrayList(Arrays.asList(2,3,4));
	List<Integer> output1= new ArrayList(Arrays.asList(1,3,12));
	
	//Example 2:
	int num2 =15;
	List<Integer> A2= new ArrayList(Arrays.asList(2,10,6,9,11));	
	List<Integer> output2= new ArrayList();
	
	//Example 3:
	int num3 =72;
	List<Integer> A3= new ArrayList(Arrays.asList(2,4,6,9,3,7,16,10,5));	
	List<Integer> output3= new ArrayList(Arrays.asList(1,2,8,72));
	

	
	List<Integer> ans1=kFactorizationBruteForce(num1, A1);
	List<Integer> ans2=kFactorizationBruteForce(num2, A2);
	List<Integer> ans3=kFactorizationBruteForce(num3, A3);
	
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
	if(output3.equals(ans3)) {
		System.out.println("Case 3 Passed");
	}else {
		System.out.println("Case 3 Failed");
		System.out.println("Actual Output :"+output3);
		System.out.println("Your Output :"+ans3);
	}

	System.out.println("Better approch :");
	ans1=kFactorizationBetter(num1, A1);
	ans2=kFactorizationBetter(num2, A2);
	ans3=kFactorizationBetter(num3, A3);
	
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
	if(output3.equals(ans3)) {
		System.out.println("Case 3 Passed");
	}else {
		System.out.println("Case 3 Failed");
		System.out.println("Actual Output :"+output3);
		System.out.println("Your Output :"+ans3);
	}
	

	
	}
}
