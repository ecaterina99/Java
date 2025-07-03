import java.util.Arrays;


/*
You managed to send your friend to queue for tickets in your stead. He will get there only if you tell him
how much that is going to take. Everybody can only take one ticket at a time,
then they go back in the last position of the queue if they need more (or go home if they are fine).
Each ticket takes one minutes to emit. You will be given an array/list/vector with all the people
queuing and the initial position of your buddy. Build a function to compute it, resting assured that
only positive integers are going to be there and you will be always given a valid index.
 */
public class QueueTimeCounter {
    public static void main(String[] args) {
        int []QueueTime={2,5,3,6,4};
        int pos=QueueTime[0];
        System.out.println(pos);
        int res=0;

    while(QueueTime[pos] > 0) {
            for(int i = 0; i < QueueTime.length; i++) {
                if(QueueTime[i] > 0) {
                    res++;
                    QueueTime[i] = QueueTime[i] - 1;
                }
                if(pos == 0) {
                    break;
                }
            }
        }
        System.out.println(res);
        System.out.println(Arrays.toString(QueueTime));
    }
}