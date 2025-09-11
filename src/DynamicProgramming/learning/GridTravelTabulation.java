package DynamicProgramming.learning;

public class GridTravelTabulation {

    public static int travel(int row, int col){
        int [][] table = new int [row+1][col+1];
        table[1][1]=1;
        for(int i =0;i<table.length;i++){
            for(int j =0;j<table[0].length;j++){
                int current= table[i][j];
                if(i+1<table.length){
                    table[i+1][j]+=current;
                }
                if(j+1<table[0].length){
                    table[i][j+1]+=current;
                }
            }
        }
        return table[row][col];
    }

    public static void main(String[] args) {

        System.out.println(travel(3,3));
    }
}
