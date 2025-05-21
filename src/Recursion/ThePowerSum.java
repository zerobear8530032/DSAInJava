//Find the number of ways that a given integer, , can be expressed as the sum of the  powers of unique, natural numbers.
//
//For example, if  and , we have to find all combinations of unique squares adding up to . The only solution is .
//
//Function Description
//
//Complete the powerSum function in the editor below. It should return an integer that represents the number of possible combinations.
//
//powerSum has the following parameter(s):
//
//X: the integer to sum to
//N: the integer power to raise numbers to
//Input Format
//
//The first line contains an integer .
//The second line contains an integer .
//
//Constraints
//
//Output Format
//
//Output a single integer, the number of possible combinations caclulated.
//
//Sample Input 0
//
//10
//2
//Sample Output 0
//
//1
//Explanation 0
//
//If  and , we need to find the number of ways that  can be represented as the sum of squares of unique numbers.
//
//
//This is the only way in which  can be expressed as the sum of unique squares.
//
//Sample Input 1
//
//100
//2
//Sample Output 1
//
//3
//Explanation 1
//
//
//Sample Input 2
//
//100
//3
//Sample Output 2
//
//1
//Explanation 2
//
// can be expressed as the sum of the cubes of .
//. There is no other way to express  as the sum of cubes.
package Recursion;

public class ThePowerSum {
	 public static int powerSum(int X, int N) {
		    // Write your code here
		        int Xthroot =(int) Math.ceil(Math.pow(X, 1.0/N));
		        return helper(Xthroot,X,0,N);
		    }
		    public static int helper(int XthRoot, int num, int start, int pow ){
		        if(num==0){
		                return 1;
		        }
		        if(num<0){
		                return 0;
		        }
		        int res=0;
		        for(int i =start+1; i<=XthRoot;i++){
		                int x=(int) Math.pow(i, pow);
		                res+= helper(XthRoot,num-x,i, pow);
		        }
		        return res;
		    }


	public static void main(String[] args) {
		

		// Example 1:
		
		int x1= 10, n1=2;
		int output1=1;
		
		// Example 2:
		
		int x2= 100, n2=2;
		int output2=3;

		// Example 3:
		
		int x3= 100, n3=3;
		int output3=1;


		int ans1=powerSum(x1, n1);
		int ans2=powerSum(x2, n2);
		int ans3=powerSum(x3, n3);
		
		
		if(output1==ans1) {
			System.out.println("Case 1 Passed ");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Your Output :"+ ans1);
			System.out.println("Actual Output :"+ output1);			
		}
		if(output2==ans2) {
			System.out.println("Case 2 Passed ");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Your Output :"+ ans2);
			System.out.println("Actual Output :"+ output2);			
		}
		if(output3==ans3) {
			System.out.println("Case 3 Passed ");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Your Output :"+ ans3);
			System.out.println("Actual Output :"+ output3);			
		}
	}

}
