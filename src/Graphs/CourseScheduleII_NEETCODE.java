//Course Schedule II
//You are given an array prerequisites where prerequisites[i] = [a, b] indicates that you must take course b first if you want to take course a.
//
//For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
//There are a total of numCourses courses you are required to take, labeled from 0 to numCourses - 1.
//
//Return a valid ordering of courses you can take to finish all courses. If there are many valid answers, return any of them. If it's not possible to finish all courses, return an empty array.
//
//Example 1:
//
//Input: numCourses = 3, prerequisites = [[1,0]]
//
//Output: [0,1,2]
//Explanation: We must ensure that course 0 is taken before course 1.
//
//Example 2:
//
//Input: numCourses = 3, prerequisites = [[0,1],[1,2],[2,0]]
//
//Output: []
//Explanation: It's impossible to finish all courses.
//
//Constraints:
//
//1 <= numCourses <= 1000
//0 <= prerequisites.length <= 1000
//All prerequisite pairs are unique.
package Graphs;

import java.util.*;
class CourseScheduleII_NEETCODE {
    public static List<Integer> findOrder(int n, int[][] prerequisites) {
        // code here
        HashMap<Integer,List<Integer>> prereq= new HashMap<>();
        List<Integer> output= new ArrayList<>();
        for(int i =0;i<n;i++){
            prereq.put(i,new ArrayList<>());
        }
        for(int [] course: prerequisites){
            prereq.get(course[0]).add(course[1]);
        }
        HashSet<Integer> completedCourses = new  HashSet<>(); 
        HashSet<Integer> path = new HashSet<>(); 
        for(int i=0;i<n;i++){
            if(!DFS(i,prereq,completedCourses,path,output)){
                return new ArrayList<>();
            }
        }
        
        return output;
    }

    public static boolean DFS(int course,HashMap<Integer,List<Integer>> prereq , HashSet<Integer> completedCourses, HashSet<Integer> path,List<Integer> output){
        if(path.contains(course)){
            return false;
        }
        if(completedCourses.contains(course)){
            return true;
        }
        path.add(course);
        for(int nextCourse: prereq.get(course)){
            boolean noCycle=DFS(nextCourse,prereq,completedCourses,path,output);
            if(noCycle==false){
                return false;
            }
        }
        path.remove(course);
        completedCourses.add(course);
        output.add(course);
        return true;
    }

    public static void main(String[] args) {
        //Example 1:

        int  numCourses1 = 3;
        int [][] prerequisites1 = {{1,0}};
        List<Integer> output1= new ArrayList<>(Arrays.asList(0,1,2));

        //Example 2:

        int  numCourses2 = 3;
        int [][] prerequisites2 = {{0,1},{1,2},{2,0}};
        List<Integer> output2= new ArrayList<>();

        List<Integer> ans1= findOrder(numCourses1,prerequisites1);
        List<Integer> ans2= findOrder(numCourses1,prerequisites2);

        if(ans1.equals(output1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+(output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(ans2.equals(output2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+(output2));
            System.out.println("Your Answer :"+ (ans2));
        }


    }

}