package ua.nure.koval.Practice2;

import java.util.Iterator;

public class MyListImpl implements MyList {

    private Object[] elementData = new Object[INIT_SIZE];

    private int size;
    private static final int INIT_SIZE = 10;

    @Override
    public void add(Object o) {
        if (elementData.length < size + 1) {
            Object[] tmpArray = new Object[(elementData.length * 3) / 2 + 1];
            System.arraycopy(elementData, 0, tmpArray, 0, elementData.length);
            elementData = tmpArray;
        }
        elementData[size] = o;
        size++;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size(); i++) {
            if (!canCompareByNullOrEquality(o, elementData[i])
                    && (o == elementData[i]
                    || o.equals(elementData[i]))) {
                System.arraycopy(elementData, i + 1,
                        elementData, i, size - i);
                size--;
                elementData[size] = null;
                return true;
            }
        }
        return false;
    }

    /*
    If only one of the objects are null --
    they can't be equals by null == null or object equality
     */
    private boolean canCompareByNullOrEquality(Object a, Object b) {
        return a == null ^ b == null;
    }

    @Override
    public void clear() {
        elementData = new Object[INIT_SIZE];
        size = 0;
    }

    @Override
    public Object[] toArray() {
        Object[] copiedArray = new Object[size];
        System.arraycopy(elementData, 0, copiedArray, 0, size);
        return copiedArray;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean containsAll(MyList c) {
        Object[] array = c.toArray();
        for (int i = 0; i < array.length; i++) {
            if (!contains(array[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size(); i++) {
            if (!canCompareByNullOrEquality(o, elementData[i])
                    && (o == elementData[i]
                    || o.equals(elementData[i]))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (int i = 0; i < size(); i++) {
                result.append(String.valueOf(elementData[i])).append(", ");
        }
        result.replace(result.length() - 2, result.length(), "]");
        return result.toString();
    }

    @Override
    public ListIterator listIterator() {
        return new MyListIterator();
    }

    @Override
    public Iterator iterator() {
        return new MyListIterator();
    }

    private class MyListIterator implements ListIterator {
        private int iterator = -1;
        private boolean canBeRemoved = true;

        @Override
        public Object next() {
            if (!hasNext()) {
                throw new IllegalStateException();
            }
            iterator++;
            canBeRemoved = true;
            return elementData[iterator];
        }

        @Override
        public boolean hasNext() {
            return iterator < size() - 1;
        }

        @Override
        public Object previous() {
            if (!hasPrevious()) {
                throw new IllegalStateException();
            }
            canBeRemoved = true;
            Object elementDatum = elementData[iterator];
            iterator--;
            return elementDatum;
        }

        @Override
        public boolean hasPrevious() {
            return iterator >= 0;
        }

        @Override
        public void set(Object o) {
            if (!hasPrevious()) {
                next();
            }
            elementData[iterator] = o;
        }

        @Override
        public void remove() {
            if (!canBeRemoved) {
                throw new IllegalStateException();
            }
            canBeRemoved = false;
            /* remove deletes objects by equality,
            but now we need deletion by identity */
            elementData[iterator] = new Object();
            MyListImpl.this.remove(elementData[iterator]);
            iterator -= 1;
        }
    }
}
