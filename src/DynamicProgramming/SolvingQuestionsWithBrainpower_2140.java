//2140. Solving Questions With Brainpower
//Medium
//Topics
//Companies
//Hint
//You are given a 0-indexed 2D integer array questions where questions[i] = [pointsi, brainpoweri].
//
//The array describes the questions of an exam, where you have to process the questions in order (i.e., starting from question 0) and make a decision whether to solve or skip each question. Solving question i will earn you pointsi points but you will be unable to solve each of the next brainpoweri questions. If you skip question i, you get to make the decision on the next question.
//
//For example, given questions = [[3, 2], [4, 3], [4, 4], [2, 5]]:
//If question 0 is solved, you will earn 3 points but you will be unable to solve questions 1 and 2.
//If instead, question 0 is skipped and question 1 is solved, you will earn 4 points but you will be unable to solve questions 2 and 3.
//Return the maximum points you can earn for the exam.
//
// 
//
//Example 1:
//
//Input: questions = [[3,2],[4,3],[4,4],[2,5]]
//Output: 5
//Explanation: The maximum points can be earned by solving questions 0 and 3.
//- Solve question 0: Earn 3 points, will be unable to solve the next 2 questions
//- Unable to solve questions 1 and 2
//- Solve question 3: Earn 2 points
//Total points earned: 3 + 2 = 5. There is no other way to earn 5 or more points.
//Example 2:
//
//Input: questions = [[1,1],[2,2],[3,3],[4,4],[5,5]]
//Output: 7
//Explanation: The maximum points can be earned by solving questions 1 and 4.
//- Skip question 0
//- Solve question 1: Earn 2 points, will be unable to solve the next 2 questions
//- Unable to solve questions 2 and 3
//- Solve question 4: Earn 5 points
//Total points earned: 2 + 5 = 7. There is no other way to earn 7 or more points.
// 
//
//Constraints:
//
//1 <= questions.length <= 105
//questions[i].length == 2
//1 <= pointsi, brainpoweri <= 105

package DynamicProgramming;

public class SolvingQuestionsWithBrainpower_2140 {
	
	public static  long mostPoints(int[][] questions) {
		
		return getMostPoints(questions, 0);
    }
	public static long getMostPoints(int [][] questions, int index) {
		if(index>=questions.length) {
			return 0;
		}
		// Solve the current question
        long take = questions[index][0] + getMostPoints(questions, index + questions[index][1] + 1);

        // Skip the current question
        long skip = getMostPoints(questions, index + 1);
        return Math.max(take, skip);
	}
	
	
	

	public static void main(String[] args) {
		//Example 1:
		
		int [][] questions1 = {{3,2},{4,3},{4,4},{2,5}};
		int output1=5;
		
		//Example 2:

		int [][] questions2 = {{1,1},{2,2},{3,3},{4,4},{5,5}};
		int output2=7;
		
		//Example 3:
		
		int [][] questions3 = {{21,5},{92,3},{74,2},{39,4},{58,2},{5,5},{49,4},{65,3}};
		int output3=157;
		
		System.out.println(mostPoints(questions1));
		System.out.println(mostPoints(questions2));
		System.out.println(mostPoints(questions3));

	}

}
