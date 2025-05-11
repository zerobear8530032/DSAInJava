package Recursion.learning;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	
	public static void printAllPermutation(String str) {		
		 permutationHelper("",str);
	}
	public static void permutationHelper(String p, String unp) {
		if(unp.isBlank()) {
			System.out.println(p);
			return ;
		}
		for(int i =0;i<=p.length();i++) {
			String s=p.substring(0,i);
			char m = unp.charAt(0);
			String e=p.substring(i);
			String processed= s+m+e;
			String unprocessed= unp.substring(1);
			permutationHelper(processed,unprocessed);
		}
	}

	public static List<String> getAllPermutation(String str) {		
		return permutationHelper2("",str);
	}
	public static List<String> permutationHelper2(String p,String unp){
		if(unp.isBlank()) {
			List<String> list= new ArrayList();
			list.add(p);
			return list;
		}
		List<String> res= new ArrayList();
		for(int i =0;i<=p.length();i++) {
			String s=p.substring(0,i);
			char m = unp.charAt(0);
			String e=p.substring(i);
			String processed= s+m+e;
			String unprocessed= unp.substring(1);
			List<String> permutation= permutationHelper2(processed,unprocessed);
			res.addAll(permutation);
		}
		return res;
	}
	
	
	public static int permutationCount(String p, String unp) {
		if(unp.isBlank()) {
			return 1;
		}
		int count =0;
		for(int i =0;i<=p.length();i++) {
			String s=p.substring(0,i);
			char m = unp.charAt(0);
			String e=p.substring(i);
			String processed= s+m+e;
			String unprocessed= unp.substring(1);
			count=count+ permutationCount(processed,unprocessed);
		}
		return count;
	}
	
	public static void main(String[] args) {

		String str1 = "abc";
		String str2 = "ABC";
		String str3 = "abcde";

//		printAllPermutation(str1);
//		printAllPermutation(str2);
//		printAllPermutation(str3);
//		
		
//		System.out.println(getAllPermutation(str1));
//		System.out.println(getAllPermutation(str2));
//		System.out.println(getAllPermutation(str3));
		
		System.out.println(permutationCount("",str1));
		System.out.println(permutationCount("",str2));
		System.out.println(permutationCount("",str3));
		
		
		
	}

}
