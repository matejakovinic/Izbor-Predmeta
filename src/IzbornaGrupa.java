import java.util.ArrayList;
import java.util.List;

public class IzbornaGrupa implements IzborStudenta{

    private String oznaka;
    private OznakaPlana plan;
    private List<IzborniPredmet> predmeti = new ArrayList<>();


    public IzbornaGrupa(String oznaka,OznakaPlana plan) {
        this.oznaka = oznaka;
        this.plan = plan;
    }

    public boolean dodajPredmet(IzborniPredmet p){
        if(p == null) return false;
        if(!p.getOznakaPlana().equals(this.getPlan())) return false;
        int godinaGrupe = oznaka.charAt(0) - '0';
        int sem=p.getSemestar();
        if(!(sem == 2 * godinaGrupe - 1 || sem == 2 * godinaGrupe)) return false;
        for(IzborniPredmet ip : predmeti){
            if(ip.getNaziv().equals(p.getNaziv()))
                return false;
        }
        predmeti.add(p);
        return true;
    }



    @Override
    public boolean mozeDaIzabere(Student s){
        if(s == null) return false;
        if(s.jePonovac()) return false;
        if(!this.getPlan().equals(s.getPlan())) return false;
        int godinaStudenta = s.vratiTrenutnuGodinuStudija();
        int godinaGrupe = Integer.parseInt(oznaka.substring(0,1));
        if(godinaStudenta != godinaGrupe) return false;
        for(IzborniPredmet ip : predmeti){
            for(Predmet p : ip.getPreduslovi()){
                if(!s.getPolozeniPredmeti().contains(p)){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String opis() {
        return getOznaka();
    }

    public String getOznaka() {return oznaka;}

    public void setOznaka(String oznaka) {this.oznaka = oznaka;}


    public OznakaPlana getPlan() {return plan;}

    public void setPlan(OznakaPlana plan) {this.plan = plan;}

    public List<IzborniPredmet> getPredmeti() {return predmeti;}

    public void setPredmeti(List<IzborniPredmet> predmeti) {this.predmeti = predmeti;}
}
