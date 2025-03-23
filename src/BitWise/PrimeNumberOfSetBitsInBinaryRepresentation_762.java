//762. Prime Number of Set Bits in Binary Representation
//Easy
//Topics
//Companies
//Hint
//Given two integers left and right, return the count of numbers in the inclusive range [left, right] having a prime number of set bits in their binary representation.
//
//Recall that the number of set bits an integer has is the number of 1's present when written in binary.
//
//For example, 21 written in binary is 10101, which has 3 set bits.
// 
//
//Example 1:
//
//Input: left = 6, right = 10
//Output: 4
//Explanation:
//6  -> 110 (2 set bits, 2 is prime)
//7  -> 111 (3 set bits, 3 is prime)
//8  -> 1000 (1 set bit, 1 is not prime)
//9  -> 1001 (2 set bits, 2 is prime)
//10 -> 1010 (2 set bits, 2 is prime)
//4 numbers have a prime number of set bits.
//Example 2:
//
//Input: left = 10, right = 15
//Output: 5
//Explanation:
//10 -> 1010 (2 set bits, 2 is prime)
//11 -> 1011 (3 set bits, 3 is prime)
//12 -> 1100 (2 set bits, 2 is prime)
//13 -> 1101 (3 set bits, 3 is prime)
//14 -> 1110 (3 set bits, 3 is prime)
//15 -> 1111 (4 set bits, 4 is not prime)
//5 numbers have a prime number of set bits.
// 
//
//Constraints:
//
//1 <= left <= right <= 106
//0 <= right - left <= 104



package BitWise;

import java.util.Arrays;
import java.util.HashSet;

class PrimeNumberOfSetBitsInBinaryRepresentation_762 {
//	brute force :
//	take a number from left till right and count number of bits they have and
//	last just check the bit count is a prime or not
//	time complexity : O(n *(log n  + root(x))): here n is number from left to right
//	and log n is finding number of bits , root (x) finding prime number
//	space complexity :O(1)
	
//	here we get first set bit with formula x&(-x)
//	and substract it with original x removing that bit reepeat it untill x ==0
//	we get our set bit count
    public static int getBits(int x){
        int count=0;
        while(x!=0){
            int bit = x&(-x);
            x=x-bit;
            count++;
        }
        return count;
    }
//    iterate over left till right ccounting bits and check its prime or not
    public static int countPrimeSetBitsBruteForce(int left, int right) {
        int ans =0;
        for(int i =left;i<=right;i++){
            int numberofbits= getBits(i);
            if(isPrime(numberofbits)){
                ans++;
            }
        }           
        return ans;
    }
    public static boolean isPrime(int x){
    	if(x<2) return false;
    
        for(int i =2;i*i<=x;i++){
            if(x%i==0){
                return false;
            }
        }
        return true;
    }
    
    
//    better approch :
//  one observation  we know 2 things that the max number of bits a number can have 
//    is 32 so we can create a hash set of prime number from 0 till 32 
//    and count bits of each number form left or right we will just check wheater the 
//    count exists in hashset if it is we increment counter other wise continue;
//    here we does not need to compute prime number every time because of that 
    
//	time complexity : O(n *(log n)): here n is number from left to right and log n to count bits
//  space complexity :O(1) : cause hashset use only 10 element space not more then  that 
  public static int countPrimeSetBitsBetter(int left, int right) {
	  HashSet<Integer> primeset = new HashSet(Arrays.asList(2,3,5,7,11,13,17,19,23,29,31));
      int ans =0;
      for(int i =left;i<=right;i++){
    	  int bitscount= getBits(i);
    	  if(primeset.contains(bitscount)) {
    		  ans++;
    	  }
      }           
      return ans;
  }
    
//    best approch :
//  one observation  we know 2 things that the max number of bits a number can have 
//    is 32 so we can create a hash set of prime number from 0 till 32 
//    and count bits of each number form left or right we will just check wheater the 
//    count exists in hashset if it is we increment counter other wise continue;
//    here we does not need to compute prime number every time because of that 
  
//	time complexity : O(N) 
//  space complexity :O(1) 
  public static int countPrimeSetBitsBest(int left, int right) {
	  // Bitmask representing primes: (1 << 2) | (1 << 3) | (1 << 5) | (1 << 7) | ...
      int primeMask = (1 << 2) | (1 << 3) | (1 << 5) | (1 << 7) | (1 << 11) | (1 << 13) | (1 << 17) | (1 << 19);     
      int count = 0;
      for (int i = left; i <= right; i++) {
          if ((primeMask & (1 << Integer.bitCount(i))) != 0) {
              count++;
          }
      }
      return count;
  }
  
    public static void main(String[] args) {
    
    	
    	//Example 1:
    	
    	int left1=6, right1=10;
    	int output1=4;


    	//Example 2:
    
    	int left2=10, right2=15;
    	int output2=5;
    	
    	System.out.println("Brute Force Approch ");
    	
		int ans1= countPrimeSetBitsBruteForce(left1,right1);	
		int ans2= countPrimeSetBitsBruteForce(left2,right2);	
		
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
		
		
		System.out.println("Better Approch ");
		
		ans1= countPrimeSetBitsBetter(left1,right1);	
		ans2= countPrimeSetBitsBetter(left2,right2);	
		
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
		
		
		System.out.println("Best Approch ");
		
		ans1= countPrimeSetBitsBest(left1,right1);	
		ans2= countPrimeSetBitsBest(left2,right2);	
		
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