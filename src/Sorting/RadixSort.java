package Sorting;

import java.util.Arrays;

public class RadixSort {

//     here approch is simple
//    we get the max number of digit in the array then we can sort on the bases of place values
//    at each iterations we apply count sort in it
//    time complexity : O(digits * (n+base))
//    space complexity : O(n+base)
    public static void radixSort(int [] arr){
        int max= Arrays.stream(arr).max().getAsInt();
        int placevalues= (int)Math.log10(max)+1; // this will give number of digit in max
        int exp=1;
        for(int i =0;i<placevalues;i++){
            sort(arr,exp);
            exp=exp*10;
        }
    }

    public static void sort(int [] arr, int exp){
        int n= arr.length;
        int [] count = new int [10];
        int [] output= new int [n];

        for(int i =0;i<n;i++){
            int placevalue = (arr[i]/exp)%10;
            count[placevalue]++;
        }
        for(int i =1;i<n;i++){
            count[i]=count[i]+count[i-1];
        }
        for(int i =n-1;i>=0;i--){
            int placevalue=(arr[i]/exp)%10;
//            here count[placevalue] is position of value in output
//            because arr[i]/exp%10 map its position in count
//            so we will place it at count position -1 as index
            output[count[placevalue]-1]=arr[i];
            count[placevalue]--;
        }

        System.arraycopy(output,0,arr,0,n);


    }

    public static void main(String[] args) {
        int arr[] =  {1,4,643,32,53,23,1,45};
        System.out.println(Arrays.toString(arr));
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
