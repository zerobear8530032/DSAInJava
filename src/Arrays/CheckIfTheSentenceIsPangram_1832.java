//1832. Check if the Sentence Is Pangram
//Solved
//Easy
//Topics
//Companies
//Hint
//A pangram is a sentence where every letter of the English alphabet appears at least once.
//
//Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.
//
// 
//
//Example 1:
//
//Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
//Output: true
//Explanation: sentence contains at least one of every letter of the English alphabet.
//Example 2:
//
//Input: sentence = "leetcode"
//Output: false
// 
//
//Constraints:
//
//1 <= sentence.length <= 1000
//sentence consists of lowercase English letters.

package Arrays;

import java.util.HashSet;
class CheckIfTheSentenceIsPangram_1832 {
//	using hash set : this will make us to keep track of how many character are present in string 
//	by adding each character to the hashset we can check if final hashset size ==26 if yes means
//	every single character is present 
//	disadvantages of approch:
//	works only for lower case string need modification for upper cases 
//	only work when there are string character and no extra symbols present in the string 
	
//	time complexity : O(n)
//	space complexity : O(n) : can be O(1) because the hashset size wont be above 26 according to contrains 
	
    public static boolean checkIfPangramGoodApproch(String sentence) {
        HashSet<Character> ans = new HashSet();
        if (sentence.length()<26){
    		return false;
    	}
        for(int i=0;i<sentence.length();i++){
            ans.add(sentence.charAt(i));
        }
        return ans.size()==26;
    }
//    note : for this contrain this is not effective but for higher contrain this is better then the other approches 
//	using Array : this will make us to keep track of how many character are present in string 
//	by creating  an array of 26 size we can map each character on that indexes and check wheather each index are fill or not
//    if all are fill means string in pangram other wise not 
    
//    disadvantages :
//    does not allow different symbol other then character in string 
//    does not allow capital character required some handling 
    
//	time complexity : O(n): n is length of string 
//	space complexity : O(1) : cause the size of array cant change on any string     
    public static boolean checkIfPangramBetterApproch(String sentence) {
    	int []ans = new int [26];
    	if (sentence.length()<26){
    		return false;
    	}
    	for(int i=0;i<sentence.length();i++){
    		ans[sentence.charAt(i)-'a']++;
    	}
    	for(int i=0;i<ans.length;i++){
    		if(ans[i]==0) {
    			return false;
    		}
    	}
    	return true;  	
    }
    
    
//	using string methods : well this approch best for lower constrain but for bigger contrain this might be worst choice
//    we will use a character from a till z and check if each character exists in the string 
//    we can do that by string inbuild method 
//    disadvantages :
//    does not allow different symbol other then character in string 
//    does not allow capital character required some handling 
    
//	time complexity : O(n): n is length of string 
//	space complexity : O(1) : cause the size of array cant change on any string     
    
    public static boolean checkIfPangramBestApproch(String sentence) {
    	
    	   for(char ch='a';ch<='z';ch++){
               if(sentence.indexOf(ch)<0){// index of uses time complexity : O(n+m), space complexity : O(n)
                   return false;
               }
            }
    	return true;  	
    }

    
    
    
    public static void main(String[] args) {
    	//Example 1:
    	
    	String sentence1 = "thequickbrownfoxjumpsoverthelazydog";
    	boolean output1= true;
    	
    	//Example 2:
    	
    	String  sentence2 = "leetcode";
    	boolean output2= false;
    	
    	boolean ans1 =checkIfPangramGoodApproch(sentence1); 
    	boolean ans2 =checkIfPangramGoodApproch(sentence2); 
    	
    	System.out.println("Good Approch ");
    	if(output1== ans1) {
    		System.out.println("Case 1 Passed ");
    	}else {
    		System.out.println("Case 1 Failed");
    		System.out.println("Expected Output : "+output1);
    		System.out.println("Your Output : "+ans1);
    	}
    	if(output2== ans2) {
    		System.out.println("Case 2 Passed ");
    	}else {
    		System.out.println("Case 2 Failed");
    		System.out.println("Expected Output : "+output2);
    		System.out.println("Your Output : "+ans2);
    	}

//    	this is better approch because hashmap required more over head then array 
    	System.out.println("Better Approch ");
    	ans1 = checkIfPangramBetterApproch(sentence1);
    	ans2 = checkIfPangramBetterApproch(sentence2);
    	if(output1== ans1) {
    		System.out.println("Case 1 Passed ");
    	}else {
    		System.out.println("Case 1 Failed");
    		System.out.println("Expected Output : "+output1);
    		System.out.println("Your Output : "+ans1);
    	}
    	if(output2== ans2) {
    		System.out.println("Case 2 Passed ");
    	}else {
    		System.out.println("Case 2 Failed");
    		System.out.println("Expected Output : "+output2);
    		System.out.println("Your Output : "+ans2);
    	}
    	
//    	this is best because we need one iteration of 26 character not on entire string 
//    	so according to contrain this method is great but for very high strings array method is much better
    	System.out.println("Best Approch ");
    	ans1 = checkIfPangramBestApproch(sentence1);
    	ans2 = checkIfPangramBestApproch(sentence2);
    	if(output1== ans1) {
    		System.out.println("Case 1 Passed ");
    	}else {
    		System.out.println("Case 1 Failed");
    		System.out.println("Expected Output : "+output1);
    		System.out.println("Your Output : "+ans1);
    	}
    	if(output2== ans2) {
    		System.out.println("Case 2 Passed ");
    	}else {
    		System.out.println("Case 2 Failed");
    		System.out.println("Expected Output : "+output2);
    		System.out.println("Your Output : "+ans2);
    	}
    	
	}
    
    
}