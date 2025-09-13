package DynamicProgramming.learning;

public class canSum {

    public static boolean canSum(int [] elements, int target){
        boolean [] table = new boolean[target+1];
        table[0]=true;
        for(int i =0;i<=target;i++){
            if(table[i]==true){
                for(int x:elements){
                    if(i+x<table.length){
                     table[i+x]=true;
                    }
                }
            }
        }
        return table[target];
    }

    public static void main(String[] args) {
        System.out.println(canSum(new int [] {2,3},7));
        System.out.println(canSum(new int [] {5,3,4,7},7));
        System.out.println(canSum(new int [] {2,4},7));
        System.out.println(canSum(new int [] {2,3,5},8));
        System.out.println(canSum(new int [] {7,14},300));
    }
}
