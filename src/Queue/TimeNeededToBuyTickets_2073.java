//2073. Time Needed to Buy Tickets
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Hint
//There are n people in a line queuing to buy tickets, where the 0th person is at the front of the line and the (n - 1)th person is at the back of the line.
//
//You are given a 0-indexed integer array tickets of length n where the number of tickets that the ith person would like to buy is tickets[i].
//
//Each person takes exactly 1 second to buy a ticket. A person can only buy 1 ticket at a time and has to go back to the end of the line (which happens instantaneously) in order to buy more tickets. If a person does not have any tickets left to buy, the person will leave the line.
//
//Return the time taken for the person initially at position k (0-indexed) to finish buying tickets.
//
//
//
//Example 1:
//
//Input: tickets = [2,3,2], k = 2
//
//Output: 6
//
//Explanation:
//
//The queue starts as [2,3,2], where the kth person is underlined.
//After the person at the front has bought a ticket, the queue becomes [3,2,1] at 1 second.
//Continuing this process, the queue becomes [2,1,2] at 2 seconds.
//Continuing this process, the queue becomes [1,2,1] at 3 seconds.
//Continuing this process, the queue becomes [2,1] at 4 seconds. Note: the person at the front left the queue.
//Continuing this process, the queue becomes [1,1] at 5 seconds.
//Continuing this process, the queue becomes [1] at 6 seconds. The kth person has bought all their tickets, so return 6.
//Example 2:
//
//Input: tickets = [5,1,1,1], k = 0
//
//Output: 8
//
//Explanation:
//
//The queue starts as [5,1,1,1], where the kth person is underlined.
//After the person at the front has bought a ticket, the queue becomes [1,1,1,4] at 1 second.
//Continuing this process for 3 seconds, the queue becomes [4] at 4 seconds.
//Continuing this process for 4 seconds, the queue becomes [] at 8 seconds. The kth person has bought all their tickets, so return 8.
//
//
//Constraints:
//
//n == tickets.length
//1 <= n <= 100
//1 <= tickets[i] <= 100
//0 <= k < n
package Queue;

import java.util.PriorityQueue;

public class TimeNeededToBuyTickets_2073 {
//    approch :
//    we know the person before k is always buy their tickets first
//    and all the rest after that are gonnabuy ticket[k]-1 tickets
//    so we can say we can add the person tikcets which are smaller then kth person
//    if the ith person have more tickets to buy it will jhust add equal to kth person
//    and after k it remains same here just the thing is we add kth personticket-1
//    time complexity : o(n)
//    space complexity : o(1)
    public static int timeRequiredToBuy(int[] tickets, int k) {
        int time =0;
        int needed= tickets[k];
        for(int i=0;i<=k;i++){
            if(tickets[i]>=needed){
                time+= needed;
            }else{
                time+= tickets[i];
            }
        }
        for(int i=k+1;i<tickets.length;i++){
            if(tickets[i]>=needed){
                time+=needed-1;
            }else{
                time+=tickets[i];
            }
        }
        return time;
    }
    public static void main(String[] args) {
        //Example 1:

        int [] tickets1 = {2,3,2};
        int k1 = 2;
        int output1= 6;

        //Example 2:

        int [] tickets2 = {5,1,1,1};
        int k2=0;
        int output2= 8;

       int ans1 = timeRequiredToBuy(tickets1,k1);
       int ans2 = timeRequiredToBuy(tickets2,k2);
        if(output1== ans1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ (output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(output2== ans2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ (output2));
            System.out.println("Your Answer :"+ (ans2));
        }




    }
}
