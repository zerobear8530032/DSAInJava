//933. Number of Recent Calls
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//You have a RecentCounter class which counts the number of recent requests within a certain time frame.
//
//Implement the RecentCounter class:
//
//RecentCounter() Initializes the counter with zero recent requests.
//int ping(int t) Adds a new request at time t, where t represents some time in milliseconds, and returns the number of requests that has happened in the past 3000 milliseconds (including the new request). Specifically, return the number of requests that have happened in the inclusive range [t - 3000, t].
//It is guaranteed that every call to ping uses a strictly larger value of t than the previous call.
//
// 
//
//Example 1:
//
//Input
//["RecentCounter", "ping", "ping", "ping", "ping"]
//[[], [1], [100], [3001], [3002]]
//Output
//[null, 1, 2, 3, 3]
//
//Explanation
//RecentCounter recentCounter = new RecentCounter();
//recentCounter.ping(1);     // requests = [1], range is [-2999,1], return 1
//recentCounter.ping(100);   // requests = [1, 100], range is [-2900,100], return 2
//recentCounter.ping(3001);  // requests = [1, 100, 3001], range is [1,3001], return 3
//recentCounter.ping(3002);  // requests = [1, 100, 3001, 3002], range is [2,3002], return 3
// 
//
//Constraints:
//
//1 <= t <= 109
//Each test case will call ping with strictly increasing values of t.
//At most 104 calls will be made to ping.


package Queue;
import java.util.*;
public class NumberOfRecentCalls_933 {
	
//	approch :
// in this question we are given time on which a request will come and we have to give return
//	the number of request in 3000ms 
//	so we will use a queue 
//	when ever a request comes lesser then 3000 we can just add to the queue
//	when its greater then 3000 we will find request time t - 3000
//	that will give us the range in which each request we have server in 3000ms
//	so we can pop all the element from queue front which are lesser then t-3000ms
//	and return the list size
//	time complexity :O(1)  amaotized when poping can cause all element to be poped but it not always need to pop 
//	space complexity :O(1)
	static class RecentCounter {
	    Queue<Integer> queue;
	    public RecentCounter() {
	        queue = new ArrayDeque<>();
	    }
	    public int ping(int t) {
	        if(queue.size()==0){
	            queue.add(t);
	            return 1;
	        }
	        if(t<=3000){
	            queue.add(t);
	        }else{
	            int margin = t-3000;
	            while(queue.size()!=0 && queue.peek()<margin){
	                queue.remove();
	            }
	            queue.add(t);
	        }
	        return queue.size();
	}
	}


	public static void main(String[] args) {
		
		RecentCounter recentCounter = new RecentCounter();
		System.out.println(recentCounter.ping(1));     // requests = [1], range is [-2999,1], return 1
		System.out.println(recentCounter.ping(100)); // requests = [1, 100], range is [-2900,100], return 2
		System.out.println(recentCounter.ping(3001));     // requests = [1, 100, 3001], range is [1,3001], return 3
		System.out.println(recentCounter.ping(3002));    // requests = [1, 100, 3001, 3002], range is [2,3002], return 3
		 

		

	}

}
