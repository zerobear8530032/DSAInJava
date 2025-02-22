//3160. Find the Number of Distinct Colors Among the Balls
//Medium
//Topics
//Companies
//Hint
//You are given an integer limit and a 2D array queries of size n x 2.
//
//There are limit + 1 balls with distinct labels in the range [0, limit]. Initially, all balls are uncolored. For every query in queries that is of the form [x, y], you mark ball x with the color y. After each query, you need to find the number of distinct colors among the balls.
//
//Return an array result of length n, where result[i] denotes the number of distinct colors after ith query.
//
//Note that when answering a query, lack of a color will not be considered as a color.
//
// 
//
//Example 1:
//
//Input: limit = 4, queries = [[1,4],[2,5],[1,3],[3,4]]
//
//Output: [1,2,2,3]
//
//Explanation:
//
//
//
//After query 0, ball 1 has color 4.
//After query 1, ball 1 has color 4, and ball 2 has color 5.
//After query 2, ball 1 has color 3, and ball 2 has color 5.
//After query 3, ball 1 has color 3, ball 2 has color 5, and ball 3 has color 4.
//Example 2:
//
//Input: limit = 4, queries = [[0,1],[1,2],[2,2],[3,4],[4,5]]
//
//Output: [1,2,2,3,4]
//
//Explanation:
//
//
//
//After query 0, ball 0 has color 1.
//After query 1, ball 0 has color 1, and ball 1 has color 2.
//After query 2, ball 0 has color 1, and balls 1 and 2 have color 2.
//After query 3, ball 0 has color 1, balls 1 and 2 have color 2, and ball 3 has color 4.
//After query 4, ball 0 has color 1, balls 1 and 2 have color 2, ball 3 has color 4, and ball 4 has color 5.
// 
//
//Constraints:
//
//1 <= limit <= 109
//1 <= n == queries.length <= 105
//queries[i].length == 2
//0 <= queries[i][0] <= limit
//1 <= queries[i][1] <= 109






package Arrays;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FindTheNumberOfDistinctColorsAmongTheBalls_3160 {
	
//	Brute Force approch :
//	using simulation :
//	create a array of size limit+1 this will be size  of number of balls we have
//	now we will iterate over queries and put ball color query[i][1] at balls index query[i][0]
//	this will create a simulation of balls color and then we just need to find frequency of each 
//	color which can be done with a hash set or helper function
//	time complexity :O(query * limit+1)
//	space complexity :O(limit+1)-> limit 
//	note : this approch will not work in this constrain
	 public static int[] queryResultsBruteForce(int limit, int[][] queries) {
		 int balls[]= new int [limit+1];
		 int ans []= new int  [queries.length];
		 for(int i =0;i<queries.length;i++) {
			 balls[queries[i][0]]= queries[i][1];
			 ans[i]=getDistinctColors(balls);
		 }
		 return ans;
		 
	 }
	 public static int getDistinctColors(int [] balls) {
		 HashSet<Integer> set = new HashSet();
		 for(int i =0;i<balls.length;i++) {
			 if(balls[i]==0) {
				 continue;
			 }
			 set.add(balls[i]);
		 }
		 return set.size();
	 }
	 
	 
//	Optimize approch :
//	using simulation :
//	create a hashMap to map both ball as key and value as color
//	 now we just need to use values and check distinct colors in value set
//	time complexity :O(n^2)
//	space complexity :O(n) -> hash map
	 public static int[] queryResultsOptimize(int limit, int[][] queries) {
		 HashMap<Integer,Integer> balls = new HashMap();
		 int [] ans = new int [queries.length];
		 for(int i =0;i<queries.length;i++) {
			 int b = queries[i][0];
			 int c = queries[i][1];
			 balls.put(b,c);
			 ans[i]=getDistinctColorOptimize(balls.values());
		 }
		 return ans;
	 }
	 public static int getDistinctColorOptimize(Collection<Integer> collection) {
		 HashSet<Integer> set = new HashSet();
		 set.addAll(collection);
		 return set.size();

	 }
	 
	 
	 
//	Best approch :
// so this is the answer i was thinking of same approch previously but when i implemented this approch my self i got the concurrent use error in java thats why i left 
// here we create 2 hash map balls <ball pos,color>
// colorsmap <color,frequency>
//now check iterate over query and check wheather the ball is already in map if not put it on map and check color is on map or not if not put it on color map  and its frequency as 0
// if the ball is already present in map get the old color of ball and reduce the frequency of it in color map if it is 0 we can remove entire entry 
// now put the new color in balls map 
// repeat it as per query and keep updating  color map the size of color map will be number of distinct color at  i th query 
//	 time complexity : O(n)-> queries.length
//	 space complexity : O(n)-> 2 hash Maps

	 public static int[] queryResultsBest(int limit, int[][] queries) {
		 HashMap<Integer,Integer> balls = new HashMap();
		 HashMap<Integer,Integer> colors = new HashMap();
		 int n=queries.length;
		 int [] ans = new int[n];
		 for(int i=0;i<n;i++) {
			 int b =queries[i][0];
			 int c =queries[i][1];
			 if(balls.containsKey(b)) {
				 int oldcolor = balls.get(b);
				 colors.put(oldcolor, colors.get(oldcolor)-1);
				 if(colors.get(oldcolor)==0) {
					 colors.remove(oldcolor);
				 }
			 }
			 balls.put(b, c);
			// Update the count of the new color
	        colors.put(c, colors.getOrDefault(c, 0) + 1);
	        ans[i]=colors.size();
	            
						 }
	
		 return ans;
	 }

	
	 public static boolean check(int [] arr1, int [] arr2) {
			if(arr1.length!=arr2.length) {
				return false;
			}
			for(int i =0;i<arr1.length;i++) {
				if(arr1[i]!=arr2[i]) {
					return false;
				}
			}
			
			for(int i =0;i<arr1.length;i++) {
				if(arr1[i]!=arr2[i]) {
					return false;
				}
			}
			
			return true;
		}

	
		public static void main(String[] args) {
			
			
			
			
			//Example 1:
			//
			int limit1 = 4;
			int [][]queries1 = {{1,4},{2,5},{1,3},{3,4}};
			
			int output1[]= {1,2,2,3};

			//Example 2:
			
			int limit2 = 4;
			int [][]queries2 = {{0,1},{1,2},{2,2},{3,4},{4,5}};
			int []output2= {1,2,2,3,4};
			
			//Example 3:
			
			int limit3= 1;
			int [][]queries3 = {{0,1},{1,4},{1,1},{1,4},{1,1}};
			int []output3= {1,2,1,2,1};

			
			System.out.println("Brute Force Approch :");
			
			int []ans1 = queryResultsBruteForce(limit1,queries1);
			int []ans2 = queryResultsBruteForce(limit2,queries2);
			int []ans3 = queryResultsBruteForce(limit3,queries3);
			
			
			if(check(ans1,output1)) {
				System.out.println("Case 1 Passed ");
			}else {
				System.out.println("Case 1 Failed");
				System.out.println("Excepted Output : "+ Arrays.toString(output1));
				System.out.println("Your Output : "+ Arrays.toString(ans1));
			}
			if(check(ans2,output2)) {
				System.out.println("Case 2 Passed ");
			}else {
				System.out.println("Case 2 Failed");
				System.out.println("Excepted Output : "+ Arrays.toString(output2));
				System.out.println("Your Output : "+ Arrays.toString(ans2));
			}			
			if(check(ans3,output3)) {
				System.out.println("Case 3 Passed ");
			}else {
				System.out.println("Case 3 Failed");
				System.out.println("Excepted Output : "+ Arrays.toString(output3));
				System.out.println("Your Output : "+ Arrays.toString(ans3));
			}
			
			
			System.out.println("Better Force Approch :");
			
			ans1 = queryResultsOptimize(limit1,queries1);
			ans2 = queryResultsOptimize(limit2,queries2);
			ans3 = queryResultsOptimize(limit3,queries3);
			
			
			if(check(ans1,output1)) {
				System.out.println("Case 1 Passed ");
			}else {
				System.out.println("Case 1 Failed");
				System.out.println("Excepted Output : "+ Arrays.toString(output1));
				System.out.println("Your Output : "+ Arrays.toString(ans1));
			}
			if(check(ans2,output2)) {
				System.out.println("Case 2 Passed ");
			}else {
				System.out.println("Case 2 Failed");
				System.out.println("Excepted Output : "+ Arrays.toString(output2));
				System.out.println("Your Output : "+ Arrays.toString(ans2));
			}
			if(check(ans3,output3)) {
				System.out.println("Case 3 Passed ");
			}else {
				System.out.println("Case 3 Failed");
				System.out.println("Excepted Output : "+ Arrays.toString(output3));
				System.out.println("Your Output : "+ Arrays.toString(ans3));
			}
			
	}
}
