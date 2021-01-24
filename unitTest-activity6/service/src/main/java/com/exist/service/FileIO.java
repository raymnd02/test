package com.exist.service;
import java.util.*;
import java.io.*;
import com.exist.model.Table;
import org.apache.commons.io.IOUtils;

import java.util.stream.*;
public class FileIO {
	
	public ArrayList<ArrayList<Table>> read (String filePath) {
		
		ArrayList<ArrayList<Table>> tableList = new ArrayList<ArrayList<Table>> ();
		try {
				InputStream inputStream = new FileInputStream(filePath);
				List<String> table = IOUtils.readLines(inputStream);
				table.stream().forEach(line -> {
					
					ArrayList<Table> tableRowLine = new ArrayList<>();
					String []tableLine = line.split(",\t");
					Arrays.stream(tableLine).forEach(tableRow -> {
						String []TableItem = tableRow.split(":");
						tableRowLine.add(new Table(TableItem[0],TableItem[1]));
					});
						
					
					tableList.add(tableRowLine);
				});
				
			// }
		} catch (Exception e) {}
		return tableList;
	}
	public void writeTable (ArrayList<ArrayList<Table>> table,String filePath) {
		try {
			ArrayList<String> lineToPrint = new ArrayList<>();
			table.stream().forEach(line -> {
				String printLine = "";
				for (int i = 0; i < line.size(); i++) { 		      
					if (printLine == ""){
						printLine += line.get(i).getKey() + ":" + line.get(i).getValue();
					} else {
						printLine += ",\t" + line.get(i).getKey() + ":" + line.get(i).getValue();
					}
				}  

				lineToPrint.add(printLine);	
			});
			IOUtils.writeLines(lineToPrint,"\n", new FileOutputStream(filePath));
		} catch (Exception e) {e.printStackTrace();}
	}
}