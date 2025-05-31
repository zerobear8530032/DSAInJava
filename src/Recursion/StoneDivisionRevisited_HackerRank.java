//You have a pile of n stones that you want to split into multiple piles, as well as a set S of M distinct integers. We define a move as follows:
//First, choose a pile of stones. Let's say that the chosen pile contains  stones.
//Next, look for some  such that  and  is divisible by  (i.e.,  is a factor of ); if such an  exists, you can split the pile into  equal smaller piles.
//You are given  queries where each query consists of  and . For each query, calculate the maximum possible number of moves you can perform and print it on a new line.
//
//Input Format
//
//The first line contains an integer, , denoting the number of queries. The  subsequent lines describe each query in the following format:
//
//The first line contains two space-separated integers describing the respective values of  (the size of the initial pile in the query) and  (the size of the set in the query).
//The second line contains  distinct space-separated integers describing the values in set .
//Constraints
//
//Subtask
//
// for  of the maximum score.
//Output Format
//
//For each query, calculate the maximum possible number of moves you can perform and print it on a new line.
//
//Sample Input 0
//
//1
//12 3
//2 3 4
//Sample Output 0
//
//4
//Explanation 0
//
//Initially there is a pile with  stones:
//
//image
//
//You can make a maximal  moves, described below:
//
//Select  from  and split it into  equal piles of size  to get:
//image
//Select  from  and split a pile of size  into  equal piles of size  to get:
//image
//
//Repeat the previous move again on another pile of size  to get:
//image
//
//Repeat the move again on the last pile of size  to get:
//image
//As there are no more available moves, we print  (the number of moves) on a n



package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class StoneDivisionRevisited_HackerRank {
	
//	here we use simple approch:
//	each time we iterate from 0 till end of set 
//	and try to divide each element with current x
//	to compute all sub piles we can use formula :
//	(1+s) *helper(set,s);
//	here 1 is because currently we  already split the piles 1 time
//	then we add s because it will split in s piles per split
//	and * helper(set,s) will recursively call the function for sub piles 
//	and with formula they all add upto single one 
//	time complexxity : O(s^n)
//	space complexxity : O(n)

	public static Long divisionStone(List<Long> set, long x) {
		return helper(set, x);
	}
	
	public static long helper(List<Long> set, long x) {
		long max =0;
		long res=0;
		for(int i =0;i<set.size();i++) {
			long s= set.get(i);
			if(s!=x  && x%s==0) {
				res=1+(x/s)*helper(set, s);
			}
			max= Math.max(max, res);
		}
		return max;
	}
	
//	by memo we can make is ffaster
//	here we use simple approch:
//	each time we iterate from 0 till end of set 
//	and try to divide each element with current x
//	to compute all sub piles we can use formula :
//	(1+s) *helper(set,s);
//	here 1 is because currently we  already split the piles 1 time
//	then we add s because it will split in s piles per split
//	and * helper(set,s) will recursively call the function for sub piles 
//	and with formula they all add upto single one 
//	time complexxity : O(s^n)
//	space complexxity : O(n)
	public static Long divisionStoneBetter(List<Long> set, int x) {
		HashMap<Long,Long> map= new HashMap();
		return helperBetter(set,x,map);
	}
	
	public static Long helperBetter(List<Long> set, long x,HashMap<Long,Long> map) {
		long max =0;
		long res=0;
		if(map.containsKey(x)) {
			return map.get(x);
		}
		for(int i =0;i<set.size();i++) {
			long s= set.get(i);
			if(s!=x  && x%s==0) {
				res=1+(x/s)*helperBetter(set, s,map);
			}
			max= Math.max(max, res);
		}
		map.put(x, max);
		return max;
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		int x1 = 12;
		List<Long> set1= new ArrayList(Arrays.asList(2,3,4));
		int output1=4;
		
		int x2 = 64;
		List<Long> set2= new ArrayList(Arrays.asList(2,4,8,16,64));
		int output2=29;

		


		long ans1=divisionStone(set1,x1);
		long ans2=divisionStone(set2,x2);

		System.out.println("Brute Force approch :");
		
		if(output1==ans1) {
			System.out.println("Case 1 Passed ");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Your Output :"+ ans1);
			System.out.println("Actual Output :"+ output1);			
		}
		if(output2==ans2) {
			System.out.println("Case 2 Passed ");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Your Output :"+ ans2);
			System.out.println("Actual Output :"+ output2);			
		}
		
		ans1=divisionStoneBetter(set1,x1);
		ans2=divisionStoneBetter(set2,x2);
		
		System.out.println("Better approch :");
		
		if(output1==ans1) {
			System.out.println("Case 1 Passed ");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Your Output :"+ ans1);
			System.out.println("Actual Output :"+ output1);			
		}
		if(output2==ans2) {
			System.out.println("Case 2 Passed ");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Your Output :"+ ans2);
			System.out.println("Actual Output :"+ output2);			
		}



	}
}
