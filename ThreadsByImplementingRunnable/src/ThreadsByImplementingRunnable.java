public class ThreadsByImplementingRunnable {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(myThread);
            t.start();
        }

        System.out.println(Thread.activeCount());

        Thread.sleep(6000);

        System.out.println(Thread.activeCount());
    }
}