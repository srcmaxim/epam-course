package ua.nure.koval.Practice5;

import java.util.Random;
import java.util.concurrent.*;

public final class Part4 {

    private Part4() {
    }

    private static int[][] matrix = new int[4][100];

    static {
        Random random = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt();
            }
        }
    }

    private static int getMaxWithoutParallelization() throws InterruptedException {
        int max = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                Thread.sleep(1);
                max = Math.max(max, matrix[i][j]);
            }
        }
        return max;
    }

    private static int getMaxWithParallelization() throws InterruptedException, ExecutionException {
        ExecutorService exc = Executors.newFixedThreadPool(matrix.length);

        Future<Integer>[] futures = new Future[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            futures[i] = exc.submit(new Find(matrix[i]));
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            max = Math.max(max, futures[i].get());
        }

        exc.shutdown();
        return max;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("WITHOUT PARALELIZATION");
        long start = System.currentTimeMillis();
        System.out.println("Max: " + Part4.getMaxWithoutParallelization());
        long end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start));

        System.out.println("WITH PARALELIZATION");
        start = System.currentTimeMillis();
        System.out.println("Max: " + Part4.getMaxWithParallelization());
        end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start));
    }

    static class Find implements Callable<Integer> {
        private int max;
        private int[] column;

        public Find(int[] column) {
            this.column = column;
        }

        @Override
        public Integer call() throws InterruptedException {
            max = column[0];
            final int[] arr = column;
            for (int i = 1; i < arr.length; i++) {
                Thread.sleep(1);
                max = Math.max(max, arr[i]);
            }
            return max;
        }

    }
}
