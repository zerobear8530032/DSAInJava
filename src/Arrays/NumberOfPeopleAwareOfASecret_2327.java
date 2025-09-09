//2327. Number of People Aware of a Secret
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//On day 1, one person discovers a secret.
//
//You are given an integer delay, which means that each person will share the secret with a new person every day, starting from delay days after discovering the secret. You are also given an integer forget, which means that each person will forget the secret forget days after discovering it. A person cannot share the secret on the same day they forgot it, or on any day afterwards.
//
//Given an integer n, return the number of people who know the secret at the end of day n. Since the answer may be very large, return it modulo 109 + 7.
//
//
//
//Example 1:
//
//Input: n = 6, delay = 2, forget = 4
//Output: 5
//Explanation:
//Day 1: Suppose the first person is named A. (1 person)
//Day 2: A is the only person who knows the secret. (1 person)
//Day 3: A shares the secret with a new person, B. (2 people)
//Day 4: A shares the secret with a new person, C. (3 people)
//Day 5: A forgets the secret, and B shares the secret with a new person, D. (3 people)
//Day 6: B shares the secret with E, and C shares the secret with F. (5 people)
//Example 2:
//
//Input: n = 4, delay = 1, forget = 3
//Output: 6
//Explanation:
//Day 1: The first person is named A. (1 person)
//Day 2: A shares the secret with B. (2 people)
//Day 3: A and B share the secret with 2 new people, C and D. (4 people)
//Day 4: A forgets the secret. B, C, and D share the secret with 3 new people. (6 people)
//
//
//Constraints:
//
//2 <= n <= 1000
//1 <= delay < forget <= n

package Arrays;

import java.util.Arrays;

public class NumberOfPeopleAwareOfASecret_2327 {
//    BRUTE FORCE APPROCH :
//    Time complexity : O(forgot-delay)^n
//    space copmplexity : O(n)
    public static int peopleAwareOfSecret(int n, int delay, int forget) {
        int[] daymap = new int[n + 1];
        helper(daymap, delay, forget,1);
        return Arrays.stream(daymap).sum();
    }

    public static void helper(int[] daymap, int delay, int forgot, int currentday) {
        if (currentday >= daymap.length) {
            return;
        }
        daymap[currentday]++;
        if ((forgot+currentday) < daymap.length) {
            daymap[currentday + forgot]--;
        }
        // now start when every time a new person will know :
        for (int i = currentday+delay; i <currentday+forgot; i++) {
            if(i>=daymap.length){break;}// break early
            helper(daymap, delay, forgot, i);
        }
    }
    public static void main(String[] args) {
        //Example 1:

        int n1 = 6, delay1 = 2, forget1 = 4;
        int output1=5;

        //Example 2:

        int  n2 = 4, delay2 = 1, forget2 = 3;
        int output2=6;

        //Example 3:

        int  n3 = 4, delay3 = 1, forget3 = 4;
        int output3=8;

        System.out.println(peopleAwareOfSecret(n1,delay1,forget1));
        System.out.println(peopleAwareOfSecret(n2,delay2,forget2));
        System.out.println(peopleAwareOfSecret(n3,delay3,forget3));
        
    }
}
