//Denne klassen tester klassen Person

public class TestPerson {
  public static void main(String[] args) {
    String mari = "Mari";
    String silje = "Silje";
    String film = "Harry Potter";
    Person p1 = new Person(mari);
    Person p2= new Person(silje);
    DVD harrypotter = new DVD(film);

    p1.kjop(film, harrypotter);
    harrypotter.eidAv(p1);
    System.out.println(mari + " kjoper DVD-en " + harrypotter);
    System.out.println();
    System.out.println(mari + " eier DVD-en(e): ");
    p1.printKjop();
    System.out.println();
    p2.laant(film, harrypotter);
    harrypotter.leidAv(p2);
    System.out.println(silje + " laaner DVD-en(e): ");
    p2.printLaant();
    System.out.println();
    p1.laantUt(film, harrypotter);
    System.out.println(mari + " laaner ut DVD-en(e): ");
    p1.printLaantUt();
    System.out.println();
    System.out.println("Eier " + mari + " DVD-en " + harrypotter + "?");
    if (p1.eierDVDen(film) == true) {
      System.out.println("Ja");
    }
    else {
      System.out.println("Nei");
    }
    System.out.println();
    System.out.println("Laaner " + mari + " ut DVD-en " + harrypotter + "?");
    if (p1.utlaantDVD(film) == true) {
      System.out.println("Ja");
    }
    else {
      System.out.println("Nei");
    }
    System.out.println();
    System.out.println("Laaner " + silje + " DVD-en " + harrypotter + "?");
    if (p2.laantDVD(film) == true) {
      System.out.println("Ja");
    }
    else {
      System.out.println("Nei");
    }
    System.out.println();
    System.out.println("Eier " + silje + " noen DVD-er?");
    if (p2.eierDVD() == true) {
      System.out.println("Nei");
    }
    else {
      System.out.println("Ja");
    }
    System.out.println();
    System.out.println("Eier " + mari + " noen DVD-er?");
    if (p1.eierDVD() == true) {
      System.out.println("Nei");
    }
    else {
      System.out.println("Ja");
    }
    System.out.println();
    System.out.println("Laaner " + silje + " ut noen DVD-er?");
    if (p2.laanerUtDVD() == true) {
      System.out.println("Nei");
    }
    else {
      System.out.println("Ja");
    }
    System.out.println();
    System.out.println("Laaner " + mari + " ut noen DVD-er?");
    if (p1.laanerUtDVD() == true) {
      System.out.println("Nei");
    }
    else {
      System.out.println("Ja");
    }
    System.out.println();
    System.out.println("Laaner " + silje + " noen DVD-er?");
    if (p2.laanerDVD() == true) {
      System.out.println("Nei");
    }
    else {
      System.out.println("Ja");
    }
    System.out.println("Eier " + mari + " noen DVD-er?");
    if (p1.laanerDVD() == true) {
      System.out.println("Nei");
    }
    else {
      System.out.println("Ja");
    }
    System.out.println();
    System.out.println(mari + " eier " + p1.eDVD() + " DVD-er");
    System.out.println();
    System.out.println(mari + " laaner " + p1.lDVD() + " DVD-er");
    System.out.println();
    System.out.println(mari + " laaner ut " + p1.uDVD() + " DVD-er");
    System.out.println();
    System.out.println(silje + " eier " + p2.eDVD() + " DVD-er");
    System.out.println();
    System.out.println(silje + " laaner " + p2.lDVD() + " DVD-er");
    System.out.println();
    System.out.println(silje + " laaner ut " + p2.uDVD() + " DVD-er");
    System.out.println();
    p2.returnereDVD(film);
    System.out.println(silje + " returnerer DVD-en " + harrypotter);
    p1.faaTilbakeDVD(film);
    System.out.println(mari + " faar tilbake DVD-en " + harrypotter);
    System.out.println();
    System.out.println(mari + " eier " + p1.eDVD() + " DVD-er");
    System.out.println();
    System.out.println(mari + " laaner " + p1.lDVD() + " DVD-er");
    System.out.println();
    System.out.println(mari + " laaner ut " + p1.uDVD() + " DVD-er");
    System.out.println();
    System.out.println(silje + " eier " + p2.eDVD() + " DVD-er");
    System.out.println();
    System.out.println(silje + " laaner " + p2.lDVD() + " DVD-er");
    System.out.println();
    System.out.println(silje + " laaner ut " + p2.uDVD() + " DVD-er");
  }
}
