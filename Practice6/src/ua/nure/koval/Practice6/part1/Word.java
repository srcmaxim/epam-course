package ua.nure.koval.Practice6.part1;

import java.util.Comparator;

public class Word {

	private String value;

	private int frequency;

	Word(String value) {
		this.value = value;
		frequency = 1;
	}

	String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	int getFrequency() {
		return frequency;
	}

	void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	/*
	1 симетрично
	2 транзитивно
	3 рефлективно
	4 стейтлесс
	5 нул
	 */

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Word word1 = (Word) o;

		return frequency == word1.frequency && value.equals(word1.value);
	}

/*
	1 должен возвращать максимально уникальное значение
	2 если объекты екюалс значит и их хешкоды равны
	3 стейтлесс
	 */

	@Override
	public int hashCode() {
		int result = value.hashCode();
		result = 31 * result + frequency;
		return result;
	}

	static class CompareByWord implements Comparator<Word> {
		@Override
		public int compare(Word o1, Word o2) {
			return o1.getValue().compareTo(o2.getValue());
		}
	}

	static class CompareByFrequency implements Comparator<Word> {
		@Override
		public int compare(Word o1, Word o2) {
			int comparation = -o1.getFrequency() + o2.getFrequency();
			if (comparation == 0) {
				return new CompareByWord().compare(o1, o2);
			}
			return comparation;
		}
	}
}
