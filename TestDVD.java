//Denne klassen er lagd for aa teste klassen DVD.

public class TestDVD {
  public static void main(String[] args) {
    DVD film = new DVD("Harry Potter");
    Person mari = new Person("Mari");
    Person silje = new Person("Silje");

    film.eidAv(mari);
    System.out.println("DVD-en " + film + " er eid av " + mari + ".");
    film.leidAv(silje);
    System.out.println(silje + " laaner DVD-en " + film + ".");

    System.out.println(film + " er laant bort av " + film.laantAv() + ".");
    System.out.println(film + " er laant til " + film.laantTil() + ".");
  }
}
