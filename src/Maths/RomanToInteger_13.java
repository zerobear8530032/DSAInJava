//13. Roman to Integer
//Solved
//Easy
//Topics
//Companies
//Hint
//Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
//
//Symbol       Value
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000
//For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
//
//Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
//
//I can be placed before V (5) and X (10) to make 4 and 9. 
//X can be placed before L (50) and C (100) to make 40 and 90. 
//C can be placed before D (500) and M (1000) to make 400 and 900.
//Given a roman numeral, convert it to an integer.
//
// 
//
//Example 1:
//
//Input: s = "III"
//Output: 3
//Explanation: III = 3.
//Example 2:
//
//Input: s = "LVIII"
//Output: 58
//Explanation: L = 50, V= 5, III = 3.
//Example 3:
//
//Input: s = "MCMXCIV"
//Output: 1994
//Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
// 
//
//Constraints:
//
//1 <= s.length <= 15
//s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
//It is guaranteed that s is a valid roman numeral in the range [1, 3999].

package Maths;

import java.util.HashMap;

public class RomanToInteger_13 {

	
//	brute force approch:
//	time complexity :O(n)
//	space complexity :O(1)
	    public static int romanToInt(String s) {
	        int sum=0;
	        HashMap<Character,Integer> map = new HashMap();
	        map.put('I',1);
	        map.put('V',5);
	        map.put('X',10);
	        map.put('L',50);
	        map.put('C',100);
	        map.put('D',500);
	        map.put('M',1000);
	        for(int i=0;i<s.length();i++){
	            int curVal=map.get(s.charAt(i));
	            int nextVal=i+1<s.length() ? map.get(s.charAt(i+1)) :0;
	            if(curVal>=nextVal){
	                sum+=curVal;
	            }else{
	                int val =nextVal-curVal;
	                sum+=val;
	                i++;
	            }
	        }
	        return sum;
	    }
	
	public static void main(String[] args) {
		//Example 1:

		String s1 = "III";
		int output1=3;
		
		//Example 2:
		
		String s2 = "LVIII";
		int output2=58;
		
		//Example 3:

		String s3 = "MCMXCIV";
		int output3=1994;
		
		
		int ans1=romanToInt(s1);
		int ans2=romanToInt(s2);
		int ans3=romanToInt(s3);
		
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
			System.out.println("Actual Output :"+output3 );
			System.out.println("Your Output :"+ans3);
		}
		
		 
		
	}

}
