import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Evidencija {

    private List<Student> studenti = new ArrayList<>();
    private List<List<IzborStudenta>> izbori = new ArrayList<>();

    public Evidencija(List<Student> studenti, List<List<IzborStudenta>> izbori) {
        this.studenti = studenti;
        this.izbori = izbori;
    }

    public Evidencija() {
    }

    private int nadjiStudenta(Student s){
        for(int i = 0;i < studenti.size();i++){
            if(studenti.get(i).equals(s))
                return i;
        }
        return -1;
    }

    public boolean dodajIzbor(Student s,IzborStudenta izbor) {
        if (s == null || izbor == null) return false;
        if (!izbor.mozeDaIzabere(s)) return false;
        int i = nadjiStudenta(s);
        if (i == -1) {
            studenti.add(s);
            izbori.add(new ArrayList<>());
            i = studenti.size() - 1;
        }

        List<IzborStudenta> lista = izbori.get(i);
        if (s.jePonovac()) {
            if (!(izbor instanceof IzborniPredmet)) return false;
            lista.add((izbor));
            return true;
        } else {
            if (!lista.isEmpty()) return false;
            if (izbor instanceof IzbornaGrupa || izbor instanceof IzborniModul) {
                lista.add(izbor);
                return true;
            }
            return false;
        }
    }

        public void ispisiUFajl(String putanja){
            try (PrintWriter pw = new PrintWriter(new FileWriter(putanja))) {
                for (int i = 0; i < studenti.size(); i++) {
                    Student s = studenti.get(i);

                    for (IzborStudenta izbor : izbori.get(i)) {
                        pw.println(s.getBrojIndeksa() + " - " + izbor.opis());
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

    }




}
