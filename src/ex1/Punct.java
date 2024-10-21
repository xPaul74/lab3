package ex1;

public class Punct {
    final double x;
    final double y;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Punct(double x, double y) {
        super();
        this.x = x;
        this.y = y;
    }
    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

}
