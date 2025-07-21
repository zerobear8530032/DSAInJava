//733. Flood Fill
//Easy
//Topics
//premium lock icon
//Companies
//Hint
//You are given an image represented by an m x n grid of integers image, where image[i][j] represents the pixel value of the image. You are also given three integers sr, sc, and color. Your task is to perform a flood fill on the image starting from the pixel image[sr][sc].
//
//To perform a flood fill:
//
//Begin with the starting pixel and change its color to color.
//Perform the same process for each pixel that is directly adjacent (pixels that share a side with the original pixel, either horizontally or vertically) and shares the same color as the starting pixel.
//Keep repeating this process by checking neighboring pixels of the updated pixels and modifying their color if it matches the original color of the starting pixel.
//The process stops when there are no more adjacent pixels of the original color to update.
//Return the modified image after performing the flood fill.
//
// 
//
//Example 1:
//
//Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
//
//Output: [[2,2,2],[2,2,0],[2,0,1]]
//
//Explanation:
//
//
//
//From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
//
//Note the bottom corner is not colored 2, because it is not horizontally or vertically connected to the starting pixel.
//
//Example 2:
//
//Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0
//
//Output: [[0,0,0],[0,0,0]]
//
//Explanation:
//
//The starting pixel is already colored with 0, which is the same as the target color. Therefore, no changes are made to the image.
//
// 
//
//Constraints:
//
//m == image.length
//n == image[i].length
//1 <= m, n <= 50
//0 <= image[i][j], color < 216
//0 <= sr < m
//0 <= sc < n



package Stacks;

import java.util.Arrays;

public class FloodFill_733 {
	
	public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int pixel= image[sr][sc];
        int [] [] flag= new int [image.length][image[sr].length];
        helper(image,sr,sc,color,pixel,flag);
        return image;
    }
    public static void helper(int [][] image,int r,int c,int color,int pixel, int [][] flag){
        if(r<0 || c<0 || r==image.length || c==image[r].length){
            return ;
        }
        System.out.println(image[r][c]);
        if(flag[r][c]==-1 || image[r][c]!=pixel ){
            return ;
        }
        image[r][c]=color;
        flag[r][c]=-1;
        
        // go up
        helper(image,r-1,c,color,pixel,flag);
        // go down
        helper(image,r+1,c,color,pixel,flag);
        // go left
        helper(image,r,c-1,color,pixel,flag);
        // go right
        helper(image,r,c+1,color,pixel,flag);
       
    }
	public static void main(String[] args) {
		
		//Example 1:

		int [][] image1 = {{1,1,1},{1,1,0},{1,0,1}};
		int sr1 = 1, sc1 = 1, color1 = 2;
		int [][] output1= {{2,2,2},{2,2,0},{2,0,1}};

		//Example 2:

		//Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0
		int [][] image2 = {{0,0,0},{0,0,0}};
		int sr2 = 0, sc2 = 0, color2 = 0;
		int [][] output2= {{0,0,0},{0,0,0}};
		
		//Example 3:
		
		//Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0
		int [][] image3 = {{0,0,0},{0,0,0}};
		int sr3 = 1, sc3 = 0, color3 = 2;
		int [][] output3= {{0,0,0},{0,0,0}};

		int [][] arr1=floodFill(image1, sr1, sc1, color1);
		int [][] arr2=floodFill(image2, sr2, sc2, color2);
		int [][] arr3=floodFill(image3, sr3, sc3, color3);



	}

}
