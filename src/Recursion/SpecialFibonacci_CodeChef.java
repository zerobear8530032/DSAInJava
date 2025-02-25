//Special Fibonacci
//Sankalp recently learned Fibonacci numbers and now he is studying different algorithms to find them. After getting bored of reading them, he came with his own new type of numbers. He defined them as follows:
//
// f(0) = a;
// f(1) = b;
// f(n) = f(n-1) ^ f(n-2);  when n>1, where ^ denotes the bitwise xor operation.
//You are given three integers a,b and n , calculate f(n).
//
//Input
//
//The input contains one or more independent test cases.
//
//The first line of input contains a single integer T (1≤T≤103), the number of test cases.
//
//Each of the T following lines contains three space-separated integers a, b, and n (0≤a,b,n≤109) respectively.
//
//Output
//
//For each test case, output f(n).
//
//Constraints
//\(1<=T<=1000\)
//\(0<=a,b,n<=10^9\)
//Sample Input
//4
//86 77 15
//93 35 86
//92 49 21
//62 27 90
//
//Sample Input
//86
//126
//92
//62
//
//More Info
//Time limit1 secs
//Memory limit1.5 GB
//Source Limit50000 Bytes





package Recursion;

import java.util.HashMap;

class SpecialFibonacci_CodeChef{
	
//	Iterative:

//	time comeplxity :O(n)
//	time comeplxity :O(1)
	public static int SpecialfibancciIterative(int a,int b,int n) {	
		if(n==0) {
			return a;
		}else if(n==1) {
			return b;
		}
		for(int i =2;i<=n;i++) {
			int next= a^b;
			a=b;
			b=next;
		}
		return b;
	}
//	recursion:

//	time comeplxity :O(n)
//	time comeplxity :O(n)
	public static int SpecialfibancciRec(int a,int b,int n) {	
		if(n==0) {
			return a;
		}else if(n==1) {
			return b;
			
		}
		int next = a^b;
		return SpecialfibancciRec(b, next, n-1);
	}
	
//	Memorization :
//	time comeplxity :O(n)
//	time comeplxity :O(n)
	public static HashMap <Integer,Integer> memo = new HashMap();
	public static int SpecialfibancciMemoRec(int a,int b,int n) {	
		if(n==0) return a;
		if(n==1) return b;
		if(memo.containsKey(n)) return memo.get(n);
		int res = SpecialfibancciMemoRec(a, b, n-1)^SpecialfibancciMemoRec(a, b, n-2);
		memo.put(n,res);
		return res;
	}
	
	
//	Actually approch :Since this sequence follows the XOR operation, it will form a repeating pattern of length 3:
//	f(0): a
//	f(1): b
//	f(2): a ^b
//	f(3): a
//	f(4): b
//	f(5): a ^ b
//	time comeplxity :O(1)
//	time comeplxity :O(1)
	public static int Specialfibancci(int a,int b,int n) {	
		if(n%3==0) return a;
		if(n%3==1) return a;
		return a^b;
	}
	
	
	
	
	public static void main (String[] args) throws java.lang.Exception
	{
		int a1=86,b1=77,n1=15;
		int a2=93,b2=35,n2=86;
		int a3=92,b3=49,n3=21;
		int a4=62,b4=27,n4=90;
		int output1=86;
		int output2=126;
		int output3=92;
		int output4=62;
		
		System.out.println("Iterative Approch :");
		
		int ans1=SpecialfibancciIterative(a1,b1,n1);    	
		int ans2=SpecialfibancciIterative(a2,b2,n2);    	
		int ans3=SpecialfibancciIterative(a3,b3,n3);    	
		int ans4=SpecialfibancciIterative(a4,b4,n4);    	
    	
    	if(output1==ans1) {
    		System.out.println("Case 1 Passed");
    	}else {
    		System.out.println("Case 1 Failed");
    		System.out.println("Your Output :"+ans1);
    		System.out.println("Actual Output :"+output1);
    	}
    	if(output2==ans2) {
    		System.out.println("Case 2 Passed");
    	}else {
    		System.out.println("Case 2 Failed");
    		System.out.println("Your Output :"+ans2);
    		System.out.println("Actual Output :"+output2);
    	}
    	if(output3==ans3) {
    		System.out.println("Case 3 Passed");
    	}else {
    		System.out.println("Case 3 Failed");
    		System.out.println("Your Output :"+ans3);
    		System.out.println("Actual Output :"+output3);
    	}
    	if(output4==ans4) {
    		System.out.println("Case 4 Passed");
    	}else {
    		System.out.println("Case 4 Failed");
    		System.out.println("Your Output :"+ans4);
    		System.out.println("Actual Output :"+output4);
    	}
    	
    	System.out.println("Recursion Approch :");
    	
    	ans1=SpecialfibancciRec(a1,b1,n1);    	
    	ans2=SpecialfibancciRec(a2,b2,n2);    	
    	ans3=SpecialfibancciRec(a3,b3,n3);    	
    	ans4=SpecialfibancciRec(a4,b4,n4);    	
    	
    	if(output1==ans1) {
    		System.out.println("Case 1 Passed");
    	}else {
    		System.out.println("Case 1 Failed");
    		System.out.println("Your Output :"+ans1);
    		System.out.println("Actual Output :"+output1);
    	}
    	if(output2==ans2) {
    		System.out.println("Case 2 Passed");
    	}else {
    		System.out.println("Case 2 Failed");
    		System.out.println("Your Output :"+ans2);
    		System.out.println("Actual Output :"+output2);
    	}
    	if(output3==ans3) {
    		System.out.println("Case 3 Passed");
    	}else {
    		System.out.println("Case 3 Failed");
    		System.out.println("Your Output :"+ans3);
    		System.out.println("Actual Output :"+output3);
    	}
    	if(output4==ans4) {
    		System.out.println("Case 4 Passed");
    	}else {
    		System.out.println("Case 4 Failed");
    		System.out.println("Your Output :"+ans4);
    		System.out.println("Actual Output :"+output4);
    	}
		
    	System.out.println("Recursion Memorization Approch :");
    	
    	ans1=SpecialfibancciMemoRec(a1,b1,n1);
    	memo.clear();
    	ans2=SpecialfibancciMemoRec(a2,b2,n2);    	
    	memo.clear();
    	ans3=SpecialfibancciMemoRec(a3,b3,n3);    	
    	memo.clear();
    	ans4=SpecialfibancciMemoRec(a4,b4,n4);    	
    	memo.clear();
    	
    	if(output1==ans1) {
    		System.out.println("Case 1 Passed");
    	}else {
    		System.out.println("Case 1 Failed");
    		System.out.println("Your Output :"+ans1);
    		System.out.println("Actual Output :"+output1);
    	}
    	if(output2==ans2) {
    		System.out.println("Case 2 Passed");
    	}else {
    		System.out.println("Case 2 Failed");
    		System.out.println("Your Output :"+ans2);
    		System.out.println("Actual Output :"+output2);
    	}
    	if(output3==ans3) {
    		System.out.println("Case 3 Passed");
    	}else {
    		System.out.println("Case 3 Failed");
    		System.out.println("Your Output :"+ans3);
    		System.out.println("Actual Output :"+output3);
    	}
    	if(output4==ans4) {
    		System.out.println("Case 4 Passed");
    	}else {
    		System.out.println("Case 4 Failed");
    		System.out.println("Your Output :"+ans4);
    		System.out.println("Actual Output :"+output4);
    	}
    	
    	System.out.println("Best Approch :");
    	
    	ans1=Specialfibancci(a1,b1,n1);
    	ans2=Specialfibancci(a2,b2,n2);    	
    	ans3=Specialfibancci(a3,b3,n3);    	
    	ans4=Specialfibancci(a4,b4,n4);    	
    	
    	if(output1==ans1) {
    		System.out.println("Case 1 Passed");
    	}else {
    		System.out.println("Case 1 Failed");
    		System.out.println("Your Output :"+ans1);
    		System.out.println("Actual Output :"+output1);
    	}
    	if(output2==ans2) {
    		System.out.println("Case 2 Passed");
    	}else {
    		System.out.println("Case 2 Failed");
    		System.out.println("Your Output :"+ans2);
    		System.out.println("Actual Output :"+output2);
    	}
    	if(output3==ans3) {
    		System.out.println("Case 3 Passed");
    	}else {
    		System.out.println("Case 3 Failed");
    		System.out.println("Your Output :"+ans3);
    		System.out.println("Actual Output :"+output3);
    	}
    	if(output4==ans4) {
    		System.out.println("Case 4 Passed");
    	}else {
    		System.out.println("Case 4 Failed");
    		System.out.println("Your Output :"+ans4);
    		System.out.println("Actual Output :"+output4);
    	}
    	
		

	}
}