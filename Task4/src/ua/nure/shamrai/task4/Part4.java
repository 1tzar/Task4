package ua.nure.shamrai.task4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.SecureRandom;

public class Part4 {
	private static final  int COUNT_ELEMENTS = 51;
	private static final  int MIN = 0;
	private static final  int MAX = 50;

	public static void main(String[] args)  {
		File f = new File("part4.txt");
		if (!f.exists()) {
			String randomBuffer = string10Numbers();
			writeToFile(f, randomBuffer);
		}
		String input = readFile("part4.txt");
		String sortedInput = distinct(insertionSort(input.split(" ")));
		f = new File("part4_sorted.txt");
		writeToFile(f, sortedInput);
		String output = readFile("part4_sorted.txt");
		System.out.printf("input ==> %s%n",input);
		System.out.printf("output ==> %s",output);

	}

	public static void writeToFile(File f, String buffer) {
		try (BufferedWriter bf = new BufferedWriter(new FileWriter(f))) {
			bf.write(buffer);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static String distinct(String[] buffer) {
		StringBuilder strb = new StringBuilder();
		for (int i = 0;; i++) {
			String elem = String.valueOf(buffer[i]);
			if (strb.indexOf(elem) == -1) {
				strb.append(elem);
				strb.append(" ");
			}
			if (i == buffer.length - 1) {
				return strb.toString();
			}
		}
	}

	public static String readFile(String name) {
		StringBuilder strb = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(new File(name)))) {
			String str;
			while ((str = br.readLine()) != null) {
				strb.append(str);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return strb.toString();
	}

	public static String[] insertionSort(String[] array) {
		for (int i = 1; i < array.length; i++) {
			String element = array[i];
			int j = i - 1;
			while (j >= 0 && Integer.parseInt(array[j]) > Integer.parseInt(element)) {
				array[j + 1] = array[j];
				--j;
			}
			array[j + 1] = element;
		}
		return array;
	}

	public static String string10Numbers() {
		SecureRandom sr = new SecureRandom();
		StringBuilder strb = new StringBuilder();
		for (int i = 1;; i++) {
			strb.append(sr.nextInt(MAX) + MIN);
			if (i == COUNT_ELEMENTS) {
				return strb.toString();
			}
			strb.append(" ");
		}
	}

}
