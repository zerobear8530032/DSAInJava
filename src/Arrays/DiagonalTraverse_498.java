//498. Diagonal Traverse
//Medium
//Topics
//premium lock icon
//Companies
//Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.
//
//
//
//Example 1:
//
//
//Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
//Output: [1,2,4,7,5,3,6,8,9]
//Example 2:
//
//Input: mat = [[1,2],[3,4]]
//Output: [1,2,3,4]
//
//
//Constraints:
//
//m == mat.length
//n == mat[i].length
//1 <= m, n <= 104
//1 <= m * n <= 104
//-105 <= mat[i][j] <= 105

package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class DiagonalTraverse_498 {
// approch :
// just choose to put a single diagonal traversal and put all in a list of list then just reverse the odd index list and append entire list as a answer array
//    example :
//            [[1,2,3],
//            [4,5,6],
//            [7,8,9]]
//
//    diagonal traversal = [ [1], [4,2], [7,5,3], [8,6], [9] ]
//    now just reverese every odd index list and apppend all to answer
//  this got accepted in java idk best solution of it
    public static  int[] findDiagonalOrder(int[][] mat) {
            List<List<Integer>> res= new ArrayList<>();
            int rows= mat.length;
            int cols= mat[0].length;
            for(int r =0;r<rows;r++){
                res.add(diagonal(mat,r,0));
            }
            for(int c =1;c<cols;c++){
                res.add(diagonal(mat,rows-1,c));
            }
            int [] finalres= new int [rows*cols];
            int idx = 0;
            for(int i =0;i<res.size();i++){
                if(i%2==0){
                    for(int j=0;j<res.get(i).size();j++){
                        finalres[idx]=res.get(i).get(j);
                        idx++;
                    }
                }else{
                    for(int j=res.get(i).size()-1;j>=0;j--){
                        finalres[idx]=res.get(i).get(j);
                        idx++;
                    }
                }
            }
            return finalres;
        }
        public static List<Integer> diagonal(int [][] mat, int r, int c){
            List<Integer> res= new ArrayList();
            while(r>=0  && c<mat[0].length){
                res.add(mat[r][c]);
                r--;
                c++;
            }
            return res;
        }

    public static boolean check(int [] arr1, int [] arr2) {
        if(arr1.length!=arr2.length) {
            return false;
        }
        for(int i =0;i<arr1.length;i++) {
            if(arr1[i]!=arr2[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        //Example 1:

        int [][] mat1 ={{1,2,3},{4,5,6},{7,8,9}};
        int [] output1={1,2,4,7,5,3,6,8,9} ;

        //Example 2:

        int [][] mat2 ={{1,2},{3,4}};
        int [] output2={1,2,3,4} ;

        //Example 3:

        int [][] mat3 ={{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20}};
        int [] output3={1, 2, 6, 11, 7, 3, 4, 8, 12, 16, 17, 13, 9, 5, 10, 14, 18, 19, 15, 20} ;


        int [] ans1= findDiagonalOrder(mat1);
        int [] ans2= findDiagonalOrder(mat2);
        int [] ans3= findDiagonalOrder(mat3);


        if(check(ans1,output1)) {
            System.out.println("Case 1 Passed ");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Excepted Output : "+ Arrays.toString(output1));
            System.out.println("Your Output : "+ Arrays.toString(ans1));
        }
        if(check(ans2,output2)) {
            System.out.println("Case 2 Passed ");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Excepted Output : "+ Arrays.toString(output2));
            System.out.println("Your Output : "+ Arrays.toString(ans2));
        }
        if(check(ans3,output3)) {
            System.out.println("Case 3 Passed ");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Excepted Output : "+ Arrays.toString(output3));
            System.out.println("Your Output : "+ Arrays.toString(ans3));
        }



    }
    
}