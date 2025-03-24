//1684. Count the Number of Consistent Strings
//Easy
//Topics
//Companies
//Hint
//You are given a string allowed consisting of distinct characters and an array of strings words. A string is consistent if all characters in the string appear in the string allowed.
//
//Return the number of consistent strings in the array words.
//
// 
//
//Example 1:
//
//Input: allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
//Output: 2
//Explanation: Strings "aaab" and "baa" are consistent since they only contain characters 'a' and 'b'.
//Example 2:
//
//Input: allowed = "abc", words = ["a","b","c","ab","ac","bc","abc"]
//Output: 7
//Explanation: All strings are consistent.
//Example 3:
//
//Input: allowed = "cad", words = ["cc","acd","b","ba","bac","bad","ac","d"]
//Output: 4
//Explanation: Strings "cc", "acd", "ac", and "d" are consistent.
// 
//
//Constraints:
//
//1 <= words.length <= 104
//1 <= allowed.length <= 26
//1 <= words[i].length <= 10
//The characters in allowed are distinct.
//words[i] and allowed contain only lowercase English letters.


package BitWise;

import java.util.HashSet;

class CountTheNumberOfConsistentStrings_1684
 {
//	brute force approch :
//	iterate over entire word and check wheather tthe character present in word is inside allowed
//	time complexity : O(n* (a*l)) a is allow length  ,n : is length of words array , l is length of words in word array 
//	space complexity: O(1)
    public static int countConsistentStringsBruteForce(String allowed, String[] words) {
    	int count=0;
    	for(String st:words) {
    		boolean valid=true;
    		for(int i =0;i<st.length();i++) {
    			if(!checkCharacter(allowed, st.charAt(i))) {
    				valid=false;
    				break;
    			}
    		}
    		if(valid) {
    			count++;
    		}
    		
    	}
    	return count;
  
    }
    public static boolean checkCharacter(String allow,char ch ) {
    	for(int i =0;i<allow.length();i++) {
    		if(ch==allow.charAt(i)) {
    			return true;
    		}
    	}
    	return false;
    }
    
    
//	Better approch :
//  create a hashset from the allow string where each chacter is a an element in string
//	iterate over entire word and check wheather tthe character present in word is inside allowed
//	time complexity : O(n*l)+O(a): a is allow length  ,n : is length of words array , l is length of words in word array 
//	space complexity: O(n): we can say it constant as it will never exceed over 26  
    public static int countConsistentStringsBetter(String allowed, String[] words) {
    	HashSet<Character> set = new HashSet();
    	for(int i =0;i<allowed.length();i++) {
    		set.add(allowed.charAt(i));
    	}
    	int count=0;
    	for(String st:words) {
    		boolean valid=true;
    		for(int i =0;i<st.length();i++) {
    			if(!set.contains(st.charAt(i))) {
    				valid=false;
    				break;
    			}
    		}
    		if(valid) {
    			count++;
    		}
    		
    	}
    	return count;
    }
    
//	Best approch :
//  we can optimize space from hashset to a single integer 
//  which have 32 bits we can map our each cahracter on that bits 
//  to set it we can use left shift operator and ascii value chacter -'a' will give 
//  value from 0 to 25  we can set bit using xor operator
//  iterate over entire word and check wheather tthe character  bit present in the bitmask
//	time complexity : O(n*l)+ O(a): a is allow length  ,n : is length of words array , l is length of words in word array 
//	space complexity: O(1): 
    public static int countConsistentStringsOptimize(String allowed, String[] words) {
    	int bitmask = 0;
    	for(int i =0;i<allowed.length();i++) {
    		int pos = allowed.charAt(i)-'a';
    		int bit = 1<<pos;
    		bitmask=bitmask^bit;
    	}
    	
    	
    	int count=0;
    	for(String st:words) {
    		boolean valid=true;
    		for(int i =0;i<st.length();i++) {
    			int pos = st.charAt(i)-'a';
    			int bit = 1<<pos;
    			if((bit&bitmask)==0) {
    				valid=false;
    				break;
    			}
    		}
    		if(valid) {
    			count++;
    		}
    		
    	}
    	return count;
    }
    
//	Best approch :
//  we can optimize space from hashset to a single integer 
//  which have 32 bits we can map our each cahracter on that bits 
//  to set it we can use left shift operator and ascii value chacter -'a' will give 
//  value from 0 to 25  we can set bit using or operator
//  we can compute bit mask for each individual string and use 
//  then we can use allow mask & word mask   if that equals wordmask then it is valid
//    other wise invalid
//  other wise not
//	time complexity : O(n*l)+ O(a): a is allow length  ,n : is length of words array , l is length of words in word array 
//	space complexity: O(1): 
public static int countConsistentStringsBest(String allowed, String[] words) {
    	int allowbitmask = computeBitMask(allowed);
    	int count=0;
    	for(String st:words) {
    		int wordmask=computeBitMask(st);
    		if((allowbitmask &wordmask)==wordmask) {
    			count++;
    		}
    	}
    	return count;
    }
public static int computeBitMask(String str) {
	int bitmask = 0;
	for(int i =0;i<str.length();i++) {
		int pos = str.charAt(i)-'a';
		int bit = 1<<pos;
		bitmask=bitmask|bit;
	}
	return bitmask;
}

    
    public static void main(String[] args) {
    	
    	//Example 1:

    	String  allowed1 = "ab";
    	String [] words1 = {"ad","bd","aaab","baa","badab"};
    	int output1=2;

    	//Example 2:

    	String  allowed2 = "abc";
    	String [] words2 = {"a","b","c","ab","ac","bc","abc"};
    	int output2=7;
    	
    	//Example 3:

    	String  allowed3 = "cad";
    	String [] words3 = {"cc","acd","b","ba","bac","bad","ac","d"};
    	int output3=4;
    	
    	System.out.println("Brute Force Approch");
    	
    	int ans1=countConsistentStringsBruteForce(allowed1,words1);
    	int ans2=countConsistentStringsBruteForce(allowed2,words2);
    	int ans3=countConsistentStringsBruteForce(allowed3,words3);

    	if(ans1==output1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ (output1));
			System.out.println("Your Answer :"+ (ans1));
		}
		if(ans2==output2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ (output2));
			System.out.println("Your Answer :"+ (ans2));
		}
		if(ans3==output3) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Expected Ouput :"+ (output3));
			System.out.println("Your Answer :"+ (ans3));
		}
		
		System.out.println("Better Approch");
		
		ans1=countConsistentStringsBetter(allowed1,words1);
		ans2=countConsistentStringsBetter(allowed2,words2);
		ans3=countConsistentStringsBetter(allowed3,words3);
		
		if(ans1==output1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ (output1));
			System.out.println("Your Answer :"+ (ans1));
		}
		if(ans2==output2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ (output2));
			System.out.println("Your Answer :"+ (ans2));
		}
		if(ans3==output3) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Expected Ouput :"+ (output3));
			System.out.println("Your Answer :"+ (ans3));
		}
		
		System.out.println("Optimize Approch");
		
		ans1=countConsistentStringsOptimize(allowed1,words1);
		ans2=countConsistentStringsOptimize(allowed2,words2);
		ans3=countConsistentStringsOptimize(allowed3,words3);
		
		if(ans1==output1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ (output1));
			System.out.println("Your Answer :"+ (ans1));
		}
		if(ans2==output2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ (output2));
			System.out.println("Your Answer :"+ (ans2));
		}
		if(ans3==output3) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Expected Ouput :"+ (output3));
			System.out.println("Your Answer :"+ (ans3));
		}
		
		System.out.println("Best Approch");
		
		ans1=countConsistentStringsBest(allowed1,words1);
		ans2=countConsistentStringsBest(allowed2,words2);
		ans3=countConsistentStringsBest(allowed3,words3);
		
		if(ans1==output1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ (output1));
			System.out.println("Your Answer :"+ (ans1));
		}
		if(ans2==output2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ (output2));
			System.out.println("Your Answer :"+ (ans2));
		}
		if(ans3==output3) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Expected Ouput :"+ (output3));
			System.out.println("Your Answer :"+ (ans3));
		}

	}
}