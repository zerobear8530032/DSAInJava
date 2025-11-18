//717. 1-bit and 2-bit Characters
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Hint
//We have two special characters:
//
//The first character can be represented by one bit 0.
//The second character can be represented by two bits (10 or 11).
//Given a binary array bits that ends with 0, return true if the last character must be a one-bit character.
//
//
//
//Example 1:
//
//Input: bits = [1,0,0]
//Output: true
//Explanation: The only way to decode it is two-bit character and one-bit character.
//So the last character is one-bit character.
//Example 2:
//
//Input: bits = [1,1,1,0]
//Output: false
//Explanation: The only way to decode it is two-bit character and two-bit character.
//So the last character is not one-bit character.
//
//
//Constraints:
//
//1 <= bits.length <= 1000
//bits[i] is either 0 or 1.
package Arrays;

public class One_BitandTwoBitCharacters_717 {
//    approch :
//    we can just check 2 elements form currentindex
//    if its equal to 2 bit character we can go 2 step ahead other wise 1 step
//    if we are going one step ahead at the last index we get our ansewer as true
//    other wise false;
//    time complexity : O(n)
//    space complexity : O(1)
    public static boolean isOneBitCharacter(int[] bits) {
        int idx=0;
        while(idx<=bits.length-1){
            if(bits[idx]==1 && bits[idx+1]==0 || bits[idx]==1 && bits[idx+1]==1  ){
                idx+=2;
            }else{
                if(idx==bits.length-1){
                    return true;
                }
                idx++;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        //Example 1:

        int [] bits1 = {1,0,0};
        boolean output1= true;

        //Example 2:

        int [] bits2 = {1,1,1,0};
        boolean output2= false;

        boolean ans1= isOneBitCharacter(bits1);
        boolean ans2= isOneBitCharacter(bits2);

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
