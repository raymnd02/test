package activity4;
import java.util.*;
import java.io.*;
public class FileIO {
	
	public ArrayList<ArrayList<String>> read (String filePath) {
		ArrayList<ArrayList<String>> tableList = new ArrayList<ArrayList<String>> ();
		try {
			BufferedReader br = new BufferedReader (new FileReader(filePath));
			String readerResult = "";
			while ((readerResult = br.readLine()) != null) {
				String column[] = readerResult.split(",\t");
				ArrayList<String> columnLine = new ArrayList<String>();
				for (int i = 0; i < column.length; i++) {
					columnLine.add(column[i]);
				}
				tableList.add(columnLine);
			}
		} catch (Exception e) {}
		return tableList;
	}
	public void writeTable (ArrayList<ArrayList<String>> table,String filePath) {
		try {
			BufferedWriter wr = new BufferedWriter (new FileWriter(filePath));
			for ( int i = 0; i < table.size(); i++ ) {
			String list = "";
			for ( int j = 0; j < table.get(i).size(); j++ ) {
				if (list == "") {
					list = table.get(i).get(j);
					wr.write(table.get(i).get(j));
				} else {
					wr.write(",\t" + table.get(i).get(j));
				}
			}
			wr.write("\n");
		}
		wr.close();
		} catch (Exception e) {}
	}
}