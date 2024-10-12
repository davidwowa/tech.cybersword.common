package tech.cybersword.common.csv;

import java.util.Map;

import tech.cybersword.io.file.MyFileWriter;

public class CSVWriter {

	public void writeCSVFile(String file, Map<Integer, String[]> data) {
		int dataLenght = data.size();

		StringBuilder strData = new StringBuilder();
		for (int i = 1; i < dataLenght; i++) {
			String[] array = data.get(i);
			String d = "";
			for (int j = 0; j < array.length; j++) {
				String string = array[j];
				
				// rule, remove it if you will write other csv file
				if (string.contains("/")) {
					String[] arr = string.split("/");
					arr[2] = "20" + arr[2];
					string = "";
					for (int k = 0; k < arr.length; k++) {
						string = string + "." + arr[k];
					}
					string = string.replaceFirst("\\.", "");
				}
				d = d + string + ";";
			}
			strData.append(d + "\n");
//			= strData + d + "\n";
			System.out.println(i);
		}

		MyFileWriter fileWriter = new MyFileWriter();
		System.out.println("write data");
		fileWriter.writeInToFile(file, strData.toString());
		System.out.println("write data end");
	}
}