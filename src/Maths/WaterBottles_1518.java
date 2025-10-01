//1518. Water Bottles
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Hint
//There are numBottles water bottles that are initially full of water. You can exchange numExchange empty water bottles from the market with one full water bottle.
//
//The operation of drinking a full water bottle turns it into an empty bottle.
//
//Given the two integers numBottles and numExchange, return the maximum number of water bottles you can drink.
//
//
//
//Example 1:
//
//
//Input: numBottles = 9, numExchange = 3
//Output: 13
//Explanation: You can exchange 3 empty bottles to get 1 full water bottle.
//Number of water bottles you can drink: 9 + 3 + 1 = 13.
//Example 2:
//
//
//Input: numBottles = 15, numExchange = 4
//Output: 19
//Explanation: You can exchange 4 empty bottles to get 1 full water bottle.
//Number of water bottles you can drink: 15 + 3 + 1 = 19.
//
//
//Constraints:
//
//1 <= numBottles <= 100
//2 <= numExchange <= 100

package Maths;

public class WaterBottles_1518 {

    // approch simulate the process
    //     time complexity : O (numbottles/numexchange;
    //     space complexity : O (1);
    public int numWaterBottles(int numBottles, int numExchange) {
        int drink=numBottles;// drink the inital bottles
        int emptyBottles= numBottles;// all bottles will be empty
        while(emptyBottles>=numExchange){// now try to exchnge bottles untill we hve more empty bottles then exchange rate
            int refill= emptyBottles/numExchange;// after exchange refilled bottles
            drink+=refill;// drinked the refill bottles
            //  new empty bottles = refilled + remaining empty bottles from last exchange
            emptyBottles= refill+emptyBottles%numExchange;
        }
    return drink;
    }
    //     time complexity : O (1);
    //     space complexity : O (1);
    public  static int numWaterBottlesBruteForce(int numBottles, int numExchange) {
        return numBottles + (numBottles - 1) / (numExchange - 1);
    }

    public static void main(String[] args) {
        //Example 1:

        int  numBottles1 = 9, numExchange1 = 3;
        int output1=13;

        //Example 2:


        int  numBottles2 = 15, numExchange2 = 4;
        int output2=19;

        System.out.println("Brute Force Approch :");
        int ans1= numWaterBottlesBruteForce(numBottles1,numExchange1);
        int ans2= numWaterBottlesBruteForce(numBottles2,numExchange2);

        System.out.println("Better Approch :");

        ans1= numWaterBottlesBruteForce(numBottles1,numExchange1);
        ans2= numWaterBottlesBruteForce(numBottles2,numExchange2);

    }

}
