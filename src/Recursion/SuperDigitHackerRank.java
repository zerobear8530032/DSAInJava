//We define super digit of an integer  using the following rules:
//
//Given an integer, we need to find the super digit of the integer.
//
//If  has only  digit, then its super digit is .
//Otherwise, the super digit of  is equal to the super digit of the sum of the digits of .
//For example, the super digit of  will be calculated as:
//
//	super_digit(9875)   	9+8+7+5 = 29 
//	super_digit(29) 	2 + 9 = 11
//	super_digit(11)		1 + 1 = 2
//	super_digit(2)		= 2  
//Example
//
//
//The number  is created by concatenating the string   times so the initial .
//
//    superDigit(p) = superDigit(9875987598759875)
//                  9+8+7+5+9+8+7+5+9+8+7+5+9+8+7+5 = 116
//    superDigit(p) = superDigit(116)
//                  1+1+6 = 8
//    superDigit(p) = superDigit(8)
//All of the digits of  sum to . The digits of  sum to .  is only one digit, so it is the super digit.
//
//Function Description
//
//Complete the function superDigit in the editor below. It must return the calculated super digit as an integer.
//
//superDigit has the following parameter(s):
//
//string n: a string representation of an integer
//int k: the times to concatenate  to make 
//Returns
//
//int: the super digit of  repeated  times
//Input Format
//
//The first line contains two space separated integers,  and .
//
//Constraints
//
//Sample Input 0
//
//148 3
//Sample Output 0
//
//3
//Explanation 0
//
//Here  and , so .
//
//super_digit(P) = super_digit(148148148) 
//               = super_digit(1+4+8+1+4+8+1+4+8)
//               = super_digit(39)
//               = super_digit(3+9)
//               = super_digit(12)
//               = super_digit(1+2)
//               = super_digit(3)
//               = 3
//Sample Input 1
//
//9875 4
//Sample Output 1
//
//8
//Sample Input 2
//
//123 3
//Sample Output 2
//
//9
//Explanation 2
//
//Here  and , so .
//
//super_digit(P) = super_digit(123123123) 
//               = super_digit(1+2+3+1+2+3+1+2+3)
//               = super_digit(18)
//               = super_digit(1+8)
//               = super_digit(9)
//               = 9


package Recursion;

public class SuperDigitHackerRank {
	
	
//	Best Approch :
//	here we first create the entire string and find super digit at once
//	time complexity : O(n*k)
//	space complexity : O(n*k)
	public static int superDigitBruteForce(String n, int k) {
		// Write your code here
		StringBuilder str = new StringBuilder();
		for(int i =0;i<k;i++) {
			str.append(n);
		}
		
		return getSuperDigit(str.toString());
		
		
	}
	


//	Best Approch :
//	here we find the superdigit of original string 
//	then we can multiply k with that and again find superdigit as answer 
//	why this works because str*k = superdigit *k
//	cause each string will have there own individual superdigit and each will be same
//	so we can directly take one superdigit and multiply it by k and take superdigit of original string *k
//	is our answer 
//	and apply superdigit untill its length becomes 0
//	time complexity : O(n)
//	space complexity : O(n)
	  public static int superDigitBest(String n, int k) {
		    // Write your code here
		    int onestrres=getSuperDigit(n)*k;
		    return getSuperDigit(Integer.toString(onestrres));
		    
		    
		}
		public static int getSuperDigit(String n){
		        // System.out.println(n);
		        if(n.length()==1){
		                return n.charAt(0)-'0';
		        }
		        int superdigit=0;
		        for(int i =0;i<n.length();i++){
		                char ch = n.charAt(i);
		                int x = ch-'0';
		                superdigit+=x;
		        }
		        // System.out.println(superdigit);
		        return getSuperDigit(Integer.toString(superdigit));
		}
		
		public static void main(String[] args) {
			
			//Examples 1: 
			
			String n1= "148";
			int k1= 3;
			int output1=3;

			//Examples 2: 
			
			String n2= "9875";
			int k2 = 4;
			int output2= 8;
			
			//Examples 3: 
			
			String n3= "123";
			int k3 = 3;
			int output3= 9;
			
			
			System.out.println("Brute Force Approch :");
			
			int ans1=superDigitBruteForce(n1,k1);
			int ans2=superDigitBruteForce(n2,k2);
			int ans3=superDigitBruteForce(n3,k3);
			
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
			
			System.out.println("Best Approch :");
			
			ans1=superDigitBest(n1,k1);
			ans2=superDigitBest(n2,k2);
			ans3=superDigitBest(n3,k3);
			
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
