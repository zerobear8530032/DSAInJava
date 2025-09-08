//1317. Convert Integer to the Sum of Two No-Zero Integers
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Hint
//No-Zero integer is a positive integer that does not contain any 0 in its decimal representation.
//
//Given an integer n, return a list of two integers [a, b] where:
//
//a and b are No-Zero integers.
//a + b = n
//The test cases are generated so that there is at least one valid solution. If there are many valid solutions, you can return any of them.
//
//
//
//Example 1:
//
//Input: n = 2
//Output: [1,1]
//Explanation: Let a = 1 and b = 1.
//Both a and b are no-zero integers, and a + b = 2 = n.
//Example 2:
//
//Input: n = 11
//Output: [2,9]
//Explanation: Let a = 2 and b = 9.
//Both a and b are no-zero integers, and a + b = 11 = n.
//Note that there are other valid answers as [8, 3] that can be accepted.
//
//
//Constraints:
//
//2 <= n <= 104
package Arrays;

import java.util.Arrays;

public class ConvertIntegerToTheSumOfTwoNo_ZeroIntegers_1317 {
//  approch :
//    here we can just use a two pointer to keep track of s , e which will sum up to n
//    both at s= 1, e= n we can sum both equal to n means we get our answre
//    we can check the condition it have zero or not
//    if both does not contains zero we can return then as answer
//    time complexity : O(n)
//    space complexity : O(1)
    public static int[] getNoZeroIntegers(int n) {
        int s= 1;
        int e= n;
        while(s<=e){
            int sum = s+e;
            if(sum<n){s++;}
            if(sum>n){e--;}
            if(sum==n){
                if(!checkContainsZero(s) && !checkContainsZero(e)){
                    return new int []{s,e};
                }else{
                    s++;
                    e--;
                }
            }
        }
        return new int []{-1,-1};
    }
    public static boolean checkContainsZero(int x){
        while(x!=0){
            if(x%10 ==0){return  true;}
            x=x/10;
        }
        return false;
    }

// more consice approch :
//    here we can just use a single pointer to keep track of n , n-i which will sum up to n
//    if both does not contains zero we can return then as answer
//    time complexity : O(n)
//    space complexity : O(1)
    public static int[] getNoZeroIntegersBetter(int n) {
        for(int i =1;i<=n;i++){
            if(!checkContainsZero(i) && !checkContainsZero(n-i)){
                return new int [] {i,n-i};
            }
        }
        return new int [] {-1,-1};
    }

    public static void main(String[] args) {
//        Example 1 :
        int n1= 2;

//        Example 2 :
        int n2=11;

//        Example 3 :
        int n3=1000;

        int []ans1= getNoZeroIntegers(n1);
        int []ans2= getNoZeroIntegers(n2);
        int []ans3= getNoZeroIntegers(n3);

        if(Arrays.stream(ans1).sum()==n1) {
            System.out.println("Case 1 Passed ");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Excepted Output : a+b="+ n1);
            System.out.println("Your Output : "+ Arrays.toString(ans1));
        }
        if(Arrays.stream(ans2).sum()==n2) {
            System.out.println("Case 2 Passed ");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Excepted Output : a+b="+ n2);
            System.out.println("Your Output : "+ Arrays.toString(ans2));
        }
        if(Arrays.stream(ans3).sum()==n3) {
            System.out.println("Case 3 Passed ");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Excepted Output : a+b="+ n3);
            System.out.println("Your Output : "+ Arrays.toString(ans3));
        }

    }


}
