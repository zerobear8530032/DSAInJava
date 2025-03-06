//2965. Find Missing and Repeated Values
//Solved
//Easy
//Topics
//Companies
//You are given a 0-indexed 2D integer matrix grid of size n * n with values in the range [1, n2]. Each integer appears exactly once except a which appears twice and b which is missing. The task is to find the repeating and missing numbers a and b.
//
//Return a 0-indexed integer array ans of size 2 where ans[0] equals to a and ans[1] equals to b.
//
// 
//
//Example 1:
//
//Input: grid = [[1,3],[2,2]]
//Output: [2,4]
//Explanation: Number 2 is repeated and number 4 is missing so the answer is [2,4].
//Example 2:
//
//Input: grid = [[9,1,7],[8,9,2],[3,4,6]]
//Output: [9,5]
//Explanation: Number 9 is repeated and number 5 is missing so the answer is [9,5].
// 
//
//Constraints:
//
//2 <= n == grid.length == grid[i].length <= 50
//1 <= grid[i][j] <= n * n
//For all x that 1 <= x <= n * n there is exactly one x that is not equal to any of the grid members.
//For all x that 1 <= x <= n * n there is exactly one x that is equal to exactly two of the grid members.
//For all x that 1 <= x <= n * n except two of them there is exatly one pair of i, j that 0 <= i, j <= n - 1 and grid[i][j] == x.


package Arrays;

import java.util.Arrays;
import java.util.HashSet;

class FindMissingAndRepeatedValues_2965 {
//	brute force approch :
//	create a hash set iterate over entire matrix and add element in hashset
//	while adding check wheather it already exists in it or not if yes make it the repeating number
//	now once each element is in hash set
//	use a loop from 1 till row*cols n*n
//	and ccheck that i exists in hashset if not thats the missing number 
//	lastly return both 
//	here its given all the test case will have such number
//	time complexity :2* O(n*n)
//	space complexity : O(n*n)
    public static int[] findMissingAndRepeatedValuesBruteForce(int[][] grid) {
        HashSet<Integer> set = new HashSet();
        int repeating =-1;
        int missing =-1;
        int rows = grid.length;
        int cols = grid[0].length;
        for(int i =0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(set.contains(grid[i][j])){
                    repeating = grid[i][j];
                   
                }else{
                    set.add(grid[i][j]);
                }
            }
        }
        for(int i =1;i<=rows*cols;i++){
            if(!set.contains(i)) {
                missing = i;
                break;
            }
            
        }

        return new int [] {repeating,missing};

    }
//    here instead of using hash map we can use an array of length rows*cols
//    where each number can be put at its numb-1 index this will allow us to look up
//	time complexity :2* O(n*n)
//	space complexity : O(n*n)
    
    public static int[] findMissingAndRepeatedValuesBetter(int[][] grid) {
    	
    	int repeating =-1;
    	int missing =-1;
    	int rows = grid.length;
    	int cols = grid[0].length;
    	int [] temp = new int [rows*cols+1];
    	
    	for(int i =0;i<rows;i++){
    		for(int j=0;j<cols;j++){
    			if(temp[grid[i][j]-1]!=0){
    				repeating = grid[i][j];
    			}else{
    				temp[grid[i][j]-1]=grid[i][j];
    			}
    		}
    	}
    	for(int i =0;i<temp.length;i++) {
    		if(temp[i]==0) {
    			
    			missing = i+1;
    			break;
    		}
    	}
    	
    	
    	return new int [] {repeating,missing};
    	
    }
    
//    best approch :
//    we can remove the requirement of last loop to find missing number 
//    first iterate over entire matrix by summing each number 
//    and also checking for repeating number as previous one 
//    lastly we can substract the repeating number from the sum of element in grid
//    this means we remove the repeating number 
//    lastly we can just using formula of sum of n 
//    natural number n*(n+1)/2  to get sum of number 1 - n*n
//    by substrating sum of natural number or our grid sum we get the missing number
//    time complexity :O(n*n)
//    space complexity :O(n*n)
    public static int[] findMissingAndRepeatedValuesBest(int[][] grid) {
    	
    	int repeating =-1;
    	int missing =-1;
    	int rows = grid.length;
    	int cols = grid[0].length;
    	int [] temp = new int [rows*cols+1];
    	int gridsum=0;    	
    	for(int i =0;i<rows;i++){
    		for(int j=0;j<cols;j++){
    			if(temp[grid[i][j]-1]!=0){
    				repeating = grid[i][j];
    				gridsum+=grid[i][j];
    			}else{
    				temp[grid[i][j]-1]=grid[i][j];
    				gridsum+=grid[i][j];
    			}
    		}
    	}
    	int n = rows*cols;// total number
    	int totalsum = n*(n+1)/2;// total number sum
    	gridsum=gridsum-repeating;// remove the repeating from grid sum
    	missing = totalsum-gridsum;
    	
    	
    	return new int [] {repeating,missing};
    	
    }
    
    public static boolean check(int [] ans,int [] output) {
    	if(ans.length!=output.length) {
    		return false;
    	}
    	for(int i =0;i<ans.length;i++) {
    		if(ans[i]!=output[i]) {
    			return false;
    		}
    	}
    	return true;
    }
    
    public static void main(String[] args) {
    	
    	//Example 1:
    	
    	int [][]grid1 = {{1,3},{2,2}};
    	int []output1= {2,4};
    	
    	//Example 2:
    	
    	int [][]grid2 = {{9,1,7},{8,9,2},{3,4,6}};
    	int [] output2= {9,5};
    	
    	
    	System.out.println("Brute Force Approch :");
		
		int []ans1 = findMissingAndRepeatedValuesBruteForce(grid1);
		int []ans2 = findMissingAndRepeatedValuesBruteForce(grid2);
		
		
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
		
		System.out.println("Better Approch :");
		
		ans1 = findMissingAndRepeatedValuesBetter(grid1);
		ans2 = findMissingAndRepeatedValuesBetter(grid2);
		
		
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
		
		System.out.println("Best Force Approch :");
		
		ans1 = findMissingAndRepeatedValuesBest(grid1);
		ans2 = findMissingAndRepeatedValuesBest(grid2);
		
		
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
		
		
	}
}