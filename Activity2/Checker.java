import java.util.*;
public class Checker {
	static Scanner sc = new Scanner(System.in);
	public static String searchInputChecker () {
		String textPattern = "";
		try{
			sc = new Scanner(System.in);
			
			System.out.println("Enter a characters that you want to search");
			System.out.print("Search: ");
			
			textPattern = sc.nextLine().toString();
			if (textPattern.length() == 0) {
				System.out.println("You cant search null value!!");
				return searchInputChecker();
			}
		} catch (Exception e) {}
		return textPattern;
	}
	public static int inputChecker (String message,int inputMin, int inputMax) {
		boolean choiceChecker = false;
		int choice = 0;

		do {
			System.out.print(message);
			while (!sc.hasNextInt()) {
				System.out.println("Invalid Input\n");
				System.out.println("Select between " + inputMin + " and " + inputMax);
			System.out.print(message);
			sc.next();
			}
			choice = sc.nextInt();
			if (choice >= inputMin && choice <= inputMax){
				choiceChecker = true;
			} else {
				System.out.println("Invalid Input\n");
				System.out.println("Select between " + inputMin + " and " + inputMax);
			}
		} while ( choiceChecker == false);
		return choice;
	}
	public static int inputChecker (int inputMin,String message) {
		boolean choiceChecker = false;
		int choice = 0;
		do {
			System.out.print(message);
			while(!sc.hasNextInt()) {
				System.out.println("Invalid Input\n");
				System.out.println("Input must be more than 0");
			System.out.print(message);
			sc.next();
			}
			choice = sc.nextInt();
			if (choice > inputMin) {
				choiceChecker = true;
			} else {
				System.out.println("Invalid Input\n");
				System.out.println("Input must be more than 0");
			}
		} while ( choiceChecker == false);
		return choice;
	}
}