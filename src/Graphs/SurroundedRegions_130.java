//130. Surrounded Regions
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:
//
//Connect: A cell is connected to adjacent cells horizontally or vertically.
//Region: To form a region connect every 'O' cell.
//Surround: The region is surrounded with 'X' cells if you can connect the region with 'X' cells and none of the region cells are on the edge of the board.
//To capture a surrounded region, replace all 'O's with 'X's in-place within the original board. You do not need to return anything.
//
// 
//
//Example 1:
//
//Input: board = [['X','X','X','X'],['X','O','O','X'],['X','X','O','X'],['X','O','X','X']]
//
//Output: [['X','X','X','X'],['X','X','X','X'],['X','X','X','X'],['X','O','X','X']]
//
//Explanation:
//
//
//In the above diagram, the bottom region is not captured because it is on the edge of the board and cannot be surrounded.
//
//Example 2:
//
//Input: board = [['X']]
//
//Output: [['X']]
//
// 
//
//Constraints:
//
//m == board.length
//n == board[i].length
//1 <= m, n <= 200
//board[i][j] is 'X' or 'O'.
package Graphs;

import java.util.Arrays;

public class SurroundedRegions_130 {
//    approch : go check every border and try to mark all O connected with the o at borders
//    this allow us to identiyf whuch are not surrounded :
//    time compelxity : O(n*m*s)
//    space compelxity : O(n*m);

    public static void solve(char[][] board){
        int rows= board.length;
        int cols= board[0].length;
        for(int c=0;c<cols;c++){
            if(board[0][c]=='O'){
                markDFS(board,0,c);
            }
        }
        for(int c=0;c<cols;c++){
            if(board[rows-1][c]=='O'){
                markDFS(board,rows-1,c);
            }
        }
        for(int r=0;r<rows;r++){
            if(board[r][0]=='O'){
                markDFS(board,r,0);
            }
        }
        for(int r=0;r<rows;r++){
            if(board[r][cols-1]=='O'){
                markDFS(board,r,cols-1);
            }
        }

        for(int i =0;i<rows;i++){
            for(int j =0;j<cols;j++){
                if(board[i][j]=='#'){
                    board[i][j]='O';
                }else{
                    board[i][j]='X';
                }
            }
        }
    }

    public static void markDFS(char [][] board, int row , int col){
        if(row<0 || col<0 || row==board.length || col== board[0].length){
            return ;
        }
        if(board[row][col]!='O'){
            return ;
        }
        board[row][col]='#';

        // up :
        markDFS(board,row-1,col);
        // down :
        markDFS(board,row+1,col);
        // left :
        markDFS(board,row,col-1);
        // right :
        markDFS(board,row,col+1);
    }

    public static boolean check(char [][] ans,char [][]output) {
        if(ans.length!=output.length) {
            return false;
        }
        for(int i=0;i<ans.length;i++) {
            if(ans[i].length!=output[i].length){return false;}
            for(int j=0;j<ans[i].length;j++){
                if(ans[i][j]!=output[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    public static String printMatrix(char [][] matrix){
        StringBuilder res= new StringBuilder("[");
        for (char [] row:matrix){
            res.append("\n").append(Arrays.toString(row));
        }
        res.append("]");
        return res.toString();
    }
    public static void main(String[] args) {
        //Example 1:

        char [][] board1 = {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}};
        char [][] output1 = {
                {'X','X','X','X'},
                {'X','X','X','X'},
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X'}};

        //Example 2:

        char [][] board2 = {{'X'}};
        char [][] output2 = {{'X'}};


        solve(board1);
        solve(board2);


        if(check(board1,output1)) {
            System.out.println("Case 1 Passed ");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Excepted Output : "+ printMatrix(output1));
            System.out.println("Your Output : "+ printMatrix(board1));
        }
        if(check(board2,output2)) {
            System.out.println("Case 2 Passed ");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Excepted Output : "+ printMatrix(output2));
            System.out.println("Your Output : "+ printMatrix(board2));
        }







    }
}
