package BitWise;

public class FindAPowerB {
	
//	public static int getAPowerB(int x, int p) {
//		int ans=1;
//		for(int i =0;i<p;i++) {
//			ans*=x;
//		}
//		return ans;
//	}
	
	
//	how this woorks:
//	we see the bit which are set and only then we are updating answer as answer * base
//	other wise we can just do base * base 
//	time complexity : O(log b) or log power 
//	s complexity : O(1) 
	public static int getAPowerB(int x, int p) {
		int base = x;
		int ans =1;
		while(p!=0) {
			if((p&1)==1) {
				ans=ans*base;
			}
			base=base*base;
			p=p>>1;
		}
		return ans;
	}
	
	public static void main(String[] args) {
		
		int a1=5,b1=2; 
		int a2=2,b2=4; 
		int a3=3,b3=3; 
		int a4=4,b4=7; 
		
		System.out.println(getAPowerB(a1, b1));
		System.out.println(getAPowerB(a2, b2));
		System.out.println(getAPowerB(a3, b3));
		System.out.println(getAPowerB(a4, b4));
		
	}

}
