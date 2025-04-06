package Maths;

public class NewtonSquareRoot {
	public static void main(String[] args) {

		double n =4;
		System.out.println(newtonRoot(n));
	}
	public static double newtonRoot(double n) {
		double x=n;
		double root ;
		while(true) {
			root= 0.5 * (n+(n/x));
			if(Math.abs(root-x)<0.1) {
				break;
			}
			x=root;
		}
		return root;
	}
	
	
}
