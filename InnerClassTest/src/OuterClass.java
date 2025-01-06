public class OuterClass {
    private int i;

    private void m() {
        System.out.println(i);
    }

    class InnerClass {
        void accessOuterClass() {
            i = 1;
            m();
        }
    }

}
