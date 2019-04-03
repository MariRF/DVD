/*
Klassen Person blir brukt for aa opprette personer,
og for aa holde styr paa DVD-ene til hver enkelt person,
da baade de laante, utlaante og eide DVD-ene.
*/

import java.util.HashMap;

public class Person {
  private String navn;
  private int eier = 0;
  private int laaner = 0;
  private int utlaant = 0;

  private HashMap <String, DVD> arkiv = new HashMap <String, DVD>(); //Et HashMap som holder styr paa hvilke DVD-er personen eier.
  private HashMap <String, DVD> laante = new HashMap <String, DVD>(); //Et HashMap som holder styr paa hvilke DVD-er personen laaner.
  private HashMap <String, DVD> utlaante = new HashMap <String, DVD>(); //Et HashMap som holder styr paa hvilke DVD-er personen laaner ut.

  //Konstruktoren som tar i mot navnet til personen.
  public Person(String navn) {
    this.navn = navn;
  }

  //Metode som gjor om Person til String.
  public String toString() {
    return navn;
  }

  //Metode som putter kjopte DVD-er inn i HashMap'et arkiv.
  public void kjop(String tittel, DVD film) {
    arkiv.put(tittel, film);
    eier++;
  }

  //Metode som printer ut DVD-ene i arkiv.
  public void printKjop() {
    for (DVD film : arkiv.values()) {
      System.out.println(film.toString());
    }
  }

  //Metode som putter laante DVD-er inn i HashMap'et laante.
  public void laant(String tittel, DVD film) {
    laante.put(tittel, film);
    laaner++;
  }

  //Metode som printer ut DVD-ene i laante.
  public void printLaant() {
    for (DVD film : laante.values()) {
      System.out.println(film.toString() + " er laant fra " + film.laantAv());
    }
  }

  //Metode som putter utlaante DVD-er inn i HashMap'et utlaante.
  public void laantUt(String tittel, DVD film) {
    utlaante.put(tittel, film);
    utlaant++;
  }

  //Metode som printer ut DVD-ene i utlaante.
  public void printLaantUt() {
    for (DVD film : utlaante.values()) {
      System.out.println(film.toString() + " er utlaant til " + film.laantTil());
    }
  }

  //Metode med returverdi som returnerer true hvis personen eier DVD-en tittel.
  public boolean eierDVDen(String tittel) {
    if (arkiv.containsKey(tittel)) {
      return true;
    }
    return false;
  }

  //Metode med returverdi som returnerer true hvis personen har laant ut DVD-en tittel.
  public boolean utlaantDVD(String tittel) {
    if (utlaante.containsKey(tittel)) {
      return true;
    }
    return false;
  }

  //Metode med returverdi som returnerer true hvis personen har laant DVD-en tittel.
  public boolean laantDVD(String tittel) {
    if (laante.containsKey(tittel)) {
      return true;
    }
    return false;
  }

  //Metode med returverdi som returner true hvis personen ikke eier noen DVD-er.
  public boolean eierDVD() {
    if (arkiv.isEmpty()) {
      return true;
    }
    return false;
  }

  //Metode med returverdi som returnerer true hvis personen ikke laaner ut noen DVD-er.
  public boolean laanerUtDVD() {
    if (utlaante.isEmpty()) {
      return true;
    }
    return false;
  }

  //Metode med returverdi som returnerer true hvis personen ikke laaner noen DVD-er.
  public boolean laanerDVD() {
    if (laante.isEmpty()) {
      return true;
    }
    return false;
  }

  //Metode med returverdi som returnerer hvor mange DVD-er personen eier.
  public int eDVD() {
    return eier;
  }

  //Metode med returverdi som returnerer hvor mange DVD-er personen laaner.
  public int lDVD() {
    return laaner;
  }

  //Metode med returverdi som returnerer hvor mange DVD-er personen laaner ut.
  public int uDVD() {
    return utlaant;
  }

  //Metode som fjerner DVD-en tittel fra persones laante DVD-er.
  public void returnereDVD(String tittel) {
    laante.remove(tittel);
    laaner--;
  }

  //Metode som fjerner DVD-en tittel fra personens utlaante DVD-er.
  public void faaTilbakeDVD(String tittel) {
    utlaante.remove(tittel);
    utlaant--;
  }
}
