package OOPS.generics;

import java.util.Arrays;

public class CustomArrayList <T>{
//public class CustomArrayList <T extends Number>{ this is called wildcards where
//    the type of generic can only be a class which extends Number


    private Object [] data;
    private int size=0;
    private final int DEFAULT_SIZE=10;

    CustomArrayList(){
        data= new Object [DEFAULT_SIZE];
    }
    CustomArrayList(int size){
        data= new Object [size];
    }

    public void add(T val){
        if(isFull()){
            resize();
        }
        data[size]=val;
        size++;
    }

    public T remove(){
        if(isEmpty()){
            throw new RuntimeException("List is Empty");
        }
            size--;
            return (T) data[size];
    }

    public int size(){
        return size;
    }
    public void set(int idx, T val){
        if(idx<0 || idx>=size){
            throw new IndexOutOfBoundsException("List Array Index Out Of Bound");
        }
        data[idx]=val;
    }

    public T get(int idx){
        if(idx<0 || idx>=size){
            throw new IndexOutOfBoundsException("List Array Index Out Of Bound");
        }
        return (T) data[idx];
    }

    @Override
    public String toString() {
        StringBuilder str= new StringBuilder("[");
        for(int i =0;i<size;i++){
            str.append(data[i]).append(",");
        }
        str.setCharAt(str.length()-1,']');
        return str.toString();
//        return Arrays.toString(data);
    }

    private void resize(){
        Object [] temp = data;
        data= new Object [temp.length*2];
        for(int i =0;i<temp.length;i++){
            data[i]=(T) temp[i];
        }
    }

    private boolean isFull(){return size==data.length;}
    public boolean isEmpty(){return size==0;}


    public static void main(String[] args) {

        CustomArrayList list = new CustomArrayList();
        list.add(12);
        list.add(11);
        list.add(12);
        list.add("12");// this happen because out array list only take types
//        which class get extended by numbers these are called wild cards
        System.out.println(list);
        list.remove();
        System.out.println(list);
        list.set(1,1);
        System.out.println(list);
        for(int i =0;i<100;i++){
            list.add(i);
        }
        System.out.println(list);
    }


}
