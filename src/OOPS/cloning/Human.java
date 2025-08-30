package OOPS.cloning;

import java.util.Arrays;

public class Human implements  Cloneable{
    String name;
    int age;
    int [] arr;

    public Human(String name, int age, int [] arr) {
        this.name = name;
        this.age = age;
        this.arr=arr;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", arr=" + Arrays.toString(arr) +
                '}';
    }

    public Human(Human human) {
        this.name = human.name;
        this.age = human.age;
    }
// this clone only create shallow copy means the object present inside this are same in clone
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Human deepCopy(){
        int [] copyarr= new int [arr.length];
        for(int i=0;i<arr.length;i++){
            copyarr[i]=arr[i];
        }
        return new Human(name,age,copyarr);
    }
}
