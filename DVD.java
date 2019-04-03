/*
Klassen DVD blir brukt for aa opprette DVD-er,
og for aa holde styr paa hvem som eier hvilke DVD-er,
og hvem som laaner hvilke DVD-er.
*/

public class DVD {
  private String tittel;
  private Person eier;
  private Person laaner;

  //Konstruktoren som tar i mot tittelen paa DVD-en.
  public DVD(String tittel) {
    this.tittel = tittel;
  }

  //Metode som gjor om DVD til String.
  public String toString() {
    return tittel;
  }

  //Metode som gir DVD-en en eier.
  public void eidAv(Person eier) {
    this.eier = eier;
  }

  //Metode som gir DVD-en en leier.
  public void leidAv(Person laaner) {
    this.laaner = laaner;
  }

  //Metode med returverdi som returnerer eieren av DVD-en.
  public Person laantAv() {
    return eier;
  }

  //Metode med returverdi som returnerer leieren av DVD-en.
  public Person laantTil() {
    return laaner;
  }
}
