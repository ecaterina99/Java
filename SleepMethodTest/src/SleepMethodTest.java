public class SleepMethodTest {
    public static void main(String[] args) throws InterruptedException {

        MyThread mt = new MyThread(false);
        MyThread mt1 = new MyThread(true);
        new Thread(mt).start();
        new Thread(mt1).start();
        Thread.sleep(3000);
        mt.setDecrement(true);
    }
}