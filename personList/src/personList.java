/*
Creaţi o clasă Person cu atributele name şi surname.
După aceasta, efectuaţi instanţierea mai multor obiecte de tip Person,
pe care le veţi plasa în colecţia generică ArrayList.

 */

import java.util.ArrayList;
import java.util.List;

public class personList {
    public static void main(String[] args) {
        Person person1 = new Person("John", "Mill");
        Person person2 = new Person("Jane", "Doe");


        List<Person> persons = new ArrayList<Person>();
        persons.add(person1);
        persons.add(person2);

        for (Person person : persons) {
            System.out.println(person.name + " " + person.surname);
        }
    }
}
