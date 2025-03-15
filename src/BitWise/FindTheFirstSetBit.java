package BitWise;

public class FindTheFirstSetBit {

	public static int findFirstSetBitFromRight(int x) {
		int count=0;
		if (x==0) return -1;
		if (((x>>1) & 1) ==1 )return 1;
		while(((x>>1)&1)!=1) {
			count++;
			x=x>>1;
		}
		return count+1;
	}
			public static void main(String[] args) {
				int  x1=54;
				int  x2=10;
				int  x3=8;
				System.out.println(findFirstSetBitFromRight(x1));
				System.out.println(findFirstSetBitFromRight(x2));
				
			}


}
