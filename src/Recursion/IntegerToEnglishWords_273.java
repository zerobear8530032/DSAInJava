//273. Integer to English Words
//Hard
//Topics
//premium lock icon
//Companies
//Hint
//Convert a non-negative integer num to its English words representation.
//
// 
//
//Example 1:
//
//Input: num = 123
//Output: "One Hundred Twenty Three"
//Example 2:
//
//Input: num = 12345
//Output: "Twelve Thousand Three Hundred Forty Five"
//Example 3:
//
//Input: num = 1234567
//Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
// 
//
//Constraints:
//
//0 <= num <= 231 - 1

package Recursion;

import java.util.HashMap;

public class IntegerToEnglishWords_273 {
	
//	approch:
//	each 3  digit number can be consider as 100 s, 10 s, 1 s,place
//	so we can divide the number in small subset of 3 
//	and convert it into String 
//	then we just have to add there valid place values like for
//	3 digit it have no particula name
//	above that we need thousand
//	above that we need to add million
//	above that we need to add billion
//	etc
//	time complexity O(n * log (digit))
//	space complexity : O(n)
	 public  static String numberToWords(int num) {
		   if(num==0) {
			   return "Zero";
		   }
		   HashMap<Integer, String> nummap = new HashMap();
		   nummap.put(1,"One");
		   nummap.put(2,"Two");
		   nummap.put(3,"Three");
		   nummap.put(4,"Four");
		   nummap.put(5,"Five");
		   nummap.put(6,"Six");
		   nummap.put(7,"Seven");
		   nummap.put(8,"Eight");
		   nummap.put(9,"Nine");
		   nummap.put(10,"Ten");
		   nummap.put(11,"Eleven");
		   nummap.put(12,"Twelve");
		   nummap.put(13,"Thirteen");
		   nummap.put(14,"Fourteen");
		   nummap.put(15,"Fifteen");
		   nummap.put(16,"Sixteen");
		   nummap.put(17,"Seventeen");
		   nummap.put(18,"Eighteen");
		   nummap.put(19,"Nineteen");
		   nummap.put(20,"Twenty");
		   nummap.put(30,"Thirty");
		   nummap.put(40,"Forty");
		   nummap.put(50,"Fifty");
		   nummap.put(60,"Sixty");
		   nummap.put(70,"Seventy");
		   nummap.put(80,"Eighty");
		   nummap.put(90,"Ninety");
         String res =helper(num,0,nummap);
         String [] arr= res.split(" ");
         StringBuilder preprocess= new StringBuilder();
         for(String s:arr){
          if(s.isBlank()) continue;
          // System.out.print(s);
          preprocess.append(s).append(" ");
         }
         return preprocess.toString().strip();

	   }
	   
	   public static String helper(int num, int place , HashMap<Integer,String> nummap) {
		   if(num==0) {
			   return "";
		   }
		   int strconvert= num%1000; 
		   String res = converttoString(strconvert, place, nummap);
		   int next= num/1000;
		   String rest=helper(next,place+1,nummap);
		   String finalres= rest+" "+res;
		   return finalres;
	   }
	   
	   public static String converttoString(int n, int place, HashMap<Integer,String> nummap) {
		   String res="";
		   
          if(n==0) return res;
          String [] places= {"", "Thousand", "Million", "Billion", "Trillion", "Quadrillion"};
		   if(n>=100 && n<=999) {
			   int place2values = n%100;
			   res ="";
			   if(place2values>=10 && place2values<=19) {
				   res+=nummap.get(place2values);
				   int lastValue = n/100;
				   if(lastValue!=0) {
					   res= nummap.get(lastValue)+" "+"Hundred"+" "+res;
				   }
			   }else {
				   int x = n;
				   int p=0;
				   while(x!=0) {
					   int rem = x%10;
					   if(rem==0) {
						   x/=10;
						   p++;
						   continue;
					   }
					   if(p==0) {
						   res= nummap.get(rem)+ res;
					   }else if(p==1){
						   res= nummap.get(rem*10)+" "+res;
					   }else {
						   res= nummap.get(rem)+" "+"Hundred"+" "+res;						   
					   }
					   p++;
					   x/=10;
				   }
			   }
		   }
		   if(n>=10 && n<=99) {
			   if(n>=10 && n<=19) {
				   res+= nummap.get(n);
			   }else {
				   
				   int first= n%10;
				   int second= (n/10);
				   if(first==0) {
					   res+= nummap.get(second*10);
				   }else {
					   res+= nummap.get(second*10)+" "+nummap.get(first);
				   }
			   }
		   }
		   if(n>=1 && n<=9) {
			   res+= nummap.get(n);
		   }
		   return res+" "+places[place];			   

		  }	   
	public static void main(String[] args) {
		
		//Example 1:

		int num1 = 123;
		String output1="One Hundred Twenty Three";

		//Example 2:

		int num2= 12345;
		String output2="Twelve Thousand Three Hundred Forty Five";
		
		//Example 3:

		int num3= 1234567;
		String output3="One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven";
		

    	String ans1=numberToWords(num1);
    	String ans2=numberToWords(num2);
    	String ans3=numberToWords(num3);
    	
    	if(output1.equals(ans1)) {
    		System.out.println("Case 1 Passed");
    	}else {
    		System.out.println("Case 1 Failed");
    		System.out.println("Expected Ouput :"+ output1);
    		System.out.println("Your Answer :"+ ans1);  		
    	}
    	
    	if(output2.equals(ans2)) {
    		System.out.println("Case 2 Passed");
    	}else {
    		System.out.println("Case 2 Failed");
    		System.out.println("Expected Ouput :"+ output2);
    		System.out.println("Your Answer :"+ ans2);  		
    	}
    	if(output3.equals(ans3)) {
    		System.out.println("Case 3 Passed");
    	}else {
    		System.out.println("Case 3 Failed");
    		System.out.println("Expected Ouput :"+ output3);
    		System.out.println("Your Answer :"+ ans3);  		
    	}		
	}

}
