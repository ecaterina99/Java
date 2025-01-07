public class EventsTest implements AlarmListener {
    public static void main(String[] args) {

        EventsTest test1 = new EventsTest();
        EventsTest test2 = new EventsTest();
        EventsTest test3 = new EventsTest();

        Alarm alarm = new Alarm();
        alarm.addListener(test1);
        alarm.addListener(test2);
        alarm.addListener(test3);

        alarm.removeListener(test2);

        alarm.setTimeFromNow(2000);
    }


    @Override
    public void alarmRang(AlarmEvent event) {
        System.out.println(event.message);
        System.out.println("Wake up!!!");
    }
}
