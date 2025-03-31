//739. Daily Temperatures
//Medium
//Topics
//Companies
//Hint
//Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.
//
// 
//
//Example 1:
//
//Input: temperatures = [73,74,75,71,69,72,76,73]
//Output: [1,1,4,2,1,1,0,0]
//Example 2:
//
//Input: temperatures = [30,40,50,60]
//Output: [1,1,1,0]
//Example 3:
//
//Input: temperatures = [30,60,90]
//Output: [1,1,0]
// 
//
//Constraints:
//
//1 <= temperatures.length <= 105
//30 <= temperatures[i] <= 100


package Stacks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;



class DailyTemperatures_739 {
//	Brute Force Approch :
//	we get each index and check the entire right hand side to get the greater temprature
//	if not found return 0
//	time complexity :O(n*n)
//	space complexity :O(1)
	
    public static int[] dailyTemperaturesBruteForce(int[] temperatures) {
        int n = temperatures.length;
        int [] ans = new int [n];
        for(int i =0;i<n;i++){
            ans[i]=daysBtwWarmerDay(i,temperatures);
        }
        return ans;
    }
    public static int daysBtwWarmerDay(int s, int[] days){
        int c=0;
        for(int i =s+1;i<days.length;i++){
            c++;
            if(days[s]<days[i]){
                return c;
            }
        }
        return 0;
    }
    
//	Best Approch :
// we can use a basic monotonic stack where we push element if its empty
//    if the current top is greater then current value we pushit on stack
//    if the current top is smaller then we will pop until the top is greater and 
// 	or the stack becomes empty and count number of pop happen thats our answer 
//    at each day
//	time complexity :O(n)
//	space complexity :O(n)
    
    public static int[] dailyTemperaturesBest(int[] temperatures) {
    	Stack<int []> stack = new Stack();
    	int [] ans = new int[temperatures.length];
    	int [] p ;
    	for(int i =0;i<temperatures.length;i++) {
    		while(!stack.isEmpty() && temperatures[i]> stack.peek()[0]) {
    			p= stack.pop();
    			int idx=p[1];
    			int temp=p[0];
    			ans[idx]= i-idx;
    		}
    		stack.push(new int [] {temperatures[i],i});
    	}
    	return ans;
    }
    
    
    public static boolean check( int [] ans, int [] output) {
    	if(ans.length!= output.length) {
    		return false;
    	}
    	for(int i =0;i<ans.length;i++) {
    		if(ans[i]!=output[i]) {
    			return false;
    		}
    	}
    	return true;
    }
    
    public static void main(String[] args) {
    	
//    	    Example 1:

    		int []temperatures1 = {73,74,75,71,69,72,76,73};
    		int []output1= {1,1,4,2,1,1,0,0};
    		
//    		Example 2:

    		int []temperatures2 = {30,40,50,60};
    		int []output2= {1,1,1,0};
    		
//    		Example 3:
    		
    		int []temperatures3 = {30,60,90};
    		int []output3= {1,1,0};
    		
    		
    		int  []ans1=dailyTemperaturesBruteForce(temperatures1);
    		int  []ans2=dailyTemperaturesBruteForce(temperatures2);
    		int  []ans3=dailyTemperaturesBruteForce(temperatures3);
    		
    		System.out.println("Brute Force Approch :");
    		
    		if(check(output1,ans1)) {
    			System.out.println("Case 1 Passed ");
    		}else {
    			System.out.println("Case 1 Failed");
    			System.out.println("Your Output :"+Arrays.toString(ans1) );
    			System.out.println("Actual Output :"+ Arrays.toString(output1));			
    		}
    		if(check(output2,ans2)) {
    			System.out.println("Case 2 Passed ");
    		}else {
    			System.out.println("Case 2 Failed");
    			System.out.println("Your Output :"+ Arrays.toString(ans2));
    			System.out.println("Actual Output :"+ Arrays.toString(output2));			
    		}
    		if(check(output3,ans3)) {
    			System.out.println("Case 3 Passed ");
    		}else {
    			System.out.println("Case 3 Failed");
    			System.out.println("Your Output :"+ Arrays.toString(ans3));
    			System.out.println("Actual Output :"+ Arrays.toString(output3));			
    		}
    		
    		System.out.println("Best Approch :");
    		
    		ans1=dailyTemperaturesBest(temperatures1);
    		ans2=dailyTemperaturesBest(temperatures2);
    		ans3=dailyTemperaturesBest(temperatures3);
    		
    		if(check(output1,ans1)) {
    			System.out.println("Case 1 Passed ");
    		}else {
    			System.out.println("Case 1 Failed");
    			System.out.println("Your Output :"+Arrays.toString(ans1) );
    			System.out.println("Actual Output :"+ Arrays.toString(output1));			
    		}
    		if(check(output2,ans2)) {
    			System.out.println("Case 2 Passed ");
    		}else {
    			System.out.println("Case 2 Failed");
    			System.out.println("Your Output :"+ Arrays.toString(ans2));
    			System.out.println("Actual Output :"+ Arrays.toString(output2));			
    		}
    		if(check(output3,ans3)) {
    			System.out.println("Case 3 Passed ");
    		}else {
    			System.out.println("Case 3 Failed");
    			System.out.println("Your Output :"+ Arrays.toString(ans3));
    			System.out.println("Actual Output :"+ Arrays.toString(output3));			
    		}

    		
	}
}
