//119. Pascal's Triangle II
//Easy
//Topics
//premium lock icon
//Companies
//Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
//
//In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
//
//
//
//
//Example 1:
//
//Input: rowIndex = 3
//Output: [1,3,3,1]
//Example 2:
//
//Input: rowIndex = 0
//Output: [1]
//Example 3:
//
//Input: rowIndex = 1
//Output: [1,1]
//
//
//Constraints:
//
//0 <= rowIndex <= 33
//
//
//Follow up: Could you optimize your algorithm to use only O(rowIndex) extra space?

package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Pascal_sTriangleII_119 {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList();
        int[] arr1 = new int[rowIndex + 1];
        int[] arr2 = new int[rowIndex + 1];
        arr1[0] = 1;
        for (int i = 1; i <=rowIndex; i++) {
            for(int j =0;j<i+1;j++){
                int n1= j-1>=0?arr1[j-1]:0;
                int n2= j<arr1.length?arr1[j]:0;
                arr2[j]=n1+n2;
            }
//            swap;
            int [] temp= arr1;
            arr1=arr2;
            arr2=temp;
        }
        for(int x:arr1){
            res.add(x);
        }
        return res;
    }


    public static void main(String[] args) {
        //Example 1:

        int rowIndex1 = 3;
        List<Integer> output1 = new ArrayList<>(Arrays.asList(1, 3, 3, 1));

        //Example 2:

        int rowIndex2 = 0;
        List<Integer> output2 = new ArrayList<>(Arrays.asList(1));

        //Example 3:

        int rowIndex3 = 1;
        List<Integer> output3 = new ArrayList<>(Arrays.asList(1, 1));

        List<Integer> ans1=getRow(rowIndex1);
        List<Integer> ans2=getRow(rowIndex2);
        List<Integer> ans3=getRow(rowIndex3);

        if(output1.equals(ans1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :"+output1 );
            System.out.println("Your Output :"+ans1);
        }
        if(output2.equals(ans2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :"+output2 );
            System.out.println("Your Output :"+ans2);
        }
        if(output3.equals(ans3)) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Actual Output :"+output3 );
            System.out.println("Your Output :"+ans3);
        }
    }
}