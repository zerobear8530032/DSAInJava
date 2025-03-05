

package Maths;
class CountTotalNumberOfColoredCells_2579{
//	here we first find the pattern whichs :
//	that each time we increase 1 row the next row 
//	have n+2 cells so we just use that concept 
//	but because it have 2 sides we will use 2 loops 
//	time complexity :2*O(n)
//	space complexity :O(1)

	public static long coloredCellsBruteForce(int n) {
		 long ans =0;
	    	for(int i =0;i<n-1;i++) {
				ans=ans+ (i*2+1);
			}
			for(int i =0;i<n-1;i++) {
				ans=ans+ (i*2+1);
			}  
	        ans=ans+(n-1)*2+1;
	        return ans;
		
		
	}
//	here we first find the pattern whichs :
//	that each time we increase 1 row the next row 
//	have n+2 cells so we just use that concept 
//	but because it have 2 sides we will use 2 loops 
//	time complexity :O(n)
//	space complexity :O(1)
    public static long coloredCellsBetter(int n) {
    	long ans =0;
    	for(int i =0;i<n-1;i++) {
    		ans=ans+ (i*2+1)*2;
    	}
    	ans=ans+((n-1)*2+1);    	
        return ans;
    }
//	here we first find the pattern whichs :
//  we are just suming odd numbers from 
//    so we just need a sum of odd number from 1 till n-2
//    + n-1 th odd number + 1 till n-2
//	time complexity :O(1)
//	space complexity :O(1)
    public static long coloredCellsBest(int n) {

//    	return n*n+ (n-1)*(n-1); this one liner is the answer but it can over flow the integer
    	 long ans =(long) n*(long)n;
         ans= ans+ (long)(n-1)*(long)(n-1);
           return ans; 
    }
    
    public static void main(String[] args) {
    	
    	
    	int n1=1;
    	int output1= 1;
    	int n2=2;
    	int output2= 5;
    	int n3=3;
    	int output3= 13;
    	int n4=4;
    	int output4= 25;
    	
    	
    	long ans1=coloredCellsBruteForce(n1);
		long ans2=coloredCellsBruteForce(n2);
		long ans3=coloredCellsBruteForce(n3);
		long ans4=coloredCellsBruteForce(n4);
		
		System.out.println("brute Force Approch :");
		
		if(output1==ans1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output :"+output1 );
			System.out.println("Your Output :"+ans1);
		}
		if(output2==ans2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Actual Output :"+output2 );
			System.out.println("Your Output :"+ans2);
		}
		if(output3==ans3) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Actual Output :"+output3 );
			System.out.println("Your Output :"+ans3);
		}
		if(output4==ans4) {
			System.out.println("Case 4 Passed");
		}else {
			System.out.println("Case 4 Failed");
			System.out.println("Actual Output :"+output4 );
			System.out.println("Your Output :"+ans4);
		}
		
		
		
		System.out.println("Better Approch :");
		
		ans1=coloredCellsBetter(n1);
		ans2=coloredCellsBetter(n2);
		ans3=coloredCellsBetter(n3);
		ans4=coloredCellsBetter(n4);
		
		if(output1==ans1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output :"+output1 );
			System.out.println("Your Output :"+ans1);
		}
		if(output2==ans2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Actual Output :"+output2 );
			System.out.println("Your Output :"+ans2);
		}
		if(output3==ans3) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Actual Output :"+output3 );
			System.out.println("Your Output :"+ans3);
		}
		if(output4==ans4) {
			System.out.println("Case 4 Passed");
		}else {
			System.out.println("Case 4 Failed");
			System.out.println("Actual Output :"+output4 );
			System.out.println("Your Output :"+ans4);
		}
	
		System.out.println("Best approch :");
		ans1=coloredCellsBest(n1);
		ans2=coloredCellsBest(n2);
		ans3=coloredCellsBest(n3);
		ans4=coloredCellsBest(n4);
		if(output1==ans1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output :"+output1 );
			System.out.println("Your Output :"+ans1);
		}
		if(output2==ans2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Actual Output :"+output2 );
			System.out.println("Your Output :"+ans2);
		}
		if(output3==ans3) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Actual Output :"+output3 );
			System.out.println("Your Output :"+ans3);
		}
		if(output4==ans4) {
			System.out.println("Case 4 Passed");
		}else {
			System.out.println("Case 4 Failed");
			System.out.println("Actual Output :"+output4 );
			System.out.println("Your Output :"+ans4);
		}
    
    	
	}
    
}