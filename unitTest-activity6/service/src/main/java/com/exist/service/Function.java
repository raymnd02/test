package com.exist.service;
import java.util.*;
import java.util.regex.*;
import com.exist.model.Table;
public class Function {
	Scanner sc = new Scanner(System.in);
	public void print (ArrayList<ArrayList<Table>> tableList) {
		
		tableList.stream().forEach(row -> {
			row.stream().forEach(col -> {
				System.out.print(col.getKey() + ":" + col.getValue() + ",\t");
			});
			System.out.println();
		});
		System.out.println();
	}
	public ArrayList<ArrayList<Table>> edit (int row, int column, int keyOrValue,String changeTo, ArrayList<ArrayList<Table>> tableList) {
		
		if (keyOrValue == 1) {
			tableList.get(row).get(column).setKey(changeTo);
		} else if (keyOrValue == 2){
			tableList.get(row).get(column).setValue(changeTo);
		}
		return tableList;
	}
	public void search (String stringToSearch, ArrayList<ArrayList<Table>> tableList) {
		Pattern pattern = Pattern.compile(stringToSearch);
		boolean foundCheck = false;
		for (int i = 0; i < tableList.size(); i++) {
			for (int j = 0 ; j < tableList.get(i).size(); j++) {
				int countMatch = 0;
				String matchIn = tableList.get(i).get(j).getKey() + tableList.get(i).get(j).getValue();
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
	public ArrayList<ArrayList<Table>> addRow (ArrayList<ArrayList<Table>> tableList) {
		String key;
		String value;
		int rowMaxLength = 0;
		ArrayList<Table> additionalRow = new ArrayList<> ();
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
			additionalRow.add(new Table(key,value));
			System.out.print("[" + (tableList.size()) +"][" + i + "]");
			System.out.println(" - " + key + ":" + value);
		}
		tableList.add(additionalRow);
		return tableList;
	}
	public ArrayList<ArrayList<Table>> sort (int index, int orderBy, ArrayList<ArrayList<Table>> tableList) {
		
		ArrayList<String> listToSort = new ArrayList<>();
		ArrayList<Table> sortedTable = new ArrayList<>();
		
		tableList.get(index).stream()
			.forEach(listForSorting -> {
				listToSort.add(listForSorting.getKey() + ":" + listForSorting.getValue());
			});
		

		if (orderBy == 1) {
			Collections.sort(listToSort);
		} else {
			Collections.sort(listToSort,Collections.reverseOrder());
		}
		listToSort.stream().forEach(sortTable -> {
			String []keyAndValue = sortTable.split(":");
			sortedTable.add(new Table(keyAndValue[0],keyAndValue[1]));
			});
			tableList.set(index,sortedTable);
			
		return tableList;
	}
	public ArrayList<ArrayList<Table>> reset (int row,int column) {
		Random r = new Random();
		ArrayList<ArrayList<Table>> tableList = new ArrayList<> ();
		ArrayList<Table> rowList = new ArrayList<> ();
		String uppercase="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowercase="abcdefghijklmnopqrstuvwxyz";
		String specialChar="@#$_&-+()/*';!?|.~><[]{}\\=`%";
		String numbers="1234567890";
		String characters=uppercase+lowercase+specialChar+numbers;
		for ( int i = 0 ; i <= row - 1; i++ ) {
			rowList = new ArrayList<Table> ();
			String fileRowReset = "";
			for ( int j = 0 ; j <= column - 1; j++ ) {
				
				String randomKey = "";
				String randomValue = "";
				
				for ( int k = 0; k< 3; k++ ) {
					randomKey += characters.charAt (r.nextInt(characters.length()));
					randomValue += characters.charAt (r.nextInt(characters.length()));
				}rowList.add(new Table(randomKey,randomValue));
			}
			tableList.add(rowList);
		}
		return tableList;
	}
}