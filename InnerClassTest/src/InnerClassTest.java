public class InnerClassTest {

    public static void main(String[] args) {

        OuterClass outerClass = new OuterClass();
        OuterClass.InnerClass firstInnerClass = outerClass.new InnerClass();

        firstInnerClass.accessOuterClass();
    }
}
