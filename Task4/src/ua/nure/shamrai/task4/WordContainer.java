package ua.nure.shamrai.task4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordContainer {

	private List<Word> wc;

	public WordContainer() {
		wc = new ArrayList<>();
	}

	public void put(String word) {
		boolean found = false;
		Word newWord = new Word(word);
		for(int i = 0; i < wc.size();i++) {
			Word currentWord = wc.get(i);
			if(newWord.equals(currentWord)) {
				newWord.frequency = currentWord.frequency + 1;
				wc.remove(i);
				wc.add(newWord);
				found = true;
				break;
			}
		}
		if (!found) {
			wc.add(newWord);
		}
	}

	public static void main(String[] args) {
		WordContainer fraquencyDictionary = new WordContainer();
		Scanner sc = new Scanner(System.in);
		StringBuilder strb = new StringBuilder();
		Pattern p = Pattern.compile("(?U)\\w+");
		Matcher m = null;
		boolean flag = true;
		while (sc.hasNextLine() && flag) {
			strb.append(sc.nextLine());
			m = p.matcher(strb.toString());
			while (m.find()) {
				if (!"stop".equals(m.group())) {
					fraquencyDictionary.put(m.group());
				} else {
					flag = false;
					break;
				}
			}
			strb.setLength(0);

		}
		System.out.println(fraquencyDictionary);
	}

	@Override
	public String toString() {
		StringBuilder strb = new StringBuilder();
		Collections.sort(wc);
		for (Word w : wc) {
			strb.append(w.content);
			strb.append(" : ");
			strb.append(w.frequency);
			strb.append(System.lineSeparator());
		}
		return strb.toString();
	}

	static class Word implements Comparable<Word> {
		private String content;
		private int frequency = 1;

		public Word(String content) {
			this.content = content;
		}

		public void setFrequency(int frequency) {
			this.frequency = frequency;
		}

		public int getFrequency() {
			return frequency;
		}

		@Override
		public int hashCode() {
			return frequency;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null || obj.getClass() != this.getClass()) {
				return false;
			}
			Word word = (Word) obj;
			return this.content.equals(word.content);
		}

		@Override
		public int compareTo(Word anotherWord) {
			if (this.frequency == anotherWord.frequency) {
				return this.content.compareTo(anotherWord.content);
			}
			return frequency - anotherWord.frequency;
		}
	}
}