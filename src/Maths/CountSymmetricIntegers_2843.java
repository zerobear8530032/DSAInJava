//2843. Count Symmetric Integers
//Solved
//Easy
//Topics
//Companies
//Hint
//You are given two positive integers low and high.
//
//An integer x consisting of 2 * n digits is symmetric if the sum of the first n digits of x is equal to the sum of the last n digits of x. Numbers with an odd number of digits are never symmetric.
//
//Return the number of symmetric integers in the range [low, high].
//
// 
//
//Example 1:
//
//Input: low = 1, high = 100
//Output: 9
//Explanation: There are 9 symmetric integers between 1 and 100: 11, 22, 33, 44, 55, 66, 77, 88, and 99.
//Example 2:
//
//Input: low = 1200, high = 1230
//Output: 4
//Explanation: There are 4 symmetric integers between 1200 and 1230: 1203, 1212, 1221, and 1230.
// 
//
//Constraints:
//
//1 <= low <= high <= 104


package Maths;
class CountSymmetricIntegers_2843 {
        
//brute force approch :
//	here we just iterate from low to high and 
//	convert every single element to string and check its digits left 
//	and right sum are equal 
//	if its odd length we does not take them
//	time complexity :O(N × D)	Checks every number
//	space complexity :O(1)
    public static int countSymmetricIntegersBruteForce(int low, int high) {
        int ans =0;       
        for(int i=low;i<=high;i++){
            String integer= Integer.toString(i);
         if(symmetric(integer)){
            ans++;
         }   
        }
        return ans;
    }
    
//   better approch :
//    here we skip the all odd length element by taking the power of 10 
//    this allow us to skip the odd elements by checking only first one 
//	time complexity :O(M × D), M << N	Skips odd-length numbers cleverly
//	space complexity :O(1)
    public static int countSymmetricIntegersBetter(int low, int high) {
        int ans =0;
        int i =low;
        while(i<=high){
            String integer=Integer.toString(i);
            if(integer.length()%2==0){
                if(symmetric(integer)){
                    ans++;
                }
                i++;
            }else{
                i=(int)Math.pow(10,integer.length());
            }
        }
        return ans;
    }
    public static boolean symmetric(String str){
        int s=0;
        int e= str.length()-1;
        int leftsum=0;
        int rightsum=0;
        while(s<e){
            leftsum+= str.charAt(s)-'0';
            rightsum+= str.charAt(e)-'0';
            s++;
            e--;
        }
        return leftsum==rightsum;
    }
//    here we obsever from 1 to 100 oonly numbers mod to 11 are valid
//    similarlt in range 101 till 1000 we can sperateeven digits numbers in 2 parts simily
//    by taking mod and division
//   time complexity : O log (high)
//   space complexity : O(1)
   public static int countSymmetricIntegersBest(int low, int high) {
        int ans = 0;
        int i = low;
        while( i <= high){
            // 2-digit
            if(i < 100 && i % 11 == 0){ans++;}
            // 4-digit
            else if(i >= 1000 && i < 10000){
                final int n1 = i / 1000 + (i % 1000) / 100; // separate 1st 2 digits and their sum
                final int n2 = (i % 100) / 10 + i % 10; // separate last 2 digits adn their sum
                if(n1 == n2)ans++;
                
            }
//            if the current i is having odd number of digit we will
//            start from 10^ number of digits
            if ((logbase10(i) + 1) % 2 != 0) {
                i = (int)Math.pow(10, (logbase10(i) + 1));
            } else {
                i++;
            }
        }
        return ans;
    }
   
    public static int logbase10(int x){
    double log = Math.log(x)/Math.log(10);
   	return (int)log;
    }

    
    public static void main(String[] args) {
    	//Example 1:
    	//
    	int low1 = 1, high1 = 100;
    	int output1=9;
    	
    	//Example 2:

    	int low2 = 1200, high2 = 1230;
    	int output2=4;
    	
    	//Example 3:
    	
    	int low3 = 1000, high3 = 1782;
    	int output3=44;
    	

		System.out.println("Brute force Approch :");
		
		int ans1=countSymmetricIntegersBruteForce(low1,high1);
		int ans2=countSymmetricIntegersBruteForce(low2,high2);
		int ans3=countSymmetricIntegersBruteForce(low3,high3);
		
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
			System.out.println("Actual Output :"+output3 );
			System.out.println("Your Output :"+ans3);
		}
		System.out.println("Better Approch :");
		
		ans1=countSymmetricIntegersBetter(low1,high1);
		ans2=countSymmetricIntegersBetter(low2,high2);
		ans3=countSymmetricIntegersBetter(low3,high3);
		
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
			System.out.println("Actual Output :"+output3 );
			System.out.println("Your Output :"+ans3);
		}
		
		System.out.println("Best Approch :");
		
		ans1=countSymmetricIntegersBest(low1,high1);
		ans2=countSymmetricIntegersBest(low2,high2);
		ans3=countSymmetricIntegersBest(low3,high3);
		
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
			System.out.println("Actual Output :"+output3 );
			System.out.println("Your Output :"+ans3);
		}

    	
    	
	}
}