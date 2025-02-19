class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.print(i);
            try {
                sleep(500);
            } catch (InterruptedException exc) {
                System.out.println(exc.getMessage());
            }
        }
    }
}