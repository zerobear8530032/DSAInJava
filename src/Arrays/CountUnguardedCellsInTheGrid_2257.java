//2257. Count Unguarded Cells in the Grid
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You are given two integers m and n representing a 0-indexed m x n grid. You are also given two 2D integer arrays guards and walls where guards[i] = [rowi, coli] and walls[j] = [rowj, colj] represent the positions of the ith guard and jth wall respectively.
//
//A guard can see every cell in the four cardinal directions (north, east, south, or west) starting from their position unless obstructed by a wall or another guard. A cell is guarded if there is at least one guard that can see it.
//
//Return the number of unoccupied cells that are not guarded.
//
//
//
//Example 1:
//
//
//Input: m = 4, n = 6, guards = [[0,0],[1,1],[2,3]], walls = [[0,1],[2,2],[1,4]]
//Output: 7
//Explanation: The guarded and unguarded cells are shown in red and green respectively in the above diagram.
//There are a total of 7 unguarded cells, so we return 7.
//Example 2:
//
//
//Input: m = 3, n = 3, guards = [[1,1]], walls = [[0,1],[1,0],[2,1],[1,2]]
//Output: 4
//Explanation: The unguarded cells are shown in green in the above diagram.
//There are a total of 4 unguarded cells, so we return 4.
//
//
//Constraints:
//
//1 <= m, n <= 105
//2 <= m * n <= 105
//1 <= guards.length, walls.length <= 5 * 104
//2 <= guards.length + walls.length <= m * n
//guards[i].length == walls[j].length == 2
//0 <= rowi, rowj < m
//0 <= coli, colj < n
//All the positions in guards and walls are unique.
package Arrays;

public class CountUnguardedCellsInTheGrid_2257 {
//     approch :
//    simulate the process simpley create a 2d matrix form n*m given
//    put the guards and wall cells
//    then check for the path form guard in all directions and mark them
//    the path check will mark path and check the path is obstructed by other guard or wall then we will stop looking ahead
//    if the path is already been looked by a guard so we will not include that cell for other guards and skip over to next one \
//    time complexity : O(n*m)
//    space complexity : O(n*m)
public static int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
    int [][] matrix = new int [m][n];
    for(int [] guard:guards){
        matrix[guard[0]][guard[1]]=1;
    }
    for(int [] wall:walls){
        matrix[wall[0]][wall[1]]=2;
    }
    int guardedcells =0;
    for(int [] guard:guards){
        int protectedcells =checkAllDirections(matrix,guard[0],guard[1]);
        guardedcells+=protectedcells;
    }
    guardedcells+=walls.length;// we need to inlcude the wall seperately here
    return m*n-guardedcells;
}

// this function also include guard cells
    public static int checkAllDirections (int [][] matrix, int r, int c){
        //  check up :
        int up =0;
        for(int i =r-1;i>=0;i--){
            if(matrix[i][c]==0){
                up++;
                matrix[i][c]=-1;
            }else if(matrix[i][c]==-1){
                continue;
            }else{
                break;
            }
        }
        //  check down :
        int down =0;
        for(int i =r+1;i<matrix.length;i++){
            if(matrix[i][c]==0){
                down++;
                matrix[i][c]=-1;
            }else if(matrix[i][c]==-1){
                continue;
            }else{
                break;
            }
        }
        //  check left :
        int left =0;
        for(int i =c-1;i>=0;i--){
            if(matrix[r][i]==0){
                left++;
                matrix[r][i]=-1;
            }else if(matrix[r][i]==-1){
                continue;
            }else{
                break;
            }
        }
        int right=0;
        for(int i =c+1;i<matrix[r].length;i++){
            if(matrix[r][i]==0){
                matrix[r][i]=-1;
                right++;
            }else if(matrix[r][i]==-1){
                continue;
            }else{
                break;
            }
        }
        return left+right+up+down+1;
    }
    public static void main(String[] args) {
        //Example 1:

        int  m1 = 4, n1 = 6;
        int [][] guards1 = {{0,0},{1,1},{2,3}}, walls1 = {{0,1},{2,2},{1,4}};
        int output1= 7;

        //Example 2:

        int  m2 = 3, n2 = 3;
        int [][] guards2 = {{1,1}}, walls2 = {{0,1},{1,0},{2,1},{1,2}};
        int output2= 4;

        int ans1 = countUnguarded(m1,n1,guards1,walls1);
        int ans2 = countUnguarded(m2,n2,guards2,walls2);
        if(output1==(ans1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :"+output1 );
            System.out.println("Your Output :"+ans1);
        }
        if(output2==(ans2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :"+output2 );
            System.out.println("Your Output :"+ans2);
        }


    }
}
