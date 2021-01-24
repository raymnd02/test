package com.exist.utils;
import org.apache.commons.lang3.StringUtils;
import java.util.*;
public class Checker {
	public static String searchInputChecker (Scanner sc) {
		String textPattern = "";
		try{
			System.out.println("Enter a characters that you want to search");
			System.out.print("Search: ");
			
			textPattern = sc.nextLine().toString();
			if (StringUtils.isBlank(textPattern)) {
				System.out.println("You cant search null value!!");
				return searchInputChecker(sc);
			}
		} catch (Exception e) {}
		return textPattern;
	}
	public static int inputChecker (String message,int inputMin, int inputMax,Scanner sc) {
		boolean choiceChecker = false;
		int choice = 0;

		do {
			System.out.print(message);
			String input = sc.nextLine();
			while(!StringUtils.isNumeric(input)) {
				System.out.println("Invalid Input\n");
				System.out.println("Select between " + inputMin + " and " + inputMax);
			    System.out.print(message);
				input = sc.nextLine();
			} 
			choice = Integer.parseInt(input);
			if (choice >= inputMin && choice <= inputMax){
				choiceChecker = true;
			} else {
				System.out.println("Invalid Input\n");
				System.out.println("Select between " + inputMin + " and " + inputMax);
			}
		} while ( choiceChecker == false);
		return choice;
	}
	public static int inputChecker (int inputMin,String message,Scanner sc) {
		boolean choiceChecker = false;
		int choice = 0;
		do {
			System.out.print(message);
			String input = sc.nextLine();
			while(!StringUtils.isNumeric(input)) {
				System.out.println("Invalid Input\n");
				System.out.println("Input must be more than 0");
				System.out.print(message);
				input = sc.nextLine();
			}
			choice = Integer.parseInt(input);
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