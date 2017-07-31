package ua.nure.koval.Practice6.part1;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class WordContainer extends TreeSet<Word> {

    public WordContainer(Comparator<? super Word> comparator) {
        super(comparator);
    }

    public static void main(String[] args) {
        Part1.wordCounter(System.in, System.out);
    }

    @Override
    public boolean add(Word w) {
        Iterator<Word> iterator = iterator();
        if (!contains(w)) {
            super.add(w);
            return false;
        }
        while (iterator.hasNext()) {
            Word next = iterator.next();
            if (comparator().compare(next,w) == 0) {
                next.setFrequency(next.getFrequency() + 1);
                return true;
            }
        }
        return false;
    }


    public Iterator<Word> frequencyIterator() {
        TreeSet<Word> words = new TreeSet<>(new Word.CompareByFrequency());
        for (Iterator<Word> iterator = iterator(); iterator.hasNext(); ) {
            Word next = iterator.next();
            words.add(next);
        }
        return words.iterator();
    }
}
