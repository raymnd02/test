import java.util.*;
import java.util.regex.*;
public class Function {
	Scanner sc = new Scanner(System.in);
	public void print (ArrayList<ArrayList<String>> tableList) {
		int row = tableList.size();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < tableList.get(i).size(); j++) {
				System.out.print(tableList.get(i).get(j) + ",\t");
			}
			System.out.println("");
		}
		System.out.println("");
	}
	public ArrayList<ArrayList<String>> edit (int row, int column, int keyOrValue,String changeTo, ArrayList<ArrayList<String>> tableList) {
		
		String splittedString [] = tableList.get(row).get(column).split(":");
		String editedStr = "";
		if (keyOrValue == 1) {
			editedStr = changeTo + ":" + splittedString[1];
		} else if (keyOrValue == 2){
			editedStr = splittedString[0] + ":" + changeTo;
		}
		System.out.println("");
		tableList.get(row).set(column,editedStr);
		return tableList;
	}
	public void search (String stringToSearch, ArrayList<ArrayList<String>> tableList) {
		Pattern pattern = Pattern.compile(stringToSearch);
		boolean foundCheck = false;
		for (int i = 0; i < tableList.size(); i++) {
			ArrayList<String> rowItems = new ArrayList<>();
			rowItems = tableList.get(i);
			for (int j = 0 ; j < tableList.get(i).size(); j++) {
				int countMatch = 0;
				String splitedValue[] = tableList.get(i).get(j).split(":");
				String matchIn = splitedValue[0] + splitedValue[1];
				Matcher matcher = pattern.matcher(matchIn);
				while( matcher.find() ) { countMatch ++; }
				if ( countMatch != 0 ) {
					System.out.print(stringToSearch + " Found in cell(" + i +"," + j + "): ");
					System.out.println(countMatch + " occurence");
					foundCheck = true;
				}			
			}
		}
		if (foundCheck == false) {
			System.out.println("No Matches found");
		}
		System.out.println("");
	}
	public ArrayList<ArrayList<String>> addRow (ArrayList<ArrayList<String>> tableList) {
		String key;
		String value;
		int rowMaxLength = 0;
		ArrayList<String> additionalRow = new ArrayList<> ();
		for (int i = 0; i < tableList.size(); i++) {
			if (rowMaxLength < tableList.get(i).size()) {
				rowMaxLength = tableList.get(i).size();
			}
		}
		for (int i = 0; i < rowMaxLength; i++) {
			System.out.print("[" + (tableList.size()) +"][" + i + "]");
			System.out.print("Enter Key: ");
			key = sc.nextLine();
			System.out.print("[" + (tableList.size()) +"][" + i + "]");
			System.out.print("Enter Value: ");
			value = sc.nextLine();
			additionalRow.add(key + ":" + value);
			System.out.print("[" + (tableList.size()) +"][" + i + "]");
			System.out.println(" - " + key + ":" + value);
		}
		tableList.add(additionalRow);
		return tableList;
	}
	public ArrayList<ArrayList<String>> sort (int index, int orderBy, ArrayList<ArrayList<String>> tableList) {
		if (orderBy == 1) {
			Collections.sort(tableList.get(index));
		} else {
			Collections.reverse(tableList.get(index));
		}
		return tableList;
	}
	public ArrayList<ArrayList<String>> reset (int row,int column) {
		Random r = new Random();
		ArrayList<ArrayList<String>> tableList = new ArrayList<> ();
		ArrayList<String> rowList = new ArrayList<String> ();
		String uppercase="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowercase="abcdefghijklmnopqrstuvwxyz";
		String specialChar="@#$_&-+()/*';!?|.~><[]{}\\=`%";
		String numbers="1234567890";
		String characters=uppercase+lowercase+specialChar+numbers;
		for ( int i = 0 ; i <= row - 1; i++ ) {
			rowList = new ArrayList<String> ();
			String fileRowReset = "";
			for ( int j = 0 ; j <= column - 1; j++ ) {
				
				String randomKey = "";
				String randomValue = "";
				
				for ( int k = 0; k< 3; k++ ) {
					randomKey += characters.charAt (r.nextInt(characters.length()));
					randomValue += characters.charAt (r.nextInt(characters.length()));
				}rowList.add(randomKey+":"+randomValue);
			}
			tableList.add(rowList);
		}
		return tableList;
	}
}