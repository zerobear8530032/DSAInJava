//476. Number Complement
//Attempted
//Easy
//Topics
//Companies
//The complement of an integer is the integer you get when you flip all the 0's to 1's and all the 1's to 0's in its binary representation.
//
//For example, The integer 5 is "101" in binary and its complement is "010" which is the integer 2.
//Given an integer num, return its complement.
//
// 
//
//Example 1:
//
//Input: num = 5
//Output: 2
//Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
//Example 2:
//
//Input: num = 1
//Output: 0
//Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
// 
//
//Constraints:
//
//1 <= num < 231
// 
//
//Note: This question is the same as 1009: https://leetcode.com/problems/complement-of-base-10-integer/
package BitWise;
class NumberComplement_476 {
//	Brute Force Approch :
//	convert to binary string
//	then revese the string 
//	then flip the bits 
//	convert the new string to binary
//	 time complexity :O(n)
//	 space complexity :O(n)
	public static int findComplementBruteForce(int num) {
		String binary= Integer.toBinaryString(num);// convert to binary string
		int ans =0;// ans
		StringBuilder temp = new StringBuilder(binary);
		temp.reverse();// reverse 
		String flipped = flip(temp);// flip bits
		int n =flipped.length();
		for(int i =0;i<n;i++){// build answer
			if(flipped.charAt(i)=='1') {
				ans+= Math.pow(2,i);
			}
		}   
		return ans;// final ans
	}
	
	
	public static String flip(StringBuilder temp) {
		for(int i =0;i<temp.length();i++) {
			if(temp.charAt(i)=='0') {
				temp.setCharAt(i, '1');
			}else {
				temp.setCharAt(i, '0');				
			}
		}
		return temp.toString();
	}
//	Better Approch :
//	convert to binary string
//	we can read string in revese and instead of flipping bits 
//	we can read 0 as 1 and 1 as 0
// lastly build answer 
//	 time complexity :O(n)
//	 space complexity :O(n)
	
	
    public static int findComplementBetter(int num) {
        String binary= Integer.toBinaryString(num);
        int ans =0;
        int n =binary.length();
        int p=0;
        for(int i =n-1;i>=0;i--){
            if(binary.charAt(i)=='0') {
            	ans+= Math.pow(2,p);
            }
            p++;
        }   
        return ans;
    }
    
    
//	Best Approch :
//    we can remove the required of space of creating the string of binary 
// lastly build answer 
//	 time complexity :O(n)
//	 space complexity :O(n)
    
    
    public static int findComplementBest(int num) {
    	int p=0;
    	int ans =0;
    	while(num!=0) {
    		int bit= num&1;
    		if(bit==0) {
    			ans+= Math.pow(2, p);
    		}
    		p++;
    		num=num>>1;
    	}
    	return ans;
    }
    
    
    public static void main(String[] args) {
    	
    	//Example 1:

    	int  num1= 5;
    	int output1=2;
    	

    	//Example 2:

    	int  num2= 2;
    	int output2=1;
    	
    	
    	//Example 3:
    	
    	int  num3= 1;
    	int output3=0;
    	
    	
    	
    	int ans1=findComplementBruteForce(num1);
		int ans2=findComplementBruteForce(num2);
		int ans3=findComplementBruteForce(num3);
		
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
		if(output3==ans3) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Actual Output :"+output3);
			System.out.println("Your Output :"+ans3);
		}
		System.out.println("Better Approch :");
		
		ans1=findComplementBetter(num1);
		ans2=findComplementBetter(num2);
		ans3=findComplementBetter(num3);
		
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
		if(output3==ans3) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Actual Output :"+output3);
			System.out.println("Your Output :"+ans3);
		}
		
		System.out.println("Best Approch :");
		
		ans1=findComplementBest(num1);
		ans2=findComplementBest(num2);
		ans3=findComplementBest(num3);
		
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
		if(output3==ans3) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Actual Output :"+output3);
			System.out.println("Your Output :"+ans3);
		}

		
	}

}