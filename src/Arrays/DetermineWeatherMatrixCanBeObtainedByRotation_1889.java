//this question need review later


//1886. Determine Whether Matrix Can Be Obtained By Rotation
//Solved
//Easy
//Topics
//Companies
//Hint
//Given two n x n binary matrices mat and target, return true if it is possible to make mat equal to target by rotating mat in 90-degree increments, or false otherwise.
//
// 
//
//Example 1:
//
//
//Input: mat = [[0,1],[1,0]], target = [[1,0],[0,1]]
//Output: true
//Explanation: We can rotate mat 90 degrees clockwise to make mat equal target.
//Example 2:
//
//
//Input: mat = [[0,1],[1,1]], target = [[1,0],[0,1]]
//Output: false
//Explanation: It is impossible to make mat equal to target by rotating mat.
//Example 3:
//
//
//Input: mat = [[0,0,0],[0,1,0],[1,1,1]], target = [[1,1,1],[0,1,0],[0,0,0]]
//Output: true
//Explanation: We can rotate mat 90 degrees clockwise two times to make mat equal target.
// 
//
//Constraints:
//
//n == mat.length == target.length
//n == mat[i].length == target[i].length
//1 <= n <= 10
//mat[i][j] and target[i][j] are either 0 or 1.

package Arrays;

import java.util.Arrays;

public class DetermineWeatherMatrixCanBeObtainedByRotation_1889 {

//	brute force approch:
//	allocate new matrix rotate it and check 
//  Time complextity:O(N*N)
//  space complextity:O(N*N)
	
    public static boolean findRotationBruteForce(int[][] mat, int[][] target) {
    	if(check(mat, target)) {
    		return true;
    	}
    	mat=transposeLeftBruteForce(mat);
    	if(check(mat, target)) {
    		return true;
    	}
    	mat=transposeRightBruteForce(mat);
    	if(check(mat, target)) {
    		return true;
    	}
    	mat=transposeLeftBruteForce(mat);
    	if(check(mat, target)) {
    		return true;
    	}
    	return false;
    }
    
    public static int [][] transposeLeftBruteForce(int [][] mat) {
    	int [][] ans = new int [mat.length][mat[0].length];
    	int n=mat.length;
    	for(int i = 0;i<n;i++) {
    		for(int j=0;j<n;j++) {
    			ans[j][n-1-i]=mat[i][j];
    		}
    	}
    	return ans;
    }
    public static int [][] transposeRightBruteForce(int [][] mat) {
    	int [][] ans = new int [mat.length][mat[0].length];
    	int n=mat.length;
    	for(int i = 0;i<n;i++) {
    		for(int j=0;j<n;j++) {
    			ans[j][i]=mat[n-1-i][j];
    		}
    	}
    	return ans;
    }
// logic is sam but the transpose is in place 
//  Time complextity:O(N*N)
//  space complextity:O(1)
    public static boolean findRotationOptimize(int[][] mat, int[][] target) {
    	if(check(mat, target)) {
    		return true;
    	}
    	transposeLeftOptimize(mat);
    	if(check(mat, target)) {
    		return true;
    	}
    	transposeRightOptimize(mat);
    	if(check(mat, target)) {
    		return true;
    	}
    	transposeLeftOptimize(mat);
    	if(check(mat, target)) {
    		return true;
    	}
    	return false;
    }
 // Left Rotation (Counterclockwise)
    public static void  transposeLeftOptimize(int[][] mat) {
        int n = mat.length;
        
        // Transpose and reverse columns
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
            	int t =mat[j][n - 1 - i]; 
            	mat[j][n - 1 - i] = mat[i][j];
            	mat[i][j]=t;
            }
        }
       
    }

    // Right Rotation (Clockwise)
    public static void transposeRightOptimize(int[][] mat) {
        int n = mat.length;
        // Transpose and reverse rows
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
            	int t= mat[j][i] ;
            	mat[j][i] = mat[n - 1 - i][j];
            	mat[n-1-i][j]=t;
            }
        }
       
    }    
    

	public static boolean check(int [][] ans,int [][] output) {
    	if(output.length!=ans.length ||output[0].length!=ans[0].length ) {
    		return false;
    	}
    	for(int i =0;i<ans.length;i++) {
    		if(!Arrays.equals(output[i],ans[i])) {
    			return false;
    		}
    	}
    	return true;
    		}
    	
public static String printMatrix(int [][]img) {
    	
    	StringBuilder str = new StringBuilder("{");
    	for(int i =0;i<img.length;i++) {
    		str.append(Arrays.toString(img[i])+"\n");
    	}
    	str.append("}");
    	return str.toString();
    }
    public static void main(String[] args) {
		//Example 1:
		
		int [][]mat1 = {{0,1},{1,0}}, target1 = {{1,0},{0,1}};
		boolean output1=true;
		
		//Example 2:

		int [][] mat2= {{0,1},{1,1}}, target2 = {{1,0},{0,1}};
		boolean output2=false;
		
		//Example 3:

		int [][] mat3= {{0,0,0},{0,1,0},{1,1,1}}, target3 = {{1,1,1},{0,1,0},{0,0,0}};
		boolean output3=false;
		 
		boolean ans1=findRotationBruteForce(mat1,target1);
    	boolean ans2=findRotationBruteForce(mat2,target2);
    	boolean ans3=findRotationBruteForce(mat3,target3);

    	if(output1 == ans1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ output1);
			System.out.println("Your Answer :"+ ans1);
		}
		if(output2 == ans2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ output2);
			System.out.println("Your Answer :"+ans2 );
		}
		if(output3 == ans3) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Expected Ouput :"+ output3);
			System.out.println("Your Answer :"+ans3 );
		}
		
		System.out.println("Optimize Approch :");
		ans1=findRotationOptimize(mat1,target1);
		ans2=findRotationOptimize(mat2,target2);
    	ans3=findRotationOptimize(mat3,target3);
		
		if(ans1 == output1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ output1);
			System.out.println("Your Answer :"+ ans1);
		}
		if(output2 == ans2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ output2);
			System.out.println("Your Answer :"+ans2 );
		}
		if(output3 == ans3) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Expected Ouput :"+ output3);
			System.out.println("Your Answer :"+ans3 );
		}
	}
}
