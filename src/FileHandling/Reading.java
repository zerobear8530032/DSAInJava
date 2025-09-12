package FileHandling;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reading {
    public static void main(String[] args) {
//        try(InputStreamReader irs= new InputStreamReader(System.in)){
//            System.out.println("Enter some Letters");
//            int letters= irs.read();
//            while(irs.ready()){
//                System.out.println(letters );
//               letters= irs.read();
//            }
//        }catch (IOException e){
//            System.out.println(e.getMessage());
//        }


        try (FileReader fr= new FileReader("notes.txt")){
            System.out.println("Enter some Letters");
            int letters= fr.read();
            while(fr.ready()){
                System.out.println((char)letters );
               letters= fr.read();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }



    }
}
