//118. Pascal's Triangle
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Given an integer numRows, return the first numRows of Pascal's triangle.
//
//In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
//
//
//
//
//Example 1:
//
//Input: numRows = 5
//Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
//Example 2:
//
//Input: numRows = 1
//Output: [[1]]
//
//
//Constraints:
//
//1 <= numRows <= 30
package DynamicProgramming;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class PascalTriangleSolved_118 {
//    approch :
//    we can see how each value of row is just previous values
//    we can simulate is by taking previous row and using that value index
//    to calculate the next row values its just prev row idx + prev row idx-1
//
//    time complexity : O(n*n)
//    space complexity : O(n*n)
        public static  List<List<Integer>> generate(int numRows) {
            List<List<Integer>> res = new ArrayList();
            if (numRows == 0) {
                return res;
            }
            res.add(new ArrayList(Arrays.asList(1)));// default 1 row available
            for (int i = 1; i < numRows; i++) {
                List<Integer> currrow = new ArrayList();
                List<Integer> prevrow = res.get(i - 1);
                for(int j = 0; j < prevrow.size() + 1; j++) {
                    int curridx = j;
                    int previdx = j - 1;
                    int currval = 0;
                    int prevval = 0;
                    if (curridx < prevrow.size()) {
                        currval = prevrow.get(curridx);
                    }
                    if (previdx >= 0) {
                        prevval = prevrow.get(previdx);
                    }
                    currrow.add(currval + prevval);
                }
                res.add(currrow);
            }
            return res;
        }

    public static void main(String[] args) {

        //Example 1:

        int  numRows1 = 5;
        List<List<Integer>> output1= new ArrayList<>(Arrays.asList(
           Arrays.asList(1),Arrays.asList(1,1),Arrays.asList(1,2,1),Arrays.asList(1,3,3,1),Arrays.asList(1,4,6,4,1)
        ));

        //Example 2:

        int  numRows2 = 1;
        List<List<Integer>> output2= new ArrayList<>(Arrays.asList(
                Arrays.asList(1)
        ));

        List<List<Integer>> ans1 = generate(numRows1);
        List<List<Integer>> ans2 = generate(numRows2);

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


    }
}
