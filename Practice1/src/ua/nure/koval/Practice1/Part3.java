package ua.nure.koval.Practice1;

public final class Part3 {

    private Part3() {
    }

    public static void main(String[] args) {
        int first = Integer.parseInt(args[0]);
        int second = Integer.parseInt(args[1]);
        while (first != second) {
            if (first > second) {
                first -= second;
            } else {
                second -= first;
            }
        }
        System.out.println(first);
    }

}
