import java.util.ArrayList;
import java.util.Scanner;

/***************************************************************************************
A quick note: Give the code compiler largest width as possiable when running. Thanks
*****************************************************************************************/
public class HeroShowdown {
  ArrayList<Person> townsPeople, safePeople, unfortunateSouls;// all the required arraylist
  Scanner reader = new Scanner(System.in);

  public HeroShowdown() {
    townsPeople = new ArrayList<Person>(); // Add more using the default
    safePeople = new ArrayList<Person>(); // Add more using the default (aka savedPeople list)
    unfortunateSouls = new ArrayList<Person>(); // Add more using the default

    //mini welcome
    System.out.println("\nHello there! Welcome to the Greatest Hero Show down simulations ever created!  - Daniel Rajkaumar");
    System.out.println("Enjoy! ");

    // main functions
    addData();
    doStuff();
    printData();

  }

  // add datas to the array lists
  public void addData() {
    for (int i = 0; i < 10; i++) {
      townsPeople.add(new NormalGuy());// add normal guys
    }

    townsPeople.add(new GoodGuy(true, 10));// add a good guy
    townsPeople.add(new BadGuy(false, 15));// add a bad guy
  }

  //do the HeroShowdown activities 
  public void doStuff() {
    int round = 0;

    String exit = "";
    System.out.println("\n\nPress 'Q' to quit, press 'save' to save a poor soul, otherwise Enter to continue. \n\n");

    while (!exit.equalsIgnoreCase("q")) {
      System.out.println("round: " + ++round);
      System.out.println("> [ Alive: " + townsPeople.size() + " | RIP: " + unfortunateSouls.size() + " | Saved: " + safePeople.size() + " ] ");

      motherNatureAttack();// mother nature as 1 in 20 chance of attacking the town!

      if (exit.equalsIgnoreCase("save")) {
        saveASoul(); // prompt user to select Persons to save
      }

      //if incase everyone dies (or 1 person left) in the town in result of the disaster then return. 
      if (townsPeople.size() < 2) break;

      // Get(remove) 2 random people
      Person p1 = townsPeople.remove((int) (Math.random() * townsPeople.size()));
      Person p2 = townsPeople.remove((int) (Math.random() * townsPeople.size()));

      // ShowDown check
      NormalvsNormal(p1, p2); // round 2
      GoodvsGood(p1, p2);
      BadvsBad(p1, p2);

      GoodvsNormal(p1, p2);
      BadvsNormal(p1, p2);
      BadvsGood(p1, p2);

      // check again but swap the Persons
      GoodvsNormal(p2, p1);
      BadvsNormal(p2, p1);
      BadvsGood(p2, p1);

      System.out.println("\n...");
      exit = reader.nextLine(); // enter 'q' to quit or 'save' to save a poor soul, otherwise just press enter
    }

  }

  public void printData() {
    // print the final data (ArrayList)
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println("FINAL RESULT");
    System.out.println("\nIn TOWN: " + townsPeople.size() + " (survivers)");
    printList(townsPeople);//prints people in the town (survivers)
    System.out.println("\nSAVED: " + safePeople.size());
    printList(safePeople);//prints the list of saved people from town
    System.out.println("\nRIP: " + unfortunateSouls.size());
    printList(unfortunateSouls);//prints the list of died people
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
  }

  /******************************************************************************
  *************************** NormalGuy vs NormalGuy **************************** 
  ******************************************************************************/

  private void NormalvsNormal(Person p1, Person p2) {
    if (p1 instanceof NormalGuy && p2 instanceof NormalGuy) {

      String verb = MeetingSimulation.getVerb();

      //persons' type. (In this case normalGuy) 
      System.out.println("(" + p1.getClass().getSimpleName() + " vs " + p2.getClass().getSimpleName() + ")");

      //persons' interaction during the showdown 
      System.out.println(p1.getName() + "(" + p1.getJob() + ") " + verb + " " + p2.getName()+ "(" + p2.getJob() + ") ");

      // have change of adding 0-4 new members to the town!
      if (verb.equals("marries")) babiesBirth(p1, p2);

      // add them to the town
      townsPeople.add(p1);
      townsPeople.add(p2);
    }
  }

  /******************************************************************************
  ***************************** GoodGuy vs NormalGuy **************************** 
  ******************************************************************************/

  private void GoodvsNormal(Person p1, Person p2) {
    if (p1 instanceof GoodGuy && p2 instanceof NormalGuy) {

      System.out.println("(" + p1.getClass().getSimpleName() + " vs " + p2.getClass().getSimpleName() + ")");

      //print out good guy's power
      System.out.println("--> " + p1.getName() + "'s power: " + ((SuperHero) p1).getSuperPower());

      System.out.println(((GoodGuy)p1).getCatchPhrase() + "!! " + p1.getName() + "(" + p1.getJob() + ") saves " + p2.getName() + "(" + p2.getJob() + ")!!");


      // random powerups
      ((GoodGuy) p1).powerUp();

      safePeople.add(p2);// add the person to saved list
      townsPeople.add(p1);// add the person to the town

      System.out.println("> " + p1.getName() + " power ups! ");
    }

  }

  /******************************************************************************
  ***************************** BadGuy vs NormalGuy ***************************** 
  ******************************************************************************/

  private void BadvsNormal(Person p1, Person p2) {
    if (p1 instanceof BadGuy && p2 instanceof NormalGuy) {

      System.out.println("(" + p1.getClass().getSimpleName() + " vs " + p2.getClass().getSimpleName() + ")");

      //print out bad guys power. 
      System.out.println("--> " + p1.getName() + "'s power: " + ((SuperHero) p1).getSuperPower());

      System.out.println(((BadGuy)p1).getEvilLaugh() + "... " + p1.getName() + "(" + p1.getJob()  +") destroys " + p2.getName() +"(" + p2.getJob() + ") *Rest In Peace*");

      // random powerups
      ((BadGuy) p1).powerUp();

      unfortunateSouls.add(p2);// add the person to unfortunate list
      townsPeople.add(p1);// add the person to the town

      System.out.println("> " + p1.getName() + " power ups! ");
    }

  }

  /******************************************************************************
  ***************************** BadGuy vs GoodGuy ******************************* 
  ******************************************************************************/

  private void BadvsGood(Person p1, Person p2) {
    if (p1 instanceof BadGuy && p2 instanceof GoodGuy) {

      int winner = random(0, 1);//toss


      System.out.println("(" + p1.getClass().getSimpleName() + " vs " + p2.getClass().getSimpleName() + ") ");

      //print out superhero's power. 
      System.out.println("--> " + p1.getName() + "'s power: " + ((SuperHero) p1).getSuperPower());
      System.out.println("--> " + p2.getName() + "'s power: " + ((SuperHero) p2).getSuperPower());

      if (winner == 1) {
        System.out.println(((BadGuy)p1).getEvilLaugh() + "!! " + p1.getName() + "(" + p1.getJob() + ") smashes " + p2.getName() + "("+ p2.getJob() + ") *Rest In Peace*");

        unfortunateSouls.add(p2);// add the person to unfortunate list
        townsPeople.add(p1);// add the person to the town

        System.out.println("> " + p1.getName() + " power ups! ");

      } else { 
        System.out.println(((GoodGuy)p2).getCatchPhrase() + "!! " + p2.getName() + "(" + p1.getJob() + ") knocks out " + "("+ p2.getJob() + ")" + p1.getName() + " *Rest In Peace*");

        unfortunateSouls.add(p1);// add the person to unfortunate list
        townsPeople.add(p2);// add the person to the town

        System.out.println("> " + p2.getName() + " power ups! ");
      }

    }

  }

  /******************************************************************************
  ******************************* BadGuy vs BadGuy ****************************** 
  ******************************************************************************/
  private void BadvsBad(Person p1, Person p2) {
    if (p1 instanceof BadGuy && p2 instanceof BadGuy) {

      System.out.println("(" + p1.getClass().getSimpleName() + " vs " + p2.getClass().getSimpleName() + ")");
      
      System.out.println("--> " + p1.getName() + "'s power: " + ((SuperHero) p1).getSuperPower());
      System.out.println("--> " + p2.getName() + "'s power: " + ((SuperHero) p2).getSuperPower());
      
      System.out.println(((BadGuy)p1).getEvilLaugh() + ", " + p1.getName() + "(" + p1.getJob() + ") and " + p2.getName() + "(" + p2.getJob() +") plans to destory the town! ");



      // add them to the town
      townsPeople.add(p1);
      townsPeople.add(p2);
          
    }

  }

  /******************************************************************************
  ***************************** GoodGuy vs GoodGuy ****************************** 
  ******************************************************************************/
  private void GoodvsGood(Person p1, Person p2) {
    if (p1 instanceof GoodGuy && p2 instanceof GoodGuy) {

      System.out.println("(" + p1.getClass().getSimpleName() + " vs " + p2.getClass().getSimpleName() + ")");
      
      System.out.println("--> " + p1.getName() + "'s power: " + ((SuperHero) p1).getSuperPower());
      System.out.println("--> " + p2.getName() + "'s power: " + ((SuperHero) p2).getSuperPower());      
      
      System.out.println(((GoodGuy)p2).getCatchPhrase() + "!! " + p1.getName() + "(" + p1.getJob() +") invites " + p2.getName() + "(" + p2.getJob() +") to join his team to save the town from darkness! ");

      // add them to the town
      townsPeople.add(p1);
      townsPeople.add(p2);

    }

  }

  /******************************************************************************
  ******************** (E.) Approved Modifications - 1 ************************** 
  ******************************************************************************/

  // has 1 in 20 random chance for a disaster to come to the town.
  public void motherNatureAttack() {
    int randomOdds = random(0, 140);// get the dice rollin'
    int numOfLivesLoses = random(2, 5);// 2-5 lives will lose

    //if the Nature killed more people than town's total poppulation than adjust the vaule to town's total population. 
    if (numOfLivesLoses > townsPeople.size()) numOfLivesLoses = townsPeople.size();

    // add the poor souls to the unfortunate list.
    if (randomOdds % 20 == 0) {
      for (int i = 0; i < numOfLivesLoses; i++) {
          unfortunateSouls.add(townsPeople.remove(random(0,  random(0, townsPeople.size() - 1))));
      }

      System.out.print("!!!! NATURAL ATTACK: ");
      //get random natural attacks! 
      switch (randomOdds){
        case 0:   System.out.print("EARTH QUAKE"); break;
        case 20:  System.out.print("TSUNAMI"); break;
        case 40:  System.out.print("FLOOD"); break;
        case 60:  System.out.print("DROUGHT"); break;
        case 80:  System.out.print("TORNADO"); break;
        case 100: System.out.print("WILD FIRE"); break;
        case 120: System.out.print("VOLCANO ERUPTION"); break;
        case 140: System.out.print("EXTREME TEMPERATURE"); break;
      }
      System.out.println(" !!!! (costed " + numOfLivesLoses + " poor souls)");
    }
    
  }

  /******************************************************************************
  ******************** (D.) Approved Modifications - 2 ************************** 
  ******************************************************************************/

  // prompt the user to save a soul
  public void saveASoul() {
    //some basic error handling 
    if (unfortunateSouls.size() == 0) {
      System.out.println(">>>>>>> Whoo hoo! There is no one to save ! (Everyone is safe)\n");
      return;
    } 

    //prints as a column list of avaliable souls to save. 
    System.out.println();
    for (Person i : unfortunateSouls) {
      System.out.println("[" + unfortunateSouls.indexOf(i) + "] (" + i.getClass().getSimpleName() + ")     "
          + i.getName() + " (" + i.getJob() + ")");
    }

    // get the person id (index) from the list
    int personID = reader.nextInt();
    reader.nextLine();

    //to prevent out of bound error
    if (personID >= unfortunateSouls.size() || personID <= -1) {
      System.out.println(">>>>>>> No person found! \n");
      return;
    }

    System.out.println(">>>>>>> " + unfortunateSouls.get(personID).getName() + " says, thank you for saving my poor soul! \n");
    townsPeople.add(unfortunateSouls.remove(personID));// add the soul back to the town

  }

  /******************************************************************************
  *********************** Special Sauce - Babies 👶 ***************************** 
  ******************************************************************************/
  // married couples have chance to be a family of 6.
  public void babiesBirth(Person p1, Person p2) {
    int numOfBabies = random(0, 4);// couples could bring upto 4 lives to the town.

    // congrats message to the couples
    if (numOfBabies != 0) {
      System.out.println("===> Welcome to the town little one(s)! CONGRATULATIONS " + p1.getName() + " and " + p2.getName()
          + " for adding " + ((numOfBabies == 1) ? "a new member" : numOfBabies + " new members")
          + " to our town! May your son/daughter have an amazing life ahead!  ");

      for (int i = 0; i < numOfBabies; i++) {
        int random = random(0, 2);// roll the die to see what type of person the baby blongs to!

        if (random == 0)  townsPeople.add(new NormalGuy());// normal :)
        if (random == 1)  townsPeople.add(new GoodGuy(true, random(10, 25)));// good :D
        if (random == 2)  townsPeople.add(new BadGuy(false, random(15, 35)));// bad :(
      }
    }
  }
  

  // print the list in a table like formate (y axies)
  public void printList(ArrayList<Person> list) {
    for (Person i : list) {
      System.out.println("(" + i.getClass().getSimpleName() + ")    " + i.getName() + " (" + i.getJob() + ")");
    }
  }

  // random numbers (min, max)
  private int random(int min, int max) {
    return (int) (Math.random() * (max - min + 1)) + min;
  }

}
