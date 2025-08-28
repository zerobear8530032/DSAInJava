package OOPS.polymorphism;

public class Main {
    public static void main(String[] args) {
        Shape shape = new Shape();
        Circle circle = new Circle();
        Square square = new Square();
        Shape obj = new Circle();
        shape.area();
        square.area();
        circle.area();
        obj.area();
    }
}
