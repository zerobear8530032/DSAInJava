//Stock Buy and Sell – Multiple Transaction Allowed
//Difficulty: MediumAccuracy: 13.43%Submissions: 167K+Points: 4
//The cost of stock on each day is given in an array price[]. Each day you may decide to either buy or sell the stock i at price[i], you can even buy and sell the stock on the same day. Find the maximum profit that you can get.
//
//Note: A stock can only be sold if it has been bought previously and multiple stocks cannot be held on any given day.
//
//Examples:
//
//Input: prices[] = [100, 180, 260, 310, 40, 535, 695]
//Output: 865
//Explanation: Buy the stock on day 0 and sell it on day 3 => 310 – 100 = 210. Buy the stock on day 4 and sell it on day 6 => 695 – 40 = 655. Maximum Profit = 210 + 655 = 865.
//
//
//Input: prices[] = [4, 2, 2, 2, 4]
//Output: 2
//Explanation: Buy the stock on day 3 and sell it on day 4 => 4 – 2 = 2. Maximum Profit = 2.
//Constraints:
//1 <= prices.size() <= 105
//0 <= prices[i] <= 104
//
//Expected Complexities
//Time Complexity: O(n)
//Auxiliary Space: O(1)


package DynamicProgramming;

public class StockBuyAndSell_MultipleTransactionAllowed_GFG {
	
//	brute force approch try buying and selling every pair of days 
	public static int maximumProfit(int prices[]) {
		return maxProfitHelper(prices,1,prices[0]);
	}
	public static int maxProfitHelper(int [] prices, int day, int buyat) {
		if(day>=prices.length) {
			return 0;
		}
		int profit=0;
		for(int i =day;i<prices.length-1;i++) {
			int currprofit=prices[day]-buyat;
			if(currprofit<0) {
				continue;
			}else {
				profit+= Math.max(currprofit,maxProfitHelper(prices, i+2, prices[i+1]));				
			}
		}
		return profit;
	}

	public static void main(String[] args) {
		
		// Example 1 :
		
		int [] prices1= {100, 180, 260, 310, 40, 535, 695};
		int output1=865;
		
		// Example 2 :                    
		                                                                   
		int [] prices2= {4, 2, 2, 2, 4};
		int output2=2;
		
		
		System.out.println(maximumProfit(prices1));
		


	}

}
