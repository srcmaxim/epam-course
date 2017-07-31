package ua.nure.koval.Practice2;

public interface MyList extends ListIterable {
    void add(Object o);

    void clear();

    boolean remove(Object o);

    Object[] toArray();

    int size();

    boolean contains(Object o);

    boolean containsAll(MyList l);
}
