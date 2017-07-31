package ua.nure.koval.Practice6.part7;

import java.util.Iterator;

public class Range implements Iterable<Integer> {

    private final int start;
    private final int end;
    private final boolean ascending;

    Range(int a, int b) {
        this(a, b, false);
    }

    Range(int a, int b, boolean reverse) {
        ascending = !reverse;
        start = a;
        end = b;
    }


    public void output() {
        Iterator<Integer> it = iterator();
        while (it.hasNext()) {
            System.out.printf("%s ", it.next());
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        if (ascending) {
            return new RangeIteratorAscending();
        }
        return new RangeIteratorDescending();
    }

    private class RangeIteratorAscending implements Iterator<Integer> {
        private int pointer;

        RangeIteratorAscending() {
            pointer = start - 1;
        }

        @Override
        public boolean hasNext() {
            return pointer < end;
        }

        @Override
        public Integer next() {
            return ++pointer;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class RangeIteratorDescending implements Iterator<Integer> {
        private int pointer;

        RangeIteratorDescending() {
            pointer = end + 1;
        }

        @Override
        public boolean hasNext() {
            return pointer > start;
        }

        @Override
        public Integer next() {
            return --pointer;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

}
