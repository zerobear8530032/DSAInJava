//Find all Symmetric Pairs in the array of pairs
//58
//
//1
//In this article, we will solve the problem: "Find all Symmetric Pairs in the array of pairs"
//
//Problem Statement: Given an array of pairs, find all the symmetric pairs in the array.
//
//Examples:
//
//Example 1:
//Input: (1,2),(2,1),(3,4),(4,5),(5,4)
//Output: (2,1) (5,4)
//Explanation: Since (1,2) and (2,1) are symmetric pairs and (4,5) and (5,4) are symmetric pairs.
//
//Example 2:
//Input: (1,5),(2,3),(4,2),(5,1),(2,4)
//Output: (2,4) (5,1)
//Explanation: Since (1,5) and (2,4) are symmetric pairs and (5,1) and (4,2) are symmetric pairs.
package NQT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;


public class FindAllSymetricPairs {
	
//	brute force approch :
//	we can use 2 loop where we take one pair and compare it with every other pairs :

	public static List<int[]> findAllSymetricPair(int [][] matrix){
		List<int []> ans = new ArrayList<int[]>();
		for(int i=0;i<matrix.length-1;i++) {
			for(int j =i+1;j<matrix.length;j++) {
				if (checkpairs(matrix[i], matrix[j])) ans.add(matrix[j]);
			}
		}
		return ans;
		
	}
	public static boolean checkpairs(int [] p1, int [] p2) {
		return p1[0]==p2[1] && p1[1]==p2[0];
	}
	
	
	public static String printList(List<int []> ls) {
		StringBuilder str = new StringBuilder("[");
		
		for (int i =0;i<ls.size();i++) {
			str.append(Arrays.toString(ls.get(i)));
		}
		str.append("]");
		return str.toString();
	}
	
//	better approch :
//	use hash map :
	public static List<int[]> findAllSymetricPairBetter(int [][] matrix){
		HashMap<Integer,Integer> map = new HashMap();
		List<int []> ans = new ArrayList<int[]>();
		for(int i=0;i<matrix.length;i++) {
			if(map.containsKey(matrix[i][1])) {
				if(map.get(matrix[i][1])==matrix[i][0]) {
					ans.add(matrix[i]);
				}else {
					map.put(matrix[i][0],matrix[i][1]);
					
				}
			}else {
				map.put(matrix[i][0],matrix[i][1]);
			}
		
		}
		return ans;
		
	}


	public static void main(String[] args) {
		//Example 1:
		int [][]arr1= {{1,2},{2,1},{3,4},{4,5},{5,4}};
		List <int []>output1= new  ArrayList(Arrays.asList(new int []{2,1},new int []{5,4}));
		
		//Example 2:
		
		int [][]arr2= {{1,5},{2,3},{4,2},{5,1},{2,4}};
		List <int []>output2= new  ArrayList(Arrays.asList(new int []{2,4},new int []{5,1}));
		
		List<int []> ans1 =findAllSymetricPair(arr1);
		List<int []> ans2 =findAllSymetricPair(arr2);
		
		System.out.println(printList(ans1));
		System.out.println(printList(ans2));
		
		ans1 =findAllSymetricPairBetter(arr1);
		ans2 =findAllSymetricPairBetter(arr2);
		System.out.println(printList(ans1));
		System.out.println(printList(ans2));
		
		
		
		
		
	

	}

}
