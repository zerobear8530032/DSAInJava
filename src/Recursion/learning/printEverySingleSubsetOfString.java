package Recursion.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class printEverySingleSubsetOfString {
	
	public static List<String> printSubsetRec(String str) {
		List<String> ans= new ArrayList();
		subsethelper("",str,ans);
		return ans;
	}
	
	public static void subsethelper(String p ,String unp,List<String> subset) {
		if(unp.isBlank()) {
			subset.add(p);
			return ;
		}else {
			char ch = unp.charAt(0);
			subsethelper(p+ch,unp.substring(1),subset);
			subsethelper(p,unp.substring(1),subset);
		}
		
	}
	
	
	public static List<String> printSubsetRec2(String str) {
		return  subsethelper2("",str);
	}
	public static List<String> subsethelper2(String p ,String unp) {
		if(unp.isBlank()) {
			return new ArrayList(Arrays.asList(p));
		}
			char ch = unp.charAt(0);
			List<String> left=subsethelper2(p+ch,unp.substring(1));
			List<String> right=subsethelper2(p,unp.substring(1));
			
			List<String > ans = new ArrayList<String>();
			ans.addAll(left);
			ans.addAll(right);
			return ans;
		
	}
	public static void main(String[] args) {
		
		String str1= "abc";
		String str2= "abcde";
		String str3= "123";
	
		System.out.println(printSubsetRec(str1));
		System.out.println(printSubsetRec(str2));
		System.out.println(printSubsetRec(str3));
		
		System.out.println(printSubsetRec2(str1));
		System.out.println(printSubsetRec2(str2));
		System.out.println(printSubsetRec2(str3));
		
	}

}
