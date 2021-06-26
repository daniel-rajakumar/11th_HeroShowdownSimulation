public class BadGuy extends SuperHero {
    private String evilLaugh;
    private static final String[] firstName = {"Danielle", "Gregg", "Lela", "Janet", "Marty", "Casey", "Naomi", "Don", "Geraldine", "Ken"};
    private static final String[] lastName = {"Briggs" , "Frazier" , "Logan" , "Gibson" , "Higgins" , "Ball" , "Garza" , "Montgomery" , "Porter" , "Mcdonald" };
    private static final String[] job = {"Anthropologist", "Balerina","Chef","Dog Catcher", "Entomologist", "Farmer","Grocer"};
    private static final String[] superPower = 
    {"Teleportation", "Telepathy", "Invisbility", "Superhuman strength", "Magic", "Fly", "Fire", "Time travel", "Immortality"};
    private static final String[] evilLaughs = {"muhaha", "bhahaha", "mkakaka", "heeheeheee", "muhaaaaaahahahah", "muhahaha-muhahah-muhaaaaaa"};

    //constructor
    BadGuy(String name, String job, String superPower, boolean cape, int powerLevel, String evilLaugh){
        super(name, job, superPower, cape, powerLevel);
        this.evilLaugh = evilLaugh;
    }

    //default constructor with randome values
    BadGuy(boolean cape, int powerLevel){
        super(
            firstName[getRandom(firstName.length)] + " " + lastName[getRandom(lastName.length)], 
            job[getRandom(job.length)],
            superPower[getRandom(superPower.length)], 
            cape, 
            powerLevel
            );
        
        this.evilLaugh = evilLaughs[getRandom(evilLaughs.length)];
    }

    //increase the powerlevel of the BadGuy. 
    public void powerUp(){
        int min = 2, max = 5;// 2 - 5
        int random =  (int)(Math.random() * (max - min + 1)) + min;

        powerLevelModification(getPowerLevel() + random);
    }

    //returns evil laugh
    public String getEvilLaugh(){
        return this.evilLaugh;
    }
 
   
    
}





