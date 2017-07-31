package ua.nure.koval.Practice5;

public final class Part1 {

	private Part1() {
	}

	public static void main(String[] args) {
		Thread firstThread = new FirstThread();
		firstThread.setName("firstThread");
		firstThread.start();

		Thread secondThread = new Thread(new SecondThread());
		secondThread.setName("secondThread");
		secondThread.start();

		try {
			firstThread.join();
			secondThread.join();
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName()
					+ " is interrupted in Part1.main()");
		}
	}

	static class FirstThread extends Thread {

		@Override
		public void run() {
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName());
				try {
					sleep(300);
				} catch (InterruptedException e) {
					System.out.println(Thread.currentThread().getName()
							+ " is interrupted");
				}
			}
		}
	}

	static class SecondThread implements Runnable {

		@Override
		public void run() {
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName());
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					System.out.println(Thread.currentThread().getName()
							+ " is interrupted");
				}
			}

		}

	}


}

