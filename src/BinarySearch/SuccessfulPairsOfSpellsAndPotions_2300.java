//2300. Successful Pairs of Spells and Potions
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You are given two positive integer arrays spells and potions, of length n and m respectively, where spells[i] represents the strength of the ith spell and potions[j] represents the strength of the jth potion.
//
//You are also given an integer success. A spell and potion pair is considered successful if the product of their strengths is at least success.
//
//Return an integer array pairs of length n where pairs[i] is the number of potions that will form a successful pair with the ith spell.
//
//
//
//Example 1:
//
//Input: spells = [5,1,3], potions = [1,2,3,4,5], success = 7
//Output: [4,0,3]
//Explanation:
//- 0th spell: 5 * [1,2,3,4,5] = [5,10,15,20,25]. 4 pairs are successful.
//- 1st spell: 1 * [1,2,3,4,5] = [1,2,3,4,5]. 0 pairs are successful.
//- 2nd spell: 3 * [1,2,3,4,5] = [3,6,9,12,15]. 3 pairs are successful.
//Thus, [4,0,3] is returned.
//Example 2:
//
//Input: spells = [3,1,2], potions = [8,5,8], success = 16
//Output: [2,0,2]
//Explanation:
//- 0th spell: 3 * [8,5,8] = [24,15,24]. 2 pairs are successful.
//- 1st spell: 1 * [8,5,8] = [8,5,8]. 0 pairs are successful.
//- 2nd spell: 2 * [8,5,8] = [16,10,16]. 2 pairs are successful.
//Thus, [2,0,2] is returned.
//
//
//Constraints:
//
//n == spells.length
//m == potions.length
//1 <= n, m <= 105
//1 <= spells[i], potions[i] <= 105
//1 <= success <= 1010
package BinarySearch;

import java.lang.reflect.Array;
import java.util.Arrays;

// we can sort the entire potions array
// now we can check for each spell which is the lower potion power which can reach success
// cause rest of them will automatically be true
// so we can just get first potion which can get success and get distanc btw that and end
// is the number of pairs we need
// time complexity : O( n log n)
// space complexity : O(1)
public class SuccessfulPairsOfSpellsAndPotions_2300 {
    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int [] output= new int [spells.length];
        int total= potions.length;
        for(int i =0;i<spells.length;i++){
            if(spells[i]==0){
                output[i]=0;
            }else{
                output[i]=total-binarySearch(success,potions,spells[i]);
            }
        }
        return output;
    }

    public static  int binarySearch(long lowerbound, int [] potions, long  spell){
        int start=0;
        int end = potions.length-1;
        while(start<=end){
            int mid= start+(end-start)/2;
            long success= (long)potions[mid]*spell;
            if(success <lowerbound){
                start=mid+1;
            }else {
                end=mid-1;
            }
        }
        return start;
    }
    public static void main(String[] args) {

        //Example 1:

        int [] spells1 = {5,1,3}, potions1 = {1,2,3,4,5};
        int success1 = 7;
        int [] output1= {4,0,3};

        //Example 2:

        int [] spells2 = {3,1,2}, potions2 = {8,5,8};
        int success2 = 16;
        int [] output2= {2,0,2};

        int [] ans1 = successfulPairs(spells1,potions1,success1);
        int [] ans2 = successfulPairs(spells2,potions2,success2);

        if(Arrays.equals(output1,ans1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :"+Arrays.toString(output1) );
            System.out.println("Your Output :"+Arrays.toString(ans1));
        }
        if(Arrays.equals(output2,ans2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :"+ Arrays.toString(output2) );
            System.out.println("Your Output :"+Arrays.toString(ans2));
        }



    }
}
