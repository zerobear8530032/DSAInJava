package Arrays;

import java.util.Arrays;

public class subArrays {
    public static void main(String[] args) {
        int [] nums = {0,1,2,3,4,5};
        // 1  [0]
        // 2  [0,1]
        // 3  [0,1,2]
        // 4  [0,1,2,3]
        // 5 [0,1,2,3,4]
        // 6 [0,1,2,3,4,5]
        //   [1]
        //   [1,2]
        //   [1,2,3]
        //   [1,2,3,4]
        //   [1,2,3,4,5]
        //   [2]
        for(int row =0;row<nums.length;row++){
            for(int col =row;col<nums.length;col++){
                System.out.println(Arrays.toString(Arrays.copyOfRange(nums,row,col)));
            }
        }

    }
}
