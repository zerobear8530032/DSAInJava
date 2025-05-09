
package Recursion.learning;

public class RemoveACharacterFromString {
	
	public static String removeCharacter(String str, char ch) {
		StringBuilder res= new StringBuilder();
		for(int i =0;i<str.length();i++) {
			char c= str.charAt(i);
			if(ch==c) continue;
			res.append(c);
		}
		return res.toString();
	}
//	recursion:
	public static String removeCharacterRec(String str, char ch) {
		StringBuilder res= new StringBuilder();
		removeCharHelper(0,str, ch, res);
		return res.toString();
	}
	
	public static void removeCharHelper(int index,String str, char ch , StringBuilder res) {
		if(index==str.length()) {
			return ;
		}
		if(str.charAt(index)==ch) {
			removeCharHelper(index+1, str, ch, res);
		}else {
			res.append(str.charAt(index));
			removeCharHelper(index+1, str, ch, res);			
		}
	}
	
	
//	without helper function:
	public static String removeCharacterRec2(String str, char ch) {
		if(str.length()==0) {
			return "";
		}
		if(str.charAt(0)==ch) {
			return removeCharacterRec2(str.substring(1), ch);
		}else {
			return str.charAt(0)+removeCharacterRec2(str.substring(1), ch);
		}
	}
	
	public static void main(String[] args) {
		
		
		String str1="assbaaaf";
		String str2="aaaaaa";
		String str3="aanfdjnAa";

		System.out.println("Iterative Approch :");
		System.out.println(removeCharacter(str1, 'a'));
		System.out.println(removeCharacter(str2, 'a'));
		System.out.println(removeCharacter(str3, 'A'));
		
		System.out.println("Recursive Approch :");
		System.out.println(removeCharacterRec(str1, 'a'));
		System.out.println(removeCharacterRec(str2, 'a'));
		System.out.println(removeCharacterRec(str3, 'A'));
		
		System.out.println("Recursive Without Helper Approch :");
		System.out.println(removeCharacterRec2(str1, 'a'));
		System.out.println(removeCharacterRec2(str2, 'a'));
		System.out.println(removeCharacterRec2(str3, 'A'));
		
	}

}
