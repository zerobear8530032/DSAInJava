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
	        int n = dominoes.length();
	        char [] ans= dominoes.toCharArray();
	        while(l<n && (ans[l]=='.' || ans[l]=='L')){
	            if(ans[l]=='L'){
	                int i=l-1;
	                while(i>=0 && ans[i]=='.'){
	                    ans[i]='L';
	                    i--;
	                }
	            }
	            l++;
	        }
	        int r=l+1;
	        char leftside=ans[l];
	        char rightside=ans[r];
	        while(r<n){	
	        	while(r<n && ans[r]=='.') {
	        		r++;
	        	}
	        	if(r==n) break;
	        	rightside=ans[r];
	        	if(leftside==rightside) {
	        		putChar(ans, l+1, r-1, rightside);
	        		l=r;
	        		r++;
	        	}else if(leftside=='L' && rightside=='R') {
	        		l=r;
	        		r++;
	        	}else {
	        		putLR(ans,l+1,r-1);
	        		l=r;
	        		r++;
	        	}
	        }
	        
	        

	        return new String(ans);
	    }
	    public static void putLR(char[] arr, int s , int e){
	        while(s<e){
	            arr[s]='R';
	            arr[e]='L';
	        s++;
	        e--;
	        }

	    }
	    public static void putChar(char[] arr, int s , int e,char ch){
	    	while(s<=e){
	    		arr[s]=ch;
	    		arr[e]=ch;
	    		s++;
	    		e--;
	    	}
	    	
	    }
	    
	    
	    public static void main(String[] args) {
	    	//Example 1:

	    	String dominoes1 = "RR.L";
	    	String output1="RR.L";

	    	//Example 2:
	    	
	    	String dominoes2 = ".L.R...LR..L..";
	    	String output2="LL.RR.LLRRLL..";
	    	
	    	//Example 3:
	    	
	    	String dominoes3 = "L.....RR.RL.....L.R.";
	    	String output3="RRR.L";
	    	
	    	
	    	System.out.println(pushDominoes(dominoes1));
	    	System.out.println(pushDominoes(dominoes2));
	    	System.out.println(pushDominoes(dominoes3));
	    	

		}
	

}
