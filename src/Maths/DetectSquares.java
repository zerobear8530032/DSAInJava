package Maths;

class DetectSquares {

//    approch :
//    we can create a grid of max row , col and then just increment the value at that point by 1 when add operation is called
//    when a query comes we can look at each diagonal of that point and look their up , down , left right points
//    to make square at end we have our answer
//    time complexity :O(1) for add
//    space complexity :O(max row , max col)
//    time complexity :O(grid.length + grid[0].length) for query
    int [][] grid ;
    public DetectSquares() {
        grid= new int[1001][1001];
    }

    public void add(int[] point) {
        grid[point[0]][point[1]]++;
    }
    public int count(int[] point) {
        // System.out.println(Arrays.toString(point));
        int res=0;
        // upper left diagonal :
        int r= point[0]-1;
        int c= point[1]-1;
        int unit=1;
        // System.out.println("Checking Upper left");
        while(r>=0 && c>=0){
            // System.out.println(r+" "+c+" "+unit);
            if(grid[r][c]!=0){
                int val = grid[r][c];
            //  check left:
                int left = grid[point[0]][c];
            // check above:
                int above = grid[r][point[1]];
                res+= val * left *above;
            }
            r--;
            c--;
            unit++;
        }
        // upper right diagonal :
        r= point[0]-1;
        c= point[1]+1;
        unit=1;
        // System.out.println("Checking Upper right");
        while(r>=0 && c<grid[0].length){
            // System.out.println(r+" "+c+" "+unit);
            if(grid[r][c]!=0){
                int val = grid[r][c];
            //  check right:
                int right= grid[point[0]][c];
            // check above:
                int above = grid[r][point[1]];
                res+= val * right *above;
            }
            r--;
            c++;
            unit++;
        }
        // lower left diagonal :
        r= point[0]+1;
        c= point[1]-1;
        unit=1;
        // System.out.println("Checking bottom left");
        while(r<grid.length && c>=0){
            // System.out.println(r+" "+c+" "+unit);
            if(grid[r][c]!=0){
                int val = grid[r][c];
            //  check left:
                int left = grid[point[0]][c];
            // check below:
                int below = grid[r][point[1]];
                res+= val * left *below;
            }
            r++;
            c--;
            unit++;
        }
        // lower right-diagonal :
        // System.out.println("Checking bottom right");
        r= point[0]+1;
        c= point[1]+1;
        unit=1;
        while(r<grid.length && c<grid[0].length){
            // System.out.println(r+" "+c+" "+unit);
            if(grid[r][c]!=0){
                int val = grid[r][c];
            //  check right:
                int right = grid[point[0]][c];
            // check below:
                int below = grid[r][point[1]];
                res+= val * right *below;
            }
            r++;
            c++;
            unit++;
        }
        return res;
    }

    public static void main(String[] args) {
        DetectSquares detectSquares = new DetectSquares();
        detectSquares.add(new int []{3, 10});
        detectSquares.add(new int []{11, 2});
        detectSquares.add(new int []{3, 2});
        detectSquares.count(new int [] {11, 10}); // return 1. You can choose:
        //   - The first, second, and third points
        detectSquares.count(new int []{14, 8});  // return 0. The query point cannot form a square with any points in the data structure.
        detectSquares.add(new int [] {11, 2});    // Adding duplicate points is allowed.
        detectSquares.count(new int [] {11, 10}); // return 2. You can choose:
        //   - The first, second, and third points
        //   - The first, third, and fourth points
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */