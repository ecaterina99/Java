import java.util.ArrayList;

public class TenMinutesWalk {
    public static boolean isValid(char[] walk) {
        if (walk.length != 10)
            return false;

        int north = 0, south = 0, west = 0, east = 0;

        for (char step : walk) {
            switch (step) {
                case 'n': north++; break;
                case 's': south++; break;
                case 'w': west++; break;
                case 'e': east++; break;
            }
        }

        return north == south && west == east;
    }
}