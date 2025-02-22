//989. Add to Array-Form of Integer
//Solved
//Easy
//Topics
//Companies
//The array-form of an integer num is an array representing its digits in left to right order.
//
//For example, for num = 1321, the array form is [1,3,2,1].
//Given num, the array-form of an integer, and an integer k, return the array-form of the integer num + k.
//
// 
//
//Example 1:
//
//Input: num = [1,2,0,0], k = 34
//Output: [1,2,3,4]
//Explanation: 1200 + 34 = 1234
//Example 2:
//
//Input: num = [2,7,4], k = 181
//Output: [4,5,5]
//Explanation: 274 + 181 = 455
//Example 3:
//
//Input: num = [2,1,5], k = 806
//Output: [1,0,2,1]
//Explanation: 215 + 806 = 1021
// 
//
//Constraints:
//
//1 <= num.length <= 104
//0 <= num[i] <= 9
//num does not contain any leading zeros except for the zero itself.
//1 <= k <= 104


package Arrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AddToArrayFormOfInteger_989 {
//	approch :
//	we need to take only the first place value number of k and add 
//	it to first place value number of num
//	and after taking the sum we need to make sure the  sum does not exceed then 9
//	if does means we need to take the once place value of that and take the carry and add to
//	k again to 
//	and repeat this again and again for each next place value 
//	
	 public static List<Integer> addToArrayForm(int[] num, int k) {
		  List<Integer> ans = new LinkedList();
	        int carry =0;
	        for(int i =num.length-1;i>=0;i--){
	            int krem = k%10;// take remainder of k 
	            int currsum = num[i]+krem;// calculate sum 
	            int currrem= currsum%10; // calcualte remainder to be added 
	            carry = currsum/10;// calculate carry to update
	            k=(k/10)+carry;// k/10 update the k to remove the krem from orginal k and add the carry of 
	            // currsum;
	            ans.addFirst(currrem);
	        }
	        while(k!=0){
	            ans.addFirst(k%10);
	            k=k/10;
	        }
	        return ans;
	    }
	 
	  public static boolean check(List<Integer>arr1, List<Integer>arr2) {
			if(arr1.size()!=arr2.size()) {
				return false;
			}
			for(int i =0;i<arr1.size();i++) {
				if(arr1.get(i)!=arr2.get(i)) {
					return false;
				}
			}
			
			for(int i =0;i<arr1.size();i++) {
				if(arr1.get(i)!=arr2.get(i)) {
					return false;
				}
			}
			
			return true;
		}

	public static void main(String[] args) {
		
		
		//Example 1:
		//
		int []num1 = {1,2,0,0};
		int  k1 = 34;
		List<Integer>output1 = new LinkedList(Arrays.asList(1,2,3,4));
		
		
		//Example 2:
		
		int [] num2 = {2,7,4};
		int k2 = 181;
		List<Integer> output2= new LinkedList(Arrays.asList(4,5,5));
		
		//Example 3:

		int []num3 = {2,1,5};
		int k3 = 806;
		List<Integer>output3 = new LinkedList(Arrays.asList(1,0,2,1));

		List<Integer>ans1 = addToArrayForm(num1,k1);
		List<Integer>ans2 = addToArrayForm(num2,k2);
		List<Integer>ans3 = addToArrayForm(num3,k3);
		
		
		if(check(ans1,output1)) {
			System.out.println("Case 1 Passed ");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Excepted Output : "+ output1);
			System.out.println("Your Output : "+ ans1);
		}
		if(check(ans2,output2)) {
			System.out.println("Case 2 Passed ");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Excepted Output : "+ output2);
			System.out.println("Your Output : "+ ans2);
		}
		
		if(check(ans3,output3)) {
			System.out.println("Case 3 Passed ");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Excepted Output : "+ output3);
			System.out.println("Your Output : "+ ans3);
		}
	}

}
