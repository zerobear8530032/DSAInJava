package Backtracking;

class Solution {
    public static int maxPathScore(int[][] grid, int k) {
        return helper(grid,0,0,0,k,0);
    }

    public  static int helper(int [][] grid, int r,int c , int currCost, int maxCost,int score){
        if(maxCost<currCost || r==grid.length || c== grid[0].length){
            return -1;
        }
        if(r==grid.length-1 && c==grid[0].length-1){
            return score+grid[r][c];
        }
        int res= Integer.MIN_VALUE;
        if(r+1<grid.length && grid[r+1][c]==0){
            int ans=helper(grid,r+1,c,currCost,maxCost,score+grid[r][c]);
            res=Math.max(res,ans);
        }else if(r+1<grid.length && grid[r+1][c]!=0){
            int ans=helper(grid,r+1,c,currCost+1,maxCost,score+grid[r][c]);
            res=Math.max(res,ans);
        }
        if(c+1<grid[0].length && grid[r][c+1]==0){
            int ans=helper(grid,r,c+1,currCost,maxCost,score+grid[r][c]);
            res=Math.max(res,ans);
        }else if(c+1<grid[0].length && grid[r][c+1]!=0){
            int ans=helper(grid,r,c+1,currCost+1,maxCost,score+grid[r][c]);
            res=Math.max(res,ans);
        }
        return res;
    }

    public static void main(String[] args) {
        int [][] grid1 = {{0, 1},{2, 0}};
        int k1 = 1, output1=2 ;

        int [][] grid2 = {{0, 1},{1, 2}};
        int k2 = 1, output2=-1 ;

        int ans1= maxPathScore(grid1,k1);
        int ans2= maxPathScore(grid2,k1);

        System.out.println(ans1);
        System.out.println(ans2);


    }
}