//https://www.geeksforgeeks.org/find-nth-magic-number/
//Find nth Magic Number
//Last Updated : 07 Jun, 2022
//A magic number is defined as a number which can be expressed as a power of 5 or sum of unique powers of 5. First few magic numbers are 5, 25, 30(5 + 25), 125, 130(125 + 5), ….
//Write a function to find the nth Magic number.
//Example: 
//
//Input: n = 2
//Output: 25
//
//Input: n = 5
//Output: 130 
// 
//
//If we notice carefully the magic numbers can be represented as 001, 010, 011, 100, 101, 110 etc, where 001 is 0*pow(5,3) + 0*pow(5,2) + 1*pow(5,1). So basically we need to add powers of 5 for each bit set in a given integer n. 
//Below is the implementation based on this idea. 

package BitWise;

public class FindNthMagicNumber_GFG {
	
	public static int findNthMagicNumber(int x) {
		int ans =0;
		int power=1;
		while(x!=0) {
			if((x&1)==1) {
				ans+= (int)Math.pow(5, power);
			}

			x=x>>1;
			power++;
		}
		
		return ans;
	}

	public static void main(String[] args) {
		//Example: 
		//
		int  n1 = 2;
		int output1=25;
		int  n2 = 5;
		int output2=130;
		int  n3 = 10;
		int output3=650;
		
		int ans1=findNthMagicNumber(n1);
		int ans2=findNthMagicNumber(n2);
		int ans3=findNthMagicNumber(n3);
		
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
