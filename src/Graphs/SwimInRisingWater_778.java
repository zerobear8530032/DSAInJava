//778. Swim in Rising Water
//Solved
//Hard
//Topics
//premium lock icon
//Companies
//Hint
//You are given an n x n integer matrix grid where each value grid[i][j] represents the elevation at that point (i, j).
//
//It starts raining, and water gradually rises over time. At time t, the water level is t, meaning any cell with elevation less than equal to t is submerged or reachable.
//
//You can swim from a square to another 4-directionally adjacent square if and only if the elevation of both squares individually are at most t. You can swim infinite distances in zero time. Of course, you must stay within the boundaries of the grid during your swim.
//
//Return the minimum time until you can reach the bottom right square (n - 1, n - 1) if you start at the top left square (0, 0).
//
//
//
//Example 1:
//
//
//Input: grid = [[0,2],[1,3]]
//Output: 3
//Explanation:
//At time 0, you are in grid location (0, 0).
//You cannot go anywhere else because 4-directionally adjacent neighbors have a higher elevation than t = 0.
//You cannot reach point (1, 1) until time 3.
//When the depth of water is 3, we can swim anywhere inside the grid.
//Example 2:
//
//
//Input: grid = [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
//Output: 16
//Explanation: The final route is shown.
//We need to wait until time 16 so that (0, 0) and (4, 4) are connected.
//
//
//Constraints:
//
//n == grid.length
//n == grid[i].length
//1 <= n <= 50
//0 <= grid[i][j] < n2
//Each value grid[i][j] is unique.
package Graphs;

import java.util.PriorityQueue;

public class SwimInRisingWater_778 {

//     approch : use a bfs traversal to find the minimum path using a priority queue
//    here we go form 0,0 and add all adjecent cell in priority queue the cells will be added as i,j,time entry
//    where the time is the Math.max of current time and nextCell time
//    and the priority queue will be sorted as increasing order by time
//    important note the cell will be marked visited when we poped them not when we push them cause we
//    process then after we poped them
//    time complexity : O(n*m)
//    space complexity : O(n*m)
    class Entry implements Comparable<Entry> {
        int row;
        int col;
        int time;

        public Entry(int r, int c, int time) {
            this.row = r;
            this.col = c;
            this.time = time;
        }

        public int compareTo(Entry obj) {
            return this.time - obj.time;
        }

        public String toString() {
            return "[ROW :" + row + " , COL :" + col + " , TIME : " + time + " ]";
        }
    }

    public int swimInWater(int[][] grid) {
            PriorityQueue<Entry> queue = new PriorityQueue<>();
            int grow = grid.length;
            int gcol = grid[0].length;
            boolean[][] visited = new boolean[grow][gcol];
            Entry first = new Entry(0, 0, grid[0][0]);
            queue.add(first);
            while (!queue.isEmpty()) {
                Entry poped = queue.poll();
                int row = poped.row;
                int col = poped.col;
                int time = poped.time;
                if (visited[row][col]) {
                    continue;
                } // skip already visited cells
                else {
                    visited[row][col] = true;
                } // other wise we mark it as visited
                if (row - 1 >= 0) {// upside
                    queue.add(new Entry(row - 1, col, Math.max(time, grid[row - 1][col])));
                }
                if (row + 1 < grid.length) {// down
                    queue.add(new Entry(row + 1, col, Math.max(time, grid[row + 1][col])));
                }
                if (col - 1 >= 0) {// left side
                    queue.add(new Entry(row, col - 1, Math.max(time, grid[row][col - 1])));
                }
                if (col + 1 < grid.length) {// right side
                    queue.add(new Entry(row, col + 1, Math.max(time, grid[row][col + 1])));
                }
                if (row == grow - 1 && col == gcol - 1) {
                    return time;
                }
            }
            return -1;
        }

    public static void main(String[] args) {
        //Example 1:

        int [][] grid1 = {{0,2},{1,3}};
        int output1= 3;

        //Example 2:

        int [][] grid2 = {{0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}};
        int output2= 16;

    }
}
