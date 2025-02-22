//54. Spiral Matrix
//Medium
//Topics
//Companies
//Hint
//Given an m x n matrix, return all elements of the matrix in spiral order.
//
// 
//
//Example 1:
//
//
//Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
//Output: [1,2,3,6,9,8,7,4,5]
//Example 2:
//
//
//Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//Output: [1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
//Constraints:
//
//m == matrix.length
//n == matrix[i].length
//1 <= m, n <= 10
//-100 <= matrix[i][j] <= 100
package Arrays;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Spiral_Matrix_54 {
    public static List<Integer> spiralOrder(int[][] matrix) {
//    	approch :precice pointer movement :
//    	to do this problem we need 4 pointers top,bottom,left,right
//    	these act as wall of matrix means we does not go beyond that
//    	now this becomes simple when we move top row once iterated we will increase top
//    	which mean the entire row is iterated next we iterate right col and decrement right pointer
//    	then we iterate bottom row and increase bottom pointer 
//    	lastly we iterate the left col and increment left pointer
//    	time complexity : O(n*n)
//    	space complexity : O(n)
    	
    	List<Integer> ans = new ArrayList<Integer>();
    	int top = -1;
    	int bottom=matrix.length;
    	int left=-1;
    	int right=matrix[0].length;
    	int elements =0;
    	int totalelement = bottom*right;
    	
    	while(top<bottom) {
    		int row = top+1;
    		int col = left+1;
    		
    		while(col!=right) {// top row
    			ans.add(matrix[row][col]);
    			col++;
    			elements++;
    		}
    		if(elements==totalelement) {
    			return ans;
    		}
    		
    		if(col==right) {
    			top++;
    			row=top+1;
    			col--;
    		}
    		while(row!=bottom) {// right col
    			ans.add(matrix[row][col]);
    			row++;
    			elements++;
    		}
    		if(elements==totalelement) {
    			return ans;
    		}
    		if(row==bottom) {
    			right--;
    			col=right-1;
    			row--;
       		}
    		while(col!=left) {// bottom row
    			ans.add(matrix[row][col]);
    			col--;
    			elements++;
    		}
    		if(elements==totalelement) {
    			return ans;
    		}
    		if(col==left) {
    			bottom--;
    			row=bottom-1;
    			col++;
       		}
    		
    		while(row!=top) {// left col
    			ans.add(matrix[row][col]);
    			row--;
    			elements++;
    		}
    		if(elements==totalelement) {
    			return ans;
    		}
    		if(row==top) {
    			left++;
    			row=top+1;
    			col++;
    		}
    		
    		
    	}
    	
    	
    	
    	return ans;
    }
    
    public static boolean check(List<Integer> ans,List<Integer> output) {
    	if(output.size()!=ans.size()) {
    		return false;
    	}
    	
    	for(int i =0;i<ans.size();i++) {
    		if(ans.get(i)!= output.get(i)) {
    			return false;
    		}
    	}
    	return true;
    }
    
    public static void main(String[] args) {
    	

    	//Example 1:
    
    	int [][] matrix1 = {{1,2,3},{4,5,6},{7,8,9}};
    	List<Integer> output1= new ArrayList<Integer> (Arrays.asList(1,2,3,6,9,8,7,4,5));
    	
    	
    	//Example 2:

    	int [][] matrix2 = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
    	List<Integer> output2= new ArrayList<Integer> (Arrays.asList(1,2,3,4,8,12,11,10,9,5,6,7));
    	
    	List<Integer> ans1= spiralOrder(matrix1);
    	List<Integer> ans2= spiralOrder(matrix2);
    	
    	
    	if(check(ans1,output1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ output1);
			System.out.println("Your Answer :"+ ans1);
		}
		
    	if(check(ans2,output2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+output2);
			System.out.println("Your Answer :"+ ans2);
		}

	}
}