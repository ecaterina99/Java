
public class DynamicArrayTest {
    public static void main(String[] args) {

        DynamicArray da = new DynamicArray(10);
        System.out.println(da.capacity);
        da.add("A");
        da.add("B");
        da.add("C");
        da.add("D");
        da.add("E");

        da.insert(0,8);
        da.insert(2, 9);
        System.out.println("Empty: " + da.isEmpty());
        System.out.println("Size: " + da.size);
        System.out.println("Capacity: " + da.capacity);
        System.out.println(da);
        da.delete("C");
        System.out.println(da);
       System.out.println(da.search(9));
       System.out.println("Capacity: " + da.capacity);

    }
}