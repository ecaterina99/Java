public class OuterClass {
    private static int i;

    private void m() {
        System.out.println(i);

    }

    static class StaticNestedClass {
        void doSomething() {
            i = 10;
        }
    }

}