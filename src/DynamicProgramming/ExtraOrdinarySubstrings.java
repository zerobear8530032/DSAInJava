package DynamicProgramming;

public class ExtraOrdinarySubstrings {
    public static int getExtraOrdinaryCounts(String str){
        int [] charmap= {1,1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,8,8,8,9,9,9};
        int count =0;
        int [] prefixSum = new int[str.length()];
        int psum =0;
        for(int i=0;i<str.length();i++){
            psum+= charmap[str.charAt(i)-'a'];
            prefixSum[i]=psum;
        }
        for(int i =0;i<str.length();i++){
            for(int j =i;j<str.length();j++){
                int sum =(i>0)?prefixSum[j]-prefixSum[i-1]:prefixSum[j];
                if(sum%(j-i+1)==0){
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        String str= "asdf";
        System.out.println(getExtraOrdinaryCounts(str));
    }
}
