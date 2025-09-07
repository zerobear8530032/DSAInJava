package StringBufferIntro;
import java.util.Random;
public class RandomString {
    public String generateRandomStrings(int size){
        StringBuffer buffer= new StringBuffer();
        Random ran = new Random();
        for(int i =0;i<size;i++){
            if(ran.nextBoolean()){
                buffer.append((char)ran.nextInt(65,91));
            }else{
                buffer.append((char)ran.nextInt(97,123));
            }
        }
        return buffer.toString();
    }

    public static void main(String[] args) {

        RandomString str= new RandomString();
        String s1=str.generateRandomStrings(234);
        System.out.println(s1);
    }
}
