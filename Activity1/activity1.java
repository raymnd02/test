import java.util.*;
import java.io.*;

class Activity1{
	static Scanner sc = new Scanner(System.in);
	static int firstDimension =0;
	static int secondDimension=0;
	public static void main(String[] Args){
		dimensionTable();
	}
	public static void dimensionTable(){
		Random r = new Random();

		String uppercase="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowercase="abcdefghijklmnopqrstuvwxyz";
		String specialChar="@#$_&-+()/*':;!?\",.~><[]{}\\=|`%";
		String numbers="1234567890";
		String characters=uppercase+lowercase+specialChar+numbers;

		System.out.println("Create a 2D table");
		System.out.print("Enter the number of column: ");

		while(!sc.hasNextInt()){
			System.out.println("Invalid Input!!!");

			System.out.print("Enter the number of column: ");
			sc.next();
		}
		firstDimension = sc.nextInt()-1;

		System.out.print("Enter the number of row: ");

		while(!sc.hasNextInt()){
			System.out.println("Invalid Input!!!");
			System.out.print("Enter the number of row: ");
			sc.next();
		}
		secondDimension = sc.nextInt()-1;

		System.out.println("");
		String table[][] = new String[secondDimension+1][firstDimension+1];

		for(int i=0;i<=secondDimension;i++){
			for(int j = 0;j <= firstDimension;j++){
				String combination="";
				for(int k=0;k<3;k++){
					combination+=characters.charAt(r.nextInt(characters.length()));
				}
				table[i][j]=combination;
				System.out.print("| "+table[i][j]+" ");
			}
			System.out.println("|");
		}
		System.out.println("");
		selectOption(table);
	}
	public static void editTable(String arr[][]){
		System.out.println("Give the coordinates you want to edit [cell(x,y)]");

		boolean option1=false; 
		int xCoordinate=0;
		do{
			System.out.print("Enter the value of x:");
			while(!sc.hasNextInt()){
				System.out.println("Invalid Input!!!\n");
				System.out.println("Enter between 0 and "+secondDimension);
				System.out.print("Enter your choice: ");
				sc.next();
			}
		    xCoordinate=sc.nextInt();
			if(xCoordinate>=0 && xCoordinate<=secondDimension){
				option1=true;
			}
			else{
				System.out.println("Invalid Input!!!\n");
				System.out.println("Enter between 0 and "+secondDimension);
			}

		}while(option1==false);

		option1=false; 
		int yCoordinate=0;
		do{
			System.out.print("Enter the value of y:");
			while(!sc.hasNextInt()){
				System.out.println("Invalid Input!!!\n");
				System.out.println("Enter between 0 and "+firstDimension);
				System.out.print("Enter your choice: ");
				sc.next();
			}
		    yCoordinate=sc.nextInt();
			if(yCoordinate>=0 && yCoordinate<=firstDimension){
				option1=true;
			}
			else{
				System.out.println("Invalid Input!!!\n");
				System.out.println("Enter between 0 and "+firstDimension);
			}

		}while(option1==false);
		System.out.println("Change the value of cell("+xCoordinate+","+yCoordinate+")");

		String changeTo="";
		boolean option = false;
		do{
			System.out.print("to: ");
			changeTo=sc.next();

			if(changeTo.length()==3){
				option=true;
			}else{
				System.out.println("Invalid Input\n");
				System.out.println("Enter 3 characters");
			}
		}while(option!=true);

		arr[xCoordinate][yCoordinate]=changeTo;

		System.out.println("");
		showTable(arr);
		System.out.println("");
		selectOption(arr);
	}
	public static void selectOption(String arr[][]){
		System.out.println("------------Option------------");
		System.out.println("\"1\" to search,\n\"2\" to edit,\n\"3\" to reset,\n\"4\" to display table,\n\"5\" to exit.");
		boolean option1=false; 
		int choice=0;
		do{
			System.out.print("Enter your choice: ");
			while(!sc.hasNextInt()){
				System.out.println("Invalid Input!!!\n");
				System.out.println("Enter between 1 and 5");
				System.out.print("Enter your choice: ");
				sc.next();
			}
		    choice=sc.nextInt();
			if(choice>=0 && choice<6){
				option1=true;
			}
			else{
				System.out.println("Invalid Input!!!\n");
				System.out.println("Enter between 1 and 5");
			}
		}while(option1==false);

		System.out.println("");
		if(choice==1){
			searchTable(arr);
		}
		if(choice==2){
			editTable(arr);
		}
		if(choice==3){
			dimensionTable();
		}
		if(choice==4){
			showTable(arr);
		}
		if(choice==5){
			System.out.println("Exit");
			System.exit(0);
		}
	}
	public static void searchTable(String arr[][]){
		System.out.println("Enter a characters that you want to search");
		System.out.print("Search: ");
		String textPattern=sc.next().toString();


        boolean found=false;
		String result="";
		int count =0;
		for(int i=0;i<=secondDimension;i++){
			for(int j = 0;j <= firstDimension;j++){
				count = 0;
				int c=textPattern.length();
				boolean checker=false;
				for(int k =0;k<3-c+1;k++){
					if(found==false){
						found=arr[i][j].contains(textPattern);
					}
					String compareTo =arr[i][j].substring(k,c+k);

					if(textPattern.equals(compareTo)){
						result=textPattern+" found in cell("+i+","+j+")";
						count++;
						checker=true;
					}
				}
				if(checker==true){
					System.out.println(result+": "+count+" occurence");
				}
			}
		}
		if(found==false){
			System.out.println("No Matches found");
		}
		System.out.println("");
		selectOption(arr);
	}
	public static void showTable(String arr[][]){
		for(int i=0;i<=secondDimension;i++){
			for(int j = 0;j <= firstDimension;j++){

				System.out.print("| "+arr[i][j]+" ");
			}
			System.out.println("|");
		}
		System.out.println("");
		selectOption(arr);
	}
}

