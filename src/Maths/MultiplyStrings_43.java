//43. Multiply Strings
//Solved
//Medium
//Topics
//Companies
//Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
//
//Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
//
// 
//
//Example 1:
//
//Input: num1 = "2", num2 = "3"
//Output: "6"
//Example 2:
//
//Input: num1 = "123", num2 = "456"
//Output: "56088"
// 
//
//Constraints:
//
//1 <= num1.length, num2.length <= 200
//num1 and num2 consist of digits only.
//Both num1 and num2 do not contain any leading zero, except the number 0 itself.



package Maths;

public class MultiplyStrings_43 {
//	approch : brute force 
//	we just simulated hpw we multiply in real life 
//	time complexity :O(m*n)
//	space complexity :O(m+n);
	 public static String multiplyBruteForce(String num1, String num2) {
		 int n1=num1.length()-1;
		 int n2=num2.length()-1;
		 if(n2>n1) {
			 return multiplyBruteForce(num2,num1);
		 }
		 if(num1.equals("0") || num2.equals("0")) return "0";
		 StringBuilder ans = new StringBuilder("0");
		 for(int i=n2;i>=0;i--) {
			 StringBuilder build= new StringBuilder();
			 int carry =0;
			 for(int j=n1;j>=0;j--) {
				 int ch1=num1.charAt(j)-'0';
				 int ch2=num2.charAt(i)-'0';
				 int placevalue= ch1*ch2+carry;
				 build.append(placevalue%10);
				 carry=placevalue/10;
			 }
			 if(carry!=0) {
				 build.append(carry);
				 carry=0;
			 }
//			 append zeroes:
			 int zeroes= num2.length()-1-i;
			 build.reverse();
			 for(int z=0;z<zeroes;z++) {
				 build.append("0");
			 }
			 ans = new StringBuilder(add(ans.toString(), build.toString()));
		 }
		 return ans.toString();	 
	 }
//	better approch :
//	 we can remove the requirement of addition each time linearly
//	to remove a seprate addition we can maintain an array to do it which will be n+m size
//	 and apply addition on the go
//	time complexity :O(m*n)
//	space complexity :O(m+n);
	 public static String multiplyBetter(String num1, String num2) {
		 int m =num1.length();
		 int n=num2.length();
		 int [] ans = new int [n+m];
		 for(int i=n-1;i>=0;i--) {
			 for(int j=m-1;j>=0;j--) {
				 int n1=num1.charAt(j)-'0';
				 int n2=num2.charAt(i)-'0';
				 int prod= n1*n2;
				 int placevalue=i+j+1;
				 ans[placevalue]+=prod%10;
				 if(ans[placevalue]>9) {
					 int x=ans[placevalue];
					 ans[placevalue]=x%10;
					 ans[placevalue-1]+=x/10;
				 }
				 ans[placevalue-1]+=prod/10;
				 if(ans[placevalue-1]>9) {
					 int x=ans[placevalue-1];
					 ans[placevalue-1]=x%10;
					 ans[placevalue-2]+=x/10;
				 }
			 }
		 }
		 StringBuilder res= new StringBuilder();
		 int index=0;
		 while(index<ans.length &&  ans[index]==0) {
			 index++;
			 }
		 while(index<ans.length ) {
			 res.append(ans[index]);
			 index++;
		 }
		 if(res.length()==0) return "0";
		 return res.toString();
	 }
	 
	 public static String add(String num1,String num2) {
		StringBuilder res= new StringBuilder();
		int idx1=num1.length()-1;
		int idx2=num2.length()-1;
		int carry=0;
		while(idx1 >=0 && idx2>=0) {
			int n1=num1.charAt(idx1)-'0';
			int n2=num2.charAt(idx2)-'0';
			int sum = n1+n2+carry;
			res.append(sum%10);
			carry=sum/10;
			idx1--;
			idx2--;
		}
		while(idx1>=0) {
			int n1=num1.charAt(idx1)-'0';
			int sum = n1+carry;
			res.append(sum%10);
			carry=sum/10;
			idx1--;
		}
		while(idx2>=0) {
			int n2=num2.charAt(idx2)-'0';
			int sum = n2+carry;
			res.append(sum%10);
			carry=sum/10;
			idx2--;
		}
		if(carry!=0) {
			res.append(carry);
		}
		return res.reverse().toString();
	 }

	public static void main(String[] args) {
		
		
		//Example 1:

		String num11 = "2", num12 = "3";
		String output1="6";
		
		//Example 2:

		String num21 = "123", num22 = "456";
		String output2="56088";

		//Example 3:
		
		String num31 = "123", num32 = "0";
		String output3="0";
		
		System.out.println("Brute Force Approch : ");
		
		String ans1=multiplyBruteForce(num11,num12);
		String ans2=multiplyBruteForce(num21,num22);
		String ans3=multiplyBruteForce(num31,num32);
		
		if(output1.equals(ans1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output :"+output1 );
			System.out.println("Your Output :"+ans1);
		}
		if(output2.equals(ans2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Actual Output :"+output2 );
			System.out.println("Your Output :"+ans2);
		}
		if(output3.equals(ans3)) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Actual Output :"+output3);
			System.out.println("Your Output :"+ans3);
		}
		
		System.out.println("Better Approch : ");
		
		ans1=multiplyBetter(num11,num12);
		ans2=multiplyBetter(num21,num22);
		ans3=multiplyBruteForce(num31,num32);
		
		if(output1.equals(ans1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output :"+output1 );
			System.out.println("Your Output :"+ans1);
		}
		if(output2.equals(ans2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Actual Output :"+output2 );
			System.out.println("Your Output :"+ans2);
		}
		if(output3.equals(ans3)) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Actual Output :"+output3);
			System.out.println("Your Output :"+ans3);
		}
		


	}

}
