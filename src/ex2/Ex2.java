package ex2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex2 {

    public static double getMin(List<Produs> produse) {
        double min = Integer.MAX_VALUE;
        for (Produs produs : produse) {
            if (produs.getPret() < min)
                min = produs.getPret();
        }
        return min;
    }

    public static void main(String[] args) throws FileNotFoundException {
        List<Produs> produse = new ArrayList<Produs>();
        String denumire;
        int cantitate;
        double pret;
        LocalDate dataExpirarii;
        Scanner scanner = new Scanner(new File("src/ex2/produse.csv"));

        while (scanner.hasNextLine()) {
            String[] x = scanner.nextLine().split(",");
            denumire = x[0];
            pret = Double.parseDouble(x[1]);
            cantitate = Integer.parseInt(x[2]);
            dataExpirarii = LocalDate.parse(x[3]);
            produse.add(new Produs(denumire, pret, cantitate, dataExpirarii));
        }
        scanner.close();

        int optiune;
        Produs deSters = null;
        Scanner scan = new Scanner(System.in);
        PrintStream out = new PrintStream(new File("src/ex2/out.txt"));
        do {
            System.out.println("1. Afisare lista\n2. Afisare produse expirate\n3. Vanzare\n4. Pret minim\n5. Save!\n6. Exit.");
            optiune = scan.nextInt();
            switch (optiune) {
                case 1:
                    for (Produs produs: produse)
                        System.out.println(produs);
                    break;
                case 2:
                    System.out.println("Produse expirate: ");
                    for (Produs produs: produse)
                        if (produs.expirat()) System.out.println(produs);
                    break;
                case 3:
                    System.out.println("Denumire produs: ");
                    denumire = scan.next();
                    System.out.println("Cantitate: ");
                    cantitate = scan.nextInt();
                    for (Produs produs: produse)
                        if (produs.getDenumire().equals(denumire)) {
                            produs.vanzare(cantitate);
                            if (produs.getCantitate() == 0)
                                deSters = produs;
                        }
                    if (deSters != null)
                        produse.remove(deSters);
                    break;
                case 4:
                    double min = getMin(produse);
                    System.out.println("Produse cu pret minim: ");
                    for (Produs produs: produse)
                        if (produs.getPret() == min)
                            System.out.println(produs);
                    break;
                case 5:
                    System.out.println("Dati cantitate: ");
                    cantitate = scan.nextInt();
                    for (Produs produs: produse)
                        if (produs.getCantitate() < cantitate)
                            out.println(produs);
                break;
                case 6:
                    scan.close();
                    out.close();
                    System.exit(0);
                default:
                    System.out.println("Optiune invalida!");
            }
        } while (true);
    }

}
