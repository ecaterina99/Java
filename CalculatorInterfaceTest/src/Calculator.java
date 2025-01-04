public class Calculator implements Operands, Operations {
    public int a;
    public int b;

    @Override
    public int add() {
        return a + b;
    }

    @Override
    public int sub() {
        return a - b;
    }

    @Override
    public void setOperand(int a, int b) {
        this.a = a;
        this.b = b;

    }

}