//207. Course Schedule
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
//
//For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
//Return true if you can finish all courses. Otherwise, return false.
//
//
//
//Example 1:
//
//Input: numCourses = 2, prerequisites = [[1,0]]
//Output: true
//Explanation: There are a total of 2 courses to take.
//To take course 1 you should have finished course 0. So it is possible.
//Example 2:
//
//Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
//Output: false
//Explanation: There are a total of 2 courses to take.
//To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
//
//
//Constraints:
//
//1 <= numCourses <= 2000
//0 <= prerequisites.length <= 5000
//prerequisites[i].length == 2
//0 <= ai, bi < numCourses
//All the pairs prerequisites[i] are unique.
package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class CourseSchedule_207 {
//     approch :
//     we can create a  hashmap of prequist of every couse
//    then use dfs to find all the course we can complete
//    if there is a cycle we can return false

//    time complexity : O( course+ prerequist)
//    space complexity : O( course+ prerequist)

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> prereqMap = new HashMap();
        for(int i=0;i<numCourses;i++){
            prereqMap.put(i,new ArrayList<>());
        }
        for(int [] course:prerequisites){
            prereqMap.get(course[0]).add(course[1]);
        }
        HashSet<Integer> visited = new HashSet<>();
        for(int course=0;course<numCourses;course++){
            if(prereqMap.get(course).size()!=0){
                if(!canComplete(course,prereqMap,visited)){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean canComplete(int course,HashMap<Integer,List<Integer>> map, HashSet<Integer> visited){
        if(visited.contains(course)){
            return false;
        }
        if(map.get(course).size()==0){
            return true;
        }
        visited.add(course);
        for(int prereq: map.get(course)){
            if(!canComplete(prereq,map,visited)){
                return false;
            }
        }
        visited.remove(course);
        map.get(course).clear();
        return true;
    }
    public static void main(String[] args) {
        //Example 1:

        int  numCourses1 = 2;
        int [][] prerequisites1 = {{1,0}};
        boolean output1= true;

        //Example 2:

        int  numCourses2 = 2;
        int [][] prerequisites2 = {{1,0},{0,1}};
        boolean output2= false;

        boolean ans1 = canFinish(numCourses1,prerequisites1);
        boolean ans2 = canFinish(numCourses2,prerequisites2);
        if(output1==ans1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+(output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(output2==ans2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+(output2));
            System.out.println("Your Answer :"+ (ans2));
        }
    }
}
