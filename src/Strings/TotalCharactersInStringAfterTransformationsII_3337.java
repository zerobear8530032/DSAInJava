//3337. Total Characters in String After Transformations II
//Hard
//Topics
//Companies
//Hint
//You are given a string s consisting of lowercase English letters, an integer t representing the number of transformations to perform, and an array nums of size 26. In one transformation, every character in s is replaced according to the following rules:
//
//Replace s[i] with the next nums[s[i] - 'a'] consecutive characters in the alphabet. For example, if s[i] = 'a' and nums[0] = 3, the character 'a' transforms into the next 3 consecutive characters ahead of it, which results in "bcd".
//The transformation wraps around the alphabet if it exceeds 'z'. For example, if s[i] = 'y' and nums[24] = 3, the character 'y' transforms into the next 3 consecutive characters ahead of it, which results in "zab".
//Return the length of the resulting string after exactly t transformations.
//
//Since the answer may be very large, return it modulo 109 + 7.
//
// 
//
//Example 1:
//
//Input: s = "abcyy", t = 2, nums = [1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2]
//
//Output: 7
//
//Explanation:
//
//First Transformation (t = 1):
//
//'a' becomes 'b' as nums[0] == 1
//'b' becomes 'c' as nums[1] == 1
//'c' becomes 'd' as nums[2] == 1
//'y' becomes 'z' as nums[24] == 1
//'y' becomes 'z' as nums[24] == 1
//String after the first transformation: "bcdzz"
//Second Transformation (t = 2):
//
//'b' becomes 'c' as nums[1] == 1
//'c' becomes 'd' as nums[2] == 1
//'d' becomes 'e' as nums[3] == 1
//'z' becomes 'ab' as nums[25] == 2
//'z' becomes 'ab' as nums[25] == 2
//String after the second transformation: "cdeabab"
//Final Length of the string: The string is "cdeabab", which has 7 characters.
//
//Example 2:
//
//Input: s = "azbk", t = 1, nums = [2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2]
//
//Output: 8
//
//Explanation:
//
//First Transformation (t = 1):
//
//'a' becomes 'bc' as nums[0] == 2
//'z' becomes 'ab' as nums[25] == 2
//'b' becomes 'cd' as nums[1] == 2
//'k' becomes 'lm' as nums[10] == 2
//String after the first transformation: "bcabcdlm"
//Final Length of the string: The string is "bcabcdlm", which has 8 characters.
//
// 
//
//Constraints:
//
//1 <= s.length <= 105
//s consists only of lowercase English letters.
//1 <= t <= 109
//nums.length == 26
//1 <= nums[i] <= 25


package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TotalCharactersInStringAfterTransformationsII_3337 {
	
//	approch :
//	simiulate what asked get every sigle chararcter and 
//	apply the transformation on it 
//	t times 
//	as instructed
//	time complexity : O(N*2^T);
//	space complexity : O(N*2^T);
		
	public static int lengthAfterTransformationsBruteForce(String s, int t, List<Integer> nums) {
        int MOD= 1000000007;
        for(int i =0;i<t;i++){
            StringBuilder str= new StringBuilder();
            for(int j=0;j<s.length();j++){
                char ch = s.charAt(j);
                int nextChars= nums.get(ch-'a');
                StringBuilder charstr= new StringBuilder();
                for(int k=1;k<=nextChars;k++){
                    char nextchar= (char)('a'+(((ch-'a')+k)%26));
                    charstr.append(nextchar);
                }
                str.append(charstr.toString());
            }
            s=str.toString();
        }
        return s.length()%MOD;
    }  
	

//	approch :better
//	instead of applying the operation on the string 
//	we can apply it on the frequency map of string character 
//	this allow us to does not create or update string each time
//	and  we can just change frequency of string character in the map which will be of length 26
//	much smaller the string
//	time complexity : O(T);
//	space complexity : O(1);
	
	public static int lengthAfterTransformationsBetter(String s, int t, List<Integer> nums) {
		int MOD= 1000000007;
		int map1 [] = new int [26];
		int map2 [] = new int [26];
		int n = s.length();
		for(int i=0;i<n;i++) {
			char ch=s.charAt(i);
			map1[ch-'a']++;
		}
		
		for(int i =0;i<t;i++){
			for(int j =0;j<map1.length;j++) {
			char ch = (char)('a'+j);
			int increment = map1[j];
			int nextChars= nums.get(ch-'a');
			map1[j]=0;
			for(int k=1;k<=nextChars;k++) {
				int index = ((ch-'a')+k)%26;//  converted current char in an index
				map2[index]= (map2[index]+increment)%MOD;
			}
			}
			int []temp = map1;
			map1=map2;
			map2=temp;
		}
		
		int sum =0;
		for(int x:map1) {
			sum=(sum+x)%MOD;
		}
		return sum;
		
	}  

	public static void main(String[] args) {

		//Example 1:

		String s1 = "abcyy";
		int t1 = 2;
		List<Integer> nums1 =new ArrayList<Integer>(Arrays.asList(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2));
		int output1=7;

		//Example 2:

		String s2 = "azbk";
		int t2 = 1;
		List<Integer> nums2 = new ArrayList(Arrays.asList(2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2));
		int output2=8;
		System.out.println("Brute Approch :");
		
		//Example 3:
		
		String s3 = "u";
		int t3 = 5;
		List<Integer> nums3 = new ArrayList(Arrays.asList(1,1,2,2,3,1,2,2,1,2,3,1,2,2,2,2,3,3,3,2,3,2,3,2,2,3));
		int output3=55;
		System.out.println("Brute Approch :");
		
		int ans1=lengthAfterTransformationsBruteForce(s1,t1,nums1);
		int ans2=lengthAfterTransformationsBruteForce(s2,t2,nums2);
		int ans3=lengthAfterTransformationsBruteForce(s3,t3,nums3);
		
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
		
		System.out.println("Better Approch :");
		
		ans1=lengthAfterTransformationsBetter(s1,t1,nums1);
		ans2=lengthAfterTransformationsBetter(s2,t2,nums2);
		ans3=lengthAfterTransformationsBetter(s3,t3,nums3);
		
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
		
		ans1=lengthAfterTransformationsBetter(s1,t1,nums1);
		ans2=lengthAfterTransformationsBetter(s2,t2,nums2);
		ans3=lengthAfterTransformationsBetter(s3,t3,nums3);
		
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
