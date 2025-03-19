package Patterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {
	public static List<List<Long>>pascalsTriangle(int x) {
		List<List<Long>> ans = new ArrayList<List<Long>>();
		ans.add(new ArrayList(Arrays.asList(1)));
		
		for(long i=1;i<=x;i++) {
			List<Long> row = new ArrayList();
			for(long j=0;j<=i;j++) {
				long e=nCr(i, j);
				row.add(e);
			}
			ans.add(row);
		}
		return ans;
	}
	public static long nCr(long n,long r) {
		 long factn= factorial(n);
		 long factr= factorial(r);
		 long factdif= factorial(n-r);
		 if(factdif==0) {
			 factdif=1;
		 }
		 
		 return factn/(factr*factdif);		 
	}
	public static long factorial(long n) {
		if(n==0) {
			return 1;
		}
		long prod=1;
		
		for(int i=1;i<=n;i++) {
			prod*=i;
		}
		return prod;
		
	}

	public static void main(String[] args) {
		
		int x1=5;
		int x2=14;
		
		System.out.println(pascalsTriangle(x2).get(14));

	}

}
