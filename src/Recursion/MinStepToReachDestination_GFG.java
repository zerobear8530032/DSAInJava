//Minimum steps to destination
//Difficulty: MediumAccuracy: 31.77%Submissions: 43K+Points: 4
//Given an infinite number line. You start at 0 and can go either to the left or to the right. The condition is that in the ith move, you must take i steps. Given a destination d, find the minimum number of steps required to reach that destination.
//
//Example 1:
//
//Input: d = 2
//Output: 3
//Explaination: The steps taken are +1, -2 and +3.
//Example 2:
//
//Input: d = 10
//Output: 4
//Explaination: The steps taken are +1, +2, +3 and +4.
//Your Task:
//You do not need to read input or print anything. Your task is to complete the function minSteps() which takes the value d as input parameter and returns the minimum number of steps required to reach the destination d from 0.
//
//Expected Time Complexity: O(sqrt(d))
//Expected Auxiliary Space: O(1)
//
//Constraints:
//1 ≤ d ≤ 10000



package Recursion;

public class MinStepToReachDestination_GFG {
	
	
//	approch :
//	we check every single possible way to reach the destination 
//	and to stop out of bound we can go max left untill -d and right until +d
//	if we exceed it we will not go there
    static int minSteps(int d) {
    	return helper(d,0,1);
    }
    
    public static int helper(int distance ,int position, int step) {
    	if(position==distance || position==-distance) {
    		return step-1;
    	}
    	if(position<0) {
    		int bound=-distance;
    		if(position<bound) {
    			return Integer.MAX_VALUE;    		
    		}
    	}
    	if(position>0) {
    		int bound=distance;
    		if(position>bound) {
    			return Integer.MAX_VALUE;    		
    		}
    	}
    	int res=0;
    	int left = helper(distance,position-step,step+1);
    	int right = helper(distance,position+step,step+1);
    	res= Math.min(left, right);
    	return res;
    }
    
   
//    better approch :
//    we can see one thing that each time we change direction we will get the 
//    difference btw position even 
//    so if we go from left to right and get out of bound of our destination 
//    then we can return step cause its possitble to get back to even distance 
//    but if the current possition is odd we will skipit
//    
    
    
    public static int minStepsBetter(int d) {
    	int step =0;
    	int pos =0;
    	while(pos<d) {
    		pos+=step;
    		step++;
    	}
//    	check current distance btw destination and position
//    	if its even we can get in that much step
    	if(pos==d || (pos-d)%2==0) {
    		return step-1;
    	}
//    	if not we try to find such distance after d which have even position btw posittion and distance 
    	while((pos-d)%2!=0) {
    		pos+=step;
    		step++;    		
    	}
    	return step-1;
    }
    


	public static void main(String[] args) {
		
		
		//Example 1:
		
		int  d1 = 2;
		int output1 = 3;

		//Example 2:
		
		int  d2 = 10;
		int output2 = 4;
		
		
		System.out.println("Brute Force Approch :");
		
		int ans1=minSteps(d1);
		int ans2=minSteps(d2);
		
		if(output1==ans1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output :"+output1 );
			System.out.println("Your Output :"+ans1);
		}
		if(output2==ans2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Actual Output :"+output2 );
			System.out.println("Your Output :"+ans2);
		}




	}

}
