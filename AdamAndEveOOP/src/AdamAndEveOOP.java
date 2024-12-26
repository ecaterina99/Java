/*
You have to do God's job. The creation method must return an array of length 2 containing objects
(representing Adam and Eve). The first object in the array should be an instance of the class Man.
The second should be an instance of the class Woman. Both objects have to be subclasses of Human.
Your job is to implement the Human, Man and Woman classes.
 */

public class AdamAndEveOOP {
    public static Human[] create() {
        Man Adam = new Man();
        Woman Eve = new Woman();
        Human[] firstHumans = { Adam, Eve };
        return firstHumans;
    }
}

class Human {}
class Man   extends Human {}
class Woman extends Human {}