//3335. Total Characters in String After Transformations I
//Medium
//Topics
//Companies
//Hint
//You are given a string s and an integer t, representing the number of transformations to perform. In one transformation, every character in s is replaced according to the following rules:
//
//If the character is 'z', replace it with the string "ab".
//Otherwise, replace it with the next character in the alphabet. For example, 'a' is replaced with 'b', 'b' is replaced with 'c', and so on.
//Return the length of the resulting string after exactly t transformations.
//
//Since the answer may be very large, return it modulo 109 + 7.
//
// 
//
//Example 1:
//
//Input: s = "abcyy", t = 2
//
//Output: 7
//
//Explanation:
//
//First Transformation (t = 1):
//'a' becomes 'b'
//'b' becomes 'c'
//'c' becomes 'd'
//'y' becomes 'z'
//'y' becomes 'z'
//String after the first transformation: "bcdzz"
//Second Transformation (t = 2):
//'b' becomes 'c'
//'c' becomes 'd'
//'d' becomes 'e'
//'z' becomes "ab"
//'z' becomes "ab"
//String after the second transformation: "cdeabab"
//Final Length of the string: The string is "cdeabab", which has 7 characters.
//Example 2:
//
//Input: s = "azbk", t = 1
//
//Output: 5
//
//Explanation:
//
//First Transformation (t = 1):
//'a' becomes 'b'
//'z' becomes "ab"
//'b' becomes 'c'
//'k' becomes 'l'
//String after the first transformation: "babcl"
//Final Length of the string: The string is "babcl", which has 5 characters.
// 
//
//Constraints:
//
//1 <= s.length <= 105
//s consists only of lowercase English letters.
//1 <= t <= 105

package Arrays;

public class TotalCharactersInStringAfterTransformationsI_3335 {
	
//	brute force approch :
//	here we apply operation each element t times 
//	time complexity : O(N*2^T);
//	space complexity : O(N*2^T);
	
    public static int lengthAfterTransformationsBruteForce(String s, int t) {
	        for(int i=0;i<t;i++){
	            StringBuilder str= new StringBuilder();
	            for(int j =0;j<s.length();j++){
	                char ch=s.charAt(j);
	                if(ch=='z'){
	                    str.append("ab");
	                }else{
	                    str.append((char)(ch+1));
	                }
	            }
	            s=str.toString();
	        }
	        return s.length();
	    }
	
//	better approch :
//	here we apply operation each element t by using a  charactermap
//  instead of creating string we can create a ferquency map of character
//  then you can apply operation on that map 
//  note each operation apply will be seperated other wise it will collide with each other
//	time complexity : O(T);
//	space complexity : O(1); here we need a single array instead of 2 array
    
    public static int lengthAfterTransformationsBetter(String s, int t) {
    	int [] map1 = new int [26];
    	int [] map2 = new int [26];
    	int mod = 1000000007;
    	for(int i=0;i<s.length();i++) {
    		char ch = s.charAt(i);
    		map1[ch-'a']++;   		
    	}
    	
    	for(int i =0;i<t;i++) {
    		for(int j =0;j<map1.length;j++) {
    			if(map1[j]==0) continue;
    			if(j==25) {
    				int x=map1[j];
    				map1[j]=0;
    				map2[0]=(map2[0]+x)%mod;
    				map2[1]=(map2[1]+x)%mod;
    			}
    			if(map1[j]!=0) {
    				int x=map1[j];
    				map1[j]=0;
    				map2[j+1]=(map2[j+1]+x)%mod;
    			}
    		}
//    		swap the maps :
    		int [] temp = map1;
    		map1=map2;
    		map2=temp;
    	}
    	int sum =0;
    	for(int x:map1) {
    		sum =(sum+x)%mod;
    	}
    	return sum;
    }
    
//	best approch :
//	here we apply operation each element t by using a  charactermap
//  to keep safe from collision of transformation we can apply it in revese iteration
//  then we does not required 2 array 
//	time complexity : O(T*N);
//	space complexity : O(1);
    
    public static int lengthAfterTransformationsBest(String s, int t) {
    	int [] map = new int [26];
    	int mod = 1000000007;
    	for(int i=0;i<s.length();i++) {
    		char ch = s.charAt(i);
    		map[ch-'a']++;   		
    	}    	
    	for(int i =0;i<t;i++) {
    		int zval=0;
    		boolean zvalupdate=false;
    		for(int j =map.length-1;j>=0;j--) {
    			if(map[j]==0) continue;
    			if(j==25) {
    				zval =map[j];
    				map[j]=0;
    				zvalupdate=true;
    			}
    			if(map[j]!=0) {
    				int x=map[j];
    				map[j]=0;
    				map[j+1]=(map[j+1]+x)%mod;
    			}
    		}
    		if(zvalupdate) {
				map[0]=(map[0]+zval)%mod;
				map[1]=(map[1]+zval)%mod;
    		}

    	}
    	int sum =0;
    	for(int x:map) {
    		sum =(sum+x)%mod;
    	}
    	return sum;
    }
    

	public static void main(String[] args) {
		//Example 1:

		String s1 = "abcyy";
		int t1 = 2;
		int output1=7;

		//Example 2:

		String s2 = "azbk";
		int t2 = 1;
		int output2=5;
		
		//Example 3:
		
		String s3 = "jqktcurgdvlibczdsvnsg";
		int t3 = 7517;
		int output3=79033769;
		
		System.out.println("Brute Approch :");
		
		int ans1=lengthAfterTransformationsBruteForce(s1,t1);
		int ans2=lengthAfterTransformationsBruteForce(s2,t2);
		int ans3=0;
		
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
//		if(output3==ans3) {
//			System.out.println("Case 3 Passed");
//		}else {
//			System.out.println("Case 3 Failed");
//			System.out.println("Actual Output :"+output3);
//			System.out.println("Your Output :"+ans3);
//		}
		
		System.out.println("Better Approch :");
		
		ans1=lengthAfterTransformationsBetter(s1,t1);
		ans2=lengthAfterTransformationsBetter(s2,t2);
		ans3=lengthAfterTransformationsBetter(s3,t3);
		
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
		
		System.out.println("Best Approch :");
		
		ans1=lengthAfterTransformationsBest(s1,t1);
		ans2=lengthAfterTransformationsBest(s2,t2);
		ans3=lengthAfterTransformationsBest(s3,t3);
		
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
