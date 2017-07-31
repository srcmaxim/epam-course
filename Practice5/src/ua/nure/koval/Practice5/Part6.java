package ua.nure.koval.Practice5;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.concurrent.*;

public class Part6 implements Callable {

    private static final Object MONITOR = new Object();
    private static final int THREADS_NUMBER = 10;
    private static final int COLUMNS = 20;
    private static final int EOL_LENGTH = System.lineSeparator().length();
    private static String fileName = "test.txt";
    private static final String CHARSET_NAME = "UTF-8";

    private RandomAccessFile out;
    private int position;
    private String characters;

    public Part6(RandomAccessFile out, int position, String charToFill, int stringLength) {
        this.out = out;
        this.position = position;

        StringBuilder sb = new StringBuilder(stringLength);
        for (int i = 0; i < COLUMNS; i++) {
            sb.append(charToFill);
        }
        sb.append(System.lineSeparator());
        characters = sb.toString();
    }

    @Override
    public Object call() throws IOException {
        RandomAccessFile raf = getRAF();
        synchronized (MONITOR) {
            raf.seek(position);
            raf.write(characters.getBytes(CHARSET_NAME));
        }
        return null;
    }

    private RandomAccessFile getRAF() {
        return out;
    }

    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        Files.deleteIfExists(new File(fileName).toPath());
        File file = new File(fileName);
        RandomAccessFile raf = new RandomAccessFile(file, "rw");

        ExecutorService exe = Executors.newFixedThreadPool(THREADS_NUMBER);

        ArrayList<Future> futures = new ArrayList<>();

        int position = 0;
        for (int currentNumber = 0; currentNumber < THREADS_NUMBER; currentNumber++) {
            String charToFill = String.valueOf(currentNumber);
            int charsLength = COLUMNS * charToFill.length();
            int stringLength = charsLength + EOL_LENGTH;

            Future f = exe.submit(new Part6(raf, position, charToFill, stringLength));
            futures.add(f);

            position += stringLength;
        }

        for (Future future : futures) {
            future.get();
        }

        exe.shutdown();
        raf.close();

        System.out.println(new String(Files.readAllBytes(file.toPath()), CHARSET_NAME));
    }
}