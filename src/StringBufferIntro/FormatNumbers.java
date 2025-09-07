package StringBufferIntro;
import java.text.DecimalFormat;
public class FormatNumbers {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0.000000");
        System.out.println(df.format(123.123));
    }
}
