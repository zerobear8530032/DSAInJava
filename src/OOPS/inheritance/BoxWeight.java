package OOPS.inheritance;

public class BoxWeight extends Box{
    double weight;

    public BoxWeight(double weight) {
        this.weight = weight;
    }
    public BoxWeight() {
        this.weight = -1;
    }

    public BoxWeight(double side, double weight) {
        super(side);// this will call the constructor of the parent class
        this.weight = weight;
    }

    public BoxWeight(double l, double h, double w, double weight) {
        super(l, h, w);
        this.weight = weight;
    }

    public BoxWeight(Box box, double weight) {
        super(box);
        this.weight = weight;
    }
}
