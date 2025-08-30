package OOPS.abstraction;

public class Daughter extends  Parent{

    public Daughter(int num){
        super(num);
    }

    @Override
    public void career() {
        System.out.println("I will be a Programmer");
    }

    @Override
    public void partner() {
        System.out.println("I love zero");
    }

}
