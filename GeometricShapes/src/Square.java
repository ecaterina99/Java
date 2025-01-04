public class Square extends Quad implements Geom {
    @Override
    public void setValues(int x, int y, int a) {
        this.x = x;
        this.y = y;
        this.a = a;
    }

    @Override
    public int calculateArea() {
        return a * a;
    }

    @Override
    public int calculatePerimeter() {
        return this.a * 4;
    }
}
