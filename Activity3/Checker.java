import java.util.*;
public class Checker {
	private static int step;
	public static int inputChecker (Scanner sc,String message,int inputMin) {
		boolean choiceChecker = false;
		int input = 0;

		do {
			System.out.print(message);
			while (!sc.hasNextInt()) {
				System.out.println("Invalid Input\n");
				System.out.println("Must be more than " + inputMin);
				System.out.print(message);
				sc.next();
			}
			input = sc.nextInt();
			if (input >= inputMin){
				choiceChecker = true;
			} else {
				System.out.println("Invalid Input\n");
				System.out.println("Must be more than " + inputMin);
			}
		} while ( choiceChecker == false);
		return input;
	}
	
	public static int inputChecker (Scanner sc,String message,int inputMin, int inputMax) {
		boolean choiceChecker = false;
		int choice = 0;

		do {
			System.out.print(message);
			while (!sc.hasNextInt()) {
				System.out.println("Invalid Input\n");
				System.out.println("Input between " + inputMin + " and " + inputMax);
			System.out.print(message);
			sc.next();
			}
			choice = sc.nextInt();
			if (choice >= inputMin && choice <= inputMax){
				choiceChecker = true;
			} else {
				System.out.println("Invalid Input\n");
				System.out.println("Input between " + inputMin + " and " + inputMax);
			}
		} while ( choiceChecker == false);
		return choice;
	}
	
	public static int getMin(int[] inputArray){ 
		int minValue = inputArray[0]; 
		for(int i=1;i<inputArray.length;i++){ 
			if(inputArray[i] < minValue){ 
				minValue = inputArray[i]; 
			} 
		} 
		return minValue; 
	} 
	public static int stepChecker (int horseStep,int steps,int limit) {
		int totalStep = horseStep + steps;
		step = steps;
		if (totalStep >= limit) {
			return limit;
		} else {
			return totalStep;
		}
	}
}