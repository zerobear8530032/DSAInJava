//	1380. Lucky Numbers in a Matrix
//	Solved
//	Easy
//	Topics
//	Companies
//	Hint
//	Given an m x n matrix of distinct numbers, return all lucky numbers in the matrix in any order.
//	
//	A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.
//	
//	 
//	
//	Example 1:
//	
//	Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
//	Output: [15]
//	Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column.
//	Example 2:
//	
//	Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
//	Output: [12]
//	Explanation: 12 is the only lucky number since it is the minimum in its row and the maximum in its column.
//	Example 3:
//	
//	Input: matrix = [[7,8],[1,2]]
//	Output: [7]
//	Explanation: 7 is the only lucky number since it is the minimum in its row and the maximum in its column.
//	 
//	
//	Constraints:
//	
//	m == mat.length
//	n == mat[i].length
//	1 <= n, m <= 50
//	1 <= matrix[i][j] <= 105.
//	All elements in the matrix are distinct.


package Arrays;
import java.util.*;
public class LuckyNumbersInAMatrix_1380 {
	
//	Optimize approch :
//	here we know one thing the lucky number need to satisfy 2 condition it should be 
//	min in its row and max at its cols
//	so we can check min of row and check that col wheather it is  max in its col
//	it yes we can add to ans list other wise check next row min
//	time complexity :O(m*n)
//	space complexity :O(n)
	
    public static List<Integer> luckyNumbersOptimize(int[][] matrix) {
    	List<Integer> ans = new ArrayList();
    	for(int rows =0;rows<matrix.length;rows++) {
    		int min = Integer.MAX_VALUE;
    		int mincols=0;
    		for(int cols =0;cols<matrix[rows].length;cols++) {
    			if(matrix[rows][cols]<min) {
    				min=matrix[rows][cols];
    				mincols= cols;
    			}
    		}
    		if(min == colMax(matrix, mincols)) {
    			ans.add(min);
    		}
    	
    	}
    	return ans;
    }
    
    public static int colMax(int [] []matrix, int cols) {
    	int max= Integer.MIN_VALUE;
    	for(int i =0;i<matrix.length;i++) {
    		max=Math.max(max,matrix[i][cols]);
    	}
    	return max;	
    }
    
    
    
    
    

//	BruteForce approch :
//    find max of each row and min of each col 
//    and find common element in both 
//     time complexity : O(m*n)
//     time complexity : O(m+n)
    public static List<Integer> luckyNumbersBruteFroce(int[][] matrix) {
    	List<Integer > min = findallrowmin(matrix);
    	List<Integer > max = findallcolmax(matrix);
    	List<Integer > ans = new ArrayList();
    	for(int i =0;i<min.size();i++) {
    		if(max.contains(min.get(i))) {
    			ans.add(min.get(i));
    		}
    	}
    	return ans;
    	
    	
    }
    public static List<Integer> findallrowmin(int [][] mat){
    	List<Integer> allrowmin = new ArrayList();
    	for(int i =0;i<mat.length;i++) {
    		int min = Integer.MAX_VALUE;
    		for(int j =0;j<mat[i].length;j++) {
    			min = Math.min(min, mat[i][j]);
    		}
    		allrowmin.add(min);
    	}
    	return allrowmin;
    }
    public static List<Integer> findallcolmax(int [][] mat){
    	List<Integer> allrowmin = new ArrayList();
    	for(int i =0;i<mat[0].length;i++) {
    		int max = Integer.MIN_VALUE;
    		for(int j =0;j<mat.length;j++) {
    			max = Math.max(max, mat[j][i]);
    		}
    		allrowmin.add(max);
    	}
    	return allrowmin;
    }
    
    
    
    public static boolean check (List<Integer> ans ,   List<Integer> output) {
    	if(ans.size()!=output.size()) {
    		return false;
    	}
    	for(int i =0;i<ans.size();i++) {
    		if(output.get(i)!=ans.get(i)) {
    			return false;
    		}
    	}
    	return true;
    }
    
    
    
	public static void main(String[] args) {
//		Example 1:

		int[] []matrix1 = {{3,7,8},
						   {9,11,13},
						   {15,16,17}};
		List<Integer> output1 = new ArrayList(Arrays.asList(15));

//		Example 2:

		int [][]matrix2 = {{1,10,4,2},{9,3,8,7},{15,16,17,12}};
		List<Integer> output2 = new ArrayList(Arrays.asList(12));

//		Example 3:

		int [][]matrix3 = {{7,8},{1,2}};
		List<Integer> output3 = new ArrayList(Arrays.asList(7));
		
		System.out.println("Brute Approch :");
		
		List<Integer>ans1= luckyNumbersBruteFroce(matrix1);
		List<Integer>ans2= luckyNumbersBruteFroce(matrix2);
		List<Integer>ans3= luckyNumbersBruteFroce(matrix3);
		
		if(check(output1, ans1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+(output1));
			System.out.println("Your Answer :"+ (output1));
		}
		if(check(ans2, output2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+(output2));
			System.out.println("Your Answer :"+ (ans2));
		}
		if(check(ans3, output3)) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Expected Ouput :"+ (output3));
			System.out.println("Your Answer :"+ (ans3));
		}
		
		System.out.println("Optimize Approch :");
		
		ans1= luckyNumbersOptimize(matrix1);
		ans2= luckyNumbersOptimize(matrix2);
		ans3= luckyNumbersOptimize(matrix3);
		
		if(check(output1, ans1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+(output1));
			System.out.println("Your Answer :"+ (output1));
	}
		if(check(ans2, output2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+(output2));
			System.out.println("Your Answer :"+ (ans2));
		}
		if(check(ans3, output3)) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Expected Ouput :"+ (output3));
			System.out.println("Your Answer :"+ (ans3));
		}
	}
}