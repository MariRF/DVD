//Denne klassen tester klassen DVD-administrasjon.

import java.util.Scanner;

public class Test {
  public static void main(String[] args) throws Exception {
    Scanner input = new Scanner(System.in);
    int valg;

    DVDAdministrasjon alt = new DVDAdministrasjon();

    alt.lesFraFil("dvdarkiv.txt"); //Leser fra fil.

    alt.meny(); //Skriver ut menyen til programmet.
    valg = Integer.parseInt(input.nextLine()); //Lar brukeren skrive inn valget av tall fra menyen.
    System.out.println();

    while (valg != 7) { //Saa lenge valget ikke er 7, gaa inn i lokken.
      if (valg == 1) {
        alt.nyPerson(); //Kaller metoden nyPerson, som lager en ny person.
        System.out.println();
        alt.meny(); //Skriver ut menyen til programmet.
        valg = Integer.parseInt(input.nextLine()); //Lar brukeren skrive inn valget av tall fra menyen.
        System.out.println();
      }

      else if (valg == 2) {
        alt.kjop(); //Kaller metoden kjop, lar en person kjope en DVD.
        System.out.println();
        alt.meny(); //Skriver ut menyen til programmet.
        valg = Integer.parseInt(input.nextLine()); //Lar brukeren skrive inn valget av tall fra menyen.
        System.out.println();
      }

      else if (valg == 3) {
        alt.laan(); //Kaller metoden laan, lar en person laane en DVD fra en annen person.
        System.out.println();
        alt.meny(); //Skriver ut menyen til programmet.
        valg = Integer.parseInt(input.nextLine()); //Lar brukeren skrive inn valget av tall fra menyen.
        System.out.println();
      }

      else if (valg == 4) {
        alt.visPerson(); //Kaller metoden visPerson, viser en oversikt over en eller alle personene og hvilke DVD-er de eier, laaner og laaner bort.
        System.out.println();
        alt.meny(); //Skriver ut menyen til programmet.
        valg = Integer.parseInt(input.nextLine()); //Lar brukeren skrive inn valget av tall fra menyen.
        System.out.println();
      }

      else if (valg == 5) {
        alt.visOversikt(); //Kaller metoden visOversikt, viser en oversikt over alle personen; hvor mange DVD-er personen eier, laaner og laaner bort.
        System.out.println();
        alt.meny(); //Skriver ut menyen til programmet.
        valg = Integer.parseInt(input.nextLine()); //Lar brukeren skrive inn valget av tall fra menyen.
        System.out.println();
      }

      else if (valg == 6) {
        alt.retur(); //Kaller metoden retur, lar en person returnere en laant DVD.
        System.out.println();
        alt.meny(); //Skriver ut menyen til programmet.
        valg = Integer.parseInt(input.nextLine()); //Lar brukeren skrive inn valget av tall fra menyen.
        System.out.println();
      }
    }

    if (valg == 7) {
      alt.avslutt(); //Kaller metoden avslutt, avslutter programmet.
    }

  }
}
