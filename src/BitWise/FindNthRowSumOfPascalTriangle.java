package BitWise;

public class FindNthRowSumOfPascalTriangle {
//	a pascal triangle have a fomula for each element:
//	nC0 + nC1 + nC2 .... nCn == 2^n
//	we will start at 0 so n = n-1
//	so formula will be 2^n-1;
//	so we need to find this 
	
	
	public static int sumOfRow(int x) {
		return 2<<(x-1);
	}
	public static void main(String[] args) {
		int x1=5;
		int x2=2;
		int x3=6;
		int x4=1;
		
		System.out.println(sumOfRow(x1));
		System.out.println(sumOfRow(x2));
		System.out.println(sumOfRow(x3));
		System.out.println(sumOfRow(x4));
	}

	

}
