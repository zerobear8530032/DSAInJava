//1304. Find N Unique Integers Sum up to Zero
//Solved
//Easy
//Topics
//Companies
//Hint
//Given an integer n, return any array containing n unique integers such that they add up to 0.
//
// 
//
//Example 1:
//
//Input: n = 5
//Output: [-7,-1,1,3,4]
//Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
//Example 2:
//
//Input: n = 3
//Output: [-1,0,1]
//Example 3:
//
//Input: n = 1
//Output: [0]
// 
//
//Constraints:
//
//1 <= n <= 1000

package Arrays;

import java.util.Arrays;

public class FindNUniqueIntegersSumUpToZero_1304 {
	
	
	public static boolean check (int [] ans) {
		int s =0;
		for(int i :ans) {
			s+=i;
		}
		return s==0;
	}
	
	
//	brute force approch :
//	intution : just make a symetic array where left side is positive integer and right side 
//	are negative where each each element in incerasing or decreasing order 
//	example : n=5, ans =[1,2,0,-2,-1]
	    public static int[] sumZero(int n) {
	        int [] ans = new int [n];
	        int start =0;
	        int end =n-1;
	        int i =0;
	        while(start<end){
	            ans[start]=n-i;
	            ans[end]=-n+i;
	            start++;
	            end--;
	            i++;
	        }
	    return ans;
	    }
	    
	    public static void main(String[] args) {
	    	
	    	
	    	//Example 1:
	    	//
	    	int  n1 = 5;
	    	int []output1={-7,-1,1,3,4};

	    	//Example 2:

	    	int  n2 = 3;
	    	int [] output2= {-1,0,1};
	    	//Example 3:
	    	
	    	int  n3 = 1;
	    	int [] output3= {0};
	    	
	    	int [] ans1 =sumZero(n1);
	    	int [] ans2 =sumZero(n2);
	    	int [] ans3 =sumZero(n3);
	    	
	    	
	    	if(check( ans1)) {
				System.out.println("Case 1 Passed");
			}else {
				System.out.println("Case 1 Failed");
				System.out.println("Expected Ouput :"+ Arrays.toString(output1));
				System.out.println("Your Answer :"+ Arrays.toString(ans1));
			}
			if(check( ans2)) {
				System.out.println("Case 2 Passed");
			}else {
				System.out.println("Case 2 Failed");
				System.out.println("Expected Ouput :"+ Arrays.toString(output2));
				System.out.println("Your Answer :"+ Arrays.toString(ans2));
			}
			if(check( ans3)) {
				System.out.println("Case 3 Passed");
			}else {
				System.out.println("Case 3 Failed");
				System.out.println("Expected Ouput :"+ Arrays.toString(output3));
				System.out.println("Your Answer :"+ Arrays.toString(ans3));
			}

			
		}
	
	
}

