import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student {

    private int brojIndeksa;
    private int godinaUpisa;
    private List<Integer> upisaneGodine = new ArrayList<>();
    private List<Predmet> polozeniPredmeti = new ArrayList<>();
    private OznakaPlana plan;

    public Student(OznakaPlana plan, List<Integer> upisaneGodine, int godinaUpisa, int brojIndeksa) {
        this.plan = plan;
        this.upisaneGodine = upisaneGodine;
        this.godinaUpisa = godinaUpisa;
        this.brojIndeksa = brojIndeksa;

    }

    public int vratiTrenutnuGodinuStudija(){
        if(upisaneGodine == null || upisaneGodine.isEmpty()) return 0;
        return upisaneGodine.get(upisaneGodine.size()-1);
    }

    public boolean jePonovac(){
        if(upisaneGodine == null || upisaneGodine.isEmpty()) return false;
        int poslednji= upisaneGodine.get(upisaneGodine.size()-1);
        int brojac=0;
        for(int godina:upisaneGodine){
            if(godina == poslednji)
                brojac++;
        }
        return brojac>1;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return brojIndeksa == student.brojIndeksa && godinaUpisa == student.godinaUpisa && Objects.equals(upisaneGodine, student.upisaneGodine) && Objects.equals(polozeniPredmeti, student.polozeniPredmeti) && plan == student.plan;
    }

    @Override
    public int hashCode() {
        return Objects.hash(brojIndeksa, godinaUpisa, upisaneGodine, polozeniPredmeti, plan);
    }

    @Override
    public String toString() {
        return "Student{" +
                "brojIndeksa=" + brojIndeksa +
                ", godinaUpisa=" + godinaUpisa +
                ", upisaneGodine=" + upisaneGodine +
                ", polozeniPredmeti=" + polozeniPredmeti +
                ", plan=" + plan +
                '}';
    }

    public int getBrojIndeksa() {return brojIndeksa;}

    public void setBrojIndeksa(int brojIndeksa) {this.brojIndeksa = brojIndeksa;}

    public int getGodinaUpisa() {return godinaUpisa;}

    public void setGodinaUpisa(int godinaUpisa) {this.godinaUpisa = godinaUpisa;}

    public List<Integer> getUpisaneGodine() {return upisaneGodine;}

    public void setUpisaneGodine(List<Integer> upisaneGodine) {this.upisaneGodine = upisaneGodine;}

    public List<Predmet> getPolozeniPredmeti() {return polozeniPredmeti;}

    public void setPolozeniPredmeti(List<Predmet> polozeniPredmeti) {this.polozeniPredmeti = polozeniPredmeti;}

    public OznakaPlana getPlan() {return plan;}

    public void setPlan(OznakaPlana plan) {this.plan = plan;}
}
