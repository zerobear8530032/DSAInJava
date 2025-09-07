package StringBufferIntro;

public class Main {

    public static void main(String[] args) {
//        constructor 1
        StringBuffer buffer1 = new StringBuffer();
//        constructor 2
        StringBuffer buffer2 = new StringBuffer("Hello inital String");
//        constructor 3: this chnge the default  size to given side
        StringBuffer buffer3 = new StringBuffer(100);
//        it is a mutable sequence of characters
        buffer1.append("hello this is a sentence");
        String data1=buffer1.toString();
        String data2=buffer2.toString();
        System.out.println(data2);
        System.out.println(data2);
        buffer1.insert(2, "new string");
        System.out.println(buffer1);
// replace form 5, 10 to given string
        buffer1.replace(5,10, "jsankndskjfnskjdnf");
        System.out.println(buffer1);
// delete the given range of string
        buffer1.delete(3,buffer1.length());
        System.out.println(buffer1);

    }
}
