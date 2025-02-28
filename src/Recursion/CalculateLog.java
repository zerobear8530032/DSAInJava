//Write a recursive function for given n and a to determine x:
//      n = a ^ x 
//      a = 2, 3, 4
//      (2 ^ -31) <= n <= (2 ^ 31) - 1      


package Recursion;

public class CalculateLog {
//	using iterative approch :
	public static int logIterativeApproch (int n, int a) {
		int counter=0;
		while(n!=1) {
			if(n%a!=0) {
				return -1;
			}
			n=n/a;
			counter++;
		}
		return counter;
	}
//	using recursion approch :
	public static int logRecursion(int n, int a) {
		if(n==1) {
			return 0;
		}
		
		if(n%a!=0) {
			return -1;
		}
		
		return  1+logRecursion(n/a, a);
		
		
	}

	public static void main(String[] args) {
		int a1=2 ,n1=8, output1=3;
		int a2=3, n2=27,output2=3;
		int a3=4,n3=16,output3=2;
		int a4=2,n4=1,output4=0;
		int a5=3 ,n5=1,output5=0;
		int a6=10 ,n6=2, output6=-1;
		int a7=20, n7=3,output7=-1;
		int a8=6,n8=2,output8=-1;
		int a9=15,n9=5,output9=-1;
		int a10=12,n10=3,output10=-1;
		
		System.out.println("Iterative Approch :");
		
		int ans1=logIterativeApproch(n1,a1);
		int ans2=logIterativeApproch(n2,a2);
		int ans3=logIterativeApproch(n3,a3);
		int ans4=logIterativeApproch(n4,a4);
		int ans5=logIterativeApproch(n5,a5);
		int ans6=logIterativeApproch(n6,a6);
		int ans7=logIterativeApproch(n7,a7);
		int ans8=logIterativeApproch(n8,a8);
		int ans9=logIterativeApproch(n9,a9);
		int ans10=logIterativeApproch(n10,a10);
		
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
		if(output4==ans4) {
			System.out.println("Case 4 Passed ");
		}else {
			System.out.println("Case 4 Failed");
			System.out.println("Your Output :"+ ans4);
			System.out.println("Actual Output :"+ output4);			
		}
		if(output5==ans5) {
			System.out.println("Case 5 Passed ");
		}else {
			System.out.println("Case 5 Failed");
			System.out.println("Your Output :"+ ans5);
			System.out.println("Actual Output :"+ output5);			
		}
		if(output5==ans5) {
			System.out.println("Case 5 Passed ");
		}else {
			System.out.println("Case 5 Failed");
			System.out.println("Your Output :"+ ans5);
			System.out.println("Actual Output :"+ output5);			
		}
		if(output6==ans6) {
			System.out.println("Case 5 Passed ");
		}else {
			System.out.println("Case 5 Failed");
			System.out.println("Your Output :"+ ans6);
			System.out.println("Actual Output :"+ output6);			
		}
		if(output7==ans7) {
			System.out.println("Case 5 Passed ");
		}else {
			System.out.println("Case 5 Failed");
			System.out.println("Your Output :"+ ans7);
			System.out.println("Actual Output :"+ output7);			
		}
		if(output8==ans8) {
			System.out.println("Case 5 Passed ");
		}else {
			System.out.println("Case 5 Failed");
			System.out.println("Your Output :"+ ans8);
			System.out.println("Actual Output :"+ output8);			
		}
		if(output9==ans9) {
			System.out.println("Case 5 Passed ");
		}else {
			System.out.println("Case 5 Failed");
			System.out.println("Your Output :"+ ans9);
			System.out.println("Actual Output :"+ output9);			
		}
		if(output10==ans10) {
			System.out.println("Case 10 Passed ");
		}else {
			System.out.println("Case 10 Failed");
			System.out.println("Your Output :"+ ans10);
			System.out.println("Actual Output :"+ output10);			
		}

		System.out.println("Recursion Approch :");

		
		ans1=logRecursion(n1,a1);
		ans2=logRecursion(n2,a2);
		ans3=logRecursion(n3,a3);
		ans4=logRecursion(n4,a4);
		ans5=logRecursion(n5,a5);
		ans5=logRecursion(n5,a5);
		ans6=logRecursion(n6,a6);
		ans7=logRecursion(n7,a7);
		ans8=logRecursion(n8,a8);
		ans9=logRecursion(n9,a9);
		ans10=logRecursion(n10,a10);
		
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
		if(output4==ans4) {
			System.out.println("Case 4 Passed ");
		}else {
			System.out.println("Case 4 Failed");
			System.out.println("Your Output :"+ ans4);
			System.out.println("Actual Output :"+ output4);			
		}
		if(output5==ans5) {
			System.out.println("Case 5 Passed ");
		}else {
			System.out.println("Case 5 Failed");
			System.out.println("Your Output :"+ ans5);
			System.out.println("Actual Output :"+ output5);			
		}
		if(output5==ans5) {
			System.out.println("Case 5 Passed ");
		}else {
			System.out.println("Case 5 Failed");
			System.out.println("Your Output :"+ ans5);
			System.out.println("Actual Output :"+ output5);			
		}
		if(output6==ans6) {
			System.out.println("Case 5 Passed ");
		}else {
			System.out.println("Case 5 Failed");
			System.out.println("Your Output :"+ ans6);
			System.out.println("Actual Output :"+ output6);			
		}
		if(output7==ans7) {
			System.out.println("Case 5 Passed ");
		}else {
			System.out.println("Case 5 Failed");
			System.out.println("Your Output :"+ ans7);
			System.out.println("Actual Output :"+ output7);			
		}
		if(output8==ans8) {
			System.out.println("Case 5 Passed ");
		}else {
			System.out.println("Case 5 Failed");
			System.out.println("Your Output :"+ ans8);
			System.out.println("Actual Output :"+ output8);			
		}
		if(output9==ans9) {
			System.out.println("Case 5 Passed ");
		}else {
			System.out.println("Case 5 Failed");
			System.out.println("Your Output :"+ ans9);
			System.out.println("Actual Output :"+ output9);			
		}
		if(output10==ans10) {
			System.out.println("Case 10 Passed ");
		}else {
			System.out.println("Case 10 Failed");
			System.out.println("Your Output :"+ ans10);
			System.out.println("Actual Output :"+ output10);			
		}
		
		

	}

}
