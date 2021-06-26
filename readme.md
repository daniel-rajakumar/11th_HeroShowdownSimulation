
# Hero Showdown - 11th grade, APCS-A: 

``` java
public class About {
  public static void main(String[] args){
    System.out.println("Programmer: Daniel ");
    System.out.println("Published: March 2, 2021");
  }
}
```

### Approved Modifications:

* ##### Instead of just using the Scanner to continue or quit, change it to serve another purpose in the simulation.   For example you could add an option to save a Person from the unfortunateSouls list.
     * Provides a readable list for the users with unique id (index) for each person alaong with what type of person he/she is. 
     * The saved person sends thanks message and go back to the townsPeople<Person>.
     * If there is no souls to save, then automatically the saving process will be skipped. 


* ##### Add a mechanism that randomly moves people from one list to another.  For example each round there may be a 1 in 20 chance that there is an earthquake or tsunami and a couple of people are moved to the unfortunateSouls list.
    * motherNatureAttack() function gives a random natural disasters (1 in 20 times). 
    * It kills 2 to 5 people each attack regardless of the disasters type. 
    * moves those poor souls to the unfortunateSouls<Person> form townsPeople<Person>.
    * `Note: NO superPerson shall escape from the Natural Attack!!!`
  

## Speical Sauce:
* If a normalGuy and a normalGuy meets in the showdown and they desided to marrie, then babiesBirth(Person, Person) gives a random number of babies (0-4) for the married couples. 
* A message congrats the couples for their awesome offsprings!  
* Babies are randomly choosen to be either a GoodGuy or BadGuy or else NormalGuy. 
* The new babies will became a new member of the town (they will get added to the town list)
* ##### Other minor virtual changes:
  * Besides that, there is a live counter which shows how many people are in the town (alive, death, and saved)
  * The Person's jobs are always showen near them in parenthesis. 
  
 
