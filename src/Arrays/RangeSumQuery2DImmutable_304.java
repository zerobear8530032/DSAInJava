//304. Range Sum Query 2D - Immutable
//Solved
//Medium
//Topics
//Companies
//Given a 2D matrix matrix, handle multiple queries of the following type:
//
//Calculate the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
//Implement the NumMatrix class:
//
//NumMatrix(int[][] matrix) Initializes the object with the integer matrix matrix.
//int sumRegion(int row1, int col1, int row2, int col2) Returns the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
//You must design an algorithm where sumRegion works on O(1) time complexity.
//
// 
//
//Example 1:
//
//
//Input
//["NumMatrix", "sumRegion", "sumRegion", "sumRegion"]
//[[[[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]], [2, 1, 4, 3], [1, 1, 2, 2], [1, 2, 2, 4]]
//Output
//[null, 8, 11, 12]
//
//Explanation
//NumMatrix numMatrix = new NumMatrix([[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]);
//numMatrix.sumRegion(2, 1, 4, 3); // return 8 (i.e sum of the red rectangle)
//numMatrix.sumRegion(1, 1, 2, 2); // return 11 (i.e sum of the green rectangle)
//numMatrix.sumRegion(1, 2, 2, 4); // return 12 (i.e sum of the blue rectangle)
// 
//
//Constraints:
//
//m == matrix.length
//n == matrix[i].length
//1 <= m, n <= 200
//-104 <= matrix[i][j] <= 104
//0 <= row1 <= row2 < m
//0 <= col1 <= col2 < n
//At most 104 calls will be made to sumRegion.




package Arrays;

import java.util.Arrays;

//approch create a matrix giving as input and just 
// sum the number form row1 till row2 and col1 till col2
//time complexity:
//constructor : o(1)
//function : o(row*col)
//space complexity:
//constructor : o(n*m)
//function : o(1)

class NumMatrixBruteForce {
    int [][] numMatrix;

    public NumMatrixBruteForce(int[][] matrix) {
        numMatrix=matrix;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum =0;
        for(int i=row1;i<=row2;i++){
            for(int j =col1;j<=col2;j++){
                sum+=this.numMatrix[i][j];
            }
        }
        return sum;
    }
}
//approch create a matrix giving as input and just 
//where each row in our matrix is the prefix sum of entire row
// for getting the sumRange we can just do sum of all [all row] [cols1-1] index 
// for getting the sumRange we can just do sum of all [all row] [cols2] index 
// and if we substract the total sum - remaining it will give final answer

//time complexity:
//constructor : o(row*col)
//function : o(n)
//space complexity:
//constructor : o(n*m)
//function : o(1)
class NumMatrixBetter{
	int [][] rowPrefixMatrix;
	
	public NumMatrixBetter(int[][] matrix) {
		int row=matrix.length;
		int col=matrix[0].length;
		rowPrefixMatrix= new int [row][col];
		for(int i =0;i<row;i++) {
			int sum = 0;
			for(int j=0;j<col;j++) {
				sum+= matrix[i][j];
				rowPrefixMatrix[i][j]=sum;
			}
		}
		
	}
	
	public int sumRegion(int row1, int col1, int row2, int col2) {
		int totalSum=0;
		int remainingSum=0;
		for(int i =row1;i<=row2;i++) {
			int num=rowPrefixMatrix[i][col2];
			totalSum+=num;
			if((col1-1)>=0) {
				num=rowPrefixMatrix[i][col1-1];				
				remainingSum+=num;
			}
		}
		return totalSum-remainingSum;
	}
}

//approch create a matrix giving as input and just 
//where each row in our matrix is the prefix sum of entire row
// for getting the sumRange we can just do sum of all [all row] [cols1-1] index 
// for getting the sumRange we can just do sum of all [all row] [cols2] index 
// and if we substract the total sum - remaining it will give final answer

//time complexity:
//constructor : o(row*col)
//function : o(1)
//space complexity:
//constructor : o(n*m)
//function : o(1)
class NumMatrixBest{
	int [][] sumMatrix;
	
	public NumMatrixBest(int[][] matrix) {
		int row=matrix.length;
		int col=matrix[0].length;
		sumMatrix= new int [row+1][col+1];
		for(int i =0;i<row;i++) {
			int Prefsum = 0;
			for(int j=0;j<col;j++) {
				Prefsum+= matrix[i][j];
				int above= sumMatrix[i][j+1];
				sumMatrix[i+1][j+1]=Prefsum+above;
			}
		}
		
	}
	
	public int sumRegion(int row1, int col1, int row2, int col2) {
		row1+=1;
		col1+=1;
		row2+=1;
		col2+=1;
		int total = sumMatrix[row2][col2];
		int above= sumMatrix[row1-1][col2];
		int left= sumMatrix[row2][col1-1];
		int topLeft= sumMatrix[row1-1][col1-1];
		return total-above-left+topLeft;
	}
}


public class RangeSumQuery2DImmutable_304 {

    public static void main(String[] args) {
    	
    	
    	//Example 1:

    	//Input
    	//["NumMatrix", "sumRegion", "sumRegion", "sumRegion"]
    	//[[[[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]], [2, 1, 4, 3], [1, 1, 2, 2], [1, 2, 2, 4]]
    	//[null, 8, 11, 12]
    	//
    	//Explanation
    	//Output
    	int output1=8;
    	int output2=11;
    	int output3=12;
    	
    	NumMatrixBruteForce numMatrix = new NumMatrixBruteForce(new int [][] {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}}) ;
    	System.out.println("Brute Force Approch :");
		
    	int ans1= numMatrix.sumRegion(2, 1, 4, 3); // return 8 (i.e sum of the red rectangle)
    	int ans2=numMatrix.sumRegion(1, 1, 2, 2); // return 11 (i.e sum of the green rectangle)
    	int ans3= numMatrix.sumRegion(1, 2, 2, 4); // return 12 (i.e sum of the blue rectangle)
    	
		
		if(ans1==output1) {
			System.out.println("Case 1 Passed ");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Excepted Output : "+ (output1));
			System.out.println("Your Output : "+ (ans1));
		}
		if(ans2==output2) {
			System.out.println("Case 2 Passed ");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Excepted Output : "+ (output2));
			System.out.println("Your Output : "+ ans1);
		}
		if(ans3==output3) {
			System.out.println("Case 3 Passed ");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Excepted Output : "+ (output2));
			System.out.println("Your Output : "+ ans1);
		}
		
		
		NumMatrixBetter numMatrixBetter = new NumMatrixBetter(new int [][] {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}}) ;
    	System.out.println("Better Approch :");
		
    	ans1= numMatrixBetter.sumRegion(2, 1, 4, 3); // return 8 (i.e sum of the red rectangle)
    	ans2=numMatrixBetter.sumRegion(1, 1, 2, 2); // return 11 (i.e sum of the green rectangle)
    	ans3= numMatrixBetter.sumRegion(1, 2, 2, 4); // return 12 (i.e sum of the blue rectangle)
    	
		if(ans1==output1) {
			System.out.println("Case 1 Passed ");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Excepted Output : "+ (output1));
			System.out.println("Your Output : "+ (ans1));
		}
		if(ans2==output2) {
			System.out.println("Case 2 Passed ");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Excepted Output : "+ (output2));
			System.out.println("Your Output : "+ ans1);
		}
		if(ans3==output3) {
			System.out.println("Case 3 Passed ");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Excepted Output : "+ (output2));
			System.out.println("Your Output : "+ ans1);
		}
		
		NumMatrixBest numMatrixBest= new NumMatrixBest(new int [][] {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}});
		System.out.println("Best Approch :");
		
		ans1= numMatrixBest.sumRegion(2, 1, 4, 3); // return 8 (i.e sum of the red rectangle)
		ans2=numMatrixBest.sumRegion(1, 1, 2, 2); // return 11 (i.e sum of the green rectangle)
		ans3= numMatrixBest.sumRegion(1, 2, 2, 4); // return 12 (i.e sum of the blue rectangle)
		
		if(ans1==output1) {
			System.out.println("Case 1 Passed ");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Excepted Output : "+ (output1));
			System.out.println("Your Output : "+ (ans1));
		}
		if(ans2==output2) {
			System.out.println("Case 2 Passed ");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Excepted Output : "+ (output2));
			System.out.println("Your Output : "+ ans1);
		}
		if(ans3==output3) {
			System.out.println("Case 3 Passed ");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Excepted Output : "+ (output2));
			System.out.println("Your Output : "+ ans1);
		}
		
	}
}

 

