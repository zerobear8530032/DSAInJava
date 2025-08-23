package Sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CountSort {
//    time complexity : O(largest)
//    space compelxity : O(largest)
//    this sorting works by mapping each number frequency on the index of array
//    makking is sorted and then we can just collect from from array frequency times
//      this only works with positive small integers
     static int largest;
    public static void countSortArr(int [] arr){
        if(arr==null || arr.length==0){
            return ;
        }
        largest=0;
        for(int x:arr) {
            largest = Math.max(largest, x);
        }// get largest element
//        create a mapping array
        int []sortarr= new int[largest+1];
        int idx=0;//fill the array
        for(int x:arr){
            sortarr[x]++;
        }
//        get elements in the output array
//        here its inplace
        for(int i =0;i<sortarr.length;i++){
            for(int j=0;j<sortarr[i];j++){
                arr[idx++]=i;
            }
        }
    }

// here we can use a hashmap instead of using the array to reduce space
    public static void countSortHash(int [] arr){
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = Arrays.stream(arr).max().getAsInt();// get max
        int min = Arrays.stream(arr).min().getAsInt();// get min
        for(int x:arr){// populate the hashmap
            map.put(x,map.getOrDefault(x,0)+1);
        }
        int idx=0;
//        now we check form  min to max and search it exists in the map if yes
//        we will add it frequency times
        for(int i=min;i<=max;i++){
            if(map.containsKey(i)){
                int x=map.get(i);
                for(int j=0;j<x;j++){
                    arr[idx++]=i;
                }
            }
        }
        System.out.println(map);

    }

    public static void main(String[] args) {
        int [] arr ={1,3,3,6,5,7,1};
        System.out.println(Arrays.toString(arr));
        countSortArr(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int [] {1,3,3,6,5,7,1};
        System.out.println(Arrays.toString(arr));
        countSortHash(arr);
        System.out.println(Arrays.toString(arr));

    }
}
