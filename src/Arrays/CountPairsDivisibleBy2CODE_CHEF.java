//Count Pairs divisible by 2
//You are given an array 
//a
//r
//r
//arr of length 
//N
//N. You have to calculate the count of pairs in an array such that the sum of pairs is divisible by 
//2
//2.
//
//Input Format
//The first line of input will contain a single integer 
//T
//T, denoting the number of test cases.
//Each test case consists of two lines of input.
//The first line of each test case contain 
//N
//N, length of array 
//a
//r
//r
//arr.
//The second line consist of the array 
//a
//r
//r
//arr.
//Output Format
//For each test case, output on a new line the number of divisible pairs.
//
//Constraints
//1
//≤
//T
//≤
//100
//1≤T≤100
//2
//≤
//N
//≤
//1
//0
//5
//2≤N≤10 
//5
// 
//0
//≤
//a
//r
//r
//i
//≤
//1
//0
//5
//0≤arr 
//i
//​
// ≤10 
//5
// 

// input : 6 1 2 3
// output : 2
//Explanation:
//Test Case 1: There are only two pairs formed- (6,2) and (1,3).
// input :2 2 1 7 5 3
// output : 7
//Explanation:
//Test case 2: These are the 7 pairs that are formed- (2,2), (1,7), (1,5), (1,3), (7,5), (7,3), (5,3).
// input :4 8
// output : 1
//Explanation:
//Test case 3: There is only one pair that is formed- (4,8).


package Arrays;

public class CountPairsDivisibleBy2CODE_CHEF {
//	brute force :
//	check each element with every other element ans sum then check wheather they are divisible by 2
//	time complexity :O(n*n)
//	space complexity :O(1)
	
	public static int getPairsDivisibleBy2BruteForce(int [] arr) {
		int counter=0;
		for(int i =0;i<arr.length-1;i++) {
			for(int j =i+1;j<arr.length;j++) {
				if((arr[i]+arr[j])%2==0) {
					counter++;
				}
			}
		}
		return counter;
	}
	
//	better force :
//	we know in all even numbers are divisible by 2 :
//	and if we sum even+even = even
//	and if we sum odd+odd= even
//	and even+odd = odd 
//	means we need to get counter of even and odd number peresent in array 
//	and we can use formula of nCr : n!/(r!*(n-r)!
//	because its 2 number to be pair we can do :
//	n!/(2!*(n-2)!
//	here n! can be written as : n*(n-1) * (n-2)!/2!*(n-2)!
//	by evaluating this we will get n* (n-1)/ 2! (2!= 2)  
//	so finally we can use this formula to get pairs made by number 
//	with even and odd and sum them up as output
//	check each element with every other element ans sum then check wheather they are divisible by 2
//	time complexity :O(n)
//	space complexity :O(1)
	
	public static int getPairsDivisibleBy2Better(int [] arr) {
		int evenc=0;
		int oddc=0;
		for(int i =0;i<arr.length;i++) {
			if(arr[i]%2==0) evenc++;
			else oddc++;
		}
		int evenpair= evenc*(evenc-1)/2;
		int oddpair= oddc*(oddc-1)/2;
		return evenpair+oddpair;
	}
	
	public static void main(String[] args) {
		int [] input1 = {6,1,2,3};
		int output1=2;
		int [] input2 = {2,2,1,7,5,3};
		int output2=7;
		int [] input3 = {4,8};
		int output3=1;
		
		System.out.println("Brute Force Approch :");
		
		int ans1 = getPairsDivisibleBy2BruteForce(input1);
		int ans2 = getPairsDivisibleBy2BruteForce(input2);
		int ans3 = getPairsDivisibleBy2BruteForce(input3);
		
		if(output1==ans1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ output1);
			System.out.println("Your Answer :"+ ans1);
		}
		if(output2==ans2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ output2);
			System.out.println("Your Answer :"+ ans2);
		}
		if(output3==ans3) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Expected Ouput :"+ output3);
			System.out.println("Your Answer :"+ ans3);
		}
		System.out.println("Better Approch :");
		
		 ans1 = getPairsDivisibleBy2Better(input1);
		 ans2 = getPairsDivisibleBy2Better(input2);
		 ans3 = getPairsDivisibleBy2Better(input3);
		
		if(output1==ans1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ output1);
			System.out.println("Your Answer :"+ ans1);
		}
		if(output2==ans2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ output2);
			System.out.println("Your Answer :"+ ans2);
		}
		if(output3==ans3) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Expected Ouput :"+ output3);
			System.out.println("Your Answer :"+ ans3);
		}

		
		
		
	}
}

