//1882. Process Tasks Using Servers
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You are given two 0-indexed integer arrays servers and tasks of lengths n​​​​​​ and m​​​​​​ respectively. servers[i] is the weight of the i​​​​​​th​​​​ server, and tasks[j] is the time needed to process the j​​​​​​th​​​​ task in seconds.
//
//Tasks are assigned to the servers using a task queue. Initially, all servers are free, and the queue is empty.
//
//At second j, the jth task is inserted into the queue (starting with the 0th task being inserted at second 0). As long as there are free servers and the queue is not empty, the task in the front of the queue will be assigned to a free server with the smallest weight, and in case of a tie, it is assigned to a free server with the smallest index.
//
//If there are no free servers and the queue is not empty, we wait until a server becomes free and immediately assign the next task. If multiple servers become free at the same time, then multiple tasks from the queue will be assigned in order of insertion following the weight and index priorities above.
//
//A server that is assigned task j at second t will be free again at second t + tasks[j].
//
//Build an array ans​​​​ of length m, where ans[j] is the index of the server the j​​​​​​th task will be assigned to.
//
//Return the array ans​​​​.
//
//
//
//Example 1:
//
//Input: servers = [3,3,2], tasks = [1,2,3,2,1,2]
//Output: [2,2,0,2,1,2]
//Explanation: Events in chronological order go as follows:
//- At second 0, task 0 is added and processed using server 2 until second 1.
//- At second 1, server 2 becomes free. Task 1 is added and processed using server 2 until second 3.
//- At second 2, task 2 is added and processed using server 0 until second 5.
//- At second 3, server 2 becomes free. Task 3 is added and processed using server 2 until second 5.
//- At second 4, task 4 is added and processed using server 1 until second 5.
//- At second 5, all servers become free. Task 5 is added and processed using server 2 until second 7.
//Example 2:
//
//Input: servers = [5,1,4,3,2], tasks = [2,1,2,4,5,2,1]
//Output: [1,4,1,4,1,3,2]
//Explanation: Events in chronological order go as follows:
//- At second 0, task 0 is added and processed using server 1 until second 2.
//- At second 1, task 1 is added and processed using server 4 until second 2.
//- At second 2, servers 1 and 4 become free. Task 2 is added and processed using server 1 until second 4.
//- At second 3, task 3 is added and processed using server 4 until second 7.
//- At second 4, server 1 becomes free. Task 4 is added and processed using server 1 until second 9.
//- At second 5, task 5 is added and processed using server 3 until second 7.
//- At second 6, task 6 is added and processed using server 2 until second 7.
//
//
//Constraints:
//
//servers.length == n
//tasks.length == m
//1 <= n, m <= 2 * 105
//1 <= servers[i], tasks[j] <= 2 * 105
package heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ProcessTasksUsingServers_1882 {
   static class Server{
        int weight;
        int index;
        int freeAt;

        Server(int w , int i , int f){
            weight=w;
            index=i;
            freeAt=f;
        }
    }
//    approch :
//    here we put free server in priority queue where it sorted by weight , index
//    when we assign task to them we put them in workingserver with the current time + task time as free time
//    and every time we check first are their any working server which can be free other wise use current available server
//    if no available servers are their just use the working server which is most eligible and update time and push it back agian
//    time complexity : N log N
//    space complexity : N  + M
    public static int[] assignTasks(int[] servers, int[] tasks) {

        PriorityQueue<Server> freeServers = new PriorityQueue<>((s1, s2)->{
            if(s1.weight!=s2.weight){
                return s1.weight-s2.weight;
            }
            return s1.index-s2.index;
        });
        for(int i=0;i<servers.length;i++){
            freeServers.add(new Server(servers[i],i,0));
        }
        PriorityQueue<Server> workingServers = new PriorityQueue<>((s1,s2)->{
            if(s1.freeAt!=s2.freeAt){
                return s1.freeAt-s2.freeAt;
            }
            if(s1.weight!=s2.weight){
                return s1.weight-s2.weight;
            }
            return s1.index-s2.index;
        });
        int time =0;
        int [] output= new int [tasks.length];
        for(int i =0;i<tasks.length;i++){
            time =Math.max(time,i);
            while(!workingServers.isEmpty() && workingServers.peek().freeAt<=time){
                Server s= workingServers.poll();
                freeServers.add(s);
            }
            if(!freeServers.isEmpty()){
                Server s= freeServers.poll();
                s.freeAt= time+tasks[i];
                workingServers.add(s);
                output[i]= s.index;
            }else{
                Server s= workingServers.poll();
                time= s.freeAt;
                s.freeAt+=tasks[i];
                workingServers.add(s);
                output[i]=s.index;
            }
        }
        return output;
    }

    public static void main(String[] args) {
        int[] servers1 = new int[]{5, 1, 4, 3, 2};
        int[] tasks1 = new int[]{2, 1, 2, 4, 5, 2, 1};
        int [] output1= {1,4,1,4,1,3,2};

        int[] servers2 = new int[]{3, 3, 2};
        int[] tasks2 = new int[]{1, 2, 3, 2, 1, 2};
        int [] output2={2,2,0,2,1,2};

        int [] ans1= assignTasks(servers1,tasks1);
        int []ans2= assignTasks(servers2,tasks2);


        if(Arrays.equals(ans1,output1)) {
            System.out.println("Case 1 Passed ");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Excepted Output : "+ Arrays.toString(output1));
            System.out.println("Your Output : "+ Arrays.toString(ans1));
        }
        if(Arrays.equals(ans2,output2)) {
            System.out.println("Case 2 Passed ");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Excepted Output : "+ Arrays.toString(output2));
            System.out.println("Your Output : "+ Arrays.toString(ans2));
        }

    }
}
