import java.util.Timer;
import java.util.TimerTask;


// (1) local class myTimerTask

//public class AnonymousClassTest {
//    public static void main(String[] args) {
//        System.out.println("Program started...");
//
//        class MyTimerTask extends TimerTask {
//
//            @Override
//            public void run() {
//                System.out.println("Hello World!");
//                System.exit(0);
//            }
//        }
//        MyTimerTask task = new MyTimerTask();
//
//        Timer timer = new Timer ("Timer");
//        timer.schedule(task,5000);
//    }
//}


// (2) AnonymousClass
public class AnonymousClassTest {
    public static void main(String[] args) {
        System.out.println("Program started...");

        Timer timer = new Timer("Timer");
        timer.schedule(new TimerTask() {

                           @Override
                           public void run() {
                               System.out.println("Hello World!");
                               System.exit(0);
                           }
                       },
                5000);
    }
}

