//2075. Decode the Slanted Ciphertext
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//A string originalText is encoded using a slanted transposition cipher to a string encodedText with the help of a matrix having a fixed number of rows rows.
//
//originalText is placed first in a top-left to bottom-right manner.
//
//
//The blue cells are filled first, followed by the red cells, then the yellow cells, and so on, until we reach the end of originalText. The arrow indicates the order in which the cells are filled. All empty cells are filled with ' '. The number of columns is chosen such that the rightmost column will not be empty after filling in originalText.
//
//encodedText is then formed by appending all characters of the matrix in a row-wise fashion.
//
//
//The characters in the blue cells are appended first to encodedText, then the red cells, and so on, and finally the yellow cells. The arrow indicates the order in which the cells are accessed.
//
//For example, if originalText = "cipher" and rows = 3, then we encode it in the following manner:
//
//
//The blue arrows depict how originalText is placed in the matrix, and the red arrows denote the order in which encodedText is formed. In the above example, encodedText = "ch ie pr".
//
//Given the encoded string encodedText and number of rows rows, return the original string originalText.
//
//Note: originalText does not have any trailing spaces ' '. The test cases are generated such that there is only one possible originalText.
//
//
//
//Example 1:
//
//Input: encodedText = "ch   ie   pr", rows = 3
//Output: "cipher"
//Explanation: This is the same example described in the problem description.
//Example 2:
//
//
//Input: encodedText = "iveo    eed   l te   olc", rows = 4
//Output: "i love leetcode"
//Explanation: The figure above denotes the matrix that was used to encode originalText.
//The blue arrows show how we can find originalText from encodedText.
//Example 3:
//
//
//Input: encodedText = "coding", rows = 1
//Output: "coding"
//Explanation: Since there is only 1 row, both originalText and encodedText are the same.
//
//
//Constraints:
//
//0 <= encodedText.length <= 106
//encodedText consists of lowercase English letters and ' ' only.
//encodedText is a valid encoding of some originalText that does not have trailing spaces.
//1 <= rows <= 1000
//The testcases are generated such that there is only one possible originalText.
package Strings;

public class DecodeTheSlantedCiphertext_2075 {
//    approch : simulate the process by building grid and traverse the grid to build the string
//    time complexity : O(n)
//    space complexity : O(n)
    public static String decodeCiphertext(String encodedText, int rows) {
        if(rows==1 || encodedText.isBlank()){return encodedText;}
        // create the matrix :
        int cols = encodedText.length()/rows;
        char [][] matrix= new char [rows][cols];
        int idx=0;

        StringBuilder res = new StringBuilder();
        for(int r=0;r<matrix.length;r++){
            for(int c =0;c<matrix[r].length;c++){
                matrix[r][c]=encodedText.charAt(idx++);
            }
        }
        for(int c=0;c<matrix[0].length;c++){
            for(int i =0;i<matrix.length;i++){
                if(i+c<matrix[0].length){
                    res.append(matrix[i][i+c]);
                }
            }
        }
        return res.toString().stripTrailing();
    }


    public static void main(String[] args) {
        //Example 1:

        String  encodedText1 = "ch   ie   pr";
        int rows1 = 3;
        String output1= "cipher";

        //Example 2:

        String  encodedText2 = "iveo    eed   l te   olc";
        int rows2 = 4;
        String output2= "i love leetcode";

        //Example 3:

        String  encodedText3 = "coding";
        int rows3 = 1;
        String output3= "coding";


        String ans1 = decodeCiphertext(encodedText1,rows1);
        String ans2 = decodeCiphertext(encodedText2,rows2);
        String ans3 = decodeCiphertext(encodedText3,rows3);




        if(ans1.equals(output1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :"+output1 );
            System.out.println("Your Output :"+ans1);
        }
        if(ans2.equals(output2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :"+output2 );
            System.out.println("Your Output :"+ans2);
        }

        if(ans3.equals(output3)) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Actual Output :"+output3 );
            System.out.println("Your Output :"+ans3);
        }


    }
}
