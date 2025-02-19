public class MyThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {



            System.out.print(i + " ");
            try {
                Thread.sleep(600);
            } catch (InterruptedException exc) {
                System.out.println(exc.getMessage());
            }
        }

    }
}
