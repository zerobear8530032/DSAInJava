//
//1732. Find the Highest Altitude
//Solved
//Easy
//Topics
//Companies
//Hint
//There is a biker going on a road trip. The road trip consists of n + 1 points at different altitudes. The biker starts his trip on point 0 with altitude equal 0.
//
//You are given an integer array gain of length n where gain[i] is the net gain in altitude between points i​​​​​​ and i + 1 for all (0 <= i < n). Return the highest altitude of a point.
//
// 
//
//Example 1:
//
//Input: gain = [-5,1,5,0,-7]
//Output: 1
//Explanation: The altitudes are [0,-5,-4,1,1,-6]. The highest is 1.
//Example 2:
//
//Input: gain = [-4,-3,-2,-1,4,3,2]
//Output: 0
//Explanation: The altitudes are [0,-4,-7,-9,-10,-6,-3,-1]. The highest is 0.
// 
//
//Constraints:
//
//n == gain.length
//1 <= n <= 100
//-100 <= gain[i] <= 100
package Arrays;

import java.util.Arrays;

class FindTheHighestAltitude_1732 {
//	approch : simple take prefix sum of entire array and find the max out of that 
//	time complexity : O(n) -> 2 N if we consider 2 loop but in anotation is n
//	space complexity : O(1)
    public static  int largestAltitudeBruteForce(int[] gain) {
     int max =0;
     int sum=0;
     for(int i=0;i<gain.length;i++){
        sum+=gain[i];
        gain[i]=sum;
     }
     
     for(int i=0;i<gain.length;i++){
    	 max=Math.max(max, gain[i]);
     }
     return max;
    }
    
//  optimize  approch :
//    we does not need to store the prefix sum we can instead just calculate on the go sum and max using max while curr sum
//	time complexity : O(n) -> simgle loop
//	space complexity : O(1)
    
    
    public static int largestAltitudeOptimze(int[] gain) {
    	int max =0;
    	int sum=0;
    	for(int currgain: gain){
    		sum+=currgain;
    		max=Math.max(max,sum);
    	}
    	return max;
    }
    
    public static void main(String[] args) {
 
    	
    	//Example 1:
    	
    	int [] gain1 = {-5,1,5,0,-7};
    	int output1=1;
    	//Explanation: The altitudes are {0,-5,-4,1,1,-6}. The highest is 1.
    
    	//Example 2:

    	int [] gain2 = {-4,-3,-2,-1,4,3,2};
    	int output2=0;
    	
    	int ans1=largestAltitudeBruteForce(gain1);
    	int ans2=largestAltitudeBruteForce(gain2);
    	
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
    	
    	System.out.println("Optimize Approch :");
    	
    	gain1= new int []{-5,1,5,0,-7};
    	gain2=new int []{-4,-3,-2,-1,4,3,2};

    	
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
    	

    	
    }
}