//566. Reshape the Matrix
//Solved
//Easy
//Topics
//Companies
//Hint
//In MATLAB, there is a handy function called reshape which can reshape an m x n matrix into a new one with a different size r x c keeping its original data.
//
//You are given an m x n matrix mat and two integers r and c representing the number of rows and the number of columns of the wanted reshaped matrix.
//
//The reshaped matrix should be filled with all the elements of the original matrix in the same row-traversing order as they were.
//
//If the reshape operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.
//
// 
//
//Example 1:
//
//
//Input: mat = [[1,2],[3,4]], r = 1, c = 4
//Output: [[1,2,3,4]]
//Example 2:
//
//
//Input: mat = [[1,2],[3,4]], r = 2, c = 4
//Output: [[1,2],[3,4]]
// 
//
//Constraints:
//
//m == mat.length
//n == mat[i].length
//1 <= m, n <= 100
//-1000 <= mat[i][j] <= 1000
//1 <= r, c <= 300

package Arrays;

import java.util.Arrays;

public class ReshapeTheMatrix_566 {
	
//	Brute Force Approch :
//	first we check the r*c == mat.length*mat[0].length
//	if they are equal we can reshape other wise we willl return original matrix accordin to questions
//	now create abuffer array which will be a 1d array to store each element in a linear order 
//	and its lengh = r*c
//	then just fill the array  by over matrix 
//	now we have each element in a sequence in buffer now we just fill answer 
//	2d array of r*c size and fill and return ans 
	    
//	Time complexity : O(r*c) 
//	space complexity : O(r*c) 2
	public static int[][] matrixReshapeBruteFcrce(int[][] mat, int r, int c) {
	        if(r*c!= mat.length*mat[0].length){
	            return mat; // return the original array if we cant reshapre it 
	        }
	        int [] buffer = new int [r*c];// buffer arary 
	        int index=0;
	        for(int i =0;i<mat.length;i++){// iterate over rows
	            for(int j=0;j<mat[i].length;j++){// iterate over cols
	                buffer[index]=mat[i][j];// fill the matri in a single linear array easy to itereate 
	                index++;// index of buffer
	            }
	        }
	        int [] [] ans = new int [r][c];// final ans

	         index=0;// index to get element from buffer
	        for(int i =0;i<r;i++){
	            for(int j=0;j<c;j++){
	                ans[i][j]=buffer[index];// linear array to ans; 
	                index++;// index of buffer
	            }
	        }
	        return ans;


	    }

//	    OPtimize approch :
//	    here we just not using a buffer array instead we are using a  2 pointer one
//	for row and one for cols  and iterating while controlling row and col pointer
	    

//	Time complexity : O(r*c) 
//	space complexity : O(r*c) 2
	  public static int[][] matrixReshapeOptimize(int[][] mat, int r, int c) {
	        if(r*c!= mat.length*mat[0].length){
	            return mat; // return the original array if we cant reshapre it 
	        }
	        int rows=mat.length;// row length of input
	        int cols=mat[0].length;// col length of input
	        int ans[][] = new int [r][c];// ans array
	        int ansrow=0; // ans row pointer
	        int anscol=0;// ans col pointer
	        for(int i=0;i<rows;i++){// iterate over input row
	            for(int j=0;j<cols;j++){// iterate over input col
	                    ans[ansrow][anscol]=mat[i][j]; // here the ansrow,anscol set ans, and mat i,j get matri elemet
	                    anscol++; // each time we increase ans col
	                if(anscol==c){ // once row is filleed we go to next row 
	                    anscol=0;// start at col 0
	                    ansrow++;// next row
	                }
	            }
	        }
	        return ans; // ans 
	    }
	  
	  public static boolean check(int [][] ans,int [][] output) {
	    	if(ans.length!=output.length  || ans[0].length != output[0].length) {
	    		return false;
	    	}
	    	for(int i =0;i<ans.length;i++) {
	    		for(int j=0;j<ans[i].length;j++) {
	    			if(ans[i][j]!=output[i][j]) {
	    				return false;
	    			}
	    		}
	    	}
	    	return true;
	    }
	  
	  public static String printImage(int [][]img) {
	    	
	    	StringBuilder str = new StringBuilder("{");
	    	System.out.print("[");
	    	for(int i =0;i<img.length;i++) {
	    		str.append(Arrays.toString(img[i]));
	    	}
	    	str.append("]");
	    	return str.toString();
	    }
		
	public static void main(String[] args) {
		//Example 1:

		int [][]mat1 = {{1,2},{3,4}};
		int r1 = 1, c1 = 4;
		int [][] output1= {{1,2,3,4}};

		//Example 2:

		int [][]mat2 = {{1,2},{3,4}};
		int r2 = 2, c2 = 4;
		int [][] output2= {{1,2},{3,4}};
		
		
		int ans1[][]=matrixReshapeBruteFcrce(mat1,r1,c2);
    	int ans2[][]=matrixReshapeBruteFcrce(mat2,r2,c2);

    	if(check(output1, ans1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ printImage(output1));
			System.out.println("Your Answer :"+ printImage(ans1));
		}
		if(check(output2, ans2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ printImage(output2));
			System.out.println("Your Answer :"+printImage(ans2) );
		}
		
		System.out.println("Optimize approch : ");
		
		ans1=matrixReshapeOptimize(mat1,r1,c2);
    	ans2=matrixReshapeOptimize(mat2,r2,c2);

    	if(check(output1, ans1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ printImage(output1));
			System.out.println("Your Answer :"+ printImage(ans1));
		}
		if(check(output2, ans2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ printImage(output2));
			System.out.println("Your Answer :"+printImage(ans2) );
		}

		
		
	}
}

