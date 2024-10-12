package tech.cybersword.common.text;

import java.util.Scanner;
import java.util.regex.Pattern;

public class RegexChecker {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("Input Regex:");
			String testRegex = scanner.nextLine();

			try {
				Pattern.compile(testRegex);
				System.out.println("Regex OK");
			} catch (Exception e) {
				System.out.println("Regex NOK");
			}
		}
	}
}