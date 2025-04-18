//38. Count and Say
//Solved
//Medium
//Topics
//Companies
//Hint
//The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
//
//countAndSay(1) = "1"
//countAndSay(n) is the run-length encoding of countAndSay(n - 1).
//Run-length encoding (RLE) is a string compression method that works by replacing consecutive identical characters (repeated 2 or more times) with the concatenation of the character and the number marking the count of the characters (length of the run). For example, to compress the string "3322251" we replace "33" with "23", replace "222" with "32", replace "5" with "15" and replace "1" with "11". Thus the compressed string becomes "23321511".
//
//Given a positive integer n, return the nth element of the count-and-say sequence.
//
// 
//
//Example 1:
//
//Input: n = 4
//
//Output: "1211"
//
//Explanation:
//
//countAndSay(1) = "1"
//countAndSay(2) = RLE of "1" = "11"
//countAndSay(3) = RLE of "11" = "21"
//countAndSay(4) = RLE of "21" = "1211"
//Example 2:
//
//Input: n = 1
//
//Output: "1"
//
//Explanation:
//
//This is the base case.
//
// 
//
//Constraints:
//
//1 <= n <= 30
// 
//
//Follow up: Could you solve it iteratively?

package Strings;

public class CountAndSay_38 {
	
	
//	brute force use recusion:
//	here we can use recursion where we can create a seperate function 
//	which  count number of occurence of each character and buid string
//	using 2 pointer approch 
//	then we can recursively apply this on each iteration n-1 times
//	base case n==1  return "1";
//	time complexity :O(n^n)
//	space complexity :O(n^2)
	    public static String countAndSayRecursion(int n) {
	        return countAndSayhelper(n,"1");
	    }
	    public static String countAndSayhelper(int n,String str){
	        if(n==1){
	            return str;
	        }
	        return countAndSayhelper(n-1,compress(str));
	    }

	    public static String compress(String str) {
	        int l = 0;
	        int r = 0;
	        StringBuilder compressedstr = new StringBuilder();
	        while (r < str.length()) {
	            int count = 0;
	            char chl = str.charAt(l);
	            while (r < str.length() && chl == str.charAt(r)) {
	                count++;
	                r++;
	            }
	            compressedstr.append(count).append(chl);
	            l = r;
	        }
	            
	        return compressedstr.toString();
	    }
//	iterative approch without recusion:
//	here we can use recursion where we can create a seperate function 
//	which  count number of occurence of each character and buid string
//	using 2 pointer approch 
//	then we can recursively apply this on each iteration n-1 times
//	base case n==1  return "1";
//	time complexity :O(n^2)
//	space complexity :O(n^2)
	    public static String countAndSayItertive(int n) {
	    	
	    	String str="1";
	    	while(n!=1) {
	    		str=compress(str);
	    		n--;
	    	}
	    	return str;
	    	
	    }

	public static void main(String[] args) {
		
		//Example 1:
	
		int n1 = 4;
		String output1="1211";

		//Example 2:

		int n2 = 1;
		String output2="1";

		System.out.println("Recursion Approch : ");
		
		String ans1 = countAndSayRecursion(n1);
		String ans2 = countAndSayRecursion(n2);
		
		if(output1.equals(ans1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ output1);
			System.out.println("Your Answer :"+ ans1);
		}
		if(output2.equals(ans2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ output2);
			System.out.println("Your Answer :"+ ans2);
		}
		System.out.println("iterative Force Approch : ");
		
		ans1 = countAndSayItertive(n1);
		ans2 = countAndSayItertive(n2);
		
		if(output1.equals(ans1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ output1);
			System.out.println("Your Answer :"+ ans1);
		}
		if(output2.equals(ans2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ output2);
			System.out.println("Your Answer :"+ ans2);
		}


		
		

	}

}
