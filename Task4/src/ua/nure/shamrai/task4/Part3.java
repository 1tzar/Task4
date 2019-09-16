package ua.nure.shamrai.task4;

import java.util.Scanner;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.MissingResourceException;

public class Part3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = null;
		ResourceBundle bundle = null;

		while (sc.hasNextLine()) {
			str = sc.nextLine();
			if (!"stop".equals(str)) {
				String[] stroke = str.split("\\s");
				try {
					bundle = ResourceBundle.getBundle("resources", new Locale(stroke[1]));
					System.out.println(bundle.getString(stroke[0]));
				} catch (MissingResourceException | ArrayIndexOutOfBoundsException ex) {
					System.out.println("Incorrect input");
				}
			} else {
				break;
			}
		}
	}

}
