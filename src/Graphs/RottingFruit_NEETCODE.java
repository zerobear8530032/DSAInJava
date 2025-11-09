package Graphs;
import java.util.*;
class RottingFruit_NEETCODE {
    public static int orangesRotting(int[][] grid) {
        Queue<int []> queue = new LinkedList();
        int nonRotten=0;
        boolean isEmpty=true;
        for(int i =0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    queue.add(new int [] {i,j});
                    isEmpty=false;
                }
                if(grid[i][j]==1){
                    nonRotten++;
                    isEmpty=false;
                }
            }
        }
        if(isEmpty){return 0;}
        int step=0;
        while(!queue.isEmpty()){
            int size =queue.size();
            step++;
            for(int i=0;i<size;i++){
                int [] poped=queue.remove();
                int row = poped[0];
                int col = poped[1];
                if(row-1>=0 && grid[row-1][col]!=2 && grid[row-1][col]!=0){
                    queue.add(new int []{row-1,col});
                    grid[row-1][col]=2;// apply rotten
                    nonRotten--;
                    
                }
                if(row+1<grid.length && grid[row+1][col]!=2 && grid[row+1][col]!=0){
                    queue.add(new int []{row+1,col});
                    grid[row+1][col]=2;// apply rotten
                    nonRotten--;
                    
                }
                if(col-1>=0 && grid[row][col-1]!=2 && grid[row][col-1]!=0){
                    queue.add(new int []{row,col-1});
                    grid[row][col-1]=2;// apply rotten
                    nonRotten--;
                    
                }
                if(col+1<grid[0].length && grid[row][col+1]!=2 && grid[row][col+1]!=0){
                    queue.add(new int []{row,col+1});
                    grid[row][col+1]=2;// apply rotten
                    nonRotten--;
                }
            }
        }
        
        return nonRotten>0?-1:step-1;
    }

    public static void main(String[] args) {
        // Example 1:
        int [][] grid1 = {{1,1,0},{0,1,1},{0,1,2}};
        int output1= 4;

        // Example 2:


        int [][] grid2 = {{1,0,1},{0,2,0},{1,0,1}};
        int output2= -1;

        int ans1=  orangesRotting(grid1);
        int ans2=  orangesRotting(grid2);


        if(output1==ans1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+(output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(output2==ans2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+(output2));
            System.out.println("Your Answer :"+ (ans2));
        }



    }
}
