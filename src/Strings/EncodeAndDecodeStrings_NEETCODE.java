//Encode and Decode Strings
//Solved 
//Design an algorithm to encode a list of strings to a single string. The encoded string is then decoded back to the original list of strings.
//
//Please implement encode and decode
//
//Example 1:
//
//Input: ["neet","code","love","you"]
//
//Output:["neet","code","love","you"]
//Example 2:
//
//Input: ["we","say",":","yes"]
//
//Output: ["we","say",":","yes"]
//Constraints:
//
//0 <= strs.length < 100
//0 <= strs[i].length < 200
//strs[i] contains only UTF-8 characters.

package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class EncodeAndDecodeStrings_NEETCODE {

    public static String encode(List<String> strs) {
        StringBuilder ans = new StringBuilder();
        String delimiter="#";
        for(String str :strs){
            int len =str.length();
            ans.append(len).append(delimiter).append(str).append(delimiter);
        }
        return ans.toString();
    }

    public static List<String> decode(String str) {
        List<String> ans=new ArrayList();
        for(int i =0;i<str.length();i++){
            char currchar = str.charAt(i);
            int stringlen=0;
            while(currchar>='0' && currchar<='9'){
                int num=currchar-'0';
                stringlen=stringlen*10+num;
                i++;
                currchar = str.charAt(i);
            }
            if(currchar=='#'){             
                i++;
                currchar = str.charAt(i);
            }
            StringBuilder tempstr= new StringBuilder();
            for(int t=0;t<stringlen;t++){
                tempstr.append(currchar);
                i++;
                currchar=str.charAt(i);
            }
            ans.add(tempstr.toString());
        }
        return ans;
    }
    
    public static void main(String[] args) {
    	//Example 1:
    	//
    	List<String > str1= new ArrayList(Arrays.asList("neet","code","love","you"));
    	//Output:["neet","code","love","you"]
    	
    	//Example 2:
    	List<String > str2= new ArrayList(Arrays.asList("we","say",":","yes"));
    	
    	String encode1=encode(str1);
    	String encode2=encode(str2);
    	
    	List<String> ans1 =decode(encode1);
    	List<String> ans2 =decode(encode2);
   

		
		
		if(ans1.equals(str1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output :"+str1 );
			System.out.println("Your Output :"+ans1);
		}
		if(ans1.equals(str1)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Actual Output :"+str2 );
			System.out.println("Your Output :"+ans2);
		}
    	
	}
}
