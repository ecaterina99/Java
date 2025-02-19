public class MyThread implements Runnable {

    private boolean active = true;

    public void stopThread() {
        this.active = false;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            if (!active)
                break;
            System.out.print(i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException exc) {
                System.out.println(exc.getMessage());
            }
        }
    }
}