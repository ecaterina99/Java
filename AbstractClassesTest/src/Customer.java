public class Customer implements Storable {

    private String name;
    private String address;
    private String gender;

    public Customer() {

    }

    public Customer(String name, String address, String gender) {
        this.name = name;
        this.address = address;
        this.gender = gender;
    }

    @Override
    public void read() {
        //read logic
    }

    @Override
    public void write() {
        //write logic
    }

    @Override
    public void update() {
        //update logic
    }

    @Override
    public void delete() {
        //delete logic
    }
}