//1763. Longest Nice Substring
//Solved
//Easy
//Topics
//Companies
//Hint
//A string s is nice if, for every letter of the alphabet that s contains, it appears both in uppercase and lowercase. For example, "abABB" is nice because 'A' and 'a' appear, and 'B' and 'b' appear. However, "abA" is not because 'b' appears, but 'B' does not.
//
//Given a string s, return the longest substring of s that is nice. If there are multiple, return the substring of the earliest occurrence. If there are none, return an empty string.
//
// 
//
//Example 1:
//
//Input: s = "YazaAay"
//Output: "aAa"
//Explanation: "aAa" is a nice string because 'A/a' is the only letter of the alphabet in s, and both 'A' and 'a' appear.
//"aAa" is the longest nice substring.
//Example 2:
//
//Input: s = "Bb"
//Output: "Bb"
//Explanation: "Bb" is a nice string because both 'B' and 'b' appear. The whole string is a substring.
//Example 3:
//
//Input: s = "c"
//Output: ""
//Explanation: There are no nice substrings.
// 
//
//Constraints:
//
//1 <= s.length <= 100
//s consists of uppercase and lowercase English letters.

package BitWise;
class LongestNiceSubstring_1763{
//	brute force approch:
//	create every single substring and check conditions
//	to check is valid we can create two array one for mapping
//	capital 
//	one for mapping small letter on array 
//	last we can check if any array of small[i]== 0 and cap[i]!=0
//	or cap[i]==0 and small[i]!=0 return false;
//	other wise true
//	time complexity :O(n*n*n)
//	space complexity : O(n)
	
    public static String longestNiceSubstringBruteForce(String s) {
        int n= s.length();
        String ans = "";
        for(int i =0;i<n;i++){
            for(int j =i;j<n;j++){
                String substr= s.substring(i,j+1);
                if(isNiceStringBruteForce(substr)){
                    if(substr.length()>ans.length()){
                        ans=substr;
                    }
                }
            }
        }
        return ans;
    }
    public static boolean isNiceStringBruteForce(String str){
        int [] small= new int [26];
        int [] cap= new int [26];
        for(int i =0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch>='a' && ch<='z'){
                small[ch-'a']++;
            }else if(ch>='A' && ch<='Z'){
                cap[ch-'A']++;
            }
        }
        for(int i =0;i<26;i++){
            if(small[i]==0 && cap[i]!=0 ){
                return false;
            }
            if(cap[i]==0 && small[i]!=0 ){
                return false;
            }
        }
        return true;
    }
    
//	Better approch:
//	create every single substring and check conditions
//	we can reduce space by mapping the number on bitmask rather then 
//    array because int contains 32 bits and total char are 26 
//    we can create 2 bitmask for cap and small
//    and map from it 
//	
//	other wise true
//	time complexity :O(n*n*n)
//	space complexity : O(1)
    
    public static String longestNiceSubstringBetter(String s) {
    	int n= s.length();
    	String ans = "";
    	for(int i =0;i<n;i++){
    		for(int j =i;j<n;j++){
    			String substr= s.substring(i,j+1);
    			if(isNiceStringBetter(substr)){
    				if(substr.length()>ans.length()){
    					ans=substr;
    				}
    			}
    		}
    	}
    	return ans;
    }
//    this does uses 1 int space which is much less then the brute force
    public static boolean isNiceStringBetter(String str){
    	int smallBitMask =0;
    	int capBitMask =0;
    	for(int i =0;i<str.length();i++) {
    		char ch = str.charAt(i);
    		if(ch>='a' && ch<='z') {
    			smallBitMask|= (1<<ch-'a');
    		}
    		if(ch>='A' && ch<='Z') {
    			capBitMask|= (1<<ch-'A');
    		}
    	}
   	
    	return (smallBitMask ^ capBitMask) == 0;
    }
//    Best approch can be created using sliding window but i am not good n=in that right now
//    this does uses 1 int space which is much less then the brute force
    
    
    
    public static void main(String[] args) {
    	
    	
    	//Example 1:

    	String s1 = "YazaAay";
    	String output1 = "aAa";
    	
    	//Example 2:

    	String s2 = "Bb";
    	String output2 = "Bb";
    	


    	//Example 3:

    	String s3 = "c";
    	String output3 = "";
    	
    	String ans1=longestNiceSubstringBruteForce(s1);
    	String ans2=longestNiceSubstringBruteForce(s2);
    	String ans3=longestNiceSubstringBruteForce(s3);

    	if(ans1.equals(output1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ (output1));
			System.out.println("Your Answer :"+ (ans1));
		}
		if(ans2.equals(output2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ (output2));
			System.out.println("Your Answer :"+ (ans2));
		}
		if(ans3.equals(output3)) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Expected Ouput :"+ (output3));
			System.out.println("Your Answer :"+ (ans3));
		}
		
		System.out.println("Better Approch :");
		
    	ans1=longestNiceSubstringBetter(s1);
    	ans2=longestNiceSubstringBetter(s2);
    	ans3=longestNiceSubstringBetter(s3);
		
		if(ans1.equals(output1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ (output1));
			System.out.println("Your Answer :"+ (ans1));
		}
		if(ans2.equals(output2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ (output2));
			System.out.println("Your Answer :"+ (ans2));
		}
		if(ans3.equals(output3)) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Expected Ouput :"+ (output3));
			System.out.println("Your Answer :"+ (ans3));
		}
    	

		
	}
}