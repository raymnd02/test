package activity4;
import java.util.*;
public class Activity2 {
	static String file = "";
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		String dir = System.getProperty ("user.dir");
		file = dir + "\\src\\main\\resources\\Sample.txt";
		selectOptions();
		
	}
	public static void selectOptions () {
		int row,column,orderBy;
		FileIO fileIO = new FileIO();
		Function function = new Function();
		ArrayList<ArrayList<String>> tableList = fileIO.read(file);
		
		System.out.println("Selection Menu");
		System.out.println("1   Print");
		System.out.println("2   Edit");
		System.out.println("3   Search");
		System.out.println("4   Add new row"); 
		System.out.println("5   Sort");
		System.out.println("6   Reset");
		System.out.println("7   Exit");
		int choice = Checker.inputChecker("Select: ",1,7,sc);
		System.out.println("");
		switch ( choice ) {
			case 1:
			fileIO = new FileIO();
			tableList = fileIO.read(file);
				if (tableList.isEmpty()) {
					System.out.println("The file is empty");
				} else {
					function.print(tableList);
				}
				selectOptions();
				break;
			case 2:
				if (tableList.isEmpty()) {
					System.out.println("The file is empty");
				} else {
					int maxRowIndex, maxColIndex, keyOrValue;
					maxRowIndex = tableList.size() - 1;
					
					System.out.println("Enter the index of row: ");
					row = Checker.inputChecker("Enter row index: ", 0, maxRowIndex,sc);
					maxColIndex = tableList.get(row).size() - 1;
					column = Checker.inputChecker("Enter column index: ", 0, maxColIndex,sc);
					keyOrValue = Checker.inputChecker("Select you want to edit\n1 key\n2 value\nselect: ", 1, 2,sc);
					
					System.out.print("Change to: ");
					String changeTo = sc.nextLine();
					fileIO.writeTable(function.edit(row,column,keyOrValue,changeTo,tableList),file);
				}
				selectOptions();
				break;
			case 3:
				if (tableList.isEmpty()) {
					System.out.println("The file is empty");
				} else {
					String textPattern = Checker.searchInputChecker(sc);
					function.search(textPattern,tableList);
				}
				selectOptions();
				break;
			case 4:
				if (tableList.isEmpty()) {
					System.out.println("The file is empty");
				} else {
					fileIO.writeTable(function.addRow(tableList),file);
				}
				selectOptions();
				break;
			case 5:
				if (tableList.isEmpty()) {
					System.out.println("The file is empty");
				} else {
					row = Checker.inputChecker("Enter row you want to sort: ",0,tableList.size() - 1,sc);
					orderBy = Checker.inputChecker("Sort order by\n1 Ascending\n2 Descending\nSelect: ", 1, 2,sc);
					fileIO.writeTable(function.sort(row,orderBy,tableList), file);
				}
				System.out.println("");
				selectOptions();
				break;
			case 6:
				
				row = Checker.inputChecker(0,"Enter the number of row: ",sc);
				column = Checker.inputChecker(0,"Enter the number of column: ",sc);
				fileIO.writeTable(function.reset(row,column),file);
				System.out.println("");
				selectOptions();
				break;
			case 7:
				System.out.println("Exit");
				System.exit(0);
		}
	}
}