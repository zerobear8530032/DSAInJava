//461. Hamming Distance
//Solved
//Easy
//Topics
//Companies
//The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
//
//Given two integers x and y, return the Hamming distance between them.
//
// 
//
//Example 1:
//
//Input: x = 1, y = 4
//Output: 2
//Explanation:
//1   (0 0 0 1)
//4   (0 1 0 0)
//       ↑   ↑
//The above arrows point to positions where the corresponding bits are different.
//Example 2:
//
//Input: x = 3, y = 1
//Output: 1
// 
//
//Constraints:
//
//0 <= x, y <= 231 - 1


package BitWise;
class HammingDistance_461 {
//	brute force approch :
//	convert integer to binary string then just iterate oover that string 
//	and check both index in both number are having same value or not
//	keep count
//	return ans;
//    time complexity :Omax(n.m)
//    space complexity :O(n)
	 public static int hammingDistanceBruteForce(int x, int y) {
         String b1= Integer.toBinaryString(x);
       String b2= Integer.toBinaryString(y);
       int l1=b1.length();
       int l2=b2.length();
       int idx1=l1-1;
       int idx2=l2-1;
       int count=0;
       while(idx1>=0 && idx2>=0){
       	char ch1=b1.charAt(idx1);
       	char ch2=b2.charAt(idx2);
           if(ch1!=ch2){
               count++;
           }
           idx1--;
           idx2--;
       }
       while(idx1>=0){
           if(b1.charAt(idx1)=='1'){
               count++;
           }
           idx1--;
       }
       while(idx2>=0){
           if(b2.charAt(idx2)=='1'){
               count++;
           }
           idx2--;
       }
       return count;
   }
//	Better force approch :
//    we can xor the number and count the bits which are 1
//	return ans;
//    time complexity :O(n)
//    space complexity :O(n)
    public static int hammingDistanceBetter(int x, int y) {
    	int temp=x^y;
    	int count=0;
    	String binary = Integer.toBinaryString(temp);
    	for(int i=0;i<binary.length();i++) {
    		char ch = binary.charAt(i);
    		if(ch=='1') {
    			count++;
    		}
    	}
    	
    	return count;
    }
    
//	Better force approch :
//  we can use xor to get unqiue bits btw each number
//    and we can use lsb formula to find lsb much faster
//	return ans;
//    time complexity :O(Log n)
//    space complexity :O(1)
    
    public static int hammingDistanceBest(int x, int y) {
    	int temp=x^y;
    	int count=0;
    	while(temp!=0) {
    		int bit= temp&(-temp);
    		temp -= bit;
    		count++;
    	}
    	
    	return count;
    }
    
    public static void main(String[] args) {
    	//Example 1:

		int x1=1, y1=4, output1=2;
		
		//Example 2:
		
		int x2=3, y2=1, output2=1;
		
		System.out.println("Brute Force Approch");
		
		int ans1= hammingDistanceBruteForce(x1, y1);
		int ans2= hammingDistanceBruteForce(x2, y2);
		
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
		
		System.out.println("Better Approch :");
		
		ans1=hammingDistanceBetter(x1,y1);
		ans2=hammingDistanceBetter(x2,y2);
		
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
		
		
		System.out.println("Best Approch :");
		
		ans1=hammingDistanceBest(x1,y1);
		ans2=hammingDistanceBest(x2,y2);
		
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
	
	}
}