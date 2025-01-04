public class Gamepad extends Product implements Storable, Searchable{

    boolean wireless;

    public Gamepad(String brand, String model, double price, boolean wireless) {
        super(brand, model, price);
        this.wireless = wireless;
    }

    @Override
    public String toString() {
        return super.toString() + ", " +
                "wireless = " + wireless;
    }

    @Override
    public int checkStock() {
        return (int) (Math.random() * 100);
    }

    @Override
    public void read() {
        //logic for reading
    }

    @Override
    public void write() {
        //logic for writing
    }

    @Override
    public void update() {
        //logic for updating
    }

    @Override
    public void delete() {
        //logic for deleting
    }

    @Override
    public void search() {

    }


    @Override
    public boolean exists() {
        //Gamepad specific logic for exists() method
        return false;
    }

}