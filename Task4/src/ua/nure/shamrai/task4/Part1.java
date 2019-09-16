package ua.nure.shamrai.task4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String enteredStirng = "";
		String readedString = "";
		StringBuilder strb = new StringBuilder();
		while (sc.hasNextLine()) {
			enteredStirng = sc.nextLine();
			if (!"stop".equals(enteredStirng)) {
				if ("Cyrl".equals(enteredStirng)) {
					readedString = readFile("\\p{IsCyrillic}+");
				} else if ("Latn".equals(enteredStirng)) {
					readedString = readFile("\\p{IsLatin}+");
				} else {
					readedString = "Incorrect input";
				}
				strb.append(enteredStirng);
				strb.append(": ");
				strb.append(readedString);
				System.out.println(strb.toString());
			}else {
				break;
			}
			strb.setLength(0);
		}
	}

	public static String readFile(String endcode) {
		StringBuilder strb = new StringBuilder();
		Pattern pattern = Pattern.compile(endcode);
		Matcher m = null;
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("part1.txt"),"Cp1251"))) {
			String string;
			while (((string = br.readLine()) != null)) {
				m = pattern.matcher(string);
				while (m.find()) {
					strb.append(m.group());
					strb.append(" ");
				}
			}
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		return strb.toString().trim();
	}

}