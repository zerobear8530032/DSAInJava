//190. Reverse Bits
//Easy
//Topics
//Companies
//Reverse bits of a given 32 bits unsigned integer.
//
//Note:
//
//Note that in some languages, such as Java, there is no unsigned integer type. In this case, both input and output will be given as a signed integer type. They should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
//In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 2 above, the input represents the signed integer -3 and the output represents the signed integer -1073741825.
// 
//
//Example 1:
//
//Input: n = 00000010100101000001111010011100
//Output:    964176192 (00111001011110000010100101000000)
//Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so return 964176192 which its binary representation is 00111001011110000010100101000000.
//Example 2:
//
//Input: n = 11111111111111111111111111111101
//Output:   3221225471 (10111111111111111111111111111111)
//Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned integer 4294967293, so return 3221225471 which its binary representation is 10111111111111111111111111111111.
// 
//
//Constraints:
//
//The input must be a binary string of length 32
// 
//
//Follow up: If this function is called many times, how would you optimize it?
//



package BitWise;

public class ReverseBits_190 {

	public static int reverseBits(int n) {
		 int result = 0;
	        for (int i = 0; i < 32; i++) {
	            result <<= 1;        // Left shift result to make space
	            result |= (n & 1);   // Get the last bit of n and add it to result
	            n >>>= 1;           // Logical right shift (to prevent sign extension)
	        }
	        return result;
	}
	public static void main(String[] args) {
		

		//Example 1:

		int n1=43261596 ;
		int output1=964176192 ;

		//Example 2:
		
		int n2=-3 ;
		int output2=-1073741825  ;
		
		
		
		int ans1= reverseBits(n1);	
		int ans2= reverseBits(n2);	
		
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
		
		
		
	}
	
	


}
