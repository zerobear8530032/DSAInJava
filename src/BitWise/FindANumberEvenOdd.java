package BitWise;

public class FindANumberEvenOdd {

//	why this work:
//	because the number is even or odd is determined by the first bit in binarys
//	called less significant bit it its 1 number is odd other wise even
//	so how to get the first bit :
//	we can just   use bitwise end where 1 & 1= 1  else 0
//	so if we use x & 1 : only the first bit will be 
//	remain 1 rest 0
//	if the first bit it already 0 it will also become 0
	public static void evenOrOdd(int x) {
		if((x & 1)==0) System.out.println("Even");
		if((x & 1)==1) System.out.println("odd");
		
		
	}
	
	public static void main(String[] args) {
		int x1=4;
		int x2=5;
		int x3=10;
		int x4=15;
		
		evenOrOdd(x1);
		evenOrOdd(x2);
		evenOrOdd(x3);
		evenOrOdd(x4);

	}

}
