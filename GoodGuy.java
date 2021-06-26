public class GoodGuy extends SuperHero {
    private String catchPhrase;
    private static final String[] firstName = {"Bruce", "Kevin", "Jeffrey", "Nicole", "Judith", "Diana", "Karen", "Roy", "Eugene", "Christina" };
    private static final String[] lastName = {"Gray", "Watson", "Thompson", "Sanders", "Reed", "Scott", "Davis", "Griffin", "Diaz", "Baile"};
    private static final String[] job = {"Anthropologist", "Balerina","Chef","Dog Catcher", "Entomologist", "Farmer","Grocer"};
    private static final String[] superPower = {"Teleportation", "Telepathy", "Invisbility", "Superhuman strength", "Magic", "Fly", "Fire", "Time travel", "Immortality"};
    private static final String[] catchPhrases = {"Flame on", "Letz goooo", "Attttackk", "baam", "bing go", "Heee----yaaaa", "Too Good to be true" , "Unstoppable", "Boooom", "Well Well Well"};

    //constructor
    GoodGuy(String name, String job, String superPower, boolean cape, int powerLevel, String catchPhrase){
        super(name, job, superPower, cape, powerLevel);
        this.catchPhrase = catchPhrase;
    }

    //default constructor with randome values
    GoodGuy(boolean cape, int powerLevel){
        super( firstName[getRandom(firstName.length)] + " " + lastName[getRandom(lastName.length)]
             , job[getRandom(job.length)]
             , superPower[getRandom(superPower.length)]
             , cape
             , powerLevel );
        
        this.catchPhrase = catchPhrases[getRandom(catchPhrases.length)];
    }

    //returns random powerlevel. 
    public int getPowerLevel(){
      int min = 1, max = 10;// 1 - 10
      return (int)(Math.random() * (max - min + 1)) + min;
    }

    //increase the powerlevel of the GoodGuy. 
    public void powerUp(){
        int min = 1, max = 6;// 1 - 6
        int random =  (int)(Math.random() * (max - min + 1)) + min;

        //modify the goodguy's power level. 
        powerLevelModification(super.getPowerLevel() + random);

    }

    //returns CatchPhrase
    public String getCatchPhrase(){
        return this.catchPhrase;
    }
    
}
 

