//Seven different symbols represent Roman numerals with the following values:
//
//Symbol	Value
//I	1
//V	5
//X	10
//L	50
//C	100
//D	500
//M	1000
//Roman numerals are formed by appending the conversions of decimal place values from highest to lowest. Converting a decimal place value into a Roman numeral has the following rules:
//
//If the value does not start with 4 or 9, select the symbol of the maximal value that can be subtracted from the input, append that symbol to the result, subtract its value, and convert the remainder to a Roman numeral.
//If the value starts with 4 or 9 use the subtractive form representing one symbol subtracted from the following symbol, for example, 4 is 1 (I) less than 5 (V): IV and 9 is 1 (I) less than 10 (X): IX. Only the following subtractive forms are used: 4 (IV), 9 (IX), 40 (XL), 90 (XC), 400 (CD) and 900 (CM).
//Only powers of 10 (I, X, C, M) can be appended consecutively at most 3 times to represent multiples of 10. You cannot append 5 (V), 50 (L), or 500 (D) multiple times. If you need to append a symbol 4 times use the subtractive form.
//Given an integer, convert it to a Roman numeral.
//
// 
//
//Example 1:
//
//Input: num = 3749
//
//Output: "MMMDCCXLIX"
//
//Explanation:
//
//3000 = MMM as 1000 (M) + 1000 (M) + 1000 (M)
// 700 = DCC as 500 (D) + 100 (C) + 100 (C)
//  40 = XL as 10 (X) less of 50 (L)
//   9 = IX as 1 (I) less of 10 (X)
//Note: 49 is not 1 (I) less of 50 (L) because the conversion is based on decimal places
//Example 2:
//
//Input: num = 58
//
//Output: "LVIII"
//
//Explanation:
//
//50 = L
// 8 = VIII
//Example 3:
//
//Input: num = 1994
//
//Output: "MCMXCIV"
//
//Explanation:
//
//1000 = M
// 900 = CM
//  90 = XC
//   4 = IV
// 
//
//Constraints:
//
//1 <= num <= 3999


package Maths;

import java.util.HashMap;

public class IntegerToRoman_12 {    
//	approch :
//	we take each element from the nums and try to find its romain value individually with its place value
//	understand 3 conditions:
	
//	1 if the number is 3 then it will repeat its will always repeat 3 time the symbol
//	of its place value
//	means if input : 300  : 3* 100= CCC	
//	means if input : 333  : 3* 100 + 3* 10 + 3*1 = CCCXXXIII
	
//	2: condition : it also mention in problem statement :
//	if a number if 4, 9 then it will be represented like this : (n+1) - (1) :
//	how x= 4: 4+1 = 5 (V) - 1 (I) : VI
//	similarly : 9 : 9+1 :(10) - (I): XI
//	if we take a bigger place value then we just need to take its place value -1
//	x=400 = 400+100 = 500(D) - 100(C) : DC
//	x=900 = 900+100 = 1000(M) - 100(C) : MC
	
//	3: condition is  when number btw 5 till 8:
//	here the number is represented in multiple of 5 *palace value + place value+placevalue+plave value..	
//	how ? 5: V
//	6: VI
//	70: LXX
//	871:(500+100+100) DCC +(50+10+10): LXX + I (1)   
//	
//	
	
	public  static String intToRoman(int num) {
    StringBuilder ans =new StringBuilder();
    HashMap<Integer,Character> map= new HashMap();
    map.put(1,'I');
    map.put(5,'V');
    map.put(10,'X');
    map.put(50,'L');
    map.put(100,'C');
    map.put(500,'D');
    map.put(1000,'M');
    int place=0;
    while(num!=0){// get individual digits
        int rem=num%10;
        ans.append(convertToRoman(rem,place,map));
        place++;
        num/=10;
    }
    return ans.reverse().toString();// the answer is generated in revese order
}
public static String convertToRoman(int num,int place, HashMap<Integer,Character> map){
    StringBuilder ans= new StringBuilder();
    if(num<=3){// if number is smaller or equal 3 we just append the 106 place number of time
        int placevalue =(int) Math.pow(10,place);
        for(int i =0;i<num;i++){
            ans.append(map.get(placevalue));
        } 
    }else if(num==4 || num==9) {// if the number is 4 or 9 we can represent it : (n+1) +(-1)
    	int placevalue = (int)Math.pow(10, place);
    	int maxVal= placevalue*(num+1);
    	ans.append(map.get(maxVal));
    	ans.append(map.get(placevalue));
    }else {// here we take the value as 5,50,500,5k etc :num= 5* (10^place) + 10^place * (nums phase value -5) 
//    	these value will be added x time to get output
    	int placevalue=(int)Math.pow(10, place);// we get place value
    	int maxVal= placevalue*5;// we get a place value of mid number
    	ans.append(map.get(maxVal));// we append the mid symbol
    	for(int i =0;i<num-5;i++) {// we find the x value
    		ans.append(map.get(placevalue));
    	}
    	return ans.reverse().toString();
    }
    return ans.toString();
}

	public static void main(String[] args) {
		
		
		//Example 1:
		
		int num1 = 3749;
		String output1 = "MMMDCCXLIX";

		
		//Example 2:
	
		int num2 = 58;
		String output2="LVIII";

		//Example 3:

		int num3=1994;
		String output3= "MCMXCIV";
		
		System.out.println("Brute Force :");
		
		String ans1=intToRoman(num1);
		String ans2=intToRoman(num2);
		String ans3=intToRoman(num3);
		
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
