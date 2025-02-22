//832. Flipping an Image
//Solved
//Easy
//Topics
//Companies
//Given an n x n binary matrix image, flip the image horizontally, then invert it, and return the resulting image.
//
//To flip an image horizontally means that each row of the image is reversed.
//
//For example, flipping [1,1,0] horizontally results in [0,1,1].
//To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.
//
//For example, inverting [0,1,1] results in [1,0,0].
// 
//
//Example 1:
//
//Input: image = [[1,1,0],[1,0,1],[0,0,0]]
//Output: [[1,0,0],[0,1,0],[1,1,1]]
//Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
//Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
//Example 2:
//
//Input: image = [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
//Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
//Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
//Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
// 
//
//Constraints:
//
//n == image.length
//n == image[i].length
//1 <= n <= 20
//images[i][j] is either 0 or 1.

package Arrays;

import java.util.Arrays;

class FlippingAnImage_832 {
	
//	brute force approch :
//	first flip or reverse each row then invert each bit
//	
//	  time complexity :O(n*m)-> it will iterate over entire matrix 2 times so its not efficient enought
//    space complexity :O(1)
    
    public static int[][] flipAndInvertImageBruteForce(int[][] image) {
//    flip the image
    	for(int i =0;i<image.length;i++) {
    		flip(image[i]);
    	}
//    	invert the image 
    	for(int i =0;i<image.length;i++) {
    		for(int j=0;j<image[i].length;j++) {
    			if(image[i][j]==0) {
    				image[i][j]=1;
    				}else {
    					image[i][j]=0;    					
    				}
    		}
    	}
        
    	
    	return image;
    }
    
//    helper function to flip image:
    static public  void flip(int [] arr) {
    	int s=0;
    	int e= arr.length-1;
    	while(s<e) {
    		int t = arr[s];
    		arr[s]=arr[e];
    		arr[e]=t;
    		s++;
    		e--;
    	}
    }
//    better approch :
//    flip and invert at the same time :
//    time complexity :O(n*m)
//    space complexity :O(1)
    
    public static int[][] flipAndInvertImageBetter(int[][] image) {
    	
    	
    	   for (int i = 0; i < image.length; i++) {
    	        int start = 0, end = image[i].length - 1;

    	        while (start <= end) {
    	            // Swap and invert at the same time using XOR
    	            int temp = image[i][start] ^ 1;
    	            image[i][start] = image[i][end] ^ 1;
    	            image[i][end] = temp;

    	            start++;
    	            end--;
    	        }
    	   }
    	
    	return image;
    }
    
    public static void swap(int [] img,int start,int end) {
    	int t = img[start];
    	img[start]=img[end];
    	img[end]=t;
    }
    
    public static int[][] flipAndInvertImageBest(int[][] image) {
    	//

    	return image;
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
    	
    	StringBuilder str = new StringBuilder("[");
    	for(int i =0;i<img.length;i++) {
    		str.append(Arrays.toString(img[i]));
    	}
    	str.append("]");
    	return str.toString();
    }
    public static void main(String[] args) {
		
    	
    	//Example 1:
    	
    	int [][] image1 = {{1,1,0},{1,0,1},{0,0,0}};
    	int [][] output1= {{1,0,0},{0,1,0},{1,1,1}};

    	//Example 2:
    	
    	int [][] image2 = {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
    	int [][] output2 = {{1,1,0,0},{0,1,1,0},{0,0,0,1},{1,0,1,0}};
    	
    	int ans1[][]=flipAndInvertImageBruteForce(image1);
    	int ans2[][]=flipAndInvertImageBruteForce(image2);

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
		
		image1=new int [][]{{1,1,0},{1,0,1},{0,0,0}};
		image2=new int [][] {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
		ans1 = flipAndInvertImageBetter(image1);
		ans2 = flipAndInvertImageBetter(image2);
		
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