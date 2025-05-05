package Maths;
// 1344. Angle Between Hands of a Clock
// Solved
// Medium
// Topics
// Companies
// Hint
// Given two numbers, hour and minutes, return the smaller angle (in degrees) formed between the hour and the minute hand.

// Answers within 10-5 of the actual value will be accepted as correct.

 

// Example 1:


// Input: hour = 12, minutes = 30
// Output: 165
// Example 2:


// Input: hour = 3, minutes = 30
// Output: 75
// Example 3:


// Input: hour = 3, minutes = 15
// Output: 7.5
 

// Constraints:

// 1 <= hour <= 12
// 0 <= minutes <= 59


class AngleBetweenHandsOfAClock_1344 {
//	approch :
//	find the angle from 12 to minute hand
//	find the angle from 12 to hr hand
//	substract both we will get the angle between hr and minute hand
//	now we need to substract the above difference by 360 to find
//	minimum angle because there could be a chance where the angle btw them
//	is greater then angle around them
//	time complexity :O(1)
//	space complexity :O(1)
    public static double angleClock(int hour, int minutes) {
        if(minutes==0){
            return Math.min(hour*30,360-hour*30);
        }
        // find minute hand position in the clock
        double minhandpos=(double)minutes/5.0;
        // find angle from 12 to minute hand position
        double minhandangle= (minhandpos%12)*30.0;
        // now find angle of deviation from hrs hand
        double deviation= minhandangle/12.0;
        // find angle from 12 till hrs hand
        double hrhandangle= ((hour%12)*30)+deviation;
        // now just find abs difference btw the 2 angles
        double res=Math.abs(hrhandangle-minhandangle);
        // here we check the result angle is small or the rest of angle is smaller
        return Math.min(res,360-res);
    }
    public static void main(String[] args) {
    	
    	

    	// Example 1:

    	int hour1 = 12, minutes1 = 30;
    	double output1=165;

    	// Example 2:

    	int hour2 = 3, minutes2 = 30;
    	double output2=75;

    	// Example 3:
    	
    	int hour3 = 1, minutes3 = 4;
    	double output3=8;

    	// Example 4:
    	
    	int hour4 = 1, minutes4 = 57;
    	double output4=76.5;
    	
    	double ans1=angleClock(hour1,minutes1);
		double ans2=angleClock(hour2,minutes2);
		double ans3=angleClock(hour3,minutes3);
		double ans4=angleClock(hour4,minutes4);
		
		if(output1==ans1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output :"+output1 );
			System.out.println("Your Output :"+ans1);
		}
		if(output2==ans2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Actual Output :"+output2 );
			System.out.println("Your Output :"+ans2);
		}
		if(output3==ans3) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Actual Output :"+output3);
			System.out.println("Your Output :"+ans3);
		}
		if(output4==ans4) {
			System.out.println("Case 4 Passed");
		}else {
			System.out.println("Case 4 Failed");
			System.out.println("Actual Output :"+output4);
			System.out.println("Your Output :"+ans4);
		}
   			
	}
    
}