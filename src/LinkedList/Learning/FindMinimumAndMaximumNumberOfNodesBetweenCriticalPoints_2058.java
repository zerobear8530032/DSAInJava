//2058. Find the Minimum and Maximum Number of Nodes Between Critical Points
//Solved
//Medium
//Topics
//Companies
//Hint
//A critical point in a linked list is defined as either a local maxima or
//a local minima.
//
//A node is a local maxima if the current node has a value strictly greater
//than the previous node and the next node.
//
//A node is a local minima if the current node has a value strictly smaller
//than the previous node and the next node.
//
//A node can only be a local maxima/minima if there exists both a previous
//node and a next node.
//
//Return an array of length 2 containing [minDistance, maxDistance] where
//minDistance is the minimum distance between any two distinct critical
//points and maxDistance is the maximum distance between any two distinct
//critical points.
//
//If there are fewer than two critical points, return [-1, -1].

package LinkedList.Learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import LinkedList.Utils.ListNode;
import LinkedList.Utils.MyList;

public class FindMinimumAndMaximumNumberOfNodesBetweenCriticalPoints_2058 {

    //  Approach:
    //
    //  Traverse the linked list while maintaining:
    //  previous node, current node and next node.
    //
    //  A node is a critical point if:
    //
    //  1. current > previous && current > next
    //     (local maxima)
    //
    //  2. current < previous && current < next
    //     (local minima)
    //
    //  Store indices of all critical points.
    //
    //  Minimum distance:
    //  Minimum distance will always occur between
    //  two consecutive critical points.
    //
    //  Maximum distance:
    //  Maximum distance will always be between
    //  first and last critical points.
    //
    //  If critical points are less than 2,
    //  return [-1,-1].
    //
    //  Time Complexity : O(n)
    //  Space Complexity : O(n)

    public static int[] nodesBetweenCriticalPoints(ListNode head) {

        ListNode prev = head;
        ListNode curr = head;
        ListNode next = head.next;

        int cIdx = 1;

        if (next == null) {
            return new int[]{-1, -1};
        }

        List<Integer> criticals = new ArrayList<>();

        while (next != null) {

            int p = prev.val;
            int c = curr.val;
            int n = next.val;

            if ((c > p && c > n) ||
                (c < p && c < n)) {

                criticals.add(cIdx);
            }

            cIdx++;

            prev = curr;
            curr = next;
            next = curr.next;
        }

        if (criticals.size() < 2) {
            return new int[]{-1, -1};
        }

        int minDis = Integer.MAX_VALUE;

        for (int i = 1; i < criticals.size(); i++) {

            minDis = Math.min(
                    minDis,
                    criticals.get(i) - criticals.get(i - 1)
            );
        }

        int maxDis =
                criticals.get(criticals.size() - 1)
              - criticals.get(0);

        return new int[]{minDis, maxDis};
    }


    public static void main(String[] args) {

        // Example 1
        MyList l1 = new MyList(3, 1);
        int[] output1 = {-1, -1};

        // Example 2
        MyList l2 = new MyList(5, 3, 1, 2, 5, 1, 2);
        int[] output2 = {1, 3};

        // Example 3
        MyList l3 = new MyList(1, 3, 2, 2, 3, 2, 2, 2, 7);
        int[] output3 = {3, 3};

        int[] ans1 =
                nodesBetweenCriticalPoints(l1.getHead());

        int[] ans2 =
                nodesBetweenCriticalPoints(l2.getHead());

        int[] ans3 =
                nodesBetweenCriticalPoints(l3.getHead());

        if (Arrays.equals(output1, ans1)) {
            System.out.println("Case 1 Passed");
        } else {
            System.out.println("Case 1 Failed");
            System.out.println(
                    "Expected Output : "
                    + Arrays.toString(output1)
            );
            System.out.println(
                    "Your Answer     : "
                    + Arrays.toString(ans1)
            );
        }

        if (Arrays.equals(output2, ans2)) {
            System.out.println("Case 2 Passed");
        } else {
            System.out.println("Case 2 Failed");
            System.out.println(
                    "Expected Output : "
                    + Arrays.toString(output2)
            );
            System.out.println(
                    "Your Answer     : "
                    + Arrays.toString(ans2)
            );
        }

        if (Arrays.equals(output3, ans3)) {
            System.out.println("Case 3 Passed");
        } else {
            System.out.println("Case 3 Failed");
            System.out.println(
                    "Expected Output : "
                    + Arrays.toString(output3)
            );
            System.out.println(
                    "Your Answer     : "
                    + Arrays.toString(ans3)
            );
        }
    }
}