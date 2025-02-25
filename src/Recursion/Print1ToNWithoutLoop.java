//question link :
//https://www.geeksforgeeks.org/problems/print-1-to-n-without-using-loops-1587115620/1
//	Print 1 To N Without Loop
//	Difficulty: BasicAccuracy: 61.33%Submissions: 288K+Points: 1
//	Print numbers from 1 to n without the help of loops. You only need to complete the function printNos() that takes n as a parameter and prints the number from 1 to n recursively.
//	
//	Note: Don't print any newline, it will be added by the driver code.
//	
//	Examples:
//	
//	Input: n = 10
//	Output: 1 2 3 4 5 6 7 8 9 10
//	Input: n = 5
//	Output: 1 2 3 4 5
//	Input: n = 1
//	Output: 1
//	Constraints:
//	1 <= n <= 1000
package Recursion;

public class Print1ToNWithoutLoop {
	
//	using loop :
//	time complexity O(n);
//	Space complexity O(1);
	public static void Print1ToNNumbers(int n) {
		for(int i =1;i<=n;i++) {
			System.out.print(i+" ");
		}
		System.out.println();
		
	}
//	without using loop :
//	time complexity O(n);
//	Space complexity O(n);// function call
	public static void Print1ToNNumbersRec(int n) {
		if(n==0) {
			return;
		}
		Print1ToNNumbersRec(n-1);
		System.out.print(n+" ");		
	}
	
	public static void main(String[] args) {
		
		
		int n1=10;
		int n2=5;
		int n3=1;
		System.out.println("Iterative Approch :");

		Print1ToNNumbers(n1);
		Print1ToNNumbers(n2);
		Print1ToNNumbers(n3);
		
		System.out.println("Recursion Approch :");
		
		Print1ToNNumbersRec(n1);
		System.out.println();
		Print1ToNNumbersRec(n2);
		System.out.println();
		Print1ToNNumbersRec(n3);
		System.out.println();
		
		
		
	}

}

