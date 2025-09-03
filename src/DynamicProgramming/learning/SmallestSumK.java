package DynamicProgramming.learning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SmallestSumK {
//    you are given a array and a target you have to find a sequence of elements sum up to target from array
//    and you can use a element as much number of times you want

    static List<Integer> res;
    public static List<Integer> sumUpToTarget(int [] arr, int target){
        res= new ArrayList<>();
        List<Integer> curres= new ArrayList<>();
        helper(arr,target,0, curres);
        return res;
    }

    public static void helper(int [] arr, int target, int idx, List<Integer> currres){
        if(target==0){
            if(currres.size()<res.size() || res.size()==0){
                res=new ArrayList<>(currres);
            }
        }
        if(idx>=arr.length){
            return ;
        }

        for(int i=idx;i<arr.length;i++){
            if(target-arr[i]<0){
                continue;
            }
            currres.add(arr[i]);
            helper(arr,target-arr[i],i,currres);
            currres.remove(currres.size()-1);
        }
    }
// n in number
// m is length of arr
//time complexity : O(n^m * m)
// space complexity : O(n*m)
    public static List<Integer> sumUpToTargetBruteForce(int [] arr, int target){
        if(target==0){
            return new ArrayList<>();
        }
        if(target<0){
            return null;
        }
        List<Integer> bestres= null;
        for(int x:arr){
            int remainder = target-x;
            List<Integer> curr=sumUpToTargetBruteForce(arr,remainder);
            if(curr!=null){
                curr.add(x);
                if( bestres==null || bestres!=null && curr.size()<bestres.size()){
                  bestres=new ArrayList<>(curr);
                }
            }
        }
        return bestres;
    }

// time complexity : O(m*n * n)
// space complexity : O(m*n)
    public static List<Integer> sumUpToTargetBruteForce(int [] arr, int target, HashMap<Integer,List<Integer>> memo){
        if(memo.containsKey(target)){
            return memo.get(target);
        }
        if(target==0){
            return new ArrayList<>();
        }
        if(target<0){
            return null;
        }
        List<Integer> bestres= null;
        for(int x:arr){
            int remainder = target-x;
            List<Integer> curr=sumUpToTargetBruteForce(arr,remainder,memo);
            if(curr!=null){
                List<Integer> combination = new ArrayList<>(curr);
                combination.add(x);

                if (bestres == null || combination.size() < bestres.size()) {
                    bestres = combination;
                }
            }
        }
        if(bestres!=null){
            memo.put(target,new ArrayList<>(bestres));
        }else{
            memo.put(target,null);
        }
        return bestres;
    }

    public static void main(String[] args) {



        int [] arr1= {5,3,4,7};
        int target1= 7;

        int [] arr2= {2,3,5};
        int target2= 8;

        int [] arr3= {1,4,5};
        int target3= 8;

        int [] arr4= {1,2,5,25};
        int target4= 100;


        System.out.println(sumUpToTargetBruteForce(arr1,target1,new HashMap<>()));
        System.out.println(sumUpToTargetBruteForce(arr2,target2, new HashMap<>()));
        System.out.println(sumUpToTargetBruteForce(arr3,target3, new HashMap<>()));
        System.out.println(sumUpToTargetBruteForce(arr4,target4, new HashMap<>()));


    }
}
