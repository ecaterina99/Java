public class ThreadSynchronization {
    public static void main(String[] args) throws InterruptedException {

        MyThread myThread = new MyThread();

        new Thread(myThread).start();
        new Thread(myThread).start();

        Thread.sleep(500);
        myThread.hold();
        Thread.sleep(500);
        myThread.resume();

    }
}