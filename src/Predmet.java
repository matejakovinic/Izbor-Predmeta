import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Predmet {

    private String naziv;
    private int semestar;
    private int espb;
    private OznakaPlana oznakaPlana;
    private List<Predmet> preduslovi = new ArrayList<>();

    public Predmet(String naziv,int semestar,OznakaPlana oznakaPlana,int espb) {
       this.naziv=naziv;
       this.semestar=semestar;
       this.oznakaPlana=oznakaPlana;
       this.espb=espb;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Predmet predmet = (Predmet) o;
        return semestar == predmet.semestar && espb == predmet.espb && Objects.equals(naziv, predmet.naziv) && oznakaPlana == predmet.oznakaPlana && Objects.equals(preduslovi, predmet.preduslovi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(naziv, semestar, espb, oznakaPlana, preduslovi);
    }

    public void dodajPreduslov(Predmet p){
        if(p==null) return;
        if(this.oznakaPlana == p.oznakaPlana && p.semestar < this.semestar)
            preduslovi.add(p);
    }

    public String getNaziv() {return naziv;}

    public void setNaziv(String naziv) {this.naziv = naziv;}

    public int getSemestar() {return semestar;}

    public void setSemestar(int semestar) {this.semestar = semestar;}

    public int getEspb() {return espb;}

    public void setEspb(int espb) {this.espb = espb;}

    public OznakaPlana getOznakaPlana() {return oznakaPlana;}

    public void setOznakaPlana(OznakaPlana oznakaPlana) {this.oznakaPlana = oznakaPlana;}

    public List<Predmet> getPreduslovi() {return preduslovi;}

    public void setPreduslovi(List<Predmet> preduslovi) {this.preduslovi = preduslovi;}
}
