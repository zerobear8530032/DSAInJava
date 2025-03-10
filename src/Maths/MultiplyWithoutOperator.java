package Maths;
import java.util.*;
import java.lang.*;
import java.io.*;
public class MultiplyWithoutOperator {

	    public static int multiply(int x, int y){
	    	int sum=0;
	        if(x<y){
	            for(int i=0;i<x;i++){
	                sum=sum+y;
	            }
	            return x;
	        }else{
	            for(int i=0;i<y;i++){
	                sum=sum+x;
	            }
	            return sum;
	        }
	    }
	    public static int factorial(int x) {
	        if (x==0) return 1;
	    	int prod=x;
		    
	        for(int i=1;i<x;i++){
		    	prod=multiply(prod, i);
		    }
		    return prod;
	    }
	    
		public static void main (String[] args) throws java.lang.Exception
		{
			

			    int x1= 9,output1=362880;
			    int x2=5,output2=120;
			   
		    	int ans1= factorial(x1);
				int ans2= factorial(x2);
				
				if(ans1==output1) {
					System.out.println("Case 1 Passed ");
				}else {
					System.out.println("Case 1 Failed");
					System.out.println("Excepted Output : "+ (output1));
					System.out.println("Your Output : "+ (ans1));
				}
				if(ans2==output2) {
					System.out.println("Case 2 Passed ");
				}else {
					System.out.println("Case 2 Failed");
					System.out.println("Excepted Output : "+ output2);
					System.out.println("Your Output : "+ ans2);
				}
			    
			    
				    
		}

}
