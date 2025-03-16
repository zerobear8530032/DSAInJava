////
//2594. Minimum Time to Repair Cars
//Solved
//Medium
//Topics
//Companies
//Hint
//You are given an integer array ranks representing the ranks of some mechanics. ranksi is the rank of the ith mechanic. A mechanic with a rank r can repair n cars in r * n2 minutes.
//
//You are also given an integer cars representing the total number of cars waiting in the garage to be repaired.
//
//Return the minimum time taken to repair all the cars.
//
//Note: All the mechanics can repair the cars simultaneously.
//
// 
//
//Example 1:
//
//Input: ranks = [4,2,3,1], cars = 10
//Output: 16
//Explanation: 
//- The first mechanic will repair two cars. The time required is 4 * 2 * 2 = 16 minutes.
//- The second mechanic will repair two cars. The time required is 2 * 2 * 2 = 8 minutes.
//- The third mechanic will repair two cars. The time required is 3 * 2 * 2 = 12 minutes.
//- The fourth mechanic will repair four cars. The time required is 1 * 4 * 4 = 16 minutes.
//It can be proved that the cars cannot be repaired in less than 16 minutes.​​​​​
//Example 2:
//
//Input: ranks = [5,1,8], cars = 6
//Output: 16
//Explanation: 
//- The first mechanic will repair one car. The time required is 5 * 1 * 1 = 5 minutes.
//- The second mechanic will repair four cars. The time required is 1 * 4 * 4 = 16 minutes.
//- The third mechanic will repair one car. The time required is 8 * 1 * 1 = 8 minutes.
//It can be proved that the cars cannot be repaired in less than 16 minutes.​​​​​
// 
//
//Constraints:
//
//1 <= ranks.length <= 105
//1 <= ranks[i] <= 100
//1 <= cars <= 106

package BinarySearch;


public class MinimumTimeToRepairCars_2594 {

//	apply binary search :
//	from 1 till max(rank)*cars*cars:
//	why because the min time can be 1 and max will be the mechanic having highest rank * all cars ^2
//	so each time we find mid and assign time and check how many cars each mechanic can repair in that time 
//	by formula : r* n^2= t
//	we can say n= root(t/r)
//	now we use a helper function and assign t time to each machin see how many cars he can repairs
//	and then we find how many cars can be repaired using all mechanic 
//	if we can repair more then cars required reduce time by moving end = mid-1
//	it not increase time to mid= start+1;
//	repeat this until start and smaller then end
//	at last return the last possible time where the cars could be repaired;
//	time complexity :O(n log n)
//	space complexity :O(1)
	public static long repairCars(int[] ranks, int cars) {
	        
	        long maxRank = 0;
	        for(int x: ranks){//maxrank finding
	            maxRank = Math.max(x,maxRank);
	        }
	        long s=0;// lower bound
	        long e= maxRank *(long)cars*(long)cars;// upper bound and type casting for no over flow
	        long ans =-1;// default answer
	        while(s<=e){// simple binary search 
	            long m= s+(e-s)/2;
	            if(canRepair(ranks,cars,m)){// if cars can be repaired we reduce time
	                ans=m;
	                e=m-1;
	            }else{// other wise increase time
	                s=m+1;
	            }
	        }
	        return ans;// ans 
	    }
//	check how many cars can be reapired in t time
	    public static boolean canRepair(int [] ranks,int cars,long time){
	        long repaired =0;// initally no car repaired
	        for(int i =0;i<ranks.length;i++){// assign t time to each mechanic and find total cars that can be repaired
	            long currentRepaired=(long)(Math.sqrt(time/ranks[i]));// current repaired
	            repaired+=currentRepaired;
	            if(repaired>=cars) return true;// early exit if we already finish required cars we can exit here
	        }
	        return repaired>=cars;// this return true if  required number of cars are repaired other wise false
	    }
	
	public static void main(String[] args) {
		

		
		//Example 1:

		int [] ranks1= {4,2,3,1};
		int cars1=10;
		int output1=16;
		
		//Example 2:

		int [] ranks2= {5,1,8};
		int cars2=6;
		long output2=16;
		
		System.out.println("Optimize Approch : ");
		
		long ans1= repairCars(ranks1, cars1);
		long  ans2= repairCars(ranks2, cars2);
		
		if(ans1==output1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ (output1));
			System.out.println("Your Answer :"+ (ans1));
		}
		if(ans2==output2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ (output2));
			System.out.println("Your Answer :"+ (ans2));
		}
		
	}

}
