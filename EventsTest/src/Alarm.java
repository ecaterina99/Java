import java.util.Timer;
import java.util.TimerTask;

public class Alarm {


    private AlarmListener[] listeners = {};

    public void addListener(AlarmListener alarmListener) {
        AlarmListener[] newListeners = new AlarmListener[listeners.length + 1];
        System.arraycopy(listeners, 0, newListeners, 0, listeners.length);
        newListeners[listeners.length] = alarmListener;

        listeners = newListeners;
    }

    public void removeListener(AlarmListener alarmListener) {
        int indexToRemove = -1;
        for (int i = 0; i < listeners.length; i++) {
            if (alarmListener.equals(listeners[i])) {
                indexToRemove = i;
            }
        }

        AlarmListener[] newListeners = new AlarmListener[listeners.length - 1];
        System.arraycopy(listeners, 0, newListeners, 0, indexToRemove);
        System.arraycopy(listeners, indexToRemove + 1,
                newListeners, indexToRemove,
                listeners.length - indexToRemove - 1);

        listeners = newListeners;
    }

    public void setTimeFromNow(int millis) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("AlarmEvent Triggered...");

                for (AlarmListener listener : listeners) {
                    AlarmEvent eventObj = new AlarmEvent(this, "Time is up!");
                    listener.alarmRang(eventObj);
                }
                System.exit(0);
            }
        }, millis);
    }

}
