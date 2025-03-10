//https://www.codechef.com/practice/course/tcs-nqt-questions/TCSNQTC/problems/TCSNQTCP07
//Longest Common Prefix
//You are given a list of strings 
//s
//t
//r
//str. Your task is to find the longest common prefix among all the strings in the list. If there is no common prefix, return 
//−
//1
//−1.
//
//Input Format
//The first line of input will contain a single integer 
//T
//T, denoting the number of test cases.
//Each test case consists of two lines of input:
//The first line contains an integer N, the number of strings.
//The next line contain a string array str.
//Output Format
//For each test case, output the longest common prefix. If there is no common prefix, output 
//−
//1
//−1.
//
//Constraints
//1
//≤
//T
//≤
//100
//1≤T≤100
//1
//≤
//N
//≤
//100
//1≤N≤100
//1
//≤
//∣
//s
//t
//r
//∣
//≤
//100
//1≤∣str∣≤100
//All strings consist of lowercase alphabetical characters.
//Sample 1:
//Input
//Output
//2
//3
//flower flow flight
//2
//dog racecar
//fl
//-1
//Explanation:
//Test Case 1: the longest common prefix is "fl".
//Test Case 2: there is no common prefix, so the output -1.


package NQT;

public class LongestCommonPrefix_CODE_CHEF {
	
	public static String LongestCommonPrefix(String [] str) {
		int index=0;
		StringBuilder ans = new StringBuilder();
		boolean maxindex=false;
		while(true) {
			boolean charPresentInAll=true;
			
				if(str[0].isBlank()) {
					return "";
				}
				char ch = str[0].charAt(index);	
			
			for(int i =0;i<str.length-1;i++) {
				if(str[i].length()<=index) {
					maxindex=true;
					break;
				}
				
				if(ch!=str[i+1].charAt(index)) {
					charPresentInAll=false;
					break;
				}
				
			}
			if(charPresentInAll) {
				ans.append(ch);
			}else {
				break;
			}
			
			if(maxindex) break;
			index++;
		}
		return ans.toString();
		
	}
	
	public static void main(String[] args) {
		
		String []str1= {"flower","flow","flight"};
		String output1= "fl";
		String [] str2= {"dog","racecar"};
		String output2= "";
		String [] str3= {"","racecar"};
		String output3= "";
		
		
		String ans1=LongestCommonPrefix(str1);
		String ans2=LongestCommonPrefix(str2);
		String ans3=LongestCommonPrefix(str3);
			
		
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
