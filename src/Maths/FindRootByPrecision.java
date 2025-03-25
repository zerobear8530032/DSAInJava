package Maths;

public class FindRootByPrecision {

	public static void main(String[] args) {
		int x =40;
		int p=3;
		System.out.println(root(x,p));

	}
	public static double root(int x, int p) {
		int s=0;
		int e=x;
		double root =0.0;
		while(s<=e) {
			int m = s+(e-s)/2;
			if((m*m)==x) {
				return m;
			}else if(m*m<x) {
				s=m+1;
			}else {
				e=m-1;
			}
		}
		root=e;
		double increment= 0.1;
		for(int i =0;i<p;i++) {
			while(root*root<=x) {
				root+=increment;
			}
			root-=increment;
			increment/=10;
		}
		return root;
		
		
	}

}
