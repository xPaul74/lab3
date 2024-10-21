package ex1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) throws FileNotFoundException {
        List<Parabola> lista = new ArrayList<Parabola>();
        int a, b, c;
        Scanner scanner = new Scanner(new File("src/ex1/in.txt"));

        while (scanner.hasNextLine()) {
            a = scanner.nextInt();
            b = scanner.nextInt();
            c = scanner.nextInt();
            lista.add(new Parabola(a, b, c));
        }
        scanner.close();

        for (Parabola parabola : lista) {
            System.out.println(parabola);
            System.out.println(parabola.varfParabola());
        }

        System.out.println("Mijloc: " + lista.get(0).mijlocUnParametru(lista.get(1)));
        System.out.println("Distanta varfuri: " + Parabola.lungimeDoiParametrii(lista.get(0), lista.get(1)));
    }
}
