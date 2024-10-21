package ex2;

import java.time.LocalDate;

public class Produs {
    private String denumire;
    private double pret;
    private int cantitate;
    private LocalDate dataExpirarii;
    private static double incasari = 0;


    public Produs(String denumire, double pret, int cantitate, LocalDate dataExpirarii) {
        this.denumire = denumire;
        this.pret = pret;
        this.cantitate = cantitate;
        this.dataExpirarii = dataExpirarii;
    }

    public boolean expirat() {
        return dataExpirarii.isBefore(LocalDate.now());
    }

    public int getCantitate() {
        return cantitate;
    }

    public String getDenumire() {
        return denumire;
    }

    public double getPret() {
        return pret;
    }

    public void vanzare(int cant) {
        if (cant > cantitate) {
            System.out.println("Cantitate depasita!");
            return;
        }

        cantitate -= cant;
        incasari += cant * pret;
    }

    @Override
    public String toString() {
        return "Produs{" +
                "denumire='" + denumire + '\'' +
                ", pret=" + pret +
                ", cantitate=" + cantitate +
                ", dataExpirarii=" + dataExpirarii +
                '}';
    }
}
