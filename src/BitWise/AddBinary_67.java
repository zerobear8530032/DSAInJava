//67. Add Binary
//Solved
//Easy
//Topics
//Companies
//Given two binary strings a and b, return their sum as a binary string.
//
// 
//
//Example 1:
//
//Input: a = "11", b = "1"
//Output: "100"
//Example 2:
//
//Input: a = "1010", b = "1011"
//Output: "10101"
// 
//
//Constraints:
//
//1 <= a.length, b.length <= 104
//a and b consist only of '0' or '1' characters.
//Each string does not contain leading zeros except for the zero itself.


package BitWise;

public class AddBinary_67 {

	
//	 we can simulate this using a simple operations:
//	we can use formula  sum  = digit1+digit2+carry 
//	sum/2 = place value
//	sum%2= carry 
//	for sum
//	by this we can itearate over both strings 
//	and create a string ans 
//	time complexity :O(n+m)
//	space complexity :O(n+m)

	  public static String addBinary(String a, String b) {
	        int l1= a.length();
	        int l2= b.length();
	        int idx1= l1-1;
	        int idx2= l2-1;
	        int carry = 0;
	        StringBuilder ans = new StringBuilder();
	        while(idx1>=0 && idx2>=0){
	            int digit1 = (idx1>=0) ? a.charAt(idx1)-'0' :0;
	            int digit2 = (idx2>=0) ? b.charAt(idx2)-'0' :0;
	            int sum = digit1+digit2+carry;
	            carry = sum/2;
	            ans.append(sum%2);
	            idx1--;
	            idx2--;
	        }
	        while(idx1>=0){
	            int digit1 = (idx1>=0) ? a.charAt(idx1)-'0' :0;
	            int sum = digit1+carry;
	            carry = sum/2;
	            ans.append(sum%2);
	            idx1--;
	        }
	        while(idx2>=0){
	            int digit2 = (idx2>=0) ? b.charAt(idx2)-'0' :0;
	            int sum = digit2+carry;
	            carry = sum/2;
	            ans.append(sum%2);
	            idx2--;
	        }
	        if(carry!=0){
	            ans.append(carry);
	        }     
	        return ans.reverse().toString();
	        
	    }
	

	public static void main(String[] args) {
		
		
		//Example 1:
		
		String a1 = "11", b1 = "1";
		String output1="100";
		
		//Example 2:
		
		String a2 = "1010", b2 = "1011";
		String output2="10101";
		
		System.out.println("best  Approch ");
    	String  ans1 = addBinary(a1,b1);
    	String ans2 = addBinary(a2,b2);

    	if(output1.equals(ans1)) {
    		System.out.println("Case 1 Passed ");
    	}else {
    		System.out.println("Case 1 Failed");
    		System.out.println("Expected Output : "+output1);
    		System.out.println("Your Output : "+ans1);
    	}
    	if(output2.equals(ans2)) {
    		System.out.println("Case 2 Passed ");
    	}else {
    		System.out.println("Case 2 Failed");
    		System.out.println("Expected Output : "+output2);
    		System.out.println("Your Output : "+ans2);
    	}
		
		


	}

}
