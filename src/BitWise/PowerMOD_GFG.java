//Implement pow(x, n) % M.
//In other words, for a given value of x, n, and M, find  (xn) % M.
// 
//
//Example 1:
//
//Input:
//x = 3, n = 2, m = 4
//Output:
//1
//Explanation:
//32 = 9. 9 % 4 = 1.
//Example 2:
//
//Input:
//x = 2, n = 6, m = 10
//Output:
//4
//Explanation:
//26 = 64. 64 % 10 = 4.
//
//Your Task:
//You don't need to read or print anything. Your task is to complete the function PowMod() which takes integers x, n, and M as input parameters and returns xn % M.
// 
//
//Expected Time Complexity: O(log(n))
//Expected Space Complexity: O(1)
// 
//
//Constraints:
//1 ≤ x, n, M ≤ 109
//


package BitWise;

public class PowerMOD_GFG {
	
	
	
	
//	Brute Force:
//	key pointer to remember (x * x)%y == x%y * x%y;
//	mutiply x with it self n time while mod with m
//	time complexity :O(log n): log base
//	space complexity :O(1)
	public static long PowModBruteForce(long x, long n, long m)
	{
		long ans =1;
		for(int i=0;i<n;i++) {
			ans=(ans*x)%m;
		}
		return ans;
	} 
//	Best Approch :
//	key pointer to remember (x * x)%y == x%y * x%y;
//	we can optimize division by multipling number when the bit is set other wise just increase base
//	time complexity :O(log n): log base
//	space complexity :O(1)
	public static long PowModBest(long x, long n, long m)
    {
       long ans = 1;
        x = x % m; // Handle large x values
        while (n > 0) {
            // If n is odd, multiply x with the result
            if ((n & 1) == 1) {
                ans = (ans * x) % m;
            }
            // Square x and reduce n by half
            x = (x * x) % m;
            n = n >> 1; // Equivalent to n = n / 2
        }
        return ans;
    } 
	
	public static void main(String[] args) {
		//Example 1:

		int x1 = 3, n1 = 2, m1 = 4;
		int output1=1;

		//Example 2:

		int x2 = 2, n2 = 6, m2 = 10;
		int output2=4;

		//Example 3:

		int x3 = 282538755, n3 = 244836246 , m3 = 757161423;
		int output3=14373936;
		

		long ans1= PowModBruteForce(x1,n1,m1);	
		long ans2= PowModBruteForce(x2,n2,m2);	
		long ans3= PowModBruteForce(x3,n3,m3);	
		
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
		
		System.out.println("Best Approch :");
		 	
		ans1= PowModBest(x1,n1,m1);	
		ans2= PowModBest(x2,n2,m2);	
		ans3= PowModBest(x3,n3,m3);	
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
