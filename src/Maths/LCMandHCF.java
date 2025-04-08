package Maths;

public class LCMandHCF {
	
	
	public static int HCF(int a,int b) {
		if(a==0) return b;
		return HCF(b%a,a);
	}
//	using formula : a*b= lcm*hcf of a,b
//	so for lcm = a*b/hcf(a,b)
	public static int LCM(int a,int b) {
		int hcf= HCF(a,b);
		int prod=a*b;
		return prod/hcf;
	}

	public static void main(String[] args) {

		System.out.println("HCF :");
		System.out.println(HCF(2,5));
		System.out.println(HCF(5,10));
		System.out.println(HCF(10,15));
		System.out.println(HCF(3,10));
		System.out.println("LCM :");
		System.out.println(LCM(2,5));
		System.out.println(LCM(5,10));
		System.out.println(LCM(10,15));
		System.out.println(LCM(3,10));

	}

}
