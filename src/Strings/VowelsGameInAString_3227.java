//3227. Vowels Game in a String
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//Alice and Bob are playing a game on a string.
//
//You are given a string s, Alice and Bob will take turns playing the following game where Alice starts first:
//
//On Alice's turn, she has to remove any non-empty substring from s that contains an odd number of vowels.
//On Bob's turn, he has to remove any non-empty substring from s that contains an even number of vowels.
//The first player who cannot make a move on their turn loses the game. We assume that both Alice and Bob play optimally.
//
//Return true if Alice wins the game, and false otherwise.
//
//The English vowels are: a, e, i, o, and u.
//
//
//
//Example 1:
//
//Input: s = "leetcoder"
//
//Output: true
//
//Explanation:
//Alice can win the game as follows:
//
//Alice plays first, she can delete the underlined substring in s = "leetcoder" which contains 3 vowels. The resulting string is s = "der".
//Bob plays second, he can delete the underlined substring in s = "der" which contains 0 vowels. The resulting string is s = "er".
//Alice plays third, she can delete the whole string s = "er" which contains 1 vowel.
//Bob plays fourth, since the string is empty, there is no valid play for Bob. So Alice wins the game.
//Example 2:
//
//Input: s = "bbcd"
//
//Output: false
//
//Explanation:
//There is no valid play for Alice in her first turn, so Alice loses the game.
//
//
//
//Constraints:
//
//1 <= s.length <= 105
//s consists only of lowercase English letters.

package Strings;

public class VowelsGameInAString_3227 {
//   intution : bob can never making odd to even but
//   alice can make even  to odd and if its odd vovels alex always wins
//   time complexity : O(n)
//   space complexity : O(1)
    public static boolean doesAliceWin(String s) {
        //  alice will always win if vovel counts are odd cause
        // it can take entire string
        // incase of even she goes first that means she can take even a single vovel
        // making it impossible for bob to win
        int count =0;
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='a' || ch =='e' || ch =='i' || ch == 'o' || ch == 'u'){
                count++;
            }
        }
        if(count==0){
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        //Example 1:

        String s1 = "leetcoder";
        boolean output1= true;

        //Example 2:

        String s2 = "bbcd";
        boolean output2= false;


        boolean ans1= doesAliceWin(s1);
        boolean ans2= doesAliceWin(s2);

        if(ans1==output1) {
            System.out.println("Case 1 Passed ");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Excepted Output : "+ output1);
            System.out.println("Your Output : "+ ans1);
        }

        if(ans2==output2) {
            System.out.println("Case 2 Passed ");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Excepted Output : "+ output2);
            System.out.println("Your Output : "+ ans2);
        }



    }
}
