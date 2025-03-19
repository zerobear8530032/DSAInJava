package BitWise;

public class FindXORTillNthNumber {
	
	public static int getXOR(int x) {
		int ans=0;
		for(int i =1;i<=x;i++) {
			ans^=i;
		}
		return ans;
	}
	
//	try patter:
	
	public static int getIthXOR(int x) {
		int mod = x%4;
		if(mod==0) {
			return x;
		}else if(mod==1) {
			return 1;
		}else if(mod==2) {
			return x+1;
		}else {
			return 0;
		}
		
	}
	
	
	public static int getXORInRange(int a, int b) {
//		WE NEED A FUNCTION WHICH CAN GIVE XOR FROM 0 TILL A
// we can say we take  XOR from  0 till a-1 and 0 till b:
//		then we remove the part from 0 till a-1 from 0 till b
		int omitted = getIthXOR(a-1);
		int entire = getIthXOR(b);
		return omitted^entire;
	}
		public static void main(String[] args) {
//		System.out.println(getIthXOR(2));
//		System.out.println(getXOR(2));
//		System.out.println(getIthXOR(24));
//		System.out.println(getXOR(24));
		
		
	System.out.println(getXORInRange(10,100));
		

	}

}
