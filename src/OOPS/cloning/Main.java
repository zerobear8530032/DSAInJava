package OOPS.cloning;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        Human h1= new Human("zero",12, new int[]{1,2,4,5});
        Human clone1= (Human) h1.clone();
        System.out.println(h1);
        System.out.println(clone1);
        clone1.arr[2]=23;// this will change object in original array too because clone only create shallow copy
        System.out.println(h1);
        System.out.println(clone1);


        Human clone2=  h1.deepCopy();
        System.out.println(h1);
        System.out.println(clone2);
        clone2.arr[2]=3;// this will change object in original array too because clone only create shallow copy
        System.out.println(h1);
        System.out.println(clone2);



    }
}
