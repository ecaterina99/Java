import java.util.Stack;

public class StackTest {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        System.out.println(stack.empty());
        stack.push("SIMS");
        stack.push("NBA");
        stack.push("FIFA");
        stack.push("VEDMAK");
        System.out.println(stack.empty());

        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        System.out.println(stack);

        System.out.println(stack.peek());
        System.out.println(stack);

        System.out.println(stack.search("SIMS"));
        System.out.println(stack.search("FDYN"));

    }
}