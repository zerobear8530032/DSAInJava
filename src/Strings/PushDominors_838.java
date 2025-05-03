//838. Push Dominoes
//Medium
//Topics
//Companies
//There are n dominoes in a line, and we place each domino vertically upright. In the beginning, we simultaneously push some of the dominoes either to the left or to the right.
//
//After each second, each domino that is falling to the left pushes the adjacent domino on the left. Similarly, the dominoes falling to the right push their adjacent dominoes standing on the right.
//
//When a vertical domino has dominoes falling on it from both sides, it stays still due to the balance of the forces.
//
//For the purposes of this question, we will consider that a falling domino expends no additional force to a falling or already fallen domino.
//
//You are given a string dominoes representing the initial state where:
//
//dominoes[i] = 'L', if the ith domino has been pushed to the left,
//dominoes[i] = 'R', if the ith domino has been pushed to the right, and
//dominoes[i] = '.', if the ith domino has not been pushed.
//Return a string representing the final state.
//
// 
//
//Example 1:
//
//Input: dominoes = "RR.L"
//Output: "RR.L"
//Explanation: The first domino expends no additional force on the second domino.
//Example 2:
//
//
//Input: dominoes = ".L.R...LR..L.."
//Output: "LL.RR.LLRRLL.."
// 
//
//Constraints:
//
//n == dominoes.length
//1 <= n <= 105
//dominoes[i] is either 'L', 'R', or '.'.

package Strings;

public class PushDominors_838 {
    public static String pushDominoes(String dominoes) {
        int l=0;
        int r=1;
        char[] res= dominoes.toCharArray();
        int n = res.length;
        while(r<n){
            while(r<n && (r==l || res[r]=='.')){
                r++;
            }
            if(r<n &&  (res[l]=='.' && res[r]=='L')){
                while(l<r){
                    res[l]='L';
                    l++;
                }
            }else if(r<n &&(res[l]=='.' && res[r]=='R')) {
            	l=r;            	
            }else if(r<n && (res[l]==res[r])){
                char ch =res[l];
                while(l<r){
                    res[l]=ch;
                    l++;
                }
//                l=r;
            }else if(r<n &&(res[l]=='L' && res[r]=='R')){
                l=r;
            }else if(r<n && (res[l]=='R' && res[r]=='L')){
                int left=l+1;
                int right=r-1;
                while(left<right){
                    res[left]='R';
                    res[right]='L';
                    left++;
                    right--;
                }
                l=r;
            }
            r++;
        }
        if(res[l]=='R' && res[n-1]=='.') {
        	while(l<n) {
        		res[l]='R';
        		l++;
        	}
        }
		return new String(res);
    }

	    
	    
	    public static void main(String[] args) {
	    	//Example 1:

	    	String dominoes1 = "RR.L";
	    	String output1="RR.L";

	    	//Example 2:
	    	
	    	String dominoes2 = ".L.R...LR..L..";
	    	String output2="LL.RR.LLRRLL..";
	    	
	    	//Example 3:
	    	
	    	String dominoes3 = ".R..L.";
	    	String output3=".RRLL.";
	    	
	    	//Example 4:
	    	
	    	String dominoes4 = ".R..LR.....";
	    	String output4=".RRLLRRRRRR";	    	
	    	
	    	
	    	String ans1=pushDominoes(dominoes1);
	    	String ans2=pushDominoes(dominoes2);
	    	String ans3=pushDominoes(dominoes3);
	    	String ans4=pushDominoes(dominoes4);
			
			
			if(output1.equals(ans1)) {
				System.out.println("Case 1 Passed");
			}else {
				System.out.println("Case 1 Failed");
				System.out.println("Actual Output :"+output1 );
				System.out.println("Your Output :"+ans1);
			}
			if(output2.equals(ans2)) {
				System.out.println("Case 2 Passed");
			}else {
				System.out.println("Case 2 Failed");
				System.out.println("Actual Output :"+output2 );
				System.out.println("Your Output :"+ans2);
			}
			if(output3.equals(ans3)) {
				System.out.println("Case 3 Passed");
			}else {
				System.out.println("Case 3 Failed");
				System.out.println("Actual Output :"+output3);
				System.out.println("Your Output :"+ans3);
			}
			if(output4.equals(ans4)) {
				System.out.println("Case 4 Passed");
			}else {
				System.out.println("Case 4 Failed");
				System.out.println("Actual Output :"+output4);
				System.out.println("Your Output :"+ans4);
			}

		}
	

}
