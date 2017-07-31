package ua.nure.koval.Practice5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Note!!! Without synchronization this application not work properly!! Most
 * likely a runtime exception will be thrown..
 */
public final class Part51 {

    private Part51() {
    }

    private static final int ITERATION_NUMBER = 3;
    private static final int READERS_NUMBER = 3;
    private static final StringBuilder BUFFER = new StringBuilder();
    private static final int BUFFER_LENGTH = 5;
    private static final int PAUSE = 5;
    private static boolean stop;

    private static int readerSemaphore = 0;
    private static int threadNumber = 0;
    private static boolean[] threadWaited = new boolean[READERS_NUMBER];

    static {
        Arrays.fill(threadWaited, true);
    }

    // reader
    private static class Reader extends Thread {
        private final int threadNumber = Part51.threadNumber++;

        public void run() {
            while (!stop) {
                try {
                    synchronized (BUFFER) {
                        while (threadWaited[threadNumber]) {
                            BUFFER.wait();
                        }
                        readerSemaphore--;
                        // read from the buffer
                        read(getName());
                        threadWaited[threadNumber] = true;
                        if (readerSemaphore == 0) {
                            BUFFER.notifyAll();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // writer
    private static class Writer extends Thread {
        public void run() {
            int tact = 0;
            while (!stop) {
                try {
                    synchronized (BUFFER) {
                        while (readerSemaphore != 0) {
                            BUFFER.wait();
                        }
                        // write to the buffer
                        write();
                        readerSemaphore = READERS_NUMBER;
                        Arrays.fill(threadWaited, false);
                        BUFFER.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    if (++tact == ITERATION_NUMBER) {
                        stop = true;
                    }
                }
            }
        }
    }

    private static void read(String threadName) throws InterruptedException {
        System.out.printf("Reader %s:", threadName);
        for (int j = 0; j < BUFFER_LENGTH; j++) {
            Thread.sleep(PAUSE);
            System.out.print(BUFFER.charAt(j));
        }
        System.out.println();
        Thread.sleep(5);
    }

    private static void write() throws InterruptedException {
        // clear buffer
        BUFFER.setLength(0);

        // write to buffer
        System.err.print("Writer writes:");

        Random random = new Random();
        for (int j = 0; j < BUFFER_LENGTH; j++) {
            Thread.sleep(PAUSE);
            char ch = (char) ('A' + random.nextInt(26));
            System.err.print(ch);
            BUFFER.append(ch);
        }
        System.err.println();
        Thread.sleep(5);
    }

    public static void main(String[] args) throws InterruptedException {
        // create writer
        Writer writer = new Writer();

        // create readers
        List<Thread> readers = new ArrayList<>();
        for (int j = 0; j < READERS_NUMBER; j++) {
            readers.add(new Reader());
        }

        // start readers
        Thread.sleep(10);
        for (Thread reader : readers) {
            reader.start();
        }

        // start writer
        Thread.sleep(10);
        writer.start();

        // main thread is waiting for the child threads
        writer.join();
        for (Thread reader : readers) {
            reader.join();
        }
    }

}