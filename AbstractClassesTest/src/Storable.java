public interface Storable {
    void read();
    void write();
    void update();
    void delete();
    default boolean exists(){
        return true;
    }
}