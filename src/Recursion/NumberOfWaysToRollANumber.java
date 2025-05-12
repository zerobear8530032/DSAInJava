// we are given a number we have to find howmany ways we can roll that number

package Recursion;

import java.util.ArrayList;
import java.util.List;

public class NumberOfWaysToRollANumber {
	
	
	static int count=0;
	public static int rollCount(int n) {
		 rollCountHelper("",n);
		 return count;
	}
	
	public static void rollCountHelper(String p,int target) {
		if(target==0) {
			System.out.print(p+",");
			return ;
		}
		for(int i =1;i<=6;i++) {
			String process=p+i ;
			if(i>target) {
				continue;
			}
			rollCountHelper(process,target-i);
		}
	}
	
	public static int rollCountRet(int n) {
		rollCountHelper("",n);
		return count;
	}
	
	public static List<String> rollCountHelperRet(String p,int target) {
		if(target==0) {
			List<String> res= new ArrayList();
			res.add(p);
			
			return res;
		}
		
		List<String> res= new ArrayList();
		for(int i =1;i<=6;i++) {
			String process=p+i ;
			if(i>target) {
				continue;
			}
			res.addAll(rollCountHelperRet(process,target-i));
		}
		return res;
		
	}
	
	public static List<String> rollCountHelperRetFace(String p,int target,  int face) {
		if(target==0) {
			List<String> res= new ArrayList();
			res.add(p);
			
			return res;
		}
		
		List<String> res= new ArrayList();
		for(int i =1;i<=face;i++) {
			String process=p+i ;
			if(i>target) {
				continue;
			}
			res.addAll(rollCountHelperRetFace(process,target-i,face));
		}
		return res;
		
	}
	
	public static void main(String[] args) {
		
		int n1 =1;
		int n2 =2;
		int n3 =3;
		int n4 =4;
		int n5 =5;
		int n6 =6;
		
		for(int i =0;i<=6;i++) {
			System.out.println(rollCountHelperRetFace("",10,2));
		}
		
	}

}
