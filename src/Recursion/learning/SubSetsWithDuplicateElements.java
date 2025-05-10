package Recursion.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetsWithDuplicateElements {
	
	
	
	public static List<List<Integer>> subsets(int [] arr){
		List <List <Integer>> subsets= new ArrayList();
		subsets.add(new ArrayList());
		for(int x:arr) {
			int n= subsets.size();
			for(int i=0;i<n;i++) {
				List<Integer> subset= new ArrayList(subsets.get(i));
				subset.add(x);
				subsets.add(subset);
			}
		}
		return subsets;
	}
	
	public static List<List<Integer>> subsetsDuplicateElements(int [] arr){
		List <List <Integer>> subsets= new ArrayList();
		int [] nums=arr.clone();
		Arrays.sort(nums);
		int start=0;
		int end=0;
		subsets.add(new ArrayList());
		for(int i=0;i<arr.length;i++) {
			start=0;
			if(i>0 && arr[i]==arr[i-1]) {
				start=end+1;
			}
			end = subsets.size()-1;
			int n= subsets.size();
			
			for(int j=start;j<n;j++) {
				List<Integer> subset= new ArrayList(subsets.get(j));
				subset.add(arr[i]);
				subsets.add(subset);
			}
		}
		return subsets;
	}
	
	public static void main(String[] args) {
		int [] arr1= {1,2,3,4};
		int [] arr2= {1,2,3,4,5};
		int [] arr3= {6,7,8};
//	
//		System.out.println(subsets(arr1));
//		System.out.println(subsets(arr2));
//		System.out.println(subsets(arr3));
		
		int [] arr4= {1,2,2};
		int [] arr5= {1,2,4,1,2};
		int [] arr6= {1,2,3,1,4};
		System.out.println(subsetsDuplicateElements(arr4));
		System.out.println(subsetsDuplicateElements(arr5));
		System.out.println(subsetsDuplicateElements(arr6));
		
	}

}
