import java.util.ArrayList;
import java.util.List;

public class IzborniModul implements IzborStudenta{

    private String naziv;
    private List<Predmet> predmeti = new ArrayList<>();
    private int minEspb;


    public IzborniModul(String naziv, int minEspb) {
        this.naziv = naziv;
        this.minEspb = minEspb;
    }

    @Override
    public boolean mozeDaIzabere(Student s) {
        if(s.vratiTrenutnuGodinuStudija() !=3) return false;
        if(s.jePonovac()) return false;

        int ukupnoEspb=0;
        for(Predmet p : s.getPolozeniPredmeti()){
            ukupnoEspb += p.getEspb();
        }
        if(ukupnoEspb < minEspb) return false;
        return true;
    }

    @Override
    public String opis() {
        return getNaziv();
    }

    public String getNaziv() {return naziv;}

    public void setNaziv(String naziv) {this.naziv = naziv;}

    public List<Predmet> getPredmeti() {return predmeti;}

    public void setPredmeti(List<Predmet> predmeti) {this.predmeti = predmeti;}

    public int getMinEspb() {return minEspb;}

    public void setMinEspb(int minEspb) {this.minEspb = minEspb;}
}
