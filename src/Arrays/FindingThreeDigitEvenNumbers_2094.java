//2094. Finding 3-Digit Even Numbers
//Solved
//Easy
//Topics
//Companies
//Hint
//You are given an integer array digits, where each element is a digit. The array may contain duplicates.
//
//You need to find all the unique integers that follow the given requirements:
//
//The integer consists of the concatenation of three elements from digits in any arbitrary order.
//The integer does not have leading zeros.
//The integer is even.
//For example, if the given digits were [1, 2, 3], integers 132 and 312 follow the requirements.
//
//Return a sorted array of the unique integers.
//
// 
//
//Example 1:
//
//Input: digits = [2,1,3,0]
//Output: [102,120,130,132,210,230,302,310,312,320]
//Explanation: All the possible integers that follow the requirements are in the output array. 
//Notice that there are no odd integers or integers with leading zeros.
//Example 2:
//
//Input: digits = [2,2,8,8,2]
//Output: [222,228,282,288,822,828,882]
//Explanation: The same digit can be used as many times as it appears in digits. 
//In this example, the digit 8 is used twice each time in 288, 828, and 882. 
//Example 3:
//
//Input: digits = [3,7,5]
//Output: []
//Explanation: No even integers can be formed using the given digits.
// 
//
//Constraints:
//
//3 <= digits.length <= 100
package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class FindingThreeDigitEvenNumbers_2094 {
	
//	brute force approch :
//	we check every single 3 pairs integer can be created by 
//	the digits and add them to a tree set then convert to the array 
//	time complexity : O(n^3)
//	space complexity : O(n)
	    public static int[] findEvenNumbersBruteForce(int[] digits) {
	        SortedSet<Integer> set = new TreeSet<Integer>();
	        for(int i =0;i<digits.length;i++){
	            if(digits[i]==0) continue;
	            for(int j=0;j<digits.length;j++){
	                if(i==j){
	                    continue;
	                }
	                for(int k=0;k<digits.length;k++){
	                if(j==k ||  i==k){
	                    continue;
	                }
	                int num = (digits[i]*100)+(digits[j]*10)+(digits[k]);
	                if(num%2==0){
	                    set.add(num);
	                }
	                }
	            }
	        }
	        int [] res =new int[set.size()];
	        int i =0;
	        for(int x:set){
	            res[i]=x;
	            i++;
	        }
	        return res;
	    }
	    
//	Better approch :
//	    here we will find each digits frequency we can map it on a 10 digit array
//	    now to make each even element without leading zero
//	    at 100 th place only number from 1 to 9 are possible
//	    at 10 th place any digit are possible 0 to 9
//	    at 1 st place any digit which is even 0,2,4,6,8 is possible
//	    so we will check if we can make that digit by checking we have that value
//	    that digit in our map and try to make every even digits
//	    now we can put each element in an ans arraylist or array 
	    

	    
//	time complexity : O(n)
//	space complexity : O(n)
	    public static int[] findEvenNumbersBetter(int[] digits) {
	    	int [] map = new int [10];
//	    	create a frequency map
	    	for(int x:digits) {
	    		map[x]++;
	    	}
//	    	sorted set
	    	ArrayList<Integer> nums= new ArrayList<Integer>();
//	    	100 th place digit loop

	    	for(int i =1;i<=9;i++) {
	    		if(map[i]==0) {
	    			continue;
	    		}
	    		map[i]--;// take one element
	    		for(int j=0;j<=9;j++) {// 10 thplace element
	    			if(map[j]==0) {
	    				continue;
	    			}
	    			map[j]--;// take second element
	    			for(int k=0;k<=8;k+=2) {// once place digit 
	    			if(map[k]==0) {
	    				continue;
	    			}
	    			map[k]--;// take third element
	    			
	    			int num= i*100+j*10+ k;// make the numbmer
	    			nums.add(num);// add to remove duplicates and store in a sorted  manner
	    			map[k]++;// return the taken digit
	    			}
	    			map[j]++;// return the taken digit
	    		}
	    		map[i]++;// return the taken digit
	    	}
	    	
	    	int [] res =new int[nums.size()];
	    	
	        int i =0;
	        for(int x:nums){
	            res[i]=x;
	            i++;
	        }
	        return res;
	    }
	    
	    
	    public static boolean check(int [] output, int [] ans) {
	    	if(output.length!=ans.length) {
	    		return false;
	    	}
	    	for(int i=0;i<ans.length;i++) {
	    		if(ans[i]!=output[i]) return false;
	    	}
	    	return true;
	    }
	
	public static void main(String[] args) {
	
	//Example 1:
	
	int [] digits1 = {2,1,3,0};
	int [] output1= {102,120,130,132,210,230,302,310,312,320};
	

	//Example 2:

	int [] digits2 = {2,2,8,8,2};
	int [] output2= {222,228,282,288,822,828,882};

	//Example 3:
	
	int [] digits3 = {3,7,5};
	int [] output3 = {};
	
	
	int []ans1= findEvenNumbersBruteForce(digits1);
	int []ans2= findEvenNumbersBruteForce(digits2);
	int []ans3= findEvenNumbersBruteForce(digits3);
	
	if(check(output1,ans1)) {
		System.out.println("Case 1 Passed");
	}else {
		System.out.println("Case 1 Failed");
		System.out.println("Expected Ouput :"+ Arrays.toString(output1));
		System.out.println("Your Answer :"+ Arrays.toString(ans1));
	}
	if(check(output2,ans2)) {
		System.out.println("Case 2 Passed");
	}else {
		System.out.println("Case 2 Failed");
		System.out.println("Expected Ouput :"+ Arrays.toString(output2));
		System.out.println("Your Answer :"+ Arrays.toString(ans2));
	}
	if(check(output3,ans3)) {
		System.out.println("Case 3 Passed");
	}else {
		System.out.println("Case 3 Failed");
		System.out.println("Expected Ouput :"+ Arrays.toString(output3));
		System.out.println("Your Answer :"+ Arrays.toString(ans3));
	}
	
	System.out.println("Better Approch :");
	
	ans1= findEvenNumbersBetter(digits1);
	ans2= findEvenNumbersBetter(digits2);
	ans3= findEvenNumbersBetter(digits3);
	
	if(check(output1,ans1)) {
		System.out.println("Case 1 Passed");
	}else {
		System.out.println("Case 1 Failed");
		System.out.println("Expected Ouput :"+ Arrays.toString(output1));
		System.out.println("Your Answer :"+ Arrays.toString(ans1));
	}
	if(check(output2,ans2)) {
		System.out.println("Case 2 Passed");
	}else {
		System.out.println("Case 2 Failed");
		System.out.println("Expected Ouput :"+ Arrays.toString(output2));
		System.out.println("Your Answer :"+ Arrays.toString(ans2));
	}
	if(check(output3,ans3)) {
		System.out.println("Case 3 Passed");
	}else {
		System.out.println("Case 3 Failed");
		System.out.println("Expected Ouput :"+ Arrays.toString(output3));
		System.out.println("Your Answer :"+ Arrays.toString(ans3));
	}

	

	}	

}
