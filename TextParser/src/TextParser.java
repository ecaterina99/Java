
public class TextParser {

    public static void main(String[] args) {

        String text = "John.Davidson/Belgrade Michael.Barton/Krakow Ivan.Perkinson/Moscow";

        String[] usersData = text.split("[/. ]");
        Person[] persons = new Person[3];
        int personsCnt = 0;

        for (int i = 0; i < usersData.length; i += 3) {
            Person person = new Person(usersData[i], usersData[i + 1], usersData[i + 2]);
            persons[personsCnt] = person;
            personsCnt++;
        }

        for (Person person : persons) {
            System.out.println(person.getInfo());
        }

    }

}
