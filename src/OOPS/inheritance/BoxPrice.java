package OOPS.inheritance;

public class BoxPrice extends BoxWeight{
    double price;

    public BoxPrice(){}

    public BoxPrice(double weight, double price) {
        super(weight);
        this.price = price;
    }

    public BoxPrice(double price) {
        this.price = price;
    }

    public BoxPrice(double side, double weight, double price) {
        super(side, weight);
        this.price = price;
    }

    public BoxPrice(double l, double h, double w, double weight, double price) {
        super(l, h, w, weight);
        this.price = price;
    }

    public BoxPrice(Box box, double weight, double price) {
        super(box, weight);
        this.price = price;
    }


}
