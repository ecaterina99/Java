import java.util.Arrays;
/*
Build a pyramid-shaped tower, as an array/list of strings, given a positive integer number of floors.
A tower block is represented with "*" character.
For example, a tower with 3 floors looks like this:
[
  "  *  ",
  " *** ",
  "*****"
]
 */
public class BuildTower {

    private static final String SYMBOL = "*";
    private static final String SPACE = " ";

    public static String[] towerBuilder(int nFloors) {
        var tower = new String[nFloors];
        var floorLength = 1;
        for (var i = 1; i <= nFloors; i++) {
            String spaces = SPACE.repeat(nFloors - i);
            String symbols = SYMBOL.repeat(floorLength);
            tower[i - 1] = spaces + symbols + spaces;
            floorLength += 2;
        }

        return tower;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(towerBuilder(5)));
    }
}
