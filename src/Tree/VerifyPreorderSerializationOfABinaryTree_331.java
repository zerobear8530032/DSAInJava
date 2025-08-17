//331. Verify Preorder Serialization of a Binary Tree
//Medium
//One way to serialize a binary tree is to use preorder traversal. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as '#'.
//
//
//For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where '#' represents a null node.
//
//Given a string of comma-separated values preorder, return true if it is a correct preorder traversal serialization of a binary tree.
//
//It is guaranteed that each comma-separated value in the string must be either an integer or a character '#' representing null pointer.
//
//You may assume that the input format is always valid.
//
//For example, it could never contain two consecutive commas, such as "1,,3".
//Note: You are not allowed to reconstruct the tree.
//
//
//
//Example 1:
//
//Input: preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#"
//Output: true
//Example 2:
//
//Input: preorder = "1,#"
//Output: false
//Example 3:
//
//Input: preorder = "9,#,#,1"
//Output: false
//
//
//Constraints:1 <= preorder.length <= 104
//preorder consist of integers in the range [0, 100] and '#' separated by commas ','.

package Tree;

import java.util.Arrays;

public class VerifyPreorderSerializationOfABinaryTree_331 {

//    approch : here each time we encounter a null it takes a slot and if a value nodes comes
//    slot will get sub by 1 and then it will create 2 extra slots for next level
//    time complexity : O(n)
//    space complexity : O(1)
    public static boolean isValidSerializationBest(String preorder) {
        String[] arr = preorder.split(",");
        int slots = 1; // one slot for root

        for (String node : arr) {
            if (slots == 0) return false; // no place to put current node
            if (node.equals("#")) {
                slots -= 1; // null takes one slot
            } else {
                slots = slots - 1 + 2; // non-null takes one slot, creates two
            }
        }
        return slots == 0;
    }


//    approch : here we can take a helper function where it takes prevLevel and rest of the nodes  as array \
//    so at each level we check prev level and find all valid nodes if those nodes valid nodes
//    validnodes *2  are the number of slots present for next level so we can take that much nodes for next level
    // if we cannot take that much nodes or the valid nodes counter becomes zero we can return false
//    if the rest get complempletely empty we can return true
//    time complexity : O(n^2)
//    space complexity : O(n^2)
    public static  boolean isValidSerializationBruteForce(String preorder) {
        String [] arr= preorder.split(",");
        if(arr.length==1){return arr[0].equals("#");}// if the root is null it returns true other wise false cause if a node is present at root it should have its null pointer in rest elements

        return helper(Arrays.copyOfRange(arr,0,1),Arrays.copyOfRange(arr,1,arr.length));
        // return false;
    }
    public static boolean helper(String [] prevLevel, String [] rest){
        if(rest.length==0){
            return true;
        }
        int validNodes =0;
        for(String s:prevLevel){
            if(!s.equals("#")){
                validNodes++;
            }
        }
        if(validNodes==0){
            return false;
        }
        int nextLevelSize = validNodes*2;
        // if nextLevelSize is greater the  our rest size means there are no valid nodes to put in
        //  next levels
        if(nextLevelSize>rest.length){return false;}
        return helper(Arrays.copyOfRange(rest,0,nextLevelSize),Arrays.copyOfRange(rest,nextLevelSize,rest.length));
    }

    public static void main(String[] args) {

        //Example 1:

        String preorder1 = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        boolean output1= true;

        //Example 2:

        String preorder2 = "1,#";
        boolean output2=false;

        //Example 3:

        String preorder3 = "9,#,#,1";
        boolean output3=false;

        System.out.println("Brute Force Approch :");

        boolean ans1= isValidSerializationBruteForce(preorder1);
        boolean ans2= isValidSerializationBruteForce(preorder2);
        boolean ans3= isValidSerializationBruteForce(preorder3);

        if(ans1==output1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :"+output1 );
            System.out.println("Your Output :"+ans1);
        }
        if(ans2==output2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :"+output2 );
            System.out.println("Your Output :"+ans2);
        }
        if(ans3==output3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Actual Output :"+output3);
            System.out.println("Your Output :"+ans3);
        }

        System.out.println("Best  Approch :");

        ans1= isValidSerializationBest(preorder1);
        ans2= isValidSerializationBest(preorder2);
        ans3= isValidSerializationBest(preorder3);

        if(ans1==output1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :"+output1 );
            System.out.println("Your Output :"+ans1);
        }
        if(ans2==output2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :"+output2 );
            System.out.println("Your Output :"+ans2);
        }
        if(ans3==output3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Actual Output :"+output3);
            System.out.println("Your Output :"+ans3);
        }
    }
}
