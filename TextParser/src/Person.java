public class Person {
    String name;
    String surname;
    String country;

    public Person (String name, String surname, String country){
    this.name = name;
    this.surname = surname;
    this.country = country;}

    public String getInfo(){
        StringBuilder output = new StringBuilder();
        output.append(name).append(" ").append(surname).append(" ").append(country);
        return output.toString();
    }
}