//3100. Water Bottles II
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You are given two integers numBottles and numExchange.
//
//numBottles represents the number of full water bottles that you initially have. In one operation, you can perform one of the following operations:
//
//Drink any number of full water bottles turning them into empty bottles.
//Exchange numExchange empty bottles with one full water bottle. Then, increase numExchange by one.
//Note that you cannot exchange multiple batches of empty bottles for the same value of numExchange. For example, if numBottles == 3 and numExchange == 1, you cannot exchange 3 empty water bottles for 3 full bottles.
//
//Return the maximum number of water bottles you can drink.
//
//
//
//Example 1:
//
//
//Input: numBottles = 13, numExchange = 6
//Output: 15
//Explanation: The table above shows the number of full water bottles, empty water bottles, the value of numExchange, and the number of bottles drunk.
//Example 2:
//
//
//Input: numBottles = 10, numExchange = 3
//Output: 13
//Explanation: The table above shows the number of full water bottles, empty water bottles, the value of numExchange, and the number of bottles drunk.
//
//
//Constraints:
//
//1 <= numBottles <= 100
//1 <= numExchange <= 100
package Maths;

public class WaterBottlesII_3100 {
//    approch : simulate the process given in table
    public static int maxBottlesDrunk(int numBottles, int numExchange) {
        int drinks =numBottles;// drink all inital bottles
        int emptyBottles =numBottles;// so empty will be
        while(emptyBottles>=numExchange){
            emptyBottles-=numExchange;// we will remove numExchange number of bottle to get a filled one
            drinks+=1;// we drinked that bottle
            emptyBottles+=1;//after drinking  a new empty bottles will come
            numExchange+=1;// the rate increased per exchange;
        }

        return drinks;
    }
    public static void main(String[] args) {
        //Example 1:

        int  numBottles1 = 13, numExchange1 = 6;
        int output1=15;

        //Example 2:

        int  numBottles2 = 10, numExchange2 = 3;
        int output2=13;

        int ans1= maxBottlesDrunk(numBottles1,numExchange1);
        int ans2= maxBottlesDrunk(numBottles2,numExchange2);

        if(output1==(ans1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :"+output1 );
            System.out.println("Your Output :"+ans1);
        }
        if(output2==(ans2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :"+output2 );
            System.out.println("Your Output :"+ans2);
        }

    }
}
