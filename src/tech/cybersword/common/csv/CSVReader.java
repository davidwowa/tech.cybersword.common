package tech.cybersword.common.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tech.cybersword.common.date.DateFormatter;

public class CSVReader {

	public Map<String, String[]> readFOSSCSVFile(String file) {
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			int counter = 0;
			String line;
			Map<String, String[]> map = new HashMap<>();
			while ((line = br.readLine()) != null) {
				String[] arr = line.split(";");
				if (counter >= 1 && arr.length >= 4) {
					String key = arr[1] + "|" + arr[2] + "|" + arr[3];
					map.put(key, arr);
				}
				counter++;
			}
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Collections.emptyMap();
	}

	public List<String> readGanttCSVFile(String file) {
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			List<String> list = new ArrayList<>();
			while ((line = br.readLine()) != null) {
				list.add(line);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	public Map<Integer, String[]> readCSVFile(String file) {
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			Integer counter = 0;
			String line;
			Map<Integer, String[]> map = new HashMap<>();
			while ((line = br.readLine()) != null) {
				String[] arr = line.split(";");
				if (counter >= 1 && arr.length >= 4) {
					map.put(counter, arr);
				}
				counter++;
			}
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Collections.emptyMap();
	}

	public static void main(String[] args) {
		CSVReader csvReader = new CSVReader();

		var i = csvReader.readCSVFile(
				"c_data.csv");

		CSVWriter csvWriter = new CSVWriter();

		DateFormatter dateFormatter = new DateFormatter();
		Date date = new Date();

		String strDate = dateFormatter.formatedDateFrom(date);

		csvWriter.writeCSVFile(
				"c_data_"
						+ strDate + ".csv",
				i);
	}
}