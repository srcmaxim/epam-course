package ua.nure.koval.Practice6.part2;

import java.util.*;

public final class Part2 {

    private List<Integer> peopleInArray;
    private List<Integer> peopleInLink;
    private final int listLength;

    private Part2(int listLength) {
        this.listLength = listLength;
    }

    private long removeInRandomAccess(List list, int k) {
        long time = System.currentTimeMillis();
        int local = 0;
        while (list.size() > 1) {
            local += k;
            if (local >= list.size()) {
                local %= list.size();
            }
            list.remove(local);
        }
        return System.currentTimeMillis() - time;
    }

    private long removeInIterator(List list, int k) {
        long time = System.currentTimeMillis();
        int local = 0;

        while (list.size() > 1) {
            ListIterator iterator = list.listIterator(local);
            local = removeKStep(iterator, k);
            local %= list.size();
        }


        return System.currentTimeMillis() - time;
    }

    private int removeKStep(Iterator iterator, int k) {
        int i = 0;
        while (iterator.hasNext()) {
            i = (i + 1) % k;
            iterator.next();
            if (i == k - 1) {
                iterator.remove();
            }
        }
        return i;
    }

    private List<Integer> getPeopleInArray() {
        peopleInArray = new ArrayList<>();
        for (int i = 0; i < listLength; i++) {
            peopleInArray.add(i);
        }
        return peopleInArray;
    }

    private List<Integer> getPeopleInLink() {
        peopleInLink = new LinkedList<>();
        for (int i = 0; i < listLength; i++) {
            peopleInLink.add(i);
        }
        return peopleInLink;
    }
    
    public static void main(String[] args) {
        Part2 part2 = new Part2(20_000);
        final int k = 2;

        System.out.println("ArrayList [random access]: " + part2.removeInRandomAccess(part2.getPeopleInArray(), k) + " ms");
        System.out.println("ArrayList [iterator]: " + part2.removeInIterator(part2.getPeopleInArray(), k) + " ms");

        System.out.println("LinkedList [random access]: " + part2.removeInRandomAccess(part2.getPeopleInLink(), k) + " ms");
        System.out.println("LinkedList [iterator]: " + part2.removeInIterator(part2.getPeopleInLink(), k) + " ms");
    }

}
