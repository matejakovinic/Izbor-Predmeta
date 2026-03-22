public class IzborniPredmet extends Predmet implements IzborStudenta{


    public IzborniPredmet(String naziv, int semestar, OznakaPlana oznakaPlana, int espb) {
        super(naziv, semestar, oznakaPlana, espb);
    }

    @Override
    public boolean mozeDaIzabere(Student s) {
        if(!s.jePonovac()) return false;
        if(this.getOznakaPlana() != s.getPlan() ) return false;
        int godina = s.vratiTrenutnuGodinuStudija();
        if(!(this.getSemestar() == 2 * godina - 1 || this.getSemestar() == 2 * godina)) return false;
        if(s.getPolozeniPredmeti().contains(this)) return false;
        for(Predmet p : getPreduslovi()){
            if(!s.getPolozeniPredmeti().contains(p))
                return false;
        }
       return true;
    }

    @Override
    public String opis() {
        return getNaziv();
    }


}
