package BitWise;

public class showgrid {
    public static void main(String[] args) {
        int num = 4;
        System.out.println(Integer.toBinaryString(num&(num-1)));
    }
}
