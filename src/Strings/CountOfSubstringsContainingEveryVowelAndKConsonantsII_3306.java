//3306. Count of Substrings Containing Every Vowel and K Consonants II
//Medium
//Topics
//Companies
//Hint
//You are given a string word and a non-negative integer k.
//
//Return the total number of substrings of word that contain every vowel ('a', 'e', 'i', 'o', and 'u') at least once and exactly k consonants.
//
// 
//
//Example 1:
//
//Input: word = "aeioqq", k = 1
//
//Output: 0
//
//Explanation:
//
//There is no substring with every vowel.
//
//Example 2:
//
//Input: word = "aeiou", k = 0
//
//Output: 1
//
//Explanation:
//
//The only substring with every vowel and zero consonants is word[0..4], which is "aeiou".
//
//Example 3:
//
//Input: word = "ieaouqqieaouqq", k = 1
//
//Output: 3
//
//Explanation:
//
//The substrings with every vowel and one consonant are:
//
//word[0..5], which is "ieaouq".
//word[6..11], which is "qieaou".
//word[7..12], which is "ieaouq".
// 
//
//Constraints:
//
//5 <= word.length <= 2 * 105
//word consists only of lowercase English letters.
//0 <= k <= word.length - 5
package Strings;

public class CountOfSubstringsContainingEveryVowelAndKConsonantsII_3306 {
//	brute force try to find every single sub string and check they are valid or not
    public static long countOfSubstringsBruteForce(String word, int k) {
    	int count=0;
    	for(int i =0;i<word.length();i++) {
    		for(int j=i;j<word.length();j++) {
    			String str=word.substring(i,j+1);
    			if(isValidSubstring(str, k)) {
    				count++;
    			}
    		}
    	}
    	return count;
        
    }
    
    
    public static long countOfSubstringsBetter(String word, int k) {
    	int concount=0;
    	long res=0;
    	int l=0;
    	int r=0;
    	for(r=0;r<word.length();r++) {
    		char ch =word.charAt(r);
    		int windowsize= r-l+1;
    		if(!isVovel(ch)) {
    			concount++;
    		}
    		if(windowsize<5+k) {
    			continue;
    		}
    		if(concount==k) {
    			if(isValidSubstring(word.substring(l,r+1), k)) {
    				res++;
    			}
    		}
    		if(concount>k) {    			
    		while(concount>k) {
    			char lchar = word.charAt(l);
    			if(!isVovel(lchar)) concount--;
    			l++;
    		}
    		
    		if(concount==k) {
    			if(isValidSubstring(word.substring(l,r+1), k)) {
    				res++;
    			}
    		}
    		}

    	}
    	l++;
    	
    	while(l<r) {
			char lchar = word.charAt(l);
			if(!isVovel(lchar)) concount--;
			if(concount==k) {
				if(isValidSubstring(word.substring(l,r), k)) {
    				res++;
    			}
			}else {
				break;
			}
			l++;
		}
	
    	
    	
    	
    	return res;
    	
    }
    public static boolean isVovel(char ch) {
    	return ch=='a' ||ch=='e' || ch=='i' || ch =='o' || ch== 'u';
    }
    
    public static boolean isValidSubstring(String str,int k) {
    	int concount=0;
    	boolean Apresent=false;
    	boolean Epresent=false;
    	boolean Ipresent=false;
    	boolean Opresent=false;
    	boolean Upresent=false;
    	for( int i =0;i<str.length();i++) {
    		char ch =str.charAt(i);
    		if(ch=='a') Apresent=true;
    		else if(ch=='e') Epresent=true;
    		else if(ch=='i') Ipresent=true;
    		else if(ch=='o') Opresent=true;
    		else if(ch=='u') Upresent=true;
    		else concount++;
    	}
    	
    	return concount==k && (Apresent && Epresent && Ipresent && Opresent && Upresent);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Example 1:
		
		String word1= "aeioqq";
		int k1= 1;
		long output1=0;

		//Example 2:
		
		String word2 = "aeiou";
		int k2 = 0;
		long output2=1;
		

		//Example 3:
		
		String word3 = "ieaouqqieaouqq";
		int k3 = 1;
		long output3=3;
		
		
		//Example 4:
		
		String word4 = "iqeaouqi";
		int k4 = 2;
		long output4=3;
		
		
		
		long ans1=countOfSubstringsBruteForce(word1,k1);
		long ans2=countOfSubstringsBruteForce(word2,k2);
		long ans3=countOfSubstringsBruteForce(word3,k3);
		long ans4=countOfSubstringsBruteForce(word4,k4);
		
		System.out.println("Brute Force Approch :");
		
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
		if(output4==ans4) {
			System.out.println("Case 4 Passed");
		}else {
			System.out.println("Case 4 Failed");
			System.out.println("Actual Output :"+output4);
			System.out.println("Your Output :"+ans4);
		}
		
		ans1=countOfSubstringsBetter(word1,k1);
		ans2=countOfSubstringsBetter(word2,k2);
		ans3=countOfSubstringsBetter(word3,k3);
		ans4=countOfSubstringsBetter(word4,k4);
		
		System.out.println("Better Approch :");
		
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
		if(output4==ans4) {
			System.out.println("Case 4 Passed");
		}else {
			System.out.println("Case 4 Failed");
			System.out.println("Actual Output :"+output4);
			System.out.println("Your Output :"+ans4);
		}
		
		
	}

}
