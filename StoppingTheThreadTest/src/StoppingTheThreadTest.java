public class StoppingTheThreadTest {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        new Thread(myThread).start();

        Thread.sleep(2000);
        myThread.stopThread();

    }
}