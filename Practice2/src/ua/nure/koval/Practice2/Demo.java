package ua.nure.koval.Practice2;

import java.util.Iterator;

public final class Demo {
    private Demo() {
    }

    public static void main(String[] args) {

        System.out.println("==== Part1");

        MyList con = new MyListImpl();
        con.add("A");
        con.add("B");
        con.add(1);
        con.add(7);
        System.out.println(con);

        con.clear();
        System.out.println(con);
        con.add("A");
        con.add("B");
        con.add(7);
        System.out.println(con);

        con.remove("B");
        con.remove("C");
        System.out.println(con);

        System.out.println(con.size());

        System.out.println(con.contains("B"));
        System.out.println(con.contains(7));

        for (Object el : con.toArray()) {
            System.out.print(el + " ");
        }
        System.out.println();

        MyList anotherList = new MyListImpl();
        anotherList.add("A");
        anotherList.add(9);
        System.out.println(con.containsAll(anotherList));
        con.add(9);
        System.out.println(con.containsAll(anotherList));




        System.out.println("==== Part2");

        MyList con2 = new MyListImpl();
        con2.add("A");
        con2.add(7);
        con2.add(9);
        for (Object el : con) {
            System.out.print(el + " ");
        }
        System.out.println();

        Iterator<Object> it = con.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        it = con.iterator();
        it.next();
        it.next();
        it.remove();
        System.out.println(con);
        System.out.println(it.hasNext());
        System.out.println(it.next());
        System.out.println(it.hasNext());




        System.out.println("==== Part3");

        MyList con3 = new MyListImpl();
        con3.add("A");
        con3.add("B");
        con3.add(7);
        ListIterator li = con3.listIterator();
        System.out.println(con3);

        while (li.hasNext()) {
            System.out.print(li.next() + " ");
        }
        System.out.println();

        li = con3.listIterator();
        li.next();
        li.next();
        li.set("C");
        System.out.println(con3);

        while (li.hasPrevious()) {
            System.out.print(li.previous() + " ");
        }
        System.out.println();

        li.set(1);
        System.out.println(con3);
    }

}
