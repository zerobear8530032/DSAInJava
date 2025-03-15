package BitWise;

public class ResetIthBittoZero {
//			 we can use left  shift to increase 1 to the bit
//		and apply or function that will chnage the i th bit to 1 if its 0
//	we can get the i th bit left shit and by complement of that i th bit 
//	we can apply &
			public static int setIthBitLeft(int x, int bit) {
				int onebit = 1<< bit-1;
				onebit= ~onebit;
				return x & onebit;
				
			}
			public static void main(String[] args) {
				int  x1=54;
				int bit1=6;
				int  x2=10;
				int bit2=3;
				int  x3=54;
				int bit3=1;
				System.out.println("Using Left Shift : ");
				
				System.out.println(setIthBitLeft(x1, bit1));
				System.out.println(setIthBitLeft(x2, bit2));
				System.out.println(setIthBitLeft(x3, bit3));


				
			}



}
