
package Recursion.learning;

public class RemoveAStringFromString {
	
	public static String removeString(String str, String s) {
		StringBuilder ans= new StringBuilder();
		while(!str.isBlank()) {
			if(str.startsWith(s)) {
				str=str.substring(s.length());
			}else {
				ans.append(str.charAt(0));
				str=str.substring(1);
			}
			
		}
		return ans.toString();
	}
//	recursion:
	public static String removeStringRec(String str1, String str2) {
		StringBuilder res= new StringBuilder();
		removeCharHelper(str1, str2, res);
		return res.toString();
	}
	
	public static void removeCharHelper(String s1, String s2, StringBuilder res) {
		if(s1.length()==0) {
			return ;
		}
		if(s1.startsWith(s2)) {
			removeCharHelper(s1.substring(s2.length()),s2,res);
		}else {
			res.append(s1.charAt(0));
			removeCharHelper(s1.substring(1), s2, res);			
		}
	}
	
	
//	without helper function:
	public static String removeStringRec2(String s1, String s2) {
		if(s1.isBlank()) {
			return "";
		}
		if(s1.startsWith(s2)) {
			return removeStringRec2(s1.substring(s2.length()), s2);
		}else {
			return s1.charAt(0)+removeStringRec2(s1.substring(1),s2);
		}
	}
	
	public static void main(String[] args) {
		
		
		String str1="assappleapplebaaaf";
		String str2="aaaaaa";
		String str3="aanfdjnAaa";

		System.out.println("Iterative Approch :");
		System.out.println(removeString(str1,"apple"));
		System.out.println(removeString(str2,"aaa"));
		System.out.println(removeString(str3,"aa"));
		
		System.out.println("Recursive Approch :");
		System.out.println(removeStringRec(str1, "apple"));
		System.out.println(removeStringRec(str2, "aaa"));
		System.out.println(removeStringRec(str3, "aa"));
		
		System.out.println("Recursive Without Helper Approch :");
		System.out.println(removeStringRec2(str1, "apple"));
		System.out.println(removeStringRec2(str2, "aaa"));
		System.out.println(removeStringRec2(str3, "aa"));
		
	}

}
