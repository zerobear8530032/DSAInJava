package LargeNumbers;

import java.math.BigDecimal;

public class LargeDecimals {

    public static void main(String[] args) {
        BigDecimal A= new BigDecimal("0.03234234232");
        BigDecimal B= new BigDecimal("0.04234234234234");
        BigDecimal add= A.add(B);
        BigDecimal sub= B.subtract(A);
        BigDecimal mul= A.multiply(B);
        BigDecimal div= A.divide(B,20, BigDecimal.ROUND_HALF_UP);
        BigDecimal mod= A.remainder(B);

        System.out.println(add);
        System.out.println(sub);
        System.out.println(mul);
        System.out.println(div);
        System.out.println(mod);
    }
}
