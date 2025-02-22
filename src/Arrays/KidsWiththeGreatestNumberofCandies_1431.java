//1431. Kids With the Greatest Number of Candies
//Solved
//Easy
//Topics
//Companies
//Hint
//There are n kids with candies. You are given an integer array candies, where each candies[i] represents the number of candies the ith kid has, and an integer extraCandies, denoting the number of extra candies that you have.
//
//Return a boolean array result of length n, where result[i] is true if, after giving the ith kid all the extraCandies, they will have the greatest number of candies among all the kids, or false otherwise.
//
//Note that multiple kids can have the greatest number of candies.
//
// 
//
//Example 1:
//
//Input: candies = [2,3,5,1,3], extraCandies = 3
//Output: [true,true,true,false,true] 
//Explanation: If you give all extraCandies to:
//- Kid 1, they will have 2 + 3 = 5 candies, which is the greatest among the kids.
//- Kid 2, they will have 3 + 3 = 6 candies, which is the greatest among the kids.
//- Kid 3, they will have 5 + 3 = 8 candies, which is the greatest among the kids.
//- Kid 4, they will have 1 + 3 = 4 candies, which is not the greatest among the kids.
//- Kid 5, they will have 3 + 3 = 6 candies, which is the greatest among the kids.
//Example 2:
//
//Input: candies = [4,2,1,1,2], extraCandies = 1
//Output: [true,false,false,false,false] 
//Explanation: There is only 1 extra candy.
//Kid 1 will always have the greatest number of candies, even if a different kid is given the extra candy.
//Example 3:
//
//Input: candies = [12,1,12], extraCandies = 10
//Output: [true,false,true]
// 
//
//Constraints:
//
//n == candies.length
//2 <= n <= 100
//1 <= candies[i] <= 100
//1 <= extraCandies <= 50
package Arrays;
import java.util.*;

public class KidsWiththeGreatestNumberofCandies_1431 {
// approch : first take the max candies a child have 
//	now try giving candy to every single kid and check it get equal or greater then the maxx candies if yes 
//	add true to output other wise false
//	time complexity : O(n)
//	space complexity : O(1)
	  public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
	        List<Boolean> ans = new ArrayList();
	        int max = Integer.MIN_VALUE;// get max
	        for(int x: candies) {
	        	max=Math.max(x, max);// get max candies
	        }
	        for(int x: candies) {// check which child have max candies with extra candies
	        	ans.add(x+extraCandies>=max);
	        }
	       return ans; 
	    }
	  
	  public static boolean check(List<Boolean> ans , List<Boolean> output) {
		  if(ans.size()!=output.size()) {
			  return false;
		  }
		  for(int i =0;i<ans.size();i++) {
			  if(ans.get(i)!=output.get(i)) {
				  return false;
			  }
		  }
		  return true;
	  }
	  
	  
	public static void main(String[] args) {
		//Example 1:
		//
		int []candies1 = {2,3,5,1,3};
		int  extraCandies1 = 3;
		List <Boolean>output1= new ArrayList(Arrays.asList(true,true,true,false,true));
		

		//Example 2:
		//
		int []  candies2 = {4,2,1,1,2};
		int  extraCandies2 = 1;
		List <Boolean>output2= new ArrayList(Arrays.asList(true,false,false,false,false));


		//Example 3:
		//
		int []  candies3 = {12,1,12};
		int  extraCandies3 = 10;
		List <Boolean>output3= new ArrayList(Arrays.asList(true,false,true));
		
		
		List <Boolean>ans1= kidsWithCandies(candies1, extraCandies1);
		List <Boolean> ans2= kidsWithCandies(candies2, extraCandies2);
		List <Boolean> ans3= kidsWithCandies(candies3, extraCandies3);
		
		
		
		if(check(ans1,output1)) {
			System.out.println("Case 1 Passed ");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Excepted Output : "+ (output1));
			System.out.println("Your Output : "+ (ans1));
		}
		if(check(ans2,output2)) {
			System.out.println("Case 2 Passed ");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Excepted Output : "+ (output2));
			System.out.println("Your Output : "+ (ans2));
		}
		
		if(check(ans3,output3)) {
			System.out.println("Case 3 Passed ");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Excepted Output : "+(output2));
			System.out.println("Your Output : "+ (ans2));
		}
		

		
	}

}
