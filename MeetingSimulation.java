import java.util.ArrayList;
import java.util.Scanner;

public class MeetingSimulation {
  ArrayList<Person> townsPeople;
  Scanner reader = new Scanner(System.in);

  public MeetingSimulation() {
    townsPeople = new ArrayList<Person>(); // Add more using the default
    townsPeople.add(new BadGuy("Dr. Donna EvilTooth", "Dentist", "Power Drill", true, 7, "Hrah Hoo Ha"));
    townsPeople.add(new NormalGuy("Hank Johnson", "Plumber"));
    townsPeople.add(new NormalGuy("Martha Madison", "Surgeon"));
    townsPeople.add(new NormalGuy("Sandy Sampson", "Chef"));
    townsPeople.add(new NormalGuy("Arnold Avery", "Author"));
    townsPeople.add(new GoodGuy("Super Guy", "Paperboy", "Paper Cut", true, 8, "Special Delivery, Bruh"));
    doStuff();

  }

  public void doStuff() {

    String exit = "";
    System.out.println("Press 'Q' to quit, otherwise Enter to continue");

    while (!exit.equalsIgnoreCase("q")) {

      // Get 2 random people
      Person p1 = townsPeople.get((int) (Math.random() * townsPeople.size()));
      Person p2 = townsPeople.get((int) (Math.random() * townsPeople.size()));

      // getVerb() write a method that returns a random String about
      // what one person may do to/with another "scolds","hugs","goes biking with",
      // etc..

      if (p1 instanceof SuperHero) {
        System.out.println(p1.getName() + " uses " + ((SuperHero) p1).getSuperPower() + " on " + p2.getName());
      }

      System.out.println(p1.getName() + " " + getVerb() + " " + p2.getName());

      System.out.println("...");
      exit = reader.nextLine(); // enter q to quit, otherwise just press enter
    }

  }

   private static String[] verbs = { "scolds", "hugs", "marries", "goes biking with", "high fives", "fist bimps", "plays soccer with",
        "cooks", "gives ballooon to", "codes with", "debugs with" };

  public static String getVerb() {
    return verbs[Person.getRandom(verbs.length)];

  }

}
