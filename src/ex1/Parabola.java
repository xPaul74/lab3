package ex1;

public class Parabola {
    private int a, b, c;

    public Parabola(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Punct varfParabola() {
        double x =  (double)-b / (2*a);
        double y =  (double)(-(b*b) + 4 * a * c) / (4 * a);
        return new Punct(x, y);
    }

    public static Punct mijloc(Punct p1, Punct p2) {
        return new Punct((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
    }

    public Punct mijlocUnParametru(Parabola par) {
        return mijloc(this.varfParabola(), par.varfParabola());
    }

    public static Punct mijlocDoiParametrii(Parabola par1, Parabola par2) {
        return mijloc(par1.varfParabola(), par2.varfParabola());
    }

    public double lungimeUnParamatru(Parabola par) {
        Punct p1 = this.varfParabola();
        Punct p2 = par.varfParabola();
        return Math.hypot(p1.getX() - p2.getX(), p1.getY() - p2.getY());
    }

    public static double lungimeDoiParametrii(Parabola par1, Parabola par2) {
        Punct p1 = par1.varfParabola();
        Punct p2 = par2.varfParabola();
        return Math.hypot(p1.getX() - p2.getX(), p1.getY() - p2.getY());
    }

    @Override
    public String toString() {
        return "f(x) = " + a + "x^2 + " + b + "x + " + c;
    }
}
