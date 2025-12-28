package Graphs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;


public class CountWeightOfEdges {
//    simple go through each edge
//    calculate the weight by suming the incoming node index with its old weight
//    we can use an array of length n to keep track of all nodes weights
//    and at the end we can find the largest weight node
//    time complexity : O(n)
//    space complexity : O(n)

    public static void main(String[] args) {
        // Example 1: The exact sample from your screenshot
        // N=23, edges[i] provided in the image, C1=9, C2=2
        int[] edges1 = {4, 4, 1, 4, 13, 8, 8, 8, 0, 8, 14, 9, 15, 8, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        // Note: I filled the remaining indices with -1 to match N=23 based on the visual graph
        int c1_1 = 9, c2_1 = 2;
        int expected1 = 4;

        // Example 2: Simple convergence (Both meet at node 3)
        int[] edges2 = {1, 2, 3, -1, 5, 3};
        int c1_2 = 0, c2_2 = 4;
        int expected2 = 3;

        // Example 3: Disconnected components (Cannot meet)
        int[] edges3 = {1, 0, 3, 2};
        int c1_3 = 0, c2_3 = 2;
        int expected3 = -1;

        // Example 4: C1 and C2 start at the same cell
        int[] edges4 = {1, 2, 0};
        int c1_4 = 1, c2_4 = 1;
        int expected4 = 1;

        // Example 5: One node is part of a cycle, the other is far away
        int[] edges5 = {1, 2, 0, 1};
        int c1_5 = 3, c2_5 = 0;
        int expected5 = 1;

        // Testing
        int[][] testEdges = {edges1, edges2, edges3, edges4, edges5};
        int[][] testNodes = {{c1_1, c2_1}, {c1_2, c2_2}, {c1_3, c2_3}, {c1_4, c2_4}, {c1_5, c2_5}};
        int[] expectedOutputs = {expected1, expected2, expected3, expected4, expected5};

        for (int i = 0; i < testEdges.length; i++) {
//            int actual = findNearestMeetingCell(testEdges[i], testNodes[i][0], testNodes[i][1]);
//            if (actual == expectedOutputs[i]) {
//                System.out.println("Case " + (i + 1) + " Passed");
//            } else {
//                System.out.println("Case " + (i + 1) + " Failed");
//                System.out.println("   Expected: " + expectedOutputs[i]);
//                System.out.println("   Actual: " + actual);
//            }
        }
    }
}
