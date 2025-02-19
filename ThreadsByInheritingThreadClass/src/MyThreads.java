public class MyThreads implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {

            Thread currentThread = Thread.currentThread();

            System.out.println(currentThread.getId() + ": " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException exc) {
                System.out.println(exc.getMessage());
            }
        }

    }
}
