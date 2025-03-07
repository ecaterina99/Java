/*
Given the entire Solar System in the form of a list. Return a new list which has either '<', '>' or '='
depending on whether the planet is smaller than the planet on its left or not. You have to start
comparing from the second item, because the first has nothing on its left.
However, there are also asteroids in the Solar System. All asteroids are smaller than all the planets.
If two asteroids are found beside each other, the leftmost one will depend on the celestial being
on the left of it. The one on the right will have '='. The Solar System might be empty.
 */

public class JumbledPlanets {

    public char[] annotate(String[] celestailBodies) {
        if (celestailBodies.length == 0) {
            return new char[0];
        }

        char[] result = new char[celestailBodies.length - 1];
        int[] arr = new int[celestailBodies.length];
        for (int i = 0; i < celestailBodies.length; i++) {
            if (celestailBodies[i].equals("Asteroid")) {
                arr[i] = 0;
            }
            if (celestailBodies[i].equals("Pluto")) {
                arr[i] = 1;
            } else if (celestailBodies[i].equals("Mercury")) {
                arr[i] = 2;
            } else if (celestailBodies[i].equals("Mars")) {
                arr[i] = 3;
            } else if (celestailBodies[i].equals("Venus")) {
                arr[i] = 4;
            } else if (celestailBodies[i].equals("Earth")) {
                arr[i] = 5;
            } else if (celestailBodies[i].equals("Neptune")) {
                arr[i] = 6;
            } else if (celestailBodies[i].equals("Uranus")) {
                arr[i] = 7;
            } else if (celestailBodies[i].equals("Saturn")) {
                arr[i] = 8;
            } else if (celestailBodies[i].equals("Jupiter")) {
                arr[i] = 9;
            }
        }
        for (int i = 0; i < result.length; i++) {
            if (arr[i] < arr[i + 1]) {
                result[i] = '>';
            } else if (arr[i] > arr[i + 1]) {
                result[i] = '<';
            } else {
                result[i] = '=';
            }
        }
        return result;
    }
}
