package Maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FIndFactorsOfNumber {
	
	public static void main(String[] args) {
		int x1=25;
		int x2=100;
		
		factorBruteForce(x1);
		factorBruteForce(x2);
		factorBetter(x1);
		factorBetter(x2);
	// follow up question the answer we are getting are not in a sorted order can we resolve this 
		factorSorted(x1);
		factorSorted(x2);
	}
//	brute force approch :
//	time complexity : O(x)
	public static void factorBruteForce(int x) {
		for(int i =1;i<=x;i++) {
			if(x%i==0) {
				System.out.print(i+"\t");
			}
		}
		System.out.println();
	}
//	better approch :
//	20%1=0 : 20*1=20
//	20%2=0 : 10*2=20
//	20%4=0 : 5*4=20
//	20%5=0 : 4*5=20
//	20%10=0 : 10*2=20
//	20%20=0 : 20*1=20
	
//	we can obverserve that the factors are  repeating where  the divisor and questient both are factos of x
//	so we can calculate them at once 
//	time complexity : O(root(x))
	public static void factorBetter(int x) {
		for(int i =1;i*i<=x;i++) {
			if(x%i==0) {
				System.out.print(i+"\t");
				if(i==(x/i)) continue;// this is just to make sure the  perferct square number does not repeat
//				just remove condition and 
 				System.out.print(x/i+"\t");
			}
		}
		System.out.println();
	}
	
//	sort the factors :
//	time complexity : O(root(x))
//	space complexity :root(x)
	public static void factorSorted(int x) {
		List<Integer> list = new ArrayList();
		for(int i =1;i*i<=x;i++) {
			if(x%i==0) {
				System.out.print(i+"\t");
				if(i==(x/i)) continue;// this is just to make sure the  perferct square number does not repeat
//				just remove condition and 
				list.add(x/i);
				
			}
		}
		for(int i =list.size()-1;i>=0;i--) {
			System.out.print(list.get(i)+"\t");
		}
		System.out.println();
//		

	}
	
	
	

}
