//868. Binary Gap
//Easy
//Topics
//Companies
//Given a positive integer n, find and return the longest distance between any two adjacent 1's in the binary representation of n. If there are no two adjacent 1's, return 0.
//
//Two 1's are adjacent if there are only 0's separating them (possibly no 0's). The distance between two 1's is the absolute difference between their bit positions. For example, the two 1's in "1001" have a distance of 3.
//
// 
//
//Example 1:
//
//Input: n = 22
//Output: 2
//Explanation: 22 in binary is "10110".
//The first adjacent pair of 1's is "10110" with a distance of 2.
//The second adjacent pair of 1's is "10110" with a distance of 1.
//The answer is the largest of these two distances, which is 2.
//Note that "10110" is not a valid pair since there is a 1 separating the two 1's underlined.
//Example 2:
//
//Input: n = 8
//Output: 0
//Explanation: 8 in binary is "1000".
//There are not any adjacent pairs of 1's in the binary representation of 8, so we return 0.
//Example 3:
//
//Input: n = 5
//Output: 2
//Explanation: 5 in binary is "101".
// 
//
//Constraints:
//
//1 <= n <= 109


package BitWise;
class BinaryGap_868 {
//	brute force approch :
//	conver the number to binary string 
//	if bit count < 2 we can always return 0
//	thenw e can iterate over binary string 
//	in reversein a while loop
//	time complexity : O(n)
//	space complexity : O(n): thic can be said as contant because even in worst case it will not exceed 32 
    public static int binaryGapBruteForce(int n) {
    	if(Integer.bitCount(n)<2) return 0;
        String binary = Integer.toBinaryString(n);
        int l = binary.length();
        int i =l-1;
        int ans =0;
        while(binary.charAt(i)=='0') {
        	i--;
        }
        while(i>=0) {
        	int count=1;
        	char bit= binary.charAt(i);
        	i--;
        	while(i>=0 && bit != binary.charAt(i)) {
        		i--;
        		count++;
        	}
        	ans= Math.max(ans, count);
        }
        return ans;
    }
    
//	better approch :
//	conver the number to binary string 
//	if bit count < 2 we can always return 0
//	thenw e can iterate over binary string 
//	in reversein a while loop
//	time complexity : O(log n)
//	space complexity : O(1): thic can be said as contant because even in worst case it will not exceed 32 
    public static int binaryGapBetter(int n) {
    	int ans =0;// ans
    	while(n!=0) {// iterate untill n !=0
    		int bit1= n&(-n);//  get first set bit
    		n=n-bit1;// remove the first bit
    		int bit2= n&(-n);// get the second set bit 
    		if(bit2==0) break;// if the bit2 is 0 means we get all the bits 
    		// the bit is a power of 2  but we need position of it so we use log 2 of bit
//    		to get pos of both bits
    		int bit1pos=(int) (Math.log(bit1)/Math.log(2));
    		int bit2pos=(int) (Math.log(bit2)/Math.log(2));
//    		to get the position we can take differences
    		int diff = bit2pos-bit1pos;
    		ans=Math.max(ans,diff );// get max difference;
    	}
    	return ans;
    	
    	
    }
    public static void main(String[] args) {
		
    	//Example 1:
    	
    	int n1=22;
    	int output1=2;
    	
    	//Example 2:
    	
    	int n2=8;
    	int output2=0;
    	
    	//Example 3:
  
    	int n3=5;
    	int output3=2;
    	
System.out.println("Brute Force Approch ");
    	
		int ans1= binaryGapBruteForce(n1);	
		int ans2= binaryGapBruteForce(n2);	
		int ans3= binaryGapBruteForce(n3);	
		
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
		ans1= binaryGapBetter(n1);	
		ans2= binaryGapBetter(n2);	
		ans3= binaryGapBetter(n3);	
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