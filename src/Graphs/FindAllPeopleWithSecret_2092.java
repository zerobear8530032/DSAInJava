//2092. Find All People With Secret
//Solved
//Hard
//Topics
//premium lock icon
//Companies
//Hint
//You are given an integer n indicating there are n people numbered from 0 to n - 1. You are also given a 0-indexed 2D integer array meetings where meetings[i] = [xi, yi, timei] indicates that person xi and person yi have a meeting at timei. A person may attend multiple meetings at the same time. Finally, you are given an integer firstPerson.
//
//Person 0 has a secret and initially shares the secret with a person firstPerson at time 0. This secret is then shared every time a meeting takes place with a person that has the secret. More formally, for every meeting, if a person xi has the secret at timei, then they will share the secret with person yi, and vice versa.
//
//The secrets are shared instantaneously. That is, a person may receive the secret and share it with people in other meetings within the same time frame.
//
//Return a list of all the people that have the secret after all the meetings have taken place. You may return the answer in any order.
//
//
//
//Example 1:
//
//Input: n = 6, meetings = [[1,2,5],[2,3,8],[1,5,10]], firstPerson = 1
//Output: [0,1,2,3,5]
//Explanation:
//At time 0, person 0 shares the secret with person 1.
//At time 5, person 1 shares the secret with person 2.
//At time 8, person 2 shares the secret with person 3.
//At time 10, person 1 shares the secret with person 5.​​​​
//Thus, people 0, 1, 2, 3, and 5 know the secret after all the meetings.
//Example 2:
//
//Input: n = 4, meetings = [[3,1,3],[1,2,2],[0,3,3]], firstPerson = 3
//Output: [0,1,3]
//Explanation:
//At time 0, person 0 shares the secret with person 3.
//At time 2, neither person 1 nor person 2 know the secret.
//At time 3, person 3 shares the secret with person 0 and person 1.
//Thus, people 0, 1, and 3 know the secret after all the meetings.
//Example 3:
//
//Input: n = 5, meetings = [[3,4,2],[1,2,1],[2,3,1]], firstPerson = 1
//Output: [0,1,2,3,4]
//Explanation:
//At time 0, person 0 shares the secret with person 1.
//At time 1, person 1 shares the secret with person 2, and person 2 shares the secret with person 3.
//Note that person 2 can share the secret at the same time as receiving it.
//At time 2, person 3 shares the secret with person 4.
//Thus, people 0, 1, 2, 3, and 4 know the secret after all the meetings.
//
//
//Constraints:
//
//2 <= n <= 105
//1 <= meetings.length <= 105
//meetings[i].length == 3
//0 <= xi, yi <= n - 1
//xi != yi
//1 <= timei <= 105
//1 <= firstPerson <= n - 1
package Graphs;
import java.util.*;
public class FindAllPeopleWithSecret_2092 {
// apprch :
//  we need to group same time meeting together
//  then we need to divide metting in component where
//    nowe can pass secret to each person where even a single person know secret
//    time complexity : O(n log n)
//    space complexity : O(n)
    public static List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        TreeMap<Integer, List<int[]>> timeMap = new TreeMap();
        List<Integer> res = new ArrayList();
        boolean[] knownSecret = new boolean[n];
        knownSecret[0] = true;
        knownSecret[firstPerson] = true;
//        group by timing
        for (int[] meeting : meetings) {
            timeMap.computeIfAbsent(meeting[2],k->new ArrayList<>()).add(meeting);
        }
        for (Map.Entry<Integer, List<int[]>> entry : timeMap.entrySet()) {
            // int time = entry.getKey();
            List<int[]> meetingGroups = entry.getValue();
            Map<Integer, List<Integer>> graph = new HashMap<>();
            for (int[] m : meetingGroups) {
                graph.computeIfAbsent(m[0], k -> new ArrayList<>()).add(m[1]);
                graph.computeIfAbsent(m[1], k -> new ArrayList<>()).add(m[0]);
            }
            HashSet<Integer> visited= new HashSet();
            for (int person : graph.keySet()) {
                if(visited.contains(person)){continue;}
                Queue<Integer> queue = new ArrayDeque<>();
                List<Integer> connected= new ArrayList();
                boolean hasSecret= false;
                queue.add(person);
                visited.add(person);
                while(!queue.isEmpty()){
                    int poped= queue.poll();
                    connected.add(poped);
                    if(knownSecret[poped]){hasSecret=true;}
                    for(int neighbour:graph.get(poped)){
                        if (!visited.contains(neighbour)) {
                            visited.add(neighbour);
                            queue.add(neighbour);
                        }
                    }
                }
                for(int x:connected){
                    knownSecret[x]=hasSecret;
                }
            }

        }

        for(int i=0;i<n;i++){
            if(knownSecret[i]){
                res.add(i);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        //Example 1:

        int n1 = 6;
        int [][]meetings1 = {{1,2,5},{2,3,8},{1,5,10}};
        int firstPerson1 = 1;
        List<Integer> output1= new ArrayList<>(Arrays.asList(0,1,2,3,5));

        //Example 2:

        int n2 = 4;
        int [][]meetings2 = {{3,1,3},{1,2,2},{0,3,3}};
        int firstPerson2 = 3;
        List<Integer> output2= new ArrayList<>(Arrays.asList(0,1,3));

        //Example 3:

        int n3 = 5;
        int [][]meetings3 = {{3,4,2},{1,2,1},{2,3,1}};
        int firstPerson3 = 1;
        List<Integer> output3= new ArrayList<>(Arrays.asList(0,1,2,3,4));

        List<Integer> ans1=findAllPeople(n1,meetings1,firstPerson1);
        List<Integer> ans2=findAllPeople(n2,meetings2,firstPerson2);
        List<Integer> ans3=findAllPeople(n3,meetings3,firstPerson3);



        if(output1.equals(ans1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :"+output1 );
            System.out.println("Your Output :"+ans1);
        }
        if(output2.equals(ans2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :"+output2 );
            System.out.println("Your Output :"+ans2);
        }
        if(output3.equals(ans3)) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Actual Output :"+output3 );
            System.out.println("Your Output :"+ans3);
        }


    }
}
