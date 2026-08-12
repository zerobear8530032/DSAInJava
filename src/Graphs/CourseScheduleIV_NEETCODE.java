//Course Schedule IV
//Medium
//Topics
//Company Tags
//There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course ai first if you want to take course bi.
//
//For example, the pair [0, 1] indicates that you have to take course 0 before you can take course 1.
//Prerequisites can also be indirect. If course a is a prerequisite of course b, and course b is a prerequisite of course c, then course a is a prerequisite of course c.
//
//You are also given an array queries where queries[j] = [uj, vj]. For the jth query, you should answer whether course uj is a prerequisite of course vj or not.
//
//Return a boolean array answer, where answer[j] is the answer to the jth query.
//
//Example 1:
//
//Input: numCourses = 4, prerequisites = [[1,0],[2,1],[3,2]], queries = [[0,1],[3,1]]
//
//Output: [false,true]
//Example 2:
//
//Input: numCourses = 2, prerequisites = [[1,0]], queries = [[0,1]]
//
//Output: [false]
//Constraints:
//
//2 <= numCourses <= 100
//0 <= prerequisites.length <= (numCourses * (numCourses - 1) / 2)
//prerequisites[i].length == 2
//0 <= ai, bi <= numCourses - 1
//ai != bi
//All the pairs [ai, bi] are unique.
//The prerequisites graph has no cycles.
//1 <= queries.length <= 10,000
//0 <= ui, vi <= numCourses - 1
//ui != vi
package Graphs;

import java.util.*;

public class CourseScheduleIV_NEETCODE {
    public static List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        HashMap<Integer,List<Integer>> nodeMap= new HashMap<>();
        HashMap<Integer, HashSet<Integer>> prereqMap= new HashMap<>();
        for(int i=0;i<numCourses;i++){
            nodeMap.put(i,new ArrayList<>());
        }
        for(int [] prereq: prerequisites){
            nodeMap.get(prereq[0]).add(prereq[1]);
        }
        for(int i =0;i<numCourses;i++){

            HashSet<Integer> path = new HashSet<>();

            fillMap(i, nodeMap, path);

            path.remove(i);

            prereqMap.put(i, path);
        }

        List<Boolean>res = new ArrayList<>();
        for(int [] query:queries){
            boolean r=prereqMap.get(query[0]).contains(query[1]);
            res.add(r);
        }
        return res;
    }

    public static void fillMap(int node, HashMap<Integer,List<Integer>> nodeMap , HashSet<Integer> path){
        path.add(node);
        for(int n :nodeMap.get(node)){
            if(!path.contains(n)){
                fillMap(n,nodeMap,path);
            }
        }
    }
    public static void main(String[] args) {
        //Example 1:

        int numCourses1 = 4;
        int [][] prerequisites1 = {{1,0},{2,1},{3,2}};
        int [][] queries1 = {{0,1},{3,1}};
        List<Boolean> output1= Arrays.asList(false,true);

        //Example 2:

        int numCourses2 = 2;
        int [][] prerequisites2 = {{1,0}};
        int [][] queries2 = {{0,1}};
        List<Boolean> output2= Arrays.asList(false);

        List<Boolean> ans1= checkIfPrerequisite(numCourses1,prerequisites1,queries1);
        List<Boolean> ans2= checkIfPrerequisite(numCourses2,prerequisites2,queries2);

        if(output1.equals(ans1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+(output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(output2.equals(ans2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+(output2));
            System.out.println("Your Answer :"+ (ans2));
        }


    }
}
