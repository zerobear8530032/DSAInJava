//1572. Matrix Diagonal Sum
//Solved
//Easy
//Topics
//Companies
//Hint
//Given a square matrix mat, return the sum of the matrix diagonals.
//
//Only include the sum of all the elements on the primary diagonal and all the elements on the secondary diagonal that are not part of the primary diagonal.
//
// 
//
//Example 1:
//
//
//Input: mat = [[1,2,3],
//              [4,5,6],
//              [7,8,9]]
//Output: 25
//Explanation: Diagonals sum: 1 + 5 + 9 + 3 + 7 = 25
//Notice that element mat[1][1] = 5 is counted only once.
//Example 2:
//
//Input: mat = [[1,1,1,1],
//              [1,1,1,1],
//              [1,1,1,1],
//              [1,1,1,1]]
//Output: 8
//Example 3:
//
//Input: mat = [[5]]
//Output: 5
// 
//
//Constraints:
//
//n == mat.length == mat[i].length
//1 <= n <= 100
//1 <= mat[i][j] <= 100
package Arrays;


public class MatrixDiagonalSum_1572 {
//	Brute Force :
//	we know the matrixx is square so we just need to get diagonals using a for loop and 
//	and suum it one edge case we need to check is if the length is oddd the mid element 
//	need to be added once only so we can do the that by either skip it to take sum 
//	at last remove the mid by taking its differece
//	Time complexity :O(N)
//	Space complexity :O(1)
	public static int diagonalSumBruteForce(int[][] mat) {
		int sum =0;
		int mid = mat.length/2;// getting mid element to remove repreated sum
		if(mat.length==1) {
			return mat[0][0];
		}
//		primary diagonal
		for(int i =0;i<mat.length;i++) {
			sum+= mat[i][i];
		}
		
//		secondary diagonal
		for(int i =mat.length-1;i>=0;i--) {
			sum+= mat[mat.length-1-i][i];			
		}
//		if the length is odd mean both diagonal will share a mid element which
//		need to be removed 
		if(mat.length%2!=0) {
			return sum-mat[mid][mid];// take out the mid eleemnt
		}
		return sum;
        
    }
	
//	we can just combine both loops
	public static int diagonalSumOptimzeForce(int[][] mat) {
		int sum =0;
		int mid = mat.length/2;// getting mid element to remove repreated sum
		if(mat.length==1) {
			return mat[0][0];
		}
		for(int i =0;i<mat.length;i++) {
//		primary diagonal 
			sum+= mat[i][i];
//		secondary diagonal 
			sum+= mat[i][mat.length-1-i];			
			
		}
		
//		if the length is odd mean both diagonal will share a mid element which
//		need to be removed 
		if(mat.length%2!=0) {
			return sum-mat[mid][mid];// take out the mid eleemnt
		}
		return sum;
		
	}

	public static void main(String[] args) {
		
		//Example 1:
		int [][] mat1 = {{1,2,3},
		              {4,5,6},
		              {7,8,9}};
		int output1= 25;
		
		//Example 2:
		
		int [][]mat2 = {{1,1,1,1},
		              {1,1,1,1},
		              {1,1,1,1},
		              {1,1,1,1}};
		
		int output2=8;
		
		//Example 3:
		
		int [][]mat3 = {{5}};
		int output3= 5;
		
		
		
		//Example 4:
		
		int [][]mat4 = {{7,3,1,9},
						{3,4,6,9},
						{6,9,6,6},
						{9,5,8,5}};
		int output4= 55;
		
		
		int ans1=diagonalSumBruteForce(mat1);
		int ans2=diagonalSumBruteForce(mat2);
		int ans3=diagonalSumBruteForce(mat3);
		int ans4=diagonalSumBruteForce(mat4);
		

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
		if(output4==ans4) {
			System.out.println("Case 4 Passed");
		}else {
			System.out.println("Case 4 Failed");
			System.out.println("Expected Ouput :"+ output4);
			System.out.println("Your Answer :"+ ans4);
		}
		
		System.out.println("Optimize appoch ");
		ans1=diagonalSumOptimzeForce(mat1);
		ans2=diagonalSumOptimzeForce(mat2);
		ans3=diagonalSumOptimzeForce(mat3);
		ans4=diagonalSumOptimzeForce(mat4);
		
		
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
		if(output4==ans4) {
			System.out.println("Case 4 Passed");
		}else {
			System.out.println("Case 4 Failed");
			System.out.println("Expected Ouput :"+ output4);
			System.out.println("Your Answer :"+ ans4);
		}
		
		
		
		
		

	}

}
