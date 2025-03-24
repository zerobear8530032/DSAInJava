//693. Binary Number with Alternating Bits
//Solved
//Easy
//Topics
//Companies
//Given a positive integer, check whether it has alternating bits: namely, if two adjacent bits will always have different values.
//
// 
//
//Example 1:
//
//Input: n = 5
//Output: true
//Explanation: The binary representation of 5 is: 101
//Example 2:
//
//Input: n = 7
//Output: false
//Explanation: The binary representation of 7 is: 111.
//Example 3:
//
//Input: n = 11
//Output: false
//Explanation: The binary representation of 11 is: 1011.
// 
//
//Constraints:
//
//1 <= n <= 231 - 1


package BitWise;
class BinaryNumberWithAlternatingBits_693 {
//	brute force approch :
//	convert the integer to binary string and
//	check if current character == next if yes return false
//	other iterate checking it over string return true at last
//  time complexity :O(n)  
//  space complexity :O(n) : here we create a string of integer which used space 
//	we can consider the space as constant as it wont exceed 32 character
	
	public static boolean hasAlternatingBitsBruteForce(int n) {
        String binary = Integer.toBinaryString(n);
        for(int i =0;i<binary.length()-1;i++){// checking current == next character
            if(binary.charAt(i)==binary.charAt(i+1)){
               return false; 
            }
        }
        return true;
    }
//	Best approch :
//	we can use the  n&1 to get last current  bit
//	then we can  use right shift operator to remove that bit and next bit come as last position
//	and we can check does these bit are equal return false
//	other true;
//  time complexity :O(n)  
//  space complexity :O(1)
	
	public static boolean hasAlternatingBitsBest(int n) {
		int currentbit=n&1;// inital first bit
		while(n!=0) {
			n=n>>1;// remove the first bit
        	int nextbit = n&1;
        	if(currentbit == nextbit) {//check alternating
        		return false;
        	}
        	currentbit=nextbit;// set current to next
//        	next iteration the nextbit will have next bit 
		}
		return true;
		
	}
    public static void main(String[] args) {
    	
    	
    	//Example 1:
    	
    	int n1 = 5;
    	boolean output1=true;

    	//Example 2:
    	
    	int n2 = 7;
    	boolean output2=false;

    	//Example 3:

    	int n3 =11;
    	boolean output3=false;

    	System.out.println("Brute Force Approch ");
    	
    	boolean ans1=hasAlternatingBitsBruteForce(n1);
    	boolean ans2=hasAlternatingBitsBruteForce(n2);
    	boolean ans3=hasAlternatingBitsBruteForce(n3);

    	if(ans1==output1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ (output1));
			System.out.println("Your Answer :"+ (ans1));
		}
		if(ans2==output2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ (output2));
			System.out.println("Your Answer :"+ (ans2));
		}
		if(ans3==output3) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Expected Ouput :"+ (output3));
			System.out.println("Your Answer :"+ (ans3));
		}		
		System.out.println("Best Approch ");
		
		ans1=hasAlternatingBitsBest(n1);
		ans2=hasAlternatingBitsBest(n2);
		ans3=hasAlternatingBitsBest(n3);
		
		if(ans1==output1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ (output1));
			System.out.println("Your Answer :"+ (ans1));
		}
		if(ans2==output2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ (output2));
			System.out.println("Your Answer :"+ (ans2));
		}
		if(ans3==output3) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Expected Ouput :"+ (output3));
			System.out.println("Your Answer :"+ (ans3));
		}
		
	}
}