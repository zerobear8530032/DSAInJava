package OOPS;

import java.util.ArrayList;
import java.util.List;

public class constclass {


    public static void main(String[] args) {
        final List<Integer> arr = new ArrayList<>();
        System.out.println(arr);
        arr.add(23);
        System.out.println(arr);
//        arr= new ArrayList<>();// we cannot initalize it again
    }

}
