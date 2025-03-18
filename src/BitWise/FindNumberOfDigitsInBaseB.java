package BitWise;

public class FindNumberOfDigitsInBaseB {
	
//	using repeated division :
//	
	public static int numberOfDigitsInBase(int x,int b) {
		int digit=0;
		while(x!=0) {
			x/=b;
			digit++;
		}
		return digit;
				
	}
	
//	using fromula: log base b (x)
//	
	public static int numberOfDigitsInBaseFormula(int x,int b) {
		
		return (int)(Math.log(x)/Math.log(b))+1;
		 
	}

	public static void main(String[] args) {
		int x1 =10,  b1= 2;
		int x2 =5,  b2= 8;
		int x3 =10,  b3= 3;
		
		System.out.println(numberOfDigitsInBase(x1, b1));
		System.out.println(numberOfDigitsInBase(x2, b2));
		System.out.println(numberOfDigitsInBase(x3, b3));
		System.out.println(numberOfDigitsInBaseFormula(x1, b1));
		System.out.println(numberOfDigitsInBaseFormula(x2, b2));
		System.out.println(numberOfDigitsInBaseFormula(x3, b3));

		
	}

}
