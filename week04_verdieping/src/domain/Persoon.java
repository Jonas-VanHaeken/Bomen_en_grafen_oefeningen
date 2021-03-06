package domain;

public class Persoon implements Comparable<Persoon>{
    private String naam, voornaam;
    private int lengte;
    private double gewicht;
    public Persoon(String voornaam, String naam, int lengte, double gewicht) {
        this.setVoornaam(voornaam);
        this.setNaam(naam);
        this.setLengte(lengte);
        this.setGewicht(gewicht);
    }
    private void setNaam(String naam) {
        if (naam == null || naam.trim().isEmpty()) throw new
                IllegalArgumentException();
        this.naam = naam;
    }
    private void setVoornaam(String voornaam) {
        if (voornaam == null || voornaam.trim().isEmpty()) throw new
                IllegalArgumentException();
        this.voornaam = voornaam;
    }
    private void setLengte(int lengte) {
        if (lengte <= 30) throw new IllegalArgumentException();
        this.lengte = lengte;
    }
    private void setGewicht(double gewicht) {
        if (gewicht <= 25) throw new IllegalArgumentException();
        this.gewicht = gewicht;
    }
    public int getBMI() {
        return (int)(Math.round(gewicht * 10000 / (lengte * lengte)));
    }
    @Override
    public String toString() {
        return voornaam + " " + naam + " BMI = " + this.getBMI();
    }
    @Override
    public int compareTo(Persoon o) {
        if ( o == null) return 1;
        else {
            int i = this.getBMI() - o.getBMI();
            if (i != 0) return i;
            else {
                i = this.naam.compareTo(o.naam);
                if (i != 0) return i;
                else return this.voornaam.compareTo(o.voornaam);
            }
        }
    }
}
