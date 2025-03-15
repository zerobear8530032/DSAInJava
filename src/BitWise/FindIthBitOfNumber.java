package BitWise;

public class FindIthBitOfNumber {

//	 we can use right shift to reduce number 
	
	public static int getIthBitRight(int x, int bit) {
		x= x>> bit-1;
		return x&1;
	}
//	 we can use left  shift to increase 1 to the bit
	
	public static int getIthBitLeft(int x, int bit) {
//		here it return entire value so we convert it in 0 or 1 
		return  (x & (1 << (bit - 1))) != 0 ? 1 : 0;
	}
	public static void main(String[] args) {
		int  x1=54;
		int bit1=6;
		int  x2=10;
		int bit2=4;
		int  x3=54;
		int bit3=1;
		System.out.println("Using Left Shift : ");
		
		System.out.println(getIthBitLeft(x1, bit1));
		System.out.println(getIthBitLeft(x2, bit2));
		System.out.println(getIthBitLeft(x3, bit3));

		System.out.println("Using Right Shift : ");

		System.out.println(getIthBitRight(x1, bit1));
		System.out.println(getIthBitRight(x2, bit2));
		System.out.println(getIthBitRight(x3, bit3));

		
	}

}
