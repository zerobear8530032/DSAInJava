//7. Reverse Integer

//Solved
//Medium
//Topics
//Companies
//Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
//
//Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
//
// 
//
//Example 1:
//
//Input: x = 123
//Output: 321
//Example 2:
//
//Input: x = -123
//Output: -321
//Example 3:
//
//Input: x = 120
//Output: 21
// 
//
//Constraints:
//
//-231 <= x <= 231 - 1

package Maths;
class ReverseInteger_7 {
	
    public static int reverse(int x) {
      int n =x;
      int ans =0;
      while(n!=0){
        int rem=n%10;
        n/=10;
        if (ans < -214748364 || (ans == -214748364 && rem > 8)) return 0;
        if (ans > 214748364 || (ans == 214748364 && rem > 7)) return 0;
        ans=ans*10+rem;        
      }  
      return ans;
    }
    public static void main(String[] args) {
    	//Example 1:
    	
    	int x1 = 123,output1=321;
    	
    	//Example 2:
    	
    	int x2 = -123,output2=-321;
    	
    	//Example 3:
    	
    	int x3 = 120,output3=21;
    	
    	//Example 4:
    	
    	int x4 = 1534236469,output4=0;

    	
    	int ans1= reverse(x1);
		int ans2= reverse(x2);
		int ans3= reverse(x3);
		int ans4= reverse(x4);
		
		if(ans1==output1) {
			System.out.println("Case 1 Passed ");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Excepted Output : "+ (output1));
			System.out.println("Your Output : "+ (ans1));
		}
		if(ans2==output2) {
			System.out.println("Case 2 Passed ");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Excepted Output : "+ output2);
			System.out.println("Your Output : "+ ans2);
		}
		if(ans3==output3) {
			System.out.println("Case 3 Passed ");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Excepted Output : "+ output3);
			System.out.println("Your Output : "+ ans3);
		}
		if(ans4==output4) {
			System.out.println("Case 4 Passed ");
		}else {
			System.out.println("Case 4 Failed");
			System.out.println("Excepted Output : "+ output4);
			System.out.println("Your Output : "+ ans4);
		}

	}
}