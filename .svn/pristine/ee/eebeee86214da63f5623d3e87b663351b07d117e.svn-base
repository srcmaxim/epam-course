package ua.nure.koval.Practice5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public final class Part3 {

    private Part3() {
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executors = Executors.newFixedThreadPool(2);

        System.out.println("NON ATOMIC");
        executors.execute(new NonSynchronizedThread());
        executors.execute(new NonSynchronizedThread());
        executors.awaitTermination(300, TimeUnit.MILLISECONDS);


        System.out.println("ATOMIC");
        executors.execute(new SynchronizedThread());
        executors.execute(new SynchronizedThread());
        executors.awaitTermination(3000, TimeUnit.MILLISECONDS);

        executors.shutdown();
    }
}

abstract class Task implements Runnable {

    private static final long SLEEP_TIME = 250;

    @Override
    public void run() {
        long nextTime = System.currentTimeMillis() + SLEEP_TIME;
        while (nextTime > System.currentTimeMillis()) {
            atomicOperation();
        }
    }

    public abstract void atomicOperation();

    protected void task() {
        if (getA().equals(getB())) {
            System.out.println(getA() + " == " + getB());
        } else {
            System.out.println(getA() + " != " + getB());
        }
        incrA();
        try {
            sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        incrB();
    }

    protected abstract void incrB();

    protected abstract void incrA();

    protected abstract Number getA();

    protected abstract Number getB();

}

class NonSynchronizedThread extends Task {
    private static int a = 0;
    private static int b = 0;

    public void atomicOperation() {
        task();
    }

    @Override
    protected void incrB() {
        b++;
    }

    @Override
    protected void incrA() {
        a++;
    }

    @Override
    protected Number getA() {
        return a;
    }

    @Override
    protected Number getB() {
        return b;
    }

}

class SynchronizedThread extends Task {
    private static int a = 0;
    private static int b = 0;

    public void atomicOperation() {
        synchronized (SynchronizedThread.class) {
            task();
        }
    }

    @Override
    protected void incrB() {
        b++;
    }

    @Override
    protected void incrA() {
        a++;
    }

    @Override
    protected Number getA() {
        return a;
    }

    @Override
    protected Number getB() {
        return b;
    }
}
