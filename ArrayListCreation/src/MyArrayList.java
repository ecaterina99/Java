public class MyArrayList {
    private int size;
    private int[] data;

    public MyArrayList() {
        this.size = 0;
        this.data = new int[2];

    }

    public static void main(String[] args) {

        MyArrayList arrayList = new MyArrayList();
        arrayList.add(5);
        arrayList.add(8);
        arrayList.add(9);
        arrayList.add(9);
        arrayList.add(1);
        arrayList.set(2, 11);
        arrayList.printArray();
        arrayList.remove(1);
        System.out.println(arrayList.get(0));


        arrayList.printArray();
    }

    public void add(int value) {
        ensureCapacity();
        data[size] = value;
        size++;
    }

    public int get(int index) {
        checkIndex(index);
        return data[index];
    }

    public void set(int index, int value) {
        checkIndex(index);
        data[index] = value;
    }

  
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
    }

    public void remove(int index) {
        checkIndex(index);
        for(int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
    }

    private void ensureCapacity() {
        if (size == data.length) {
            int[] newArray = new int[data.length * 2];
            for (int i = 0; i < data.length; i++) {
                newArray[i] = data[i];
            }

            data = newArray;
        }
    }

    private void printArray() {
        System.out.print("[ ");
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.print("]");
    }
}