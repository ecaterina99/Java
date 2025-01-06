public class OuterClass {
    void testMethod(int x) {
        int y = x * 2;
        class LocalClass {
            int a;
            int b;

            public LocalClass() {
                a = x;
                b = y;
            }
        }
        LocalClass c = new LocalClass();
        System.out.println(c.a);
        System.out.println(c.b);
    }

}
