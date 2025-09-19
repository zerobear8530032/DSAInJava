//3484. Design Spreadsheet
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//A spreadsheet is a grid with 26 columns (labeled from 'A' to 'Z') and a given number of rows. Each cell in the spreadsheet can hold an integer value between 0 and 105.
//
//Implement the Spreadsheet class:
//
//Spreadsheet(int rows) Initializes a spreadsheet with 26 columns (labeled 'A' to 'Z') and the specified number of rows. All cells are initially set to 0.
//void setCell(String cell, int value) Sets the value of the specified cell. The cell reference is provided in the format "AX" (e.g., "A1", "B10"), where the letter represents the column (from 'A' to 'Z') and the number represents a 1-indexed row.
//void resetCell(String cell) Resets the specified cell to 0.
//int getValue(String formula) Evaluates a formula of the form "=X+Y", where X and Y are either cell references or non-negative integers, and returns the computed sum.
//Note: If getValue references a cell that has not been explicitly set using setCell, its value is considered 0.
//
//
//
//Example 1:
//
//Input:
//["Spreadsheet", "getValue", "setCell", "getValue", "setCell", "getValue", "resetCell", "getValue"]
//[[3], ["=5+7"], ["A1", 10], ["=A1+6"], ["B2", 15], ["=A1+B2"], ["A1"], ["=A1+B2"]]
//
//Output:
//[null, 12, null, 16, null, 25, null, 15]
//
//Explanation
//
//Spreadsheet spreadsheet = new Spreadsheet(3); // Initializes a spreadsheet with 3 rows and 26 columns
//spreadsheet.getValue("=5+7"); // returns 12 (5+7)
//spreadsheet.setCell("A1", 10); // sets A1 to 10
//spreadsheet.getValue("=A1+6"); // returns 16 (10+6)
//spreadsheet.setCell("B2", 15); // sets B2 to 15
//spreadsheet.getValue("=A1+B2"); // returns 25 (10+15)
//spreadsheet.resetCell("A1"); // resets A1 to 0
//spreadsheet.getValue("=A1+B2"); // returns 15 (0+15)
//
//
//Constraints:
//
//1 <= rows <= 103
//0 <= value <= 105
//The formula is always in the format "=X+Y", where X and Y are either valid cell references or non-negative integers with values less than or equal to 105.
//Each cell reference consists of a capital letter from 'A' to 'Z' followed by a row number between 1 and rows.
//At most 104 calls will be made in total to setCell, resetCell, and getValue.
package HashMap;

import java.util.HashMap;
// approch : use hashmap for managing rows and an integer array of 26 lenght to store value
// hashmap will only store the index of row and an integer array with values with the correspinding columns
// and to find reference we can checke the row exists  or not if yes solve  other wise keep the value as given or 0
// Final Summary
//Time Complexity:
//setCell → O(1)
//resetCell → O(1)
//getValue → O(1)

//Space Complexity:
//O(rows × 26)

class Spreadsheet {

    HashMap<Integer, int []> sheet= new HashMap();
    public Spreadsheet(int rows) {
        sheet= new HashMap();
    }

    public void setCell(String cell, int value) {
        char col= cell.charAt(0);// comvert to int
        int row = Integer.parseInt(cell.substring(1));// cpnver tto int
        if(sheet.containsKey(row)){// check row exists in map
            sheet.get(row)[col-'A']=value;// yes then put it in the col
        }else{
            int [] cols= new int [26];// other wise create the row and col
            cols[col-'A']=value;
            sheet.put(row,cols);
        }
    }

    public void resetCell(String cell) {

        char col= cell.charAt(0);
        int row = Integer.parseInt(cell.substring(1));
        if(sheet.containsKey(row)){
            sheet.get(row)[col-'A']=0;
        }
    }

    public int getValue(String formula) {
        formula= formula.substring(1);
        String [] expression=  formula.split("\\+");
        String x=expression[0];
        String y=expression[1];
        int  xval=0;
        int yval=0;
        if(x.charAt(0)>='A' && x.charAt(0)<='Z'){// its a reference
            int row = Integer.parseInt(x.substring(1));
            if(sheet.containsKey(row)){
                xval= sheet.get(row)[x.charAt(0)-'A'];
            }
        }else{
            xval=Integer.parseInt(x);
        }

        if(y.charAt(0)>='A' && y.charAt(0)<='Z'){// its a reference
            int row = Integer.parseInt(y.substring(1));
            if(sheet.containsKey(row)){
                yval= sheet.get(row)[y.charAt(0)-'A'];
            }
        }else{
            yval=Integer.parseInt(y);
        }
        return xval+yval;
    }

}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */
public class DesignSpreadsheet_3484 {
    public static void main(String[] args) {
        Spreadsheet spreadsheet = new Spreadsheet(3); // Initializes a spreadsheet with 3 rows and 26 columns
        spreadsheet.getValue("=5+7"); // returns 12 (5+7)
        spreadsheet.setCell("A1", 10); // sets A1 to 10
        spreadsheet.getValue("=A1+6"); // returns 16 (10+6)
        spreadsheet.setCell("B2", 15); // sets B2 to 15
        spreadsheet.getValue("=A1+B2"); // returns 25 (10+15)
        spreadsheet.resetCell("A1"); // resets A1 to 0
        spreadsheet.getValue("=A1+B2"); // returns 15 (0+15)
    }
}
