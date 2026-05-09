//1861. Rotating the Box
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You are given an m x n matrix of characters boxGrid representing a side-view of a box. Each cell of the box is one of the following:
//
//A stone '#'
//A stationary obstacle '*'
//Empty '.'
//The box is rotated 90 degrees clockwise, causing some of the stones to fall due to gravity. Each stone falls down until it lands on an obstacle, another stone, or the bottom of the box. Gravity does not affect the obstacles' positions, and the inertia from the box's rotation does not affect the stones' horizontal positions.
//
//It is guaranteed that each stone in boxGrid rests on an obstacle, another stone, or the bottom of the box.
//
//Return an n x m matrix representing the box after the rotation described above.
//
// 
//
//Example 1:
//
//
//
//Input: boxGrid = [['#','.','#']]
//Output: [['.'],
//         ['#'],
//         ['#']]
//Example 2:
//
//
//
//Input: boxGrid = [['#','.','*','.'],
//              ['#','#','*','.']]
//Output: [['#','.'],
//         ['#','#'],
//         ['*','*'],
//         ['.','.']]
//Example 3:
//
//
//
//Input: boxGrid = [['#','#','*','.','*','.'],
//              ['#','#','#','*','.','.'],
//              ['#','#','#','.','#','.']]
//Output: [['.','#','#'],
//         ['.','#','#'],
//         ['#','#','*'],
//         ['#','*','.'],
//         ['#','.','*'],
//         ['#','.','.']]
// 
//
//Constraints:
//
//m == boxGrid.length
//n == boxGrid[i].length
//1 <= m, n <= 500
//boxGrid[i][j] is either '#', '*', or '.'.
package Stacks;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

public class RotatingTheBox_1861  {
// we can use a stack to simulte gravity
//    time complexity : O(n*n)
//    space complexity : O(n)
    public static char[][] rotateTheBox(char[][] boxGrid) {
        char [][] res= new char [boxGrid[0].length][boxGrid.length];
        for(int i =0;i<boxGrid.length;i++){
            char [] col = rotate(boxGrid[i]);
            // System.out.println('row : '+i+'  '+Arrays.toString(col));
            fillGrid(boxGrid.length-i-1,col,res);
        }
        return res;
    }

    public static void fillGrid(int col , char [] data, char [][] grid){
        for(int r=0;r<grid.length;r++){
            grid[r][col]=data[r];
        }
    }

    public static String printGrid(char [][] grid){
        StringBuilder str= new StringBuilder('[');
        for(char [] row:grid){
            str.append(Arrays.toString(row)).append(',');
        }
        str.setCharAt(str.length()-1,']');
        return str.toString();
    }

    public static char [] rotate(char [] row ){
        Stack<Character> stk= new Stack();
        for(int i =row.length-1;i>=0;i--){
            // System.out.println(stk+' '+row[i]+' '+i);
            if(row[i]=='.' || row[i]=='*'){
                stk.push(row[i]);
            }else {
                int size=0;
                while(!stk.isEmpty() && stk.peek()=='.') {
                    stk.pop();
                    size++;
                }
                stk.push(row[i]);
                for(int j =0;j<size;j++){
                    stk.push('.');
                }
            }
        }
        char [] res= new char [row.length];
        int idx=0;
        while(!stk.isEmpty()){
            res[idx++]=stk.pop();
        }

        return res;

    }
    public  static  boolean check(char [][] ans, char [][] output){
        if(ans.length!=output.length ){
            return  false;
        }
        for(int i =0;i< ans.length;i++){
            if(!Arrays.equals(ans[i],output[i])){
                return false;
            }
        }


        return true;
    }

    // we can use two pointers to solve this question where we go from right to left
    //  we try to put our right pointer on empty space and swap if with left if it encounter any stone
    //  if their are obstacles we can move right pointer left side
    //    time complexity : O(n*m)
    //    space complexity : O(n)
//    public static char[][] rotateTheBoxBetter(char[][] boxGrid) {
//        char [][] res= new char [boxGrid[0].length][boxGrid.length];
//        for(int i =0;i<boxGrid.length;i++) {
//            for (int j = 0; j < boxGrid[i].length; j++) {
//                res[j][i] = boxGrid[i][j];
//            }
//        }
//        for(int c=0;c<res[0].length;c++){
//            int left = res.length-1;
//            int right = res.length-1;
//            while(right>=0 && res[right][c]!='.'){
//                right--;
//            }
//            left=right;
//            while(left>=0){
//                if(res[left][c]=='#'){
//                    char temp = res[left][c];
//                    res[left][c]= res[right][c];
//                    res[right][c]=temp;
//                    while(right>=0 && res[right][c]!='.'){
//                        right--;
//                    }
//                }
//                left--;
//            }
//        }
//        return res;
//    }
    public static void main(String[] args) {
        //Example 1:

        char [][] boxGrid1 = {{'#','.','#'}};
        char [][] output1= {{'.'},{'#'},{'#'}};
        
        //Example 2:

        char [][] boxGrid2 = {{'#','.','*','.'},{'#','#','*','.'}};
        char [][] output2= {
                {'#','.'},
                {'#','#'},
                {'*','*'},
                {'.','.'}};
        
        //Example 3:


        char [][] boxGrid3 = {
                {'#','#','*','.','*','.'},
                {'#','#','#','*','.','.'},
                {'#','#','#','.','#','.'}
        };
        char [][] output3= {
                {'.', '#', '#'},
                {'.','#','#'}, 
                {'#','#','*'}, 
                {'#','*','.'}, 
                {'#','.','*'}, 
                {'#','.','.'}
        };
        
        //Example 4:
        char [][] boxGrid4 = {
                {'*','#','*','.','.','.','#','.','*','.'}
        };
        char [][] output4= {
                {'*'},
                {'#'},
                {'*'},
                {'.'},
                {'.'},
                {'.'},
                {'.'},
                {'#'},
                {'*'},
                {'.'}
        };

        System.out.println("Brute Force Approch :");
        char [][] ans1= rotateTheBox(boxGrid1);
        char [][] ans2= rotateTheBox(boxGrid2);
        char [][] ans3= rotateTheBox(boxGrid3);
        char [][] ans4= rotateTheBox(boxGrid4);

        if(check(ans1,output1)) {
            System.out.println("Case 1 Passed ");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Excepted Output : "+ printGrid(output1));
            System.out.println("Your Output : "+ printGrid(ans1));
        }
        if(check(ans2,output2)) {
            System.out.println("Case 2 Passed ");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Excepted Output : "+ printGrid(output2));
            System.out.println("Your Output : "+ printGrid(ans2));
        }
        if(check(ans3,output3)) {
            System.out.println("Case 3 Passed ");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Excepted Output : "+ printGrid(output3));
            System.out.println("Your Output : "+ printGrid(ans3));
        }
        if(check(ans4,output4)) {
            System.out.println("Case 4 Passed ");
        }else {
            System.out.println("Case 4 Failed");
            System.out.println("Excepted Output : "+ printGrid(output4));
            System.out.println("Your Output : "+ printGrid(ans4));
        }
//        System.out.println("Better Approch :");
//        ans1= rotateTheBoxBetter(boxGrid1);
//        ans2= rotateTheBoxBetter(boxGrid2);
//        ans3= rotateTheBoxBetter(boxGrid3);
//        ans4= rotateTheBoxBetter(boxGrid4);
//
//        if(check(ans1,output1)) {
//            System.out.println("Case 1 Passed ");
//        }else {
//            System.out.println("Case 1 Failed");
//            System.out.println("Excepted Output : "+ printGrid(output1));
//            System.out.println("Your Output : "+ printGrid(ans1));
//        }
//        if(check(ans2,output2)) {
//            System.out.println("Case 2 Passed ");
//        }else {
//            System.out.println("Case 2 Failed");
//            System.out.println("Excepted Output : "+ printGrid(output2));
//            System.out.println("Your Output : "+ printGrid(ans2));
//        }
//        if(check(ans3,output3)) {
//            System.out.println("Case 3 Passed ");
//        }else {
//            System.out.println("Case 3 Failed");
//            System.out.println("Excepted Output : "+ printGrid(output3));
//            System.out.println("Your Output : "+ printGrid(ans3));
//        }
//        if(check(ans4,output4)) {
//            System.out.println("Case 4 Passed ");
//        }else {
//            System.out.println("Case 4 Failed");
//            System.out.println("Excepted Output : "+ printGrid(output4));
//            System.out.println("Your Output : "+ printGrid(ans4));
//        }

    }
}
