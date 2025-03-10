//https://www.codechef.com/practice/course/tcs-nqt-questions/TCSNQTC/problems/TCSNQTCP04
//Count Character Occurrences
//You are given two strings, str1 and str2. Your mission is to calculate the total number of occurrences of each unique character of str2 within the string str1. The task is to find the sum of occurrences of all unique characters from str2 in str1 and return this total count.
//
//Input Format
//The first line of input will contain a single integer 
//T
//T, denoting the number of test cases.
//For each test case:
//The first line contains the string str1.
//The second line contains the string str2.
//Output Format
//For each test case, output the total sum of occurrences of characters in str2 found in str1 on a new line.
//
//Constraints
//1
//≤
//T
//≤
//100
//1≤T≤100

//The strings consists of lowercase letters only.
//Sample 1:
//Input
//Output
//3
//helloworld
//do
//abacabadabacaba
//abcd
//abc 
//abcdabcdabcdabcd
//3
//15
//3
//Explanation:
//Test Case 1: the character 'd' appears once and 'o' appears twice in "helloworld", so the total count is 3.
//Test Case 2: The characters from "abcd" appear as follows in "abacabadabacaba": 'a': 7 occurrences 'b': 4 occurrences 'c': 2 occurrences 'd': 2 occurrences Total = 7 + 4 + 2 + 2 = 15.
//Test Case 3: The characters appear only once in abc as we are calculating the unique characters of abcdabcdabcdabcd.

package NQT;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
public class CountCharacterOccurrences_CODE_CHEF {	    
	    //Write sumOfOccurrences function here
	    public static int sumOfOccurrences(String str1,String str2){
	        int [] str2map = new int [26];
	        HashMap<Character,Integer> str1map= new HashMap();
	        for(int i =0;i<str2.length();i++){
	            char ch = str2.charAt(i);
	            str2map[ch-'a']++;
	        }
	      
	        
	        for(int i=0;i<str2map.length;i++){
	            if(str2map[i]!=0){
	                str1map.put((char)(i+'a'),0);
	            }
	        }
	        for(int i=0;i<str1.length();i++){
	            char ch = str1.charAt(i);
	            if(str1map.containsKey(ch)){
	                str1map.put(ch,str1map.get(ch)+1);
	            }
	        }
	        
	        
	        int sum=0;
	       for(Map.Entry<Character,Integer> e: str1map.entrySet()){
	           sum+=e.getValue();
	       }
	        return sum;
	        
	    }

	    public static void main(String[] args) {
	    	
	    	//Sample 1:
	    	//Input
	    	
	    	String str11= "helloworld" ,str12="do";
	    	int output1=3;
	    	
	    	
	    	String str21= "abacabadabacaba" ,str22="abcd";
	    	int output2=15;
	    	
	    	String str31= "abc" ,str32="abcdabcdabcdabcd";
	    	int output3=3;
	    			
	    	int ans1=sumOfOccurrences(str11,str12);
	    	int ans2=sumOfOccurrences(str21,str22);
	    	int ans3=sumOfOccurrences(str31,str32);
			
			if(output1==ans1) {
				System.out.println("Case 1 Passed");
			}else {
				System.out.println("Case 1 Failed");
				System.out.println("Actual Output :"+output1 );
				System.out.println("Your Output :"+ans1);
			}
			if(output2==ans2) {
				System.out.println("Case 2 Passed");
			}else {
				System.out.println("Case 2 Failed");
				System.out.println("Actual Output :"+output2 );
				System.out.println("Your Output :"+ans2);
			}
			if(output3==ans3) {
				System.out.println("Case 3 Passed");
			}else {
				System.out.println("Case 3 Failed");
				System.out.println("Actual Output :"+output3);
				System.out.println("Your Output :"+ans3);
			}
			
	    	
	    }
	
	

}
