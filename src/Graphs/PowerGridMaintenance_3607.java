//3607. Power Grid Maintenance
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You are given an integer c representing c power stations, each with a unique identifier id from 1 to c (1‑based indexing).
//
//These stations are interconnected via n bidirectional cables, represented by a 2D array connections, where each element connections[i] = [ui, vi] indicates a connection between station ui and station vi. Stations that are directly or indirectly connected form a power grid.
//
//Initially, all stations are online (operational).
//
//You are also given a 2D array queries, where each query is one of the following two types:
//
//[1, x]: A maintenance check is requested for station x. If station x is online, it resolves the check by itself. If station x is offline, the check is resolved by the operational station with the smallest id in the same power grid as x. If no operational station exists in that grid, return -1.
//
//[2, x]: Station x goes offline (i.e., it becomes non-operational).
//
//Return an array of integers representing the results of each query of type [1, x] in the order they appear.
//
//Note: The power grid preserves its structure; an offline (non‑operational) node remains part of its grid and taking it offline does not alter connectivity.
//
//
//
//Example 1:
//
//Input: c = 5, connections = [[1,2],[2,3],[3,4],[4,5]], queries = [[1,3],[2,1],[1,1],[2,2],[1,2]]
//
//Output: [3,2,3]
//
//Explanation:
//
//
//
//Initially, all stations {1, 2, 3, 4, 5} are online and form a single power grid.
//Query [1,3]: Station 3 is online, so the maintenance check is resolved by station 3.
//Query [2,1]: Station 1 goes offline. The remaining online stations are {2, 3, 4, 5}.
//Query [1,1]: Station 1 is offline, so the check is resolved by the operational station with the smallest id among {2, 3, 4, 5}, which is station 2.
//Query [2,2]: Station 2 goes offline. The remaining online stations are {3, 4, 5}.
//Query [1,2]: Station 2 is offline, so the check is resolved by the operational station with the smallest id among {3, 4, 5}, which is station 3.
//Example 2:
//
//Input: c = 3, connections = [], queries = [[1,1],[2,1],[1,1]]
//
//Output: [1,-1]
//
//Explanation:
//
//There are no connections, so each station is its own isolated grid.
//Query [1,1]: Station 1 is online in its isolated grid, so the maintenance check is resolved by station 1.
//Query [2,1]: Station 1 goes offline.
//Query [1,1]: Station 1 is offline and there are no other stations in its grid, so the result is -1.
//
//
//Constraints:
//
//1 <= c <= 105
//0 <= n == connections.length <= min(105, c * (c - 1) / 2)
//connections[i].length == 2
//1 <= ui, vi <= c
//ui != vi
//1 <= queries.length <= 2 * 105
//queries[i].length == 2
//queries[i][0] is either 1 or 2.
//1 <= queries[i][1] <= c
package Graphs;

import java.util.*;

public class PowerGridMaintenance_3607 {
//    approch :
//    we can use a hashamp to create a adjecency list of key value pair for connection as a map
//    then we can use dfs to create components  which are the treeset / sorted sets
//    after this we can just create a mapping of which station belongs to which component
//    by this we can find wheather the component is onlin of offline and from the component mapping we can remove it
//    from the component to make it offline
//    or to resolve query for offline components we can see which component it belongs and find the first element of sorted set
//    and append as result
//    time complexity : O((c+Q)*logc)
//    space complexity : O(c+n)

    public static int[] processQueries(int c, int[][] connections, int[][] queries){
        HashMap<Integer, HashSet<Integer>> conMap = new HashMap<>();
        boolean[] status = new boolean[c];
        // build connection map :
        for (int i = 0; i < connections.length; i++) {
            int[] conn = connections[i];
            if (conMap.containsKey(conn[0])) {
                conMap.get(conn[0]).add(conn[1]);
                if(conMap.containsKey(conn[1])){
                    conMap.get(conn[1]).add(conn[0]);
                }else{
                    HashSet<Integer> stations = new HashSet();
                    stations.add(conn[0]);
                    conMap.put(conn[1],stations );
                }
            } else {
                HashSet<Integer> stations = new HashSet();
                stations.add(conn[1]);
                conMap.put(conn[0], stations);
                if(conMap.containsKey(conn[1])){
                    conMap.get(conn[1]).add(conn[0]);
                }else{
                    HashSet<Integer> station = new HashSet();
                    stations.add(conn[0]);
                    conMap.put(conn[1],stations );
                }
            }
        }
        List<TreeSet<Integer>> grids = new ArrayList<>();
        int [] gridToStation= new int [c+1];
        HashSet<Integer> processed= new HashSet();
        for (int origin = 1; origin <= c; origin++) {
            if (!processed.contains(origin)) {
                HashSet<Integer> grid = new HashSet();
                dfs(conMap, origin, grid);
                TreeSet<Integer> sortedGrid  = new TreeSet();
                for(int x:grid){
                    gridToStation[x]=grids.size();
                    sortedGrid.add(x);
                    processed.add(x);
                }
                grids.add(sortedGrid);
            }
        }
        // now we can process queries :
        List<Integer> proxyRes= new ArrayList();
        for(int [] query:queries){
            int station= query[1];
            if(query[0]==1){
                if(!status[station-1]){
                    proxyRes.add(station);
                }else{
                    int gridIdx=gridToStation[station];
                    TreeSet<Integer> grid= grids.get(gridIdx);
                    if(grid.size()==0){
                        proxyRes.add(-1);
                    }else{
                        proxyRes.add(grid.getFirst());
                    }
                }
            }else{
                status[station-1]=true;
                int gridIdx=gridToStation[station];
                TreeSet<Integer> grid= grids.get(gridIdx);
                grid.remove(station);
            }
        }
        int [] res = new int [proxyRes.size()];
        for(int i =0;i<res.length;i++){
            res[i]= proxyRes.get(i);
        }
        return res;
    }

    public static void dfs(HashMap<Integer, HashSet<Integer>> conMap, int origin, HashSet<Integer> path) {
        if(!conMap.containsKey(origin)){
            path.add(origin);
            return ;
        }
        if (path.contains(origin)) {
            return;
        }
        HashSet<Integer> paths = conMap.get(origin);
        path.add(origin);
        for (int x : paths) {
            dfs(conMap, x, path);
        }

    }



    public static void main(String[] args) {
        //Example 1:

        int  c1 = 5;
        int [][] connections1 = {{1,2},{2,3},{3,4},{4,5}}, queries1 = {{1,3},{2,1},{1,1},{2,2},{1,2}};
        int [] output1= {3,2,3};

        //Example 2:

        int  c2 = 3;
        int [][] connections2 = {}, queries2 = {{1,1},{2,1},{1,1}};
        int [] output2= {1,-1};

        int [] ans1 = processQueries(c1,connections1,queries1);
        int [] ans2 = processQueries(c2,connections2,queries2);


        if(Arrays.equals(output1,ans1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :"+Arrays.toString(output1) );
            System.out.println("Your Output :"+Arrays.toString(ans1));
        }
        if(Arrays.equals(output2,ans2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :"+Arrays.toString(output2) );
            System.out.println("Your Output :"+Arrays.toString(ans2));
        }

    }
}
