public class MyThread implements Runnable {

    private boolean decrement;

    public MyThread(boolean decrement) {
        this.decrement = decrement;
    }

    public void setDecrement(boolean decrement) {
        this.decrement = decrement;
    }

    public void run() {
        int i = 0;
        if (this.decrement)
            i = 10;

        while (true) {
            if (this.decrement) {
                if (i < 1)
                    break;
                i--;
            } else {
                if (i > 9)
                    break;
                i++;
            }
            System.out.println(i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException exc) {
                System.out.println(exc.getMessage());
            }
        }
    }
}
