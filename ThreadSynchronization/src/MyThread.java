class MyThread implements Runnable {

    private int hold = 0;

    public void hold() {
        this.hold = 1;
    }

    public void resume() {
        this.hold = 2;
    }

    @Override
    public synchronized void run() {

        for (int i = 0; i < 25; i++) {

            if (hold == 1) {
                try {
                    hold = 0;
                    wait();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } else if (hold == 2) {
                notify();
                hold = 0;
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(Thread.currentThread().getId() + " ");

        }
    }
}
