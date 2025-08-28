package OOPS.inheritance;

public class Box {

    double l;
    double w;
    double h;

    public Box(){
        l=-1;
        w=-1;
        h=-1;
    }

    public Box(double side){
        l=side;
        w=side;
        h=side;
    }

    public Box(double l, double h, double w) {
        this.l = l;
        this.h = h;
        this.w = w;
    }

    public Box (Box box){
        h=box.h;
        l=box.l;
        w=box.w;
    }

    public void fun(){
        System.out.println("running from Box");
    }

    @Override
    public String toString() {
        return "Box{" +
                "l=" + l +
                ", w=" + w +
                ", h=" + h +
                '}';
    }

    public static void main(String[] args) {
        Box box1 = new Box();
        System.out.println("box1 : "+box1);
        Box box2 = new Box(23);
        System.out.println("box2 : "+box2);
        Box box3 = new Box(2,4,5);
        System.out.println("box3 : "+box3);
        Box box4 = new Box(box3);
        System.out.println("box4 : "+box4);
    }
}
