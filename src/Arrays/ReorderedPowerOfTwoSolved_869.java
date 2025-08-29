//869. Reordered Power of 2
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//You are given an integer n. We reorder the digits in any order (including the original order) such that the leading digit is not zero.
//
//Return true if and only if we can do this so that the resulting number is a power of two.
//
//
//
//Example 1:
//
//Input: n = 1
//Output: true
//Example 2:
//
//Input: n = 10
//Output: false
//
//
//Constraints:
//
//1 <= n <= 109
package Arrays;

public class ReorderedPowerOfTwoSolved_869 {

        public static boolean reorderedPowerOf2(int n) {
            int numdigits = (int)Math.log10(n)+1;
            for(int i=0;i<31;i++){
                int x = 1<<i;
                int digits = (int)Math.log10(x)+1;
                // System.out.println(x+" "+digits+"  "+numdigits);
                if(numdigits==digits){
                    if(checkEqual(n,x)){
                        return true;
                    }
                }else if(numdigits<digits){
                    break;
                }
            }
            return false;

        }
        private static boolean checkEqual(int num , int powerOfTwo){
            int [] map = new int [10];
            while(num!=0 || powerOfTwo!=0){
                if(num!=0){
                    int rem = num%10;
                    map[rem]++;
                    num=num/10;
                }
                if(powerOfTwo!=0){
                    int rem = powerOfTwo%10;
                    map[rem]--;
                    powerOfTwo=powerOfTwo/10;
                }
            }
            for(int x:map){
                if(x!=0){return false;}
            }
            return true;
        }

    public static void main(String[] args) {
        //Example 1:

        int n1 = 1;
        boolean output1=true;

        //Example 2:

        int n2 = 10;
        boolean output2=false;

        boolean ans1 = reorderedPowerOf2(n1);
        boolean ans2 = reorderedPowerOf2(n2);


        if(ans1== output1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ (output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(ans2== output2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ (output2));
            System.out.println("Your Answer :"+ (ans2));
        }


    }
}
