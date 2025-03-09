//3208. Alternating Groups II
//Medium
//Topics
//Companies
//Hint
//There is a circle of red and blue tiles. You are given an array of integers colors and an integer k. The color of tile i is represented by colors[i]:
//
//colors[i] == 0 means that tile i is red.
//colors[i] == 1 means that tile i is blue.
//An alternating group is every k contiguous tiles in the circle with alternating colors (each tile in the group except the first and last one has a different color from its left and right tiles).
//
//Return the number of alternating groups.
//
//Note that since colors represents a circle, the first and the last tiles are considered to be next to each other.
//
//Example 1:
//
//Input: colors = [0,1,0,1,0], k = 3
//
//Output: 3
//
//Explanation:
//
//
//
//Alternating groups:
//
//
//
//Example 2:
//
//Input: colors = [0,1,0,0,1,0,1], k = 6
//
//Output: 2
//
//Explanation:
//
//
//
//Alternating groups:
//
//
//
//Example 3:
//
//Input: colors = [1,1,0,1], k = 4
//
//Output: 0
//
//Explanation:
//
//
//
// 
//
//Constraints:
//
//3 <= colors.length <= 105
//0 <= colors[i] <= 1
//3 <= k <= colors.length


package Arrays;

import java.util.Arrays;

public class MovingZeroesToEnd {
	
//	use a new array where we have a copy of entire array with k-1 starting elements 
//	this will create a linear cicular array now we just need to take  k size window in the 
//	array and check for pairs :
//  time complexity :O(n*k)
//  space complexity :O(n+k)
//	this solution will not get accepted 
	
	 public static int numberOfAlternatingGroupsBruteForce(int[] colors, int k) {
		 int [] linearcolors= new int [colors.length+k-1];
		 int idx=0;
		 for(int i =0;i<colors.length;i++) {// create a copy of input array 
			 linearcolors[idx]= colors[i];
			 idx++;
		 }
		 for(int i =0;i<k-1;i++) {// append starting k-1 elements
			 linearcolors[idx]= colors[i];
			 idx++;
		 }
		 
		int l=0;
		int r=k-1;
		int count=0;
		while(r<linearcolors.length) {// check each pair
			if (isAlternativeGroup(l, r, linearcolors)) {
				count++;
			}
			l++;
			r++;
		}
		return count;    
	    }
	 public static boolean isAlternativeGroup(int s,int e,int[] arr) {
		 for(int i =s;i<e;i++) {
			 if(arr[i]==arr[i+1]) return false;
		 }
		 return true;
	 }
	 
//	 better approch :
//	 in brute force solution we were checking every single sub array window form start till end 
//	 but we can optimize it 
//	 we know if the window have any single element repeat in btw the entire window will never be 
//	 alternative explanations :
//	 example 2 :
//	 [0,1,0,0,1,0,1,0,1,0,0,1]
//	 here is l is at 0 , r= 5
//	look closly the window l=0,r=5 is also invalid
//	look closly the window l=1,r=6 is also invalid
//	look closly the window l=2,r=7 is also invalid
//	look closly the window l=3,r=8 is valid why
//	 because the 0,0 were reapting in window we will skip that part 
//  time complexity :O(n+k)
//  space complexity :O(n+k)
//	this solution will not get accepted 
 
	 public static int numberOfAlternatingGroupsBetter(int[] colors, int k) {
		 int [] linearcolors= new int [colors.length+k-1];
		 int idx=0;
		 for(int i =0;i<colors.length;i++) {// create a copy array
			 linearcolors[idx]= colors[i];
			 idx++;
		 }
		 for(int i =0;i<k-1;i++) {// append starting k-1 elements
			 linearcolors[idx]= colors[i];
			 idx++;
		 }
		 
		 int l=0;
		 int r=0;
		 int count=0;
		 int len = linearcolors.length;
		 while(r<len) {// here we check if window size is ==k if yes then its a avalid group
			 int winsize= r-l+1;
			 if(winsize<k) { // here we check if windowsize<k we will not take any repeating numbers
				 if(r<len-1 && linearcolors[r]==linearcolors[r+1]) {
					l=r+1; 
				 }
				 r++;
			 }else {// if the above window is ==k means we found our group
				count++;// here we increase count
				if(r<len-1 && linearcolors[r]==linearcolors[r+1]) {// here if the next pair is also have repeatiing nnumber	
					// RESET THE WINDOW					
					l=r+1;
					r++;	
				 }else {
//					 slide to next elements
					 l++;
					 r++;
				 }
			 }
		 }
return count;
	 }
	 
//	 better approch :
//	 here we does not use extra array we can use % operator to get the first index when we
//	 get out out of bounds
//	 
	 public static int numberOfAlternatingGroupsBest(int[] colors, int k) {
		
		 int l=0;
		 int count=0;
		 int len = colors.length;
//		 r = second pointer starting from 1
		 for( int r =1;r<(len+(k-1));r++) {
			 // if r%len where r >len then it will get back in bounds
			 
			 if(colors[r%len]==colors[(r-1)%len])  l=r;// here we check current r is equal to prevvious
//			 like we did in previous approch
			 int windowsize=r-l+1;// calcualte the window size
			 if(windowsize>k) l=(l+1)%len;// check if its greater decrease its size by
//			 circular increasing the left pointer
			 windowsize=r-l+1;// recalcualte windowsize
			 if(windowsize==k) count++;// if its equal to k means its a valid group
			 
		 }
		 return count;
	 }
	 
	 
	
	public static void main(String[] args) {
		
		
		//Example 1:

		int []colors1 = {0,1,0,1,0};
		int k1 = 3;
		int output1=3;
		
		//Example 2:
		
		int []colors2 = {0,1,0,0,1,0,1};
		int k2 = 6;
		int output2=2;
		
		//Example 3:
		//
		
		int []colors3 = {0,1,0,0,1};
		int k3 = 3;
		int output3=3;
		
		int []colors4 = {0,1,1};
		int k4 = 3;
		int output4=1;
		
		int ans1 =numberOfAlternatingGroupsBruteForce(colors1,k1);
		int ans2 =numberOfAlternatingGroupsBruteForce(colors2, k2);
		int ans3 =numberOfAlternatingGroupsBruteForce(colors3,  k3);
		int ans4 =numberOfAlternatingGroupsBruteForce(colors4,  k4);
		
		System.out.println("Brute Force Approch :");
		
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
		
		ans1 =numberOfAlternatingGroupsBetter(colors1,k1);
		ans2 =numberOfAlternatingGroupsBetter(colors2, k2);
		ans3 =numberOfAlternatingGroupsBetter(colors3,  k3);
		ans4 =numberOfAlternatingGroupsBetter(colors4,  k4);
		
		System.out.println("Better Approch :");
		
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
		ans1 =numberOfAlternatingGroupsBest(colors1,k1);
		ans2 =numberOfAlternatingGroupsBest(colors2, k2);
		ans3 =numberOfAlternatingGroupsBest(colors3,  k3);
		ans4 =numberOfAlternatingGroupsBest(colors4,  k4);
		
		System.out.println("Best Approch :");
		
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
