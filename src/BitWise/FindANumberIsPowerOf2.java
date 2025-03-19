package BitWise;

public class FindANumberIsPowerOf2 {
	
	
//	here each power 2 is in binary have only 1 single bit which is 1 
//	so we can left shift it continusly and check how many bits are there
//	time complexity : Log(n)
//	space complexity : Log(1)
	
	public static boolean isPowerTwo(int x) {
		int c=0;
		while(x!=0) {
			
			if((x & 1)==1) {
				c++;
			}
			if(c>1) {
				return false;
			}
			x=(x>>1);
		}
		return c ==1 ;
	}
//	here each power 2 is in binary have only 1 single bit which is 1 
//	so if we substract it with n-1 
//	let say 8 =  100 
//	100 -1 = 011
//	now if we and 011 & 100 : it will alwayys give 0 
//	if its a mutiple of 2
//	example 10 :
//	10= 1010
//	1010-1: 1001
//	1010 & 1001 = 1000
//	which is not 0 its 8 so we can say it works
//	there is one edge case the input will be 0 then output should be false
//	time complexity :O(1)
//	space complexity :O(1)
	public static boolean isPowerTwo2(int x) {
		return (x==0) ? false : (x&(x-1))==0;
	}

	public static void main(String[] args) {
		int x1=2;
		int x2=4;
		int x3=16;
		int x4=10;
		int x5=31;
		
		System.out.println(10&9);
		
		System.out.println(isPowerTwo(x1));
		System.out.println(isPowerTwo(x2));
		System.out.println(isPowerTwo(x3));
		System.out.println(isPowerTwo(x4));
		System.out.println(isPowerTwo(x5));
//		
		System.out.println("constant time solution");
		
		System.out.println(isPowerTwo2(x1));
		System.out.println(isPowerTwo2(x2));
		System.out.println(isPowerTwo2(x3));
		System.out.println(isPowerTwo2(x4));
		System.out.println(isPowerTwo2(x5));

	}

}
