/*
Klassen DVDAdministrasjon binder klassen Person og klassen DVD sammen.
Klassen gjor programmet kjorbart, og er den klassen som kommer frem i en main-metode.
*/

import java.util.HashMap;
import java.util.Scanner;
import java.io.File;

public class DVDAdministrasjon {
  private HashMap <String, Person> navneliste = new HashMap <String, Person>(); //Et HashMap som holder styr paa alle personen i systemet.
  private HashMap <String, DVD> filmer = new HashMap <String, DVD>(); //Et HashMap som holder styr paa alle DVD-ene i systemet.
  private Scanner input = new Scanner(System.in);

  //Konstruktoren til DVDAdministrasjon.
  public DVDAdministrasjon() {

  }

  //Metode som skriver ut menyen til programmet.
  public void meny() {
      System.out.println("MENY FOR DVD-ADMINISTRASJON");
      System.out.println("1: Ny person.");
      System.out.println("2: Kjop");
      System.out.println("3: Laan.");
      System.out.println("4: Vis.");
      System.out.println("5: Oversikt.");
      System.out.println("6: Retur.");
      System.out.println("7: Avslutt.");
  }

  //Metode som gjor det mulig aa lese inn informasjon fra en fil.
  public void lesFraFil(String filnavn) throws Exception {
    Scanner fil = new Scanner(new File(filnavn));
    String linje;
    Person person = null;
    DVD film = null;
    //While lokke som legger personene fra en fil til i systemet.
    while (fil.hasNextLine()) {
      linje = fil.nextLine();
      person = new Person(linje);
      navneliste.put(linje, person);

      if (linje.charAt(0) == '-') {
        navneliste.remove(linje);
        break;
      }
    }

    //While lokke som legger filmene fra en fil til i systemet.
    while (fil.hasNextLine()) {
      linje = fil.nextLine();

      if (!navneliste.containsKey(linje) && linje.charAt(0) != '-') {
        film = new DVD(linje);
        filmer.put(linje, film);
      }
    }

    /*
    Hvis Per allerede ligger inne i navneliste, la de neste linjene
    være filmene til Per helt til det dukker opp et nytt navn eller - som
    også ligger i navnelisten.*/

  }

  //Metode som oppretter et nytt objekt, Person, hvis ikke personen finnes fra for av.
  public void nyPerson() {
    System.out.println("Hva heter den nye personen?");
    String navn = input.nextLine();
    if (navneliste.containsKey(navn)) {
      System.out.println("Det finnes allerede en person med navn " + navn + ".");
    }

    else {
      Person person = new Person(navn);
      navneliste.put(navn, person); //Putter personen inn i navnelisten.
    }
  }

  //Metode som lar personer kjope DVD-er hvis de ikke har et eksemplar av DVD-en fra for av.
  public void kjop() {
    System.out.println("Hvem har kjopt DVD-en?");
    String navn = input.nextLine();

    if (navneliste.containsKey(navn) == false) { //Hvis personen ikke finnes print ut...
      System.out.println("Det er ingen personer som heter " + navn + ".");
    }

    else {
      System.out.println();

      System.out.println("Hva er tittelen paa DVD-en?");
      String tittel = input.nextLine();
      DVD film = new DVD(tittel);

      if (navneliste.get(navn).eierDVDen(tittel) == true) { //Hvis personen allerede eier et eksemplar av DVD-en, print ut...
        System.out.println(navn + " eier allerede et eksemplar av DVD-en " + tittel + ".");
      }

      else {
        navneliste.get(navn).kjop(tittel, film); //Legges til i personens eide DVD-er
        filmer.put(tittel, film); //Legger til filmen i listen over alle filmene
        filmer.get(tittel).eidAv(navneliste.get(navn)); //Personen eier DVD-en
      }
    }
  }

  //Metode som lar personer laane DVD-er av hverandre.
  public void laan() {
    System.out.println("Hvem vil laane DVD-en?");
    String navn = input.nextLine();
    String eier;
    String tittel;

    if (navneliste.containsKey(navn) == false) { //Hvis personen ikke finnes print ut...
      System.out.println("Det er ingen personer som heter " + navn + ".");
    }

    else {
      System.out.println();

      System.out.println("Hvem skal DVD-en laanes fra?");
      eier = input.nextLine();

      if (navneliste.containsKey(eier) == false) { //Hvis personen ikke finnes print ut...
        System.out.println("Det er ingen personer som heter " + eier + ".");
      }

      else if (navn.equals(eier)) { //Hvis persoen prover aa laane DVD-er av seg selv, print ut...
        System.out.println("Du kan ikke laane DVD-er av deg selv.");
      }

      else {
        System.out.println();
        System.out.println("Hva er tittelen paa DVD-en?");
        tittel = input.nextLine();

        if (filmer.containsKey(tittel) == false) { //Hvis DVD-en ikke finnes print ut...
          System.out.println("Det finnes ingen DVD-er med tittelen " + tittel + ".");
        }

        else if (navneliste.get(eier).eierDVDen(tittel) == false) { //Hvis personen du onsker aa laane DVD-en av ikke eier DVD-en print ut...
          System.out.println("Personen du onsker aa laane DVD-en av eier ikke en DVD med tittelen " + tittel + ".");
        }

        else if (navneliste.get(eier).utlaantDVD(tittel) == true) { //Hvis DVD-en allerede er laant ut, print ut...
          System.out.println("Personen du onsker aa laane DVD-en av har allerede laant ut DVD-en med tittelen " + tittel + ".");
        }

        else {
          navneliste.get(navn).laant(tittel, filmer.get(tittel)); //Legger DVD-en til i listen over personens laante DVD-er.
          navneliste.get(eier).laantUt(tittel, filmer.get(tittel)); //Legger DVD-en til i listen over personens utlaante DVD-er.
          filmer.get(tittel).leidAv(navneliste.get(navn)); //Personen leier DVD-en.
        }
      }
    }
  }

  /*
  Metode som viser en oversikt over personer og DVD-er.
  Kan vise for alle personene eller en valgfri person.
  Viser hvilke DVD-er personen eier,
  hvilke DVD-er personen laaner og fra hvem,
  hvilke DVD-er personen laaner ut og til hvem.
  */
  public void visPerson() {
    System.out.println("Hvilke person vil du se? (* for alle)");
    String navn = input.nextLine(); //Lar brukeren skrive inn hvem han/hun vil se informasjonen til.

    /*
    Hvis det forste symbolet er * vises en oversikt over alle personene i systemet.
    Dette ved hjelp av en for-each lokke, og flere if/else statements.
    */
    if (navn.charAt(0) == '*') {
      System.out.println();
      for (Person person : navneliste.values()) {
        System.out.println("Person: " + person.toString()); //Printer ut personen.

        if (person.eierDVD() == true) { //Hvis personen ikke eier noen DVD-er, print ut...
          System.out.println(person.toString() + " eier ingen DVD-er.");
        }

        else {
          System.out.println("DVD-er " + person.toString() + " eier:");
          person.printKjop(); //Printer ut DVD-ene personen eier.
        }

        if (person.laanerUtDVD() == true) { //Hvis personen ikke laaner ut noen DVD-er, print ut...
          System.out.println(person.toString() + " laaner ikke bort noen DVD-er.");
        }

        else {
          System.out.println(person.toString() + " laaner bort DVD-ene:");
          person.printLaantUt(); //Printer ut DVD-enen personen laaner ut.
        }

        if (person.laanerDVD() == true) { //Hvis personen ikke laaner noen DVD-er, print ut...
          System.out.println(person.toString() + " laaner ingen DVD-er.");
        }

        else {
          System.out.println("DVD-er " + person.toString() + " laaner:");
          person.printLaant(); //Printer ut DVD-ene personen laaner.
        }
      }
    }

    else if (navneliste.containsKey(navn) == false) { //Hvis det er skrevet inn et navn paa en person som ikke finnes, print ut...
      System.out.println("Det er ingen personer som heter " + navn + ".");
    }

    else {
      System.out.println();
      System.out.println("Person: " + navn); //Printer ut personen.

      if (navneliste.get(navn).eierDVD() == true) { //Hvis personen ikke eier noen DVD-er, print ut...
        System.out.println(navn + " eier ingen DVD-er.");
      }

      else {
        System.out.println("DVD-er " + navn + " eier:");
        navneliste.get(navn).printKjop(); //Printer ut DVD-ene personen eier.
      }

      if (navneliste.get(navn).laanerUtDVD() == true) { //Hvis personen ikke laaner ut noen DVD-er, print ut...
        System.out.println(navn + " laaner ikke bort noen DVD-er.");
      }

      else {
        System.out.println(navn + " laaner bort DVD-ene:");
        navneliste.get(navn).printLaantUt(); //Printer ut DVD-ene personen laaner bort.
      }

      if (navneliste.get(navn).laanerDVD() == true) { //Hvis personen ikke laaner noen DVD-er, print ut...
        System.out.println(navn + " laaner ingen DVD-er.");
      }

      else {
        System.out.println("DVD-er " + navn + " laaner:");
        navneliste.get(navn).printLaant(); //Printer ut DVD-ene personen laaner.
      }
    }
  }

  //Metode som viser en oversikt over hvor mange DVD-er en person eier, laaner og laaner ut.
  public void visOversikt() {
    for (Person person : navneliste.values()) {
      System.out.println("Person: " + person.toString());
      System.out.println("Eier: " + person.eDVD());
      System.out.println("Laant: " + person.lDVD());
      System.out.println("Utlaant: " + person.uDVD());
    }
  }

  //Metode som lar personer returnere laante DVD-er til eieren.
  public void retur() {
    System.out.println("Hvem har laant DVD-en?");
    String navn = input.nextLine();
    String tittel;

    if (navneliste.containsKey(navn) == false) { //Hvis personen ikke finnes print ut...
      System.out.println("Det er ingen personer som heter " + navn + ".");
    }

    else {
      System.out.println();
      System.out.println("Hva er tittelen paa DVD-en?");
      tittel = input.nextLine();

      if (filmer.containsKey(tittel) == false) { //Hvis DVD-en ikke finnes, print ut...
        System.out.println("Det finnes ingen DVD-er med tittelen " + tittel + ".");
      }

      else if (navneliste.get(navn).laantDVD(tittel) == false) { //Hvis personen ikke har laant en DVD med tittelen tittel, print ut...
        System.out.println(navn + " har ikke laant en DVD med tittelen " + tittel + ".");
      }

      else {
        navneliste.get(navn).returnereDVD(tittel); //Fjerner DVD-en fra personens liste over laante DVD-er.
        filmer.get(tittel).laantAv().faaTilbakeDVD(tittel); //Fjerner DVD-en fra eierens liste over utlaante DVD-er.
      }
    }
  }

  //Metode som avslutter programmet.
  public void avslutt() {
    System.out.println("Programmet avsluttes.");
  }
}
