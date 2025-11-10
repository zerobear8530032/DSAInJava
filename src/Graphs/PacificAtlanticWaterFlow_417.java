//417. Pacific Atlantic Water Flow
//Medium
//Topics
//premium lock icon
//Companies
//There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.
//
//The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).
//
//The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.
//
//Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.
//
//
//
//Example 1:
//
//
//Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
//Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
//Explanation: The following cells can flow to the Pacific and Atlantic oceans, as shown below:
//[0,4]: [0,4] -> Pacific Ocean
//       [0,4] -> Atlantic Ocean
//[1,3]: [1,3] -> [0,3] -> Pacific Ocean
//       [1,3] -> [1,4] -> Atlantic Ocean
//[1,4]: [1,4] -> [1,3] -> [0,3] -> Pacific Ocean
//       [1,4] -> Atlantic Ocean
//[2,2]: [2,2] -> [1,2] -> [0,2] -> Pacific Ocean
//       [2,2] -> [2,3] -> [2,4] -> Atlantic Ocean
//[3,0]: [3,0] -> Pacific Ocean
//       [3,0] -> [4,0] -> Atlantic Ocean
//[3,1]: [3,1] -> [3,0] -> Pacific Ocean
//       [3,1] -> [4,1] -> Atlantic Ocean
//[4,0]: [4,0] -> Pacific Ocean
//       [4,0] -> Atlantic Ocean
//Note that there are other possible paths for these cells to flow to the Pacific and Atlantic oceans.
//Example 2:
//
//Input: heights = [[1]]
//Output: [[0,0]]
//Explanation: The water can flow from the only cell to the Pacific and Atlantic oceans.
//
//
//Constraints:
//
//m == heights.length
//n == heights[r].length
//1 <= m, n <= 200
//0 <= heights[r][c] <= 105
package Graphs;

import java.util.*;

public class PacificAtlanticWaterFlow_417 {
//    approch :
//    apply DFS from every cell :
//    and found it reached pacific and atlantic in 2 dfs
//    time complexity : O(m^2⋅n^2)
//    space complexity : O(m*n)
    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        List<List<Integer>> res = new ArrayList<>();
        boolean[][] visitedP = new boolean[m][n];
        boolean[][] visitedA = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int height = heights[i][j];
                if (dfsPacific(heights, i, j, visitedP,height) && dfsAtlantic(heights, i, j, visitedA,height)) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    private static boolean dfsPacific(int[][] heights, int r, int c, boolean[][] visited, int prevHeight) {
        if( r<0 || c<0  || r==heights.length ||c==heights[0].length){return  false;}
        if(heights[r][c]>prevHeight){return  false;}
        if(r==0 || c==0){return  true;}
        if(visited[r][c]){return  false;}
        visited[r][c]=true;
        boolean up = dfsPacific(heights,r-1,c,visited,heights[r][c]);
        boolean down = dfsPacific(heights,r+1,c,visited,heights[r][c]);
        boolean left = dfsPacific(heights,r,c-1,visited,heights[r][c]);
        boolean right = dfsPacific(heights,r,c+1,visited,heights[r][c]);
        visited[r][c]=false;
        return up|| down || left || right;
    }

    private static boolean dfsAtlantic(int[][] heights, int r, int c, boolean[][] visited, int prevHeight) {
        if(r<0 || c<0 ){return  false;}
        if(heights[r][c]>prevHeight){return  false;}
        if(r==heights.length-1 ||c==heights[0].length-1){return  true;}
        if(visited[r][c]){return  false;}
        visited[r][c]=true;
        boolean up = dfsAtlantic(heights,r-1,c,visited,heights[r][c]);
        boolean down = dfsAtlantic(heights,r+1,c,visited,heights[r][c]);
        boolean left = dfsAtlantic(heights,r,c-1,visited,heights[r][c]);
        boolean right = dfsAtlantic(heights,r,c+1,visited,heights[r][c]);
        visited[r][c]=false;
        return up|| down || left || right;
    }
//    approch :
//    we can do reverse from taking dfs from every cell we can  dfs from
//    ocean boundary and expand every where a ocean can go by going on elevated surfaces
//    by this we can do this for atlantic and pacific and can add those which have both as true
//
//    time complexity : O(m⋅n)⋅2=O(m⋅n)
//    space complexity : O(m*n)
    public static List<List<Integer>> pacificAtlanticBetter(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        List<List<Integer>> res = new ArrayList<>();
        boolean [][] reachedAtlanticMap = new boolean[m][n];
        boolean [][] reachedPecificMap = new boolean[m][n];
        boolean [][] visitedA = new boolean[m][n];
//      pecific ocean to othe cells :
//        left boundary
        for(int i =0;i<m;i++){
            dfsPacificBetter(heights,i,0,reachedPecificMap,heights[i][0]);
        }
//        top boundary
        for(int i =0;i<n;i++){
            dfsPacificBetter(heights,0,i,reachedPecificMap,heights[0][i]);
        }

//      atlantic ocean to other cells :
//      bottom boundary
        for(int i =0;i<n;i++){
            dfsAtlanticBetter(heights,m-1,i,reachedAtlanticMap,heights[m-1][i]);
        }
        for(int i =0;i<m;i++){
            dfsAtlanticBetter(heights,i,n-1,reachedAtlanticMap,heights[i][n-1]);
        }
        for(int r =0;r<m;r++){
            for(int c=0;c<n;c++){
                if(reachedPecificMap[r][c] && reachedAtlanticMap[r][c]){
                    res.add(Arrays.asList(r,c));
                }
            }
        }
        return res;
    }

    private static void dfsPacificBetter(int[][] heights, int r, int c,boolean [][] pathMap, int prevHeight) {
        if(r<0 || c<0 || r==heights.length || c==heights[0].length){return ;}
        if(pathMap[r][c]){return;}
        if(prevHeight>heights[r][c]){return;}

        pathMap[r][c]=true;
//          go up :
        dfsPacificBetter(heights,r-1,c,pathMap,heights[r][c]);
//          go down :
        dfsPacificBetter(heights,r+1,c,pathMap,heights[r][c]);
//          go left :
        dfsPacificBetter(heights,r,c-1,pathMap,heights[r][c]);
//          go up :
        dfsPacificBetter(heights,r,c+1,pathMap,heights[r][c]);
    }

    private static void dfsAtlanticBetter(int[][] heights, int r, int c,boolean [][] pathMap, int prevHeight) {
        if(r<0 || c<0 || r==heights.length || c==heights[0].length ){return ;}
        if(pathMap[r][c]){return;}
        if(prevHeight>heights[r][c]){return ;}
        pathMap[r][c]=true;
        dfsAtlanticBetter(heights,r-1,c,pathMap,heights[r][c]);
        dfsAtlanticBetter(heights,r+1,c,pathMap,heights[r][c]);
        dfsAtlanticBetter(heights,r,c-1,pathMap,heights[r][c]);
        dfsAtlanticBetter(heights,r,c+1,pathMap,heights[r][c]);
   }

//    here we just use bfs to implement same logic:
    public static List<List<Integer>> pacificAtlanticBFS(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        String [][] oceanMap = new String[heights.length][heights[0].length];
        bfs(heights,oceanMap,"P");
        bfs(heights,oceanMap,"A");
        for(int i =0;i<oceanMap.length;i++){
            for(int j =0;j<oceanMap[0].length;j++){
                if(oceanMap[i][j]!=null && oceanMap[i][j].equals("PA")){
                    res.add(new ArrayList<>(Arrays.asList(i,j)));
                }
            }
        }

        return res;
    }

    public static void bfs(int [][] heights, String [][] oceanMap,String ocean){
        Queue<int [] > queue = new LinkedList<>();
        if(ocean.equals("P")){
            for(int col=0;col<heights[0].length;col++){
                queue.add(new int [] {0,col});
                if(oceanMap[0][col]==null){
                    oceanMap[0][col]="P";
                }else if(oceanMap[0][col].equals("A")){
                    oceanMap[0][col]="PA";
                }
            }
            for(int row=0;row<heights.length;row++){
                queue.add(new int [] {row,0});
                if(oceanMap[row][0]==null){
                    oceanMap[row][0]="P";
                } else if (oceanMap[row][0].equals("A")) {
                    oceanMap[row][0]="PA";
                }
            }

            // BFS:
            while(!queue.isEmpty()){
                int [] poped= queue.remove();
                int row = poped[0];
                int col = poped[1];
                if(oceanMap[row][col]==null){
                    oceanMap[row][col]="P";
                }else if(oceanMap[row][col].equals("A")){
                    oceanMap[row][col]="PA";
                }
                if(row-1>=0 && heights[row][col]<=heights[row-1][col]  &&  (oceanMap[row-1][col]==null ||  oceanMap[row-1][col].equals("A"))){
                    queue.add(new int []{row-1,col});
                }
                if(row+1<heights.length && heights[row][col]<=heights[row+1][col]  &&  (oceanMap[row+1][col]==null ||  oceanMap[row+1][col].equals("A"))){
                    queue.add(new int []{row+1,col});
                }

                if(col-1>=0 && heights[row][col]<=heights[row][col-1]  &&  (oceanMap[row][col-1]==null ||  oceanMap[row][col-1].equals("A"))){
                    queue.add(new int []{row,col-1});
                }
                if(col+1<heights[0].length && heights[row][col]<=heights[row][col+1]  &&  (oceanMap[row][col+1]==null ||  oceanMap[row][col+1].equals("A"))){
                    queue.add(new int []{row,col+1});
                }
            }
        }
        if(ocean.equals("A")){
            for(int col=0;col<heights[0].length;col++){
                queue.add(new int [] {heights.length-1,col});
                if(oceanMap[heights.length-1][col]==null){
                    oceanMap[heights.length-1][col]="A";
                }else if(oceanMap[heights.length-1][col].equals("P")){
                    oceanMap[heights.length-1][col]="PA";
                }
            }
            for(int row=0;row<heights.length;row++){
                queue.add(new int [] {row,heights[0].length-1});
                if(oceanMap[row][heights[0].length-1]==null){
                    oceanMap[row][heights[0].length-1]="A";
                }else if(oceanMap[row][heights[0].length-1].equals("P")){
                    oceanMap[row][heights[0].length-1]="PA";
                }
            }

            // BFS:
            while(!queue.isEmpty()){
                int [] poped= queue.remove();
                int row = poped[0];
                int col = poped[1];
                if(oceanMap[row][col]==null){
                    oceanMap[row][col]="A";
                }else if(oceanMap[row][col].equals("P")){
                    oceanMap[row][col]="PA";
                }
                if(row-1>=0 && heights[row][col]<=heights[row-1][col]  &&  (oceanMap[row-1][col]==null ||  oceanMap[row-1][col].equals("P"))){
                    queue.add(new int []{row-1,col});
                }
                if(row+1<heights.length && heights[row][col]<=heights[row+1][col]  &&  (oceanMap[row+1][col]==null ||  oceanMap[row+1][col].equals("P"))){
                    queue.add(new int []{row+1,col});
                }

                if(col-1>=0 && heights[row][col]<=heights[row][col-1]  &&  (oceanMap[row][col-1]==null ||  oceanMap[row][col-1].equals("P"))){
                    queue.add(new int []{row,col-1});
                }
                if(col+1<heights[0].length && heights[row][col]<=heights[row][col+1]  &&  (oceanMap[row][col+1]==null ||  oceanMap[row][col+1].equals("P"))){
                    queue.add(new int []{row,col+1});
                }
            }
        }
    }

    public static void main(String[] args) {
        //Example 1:

        int [][] heights1 = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        List<List<Integer>> output1 = new ArrayList<>(Arrays.asList(
                Arrays.asList(0, 4),
                Arrays.asList(1, 3),
                Arrays.asList(1, 4),
                Arrays.asList(2, 2),
                Arrays.asList(3, 0),
                Arrays.asList(3, 1),
                Arrays.asList(4, 0)
        ));

        //Example 2:

        int [][] heights2 = {{1}};
        List<List<Integer>> output2 = new ArrayList<>(Arrays.asList(
                Arrays.asList(0, 0)
        ));

        List<List<Integer>> ans1= pacificAtlanticBetter(heights1);
        List<List<Integer>> ans2= pacificAtlanticBetter(heights2);
        System.out.println(" Brute Force Approch :");

        if(output1.equals(ans1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ output1);
            System.out.println("Your Answer :"+ ans1);
        }

        if(output2.equals(ans2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ output2);
            System.out.println("Your Answer :"+ ans2);
        }

        ans1 = pacificAtlanticBetter(heights1);
        ans2 = pacificAtlanticBetter(heights2);
        System.out.println("Better Approch :");
        if(output1.equals(ans1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ output1);
            System.out.println("Your Answer :"+ ans1);
        }

        if(output2.equals(ans2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ output2);
            System.out.println("Your Answer :"+ ans2);
        }

        ans1 = pacificAtlanticBFS(heights1);
        ans2 = pacificAtlanticBFS(heights2);
        System.out.println("Breadth First Search Approch :");
        if(output1.equals(ans1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ output1);
            System.out.println("Your Answer :"+ ans1);
        }

        if(output2.equals(ans2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ output2);
            System.out.println("Your Answer :"+ ans2);
        }



    }
}
