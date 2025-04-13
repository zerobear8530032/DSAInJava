//168. Excel Sheet Column Title
//Solved
//Easy
//Topics
//Companies
//Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.
//
//For example:
//
//A -> 1
//B -> 2
//C -> 3
//...
//Z -> 26
//AA -> 27
//AB -> 28 
//...
// 
//
//Example 1:
//
//Input: columnNumber = 1
//Output: "A"
//Example 2:
//
//Input: columnNumber = 28
//Output: "AB"
//Example 3:
//
//Input: columnNumber = 701
//Output: "ZY"
// 
//
//Constraints:
//
//1 <= columnNumber <= 231 - 1



package Maths;
class ExcelSheetColumnTitle_168 {
    public static String convertToTitle(int columnNumber) {
        StringBuilder ans = new StringBuilder();

        while(columnNumber!=0){
            columnNumber--;
            int rem = columnNumber%26;
            char ch = (char)('A'+rem);
            columnNumber=columnNumber/26;
            ans.append(ch);
        }   
        return ans.reverse().toString();
    }
    public static void main(String[] args) {
    	//Example 1:

    	int columnNumber1 = 1;
    	String output1= "A";

    	//Example 2:

    	int columnNumber2 = 28;
    	String output2= "AB";

    	
    	//Example 3:

    	int columnNumber3 = 701;
    	String output3= "ZY";
    	
    	

    	String ans1=convertToTitle(columnNumber1);
    	String ans2=convertToTitle(columnNumber2);
    	String ans3=convertToTitle(columnNumber3);
		
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
			System.out.println("Actual Output :"+output3 );
			System.out.println("Your Output :"+ans3);
		}
		
    	

	}
}