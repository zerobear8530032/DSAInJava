package BitWise;

public class FindNumberOfSetBits {
//	here we check if  x&1 == 1 this will only give 1 if the current LSB is 1 other wise 0
//	so we can us this and right shift x each iteration untill x !=0
//	time complexity :O(n): n bits
	public static int getSetBits(int x) {
		int c =0;
		while(x!=0) {
			if((x&1)==1) {
				c++;
			}		
			x>>=1;
		}
		return c;
	}
	
//	here we can  use the formula (n & n-1) which give ruight most set bit and we can repeadtedly use it to 
//	get it and count it
//	time complexity :O(n): n bits
	public static int getNumberOfSetBits(int x) {
		int c=0;
		while(x!=0) {
			int setbit = x&(-x);
			c++;
			x-=setbit;
		}
		return c;
		
		
	}
	
	

	
	public static void main(String[] args) {
		int x1 =10;
		int x2 =34;
		int x3 =23;
		int x4 =11;
//		System.out.println(getSetBits(x1));
//		System.out.println(getSetBits(x2));
//		System.out.println(getSetBits(x3));
//		System.out.println(getSetBits(x4));
		
		System.out.println(getNumberOfSetBits(x1));
		System.out.println(getNumberOfSetBits(x2));
		System.out.println(getNumberOfSetBits(x3));
		System.out.println(getNumberOfSetBits(x4));
		
	
		
	}
}

