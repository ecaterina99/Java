public class BackgroundThreads {
    public static void main(String[] args) {

        MyThread mt = new MyThread();
        mt.setDaemon(true);
        mt.start();
    }
}