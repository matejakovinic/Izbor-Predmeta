import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Predmet p1 = new Predmet("Matematika 1",1,OznakaPlana.S,8);
        Predmet p2 = new Predmet("Programiranje 1",1,OznakaPlana.S,8);
        Predmet p3 = new Predmet("OOP",2,OznakaPlana.S,8);

        IzborniPredmet ip1= new IzborniPredmet("Web",3,OznakaPlana.S,6);
        IzborniPredmet ip2= new IzborniPredmet("AI",3,OznakaPlana.S,6);
        IzborniPredmet ip3= new IzborniPredmet("Baze",4,OznakaPlana.S,6);
        IzborniPredmet ip4= new IzborniPredmet("Mreze",4,OznakaPlana.S,6);
        IzborniPredmet ip5= new IzborniPredmet("Softver",3,OznakaPlana.S,6);


        ip1.dodajPreduslov(p3);
        ip2.dodajPreduslov(p3);
        ip3.dodajPreduslov(p3);

        IzbornaGrupa g1 = new IzbornaGrupa("301",OznakaPlana.S);
        IzbornaGrupa g2 = new IzbornaGrupa("302",OznakaPlana.S);

        g1.dodajPredmet(ip1);
        g1.dodajPredmet(ip2);

        g2.dodajPredmet(ip3);
        g2.dodajPredmet(ip4);

        List<Integer> godine1=new ArrayList<>();
        Student s1 = new Student(OznakaPlana.S,godine1,2022,123);
        List<Integer> godine2=new ArrayList<>();
        Student s2 = new Student(OznakaPlana.S,godine2,2021,456);

        s1.getPolozeniPredmeti().add(p1);
        s1.getPolozeniPredmeti().add(p2);
        s1.getPolozeniPredmeti().add(p3);

        s2.getPolozeniPredmeti().add(p1);
        s2.getPolozeniPredmeti().add(p2);
        s2.getPolozeniPredmeti().add(p3);

        s1.getUpisaneGodine().add(1);
        s1.getUpisaneGodine().add(2);
        s1.getUpisaneGodine().add(3);

        s2.getUpisaneGodine().add(1);
        s2.getUpisaneGodine().add(2);
        s2.getUpisaneGodine().add(2);

        Evidencija ev = new Evidencija();

        ev.dodajIzbor(s1,g1);
        ev.dodajIzbor(s2,ip1);
        ev.dodajIzbor(s2,ip2);

        ev.ispisiUFajl("izbori.txt");
    }
}
