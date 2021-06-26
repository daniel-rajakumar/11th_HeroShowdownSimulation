public class SuperHero extends Person {
    private String superPower;
    private boolean cape;
    private int powerLevel;
    
    //main constructor 
    SuperHero(String name, String job, String superPower, boolean cape, int powerLevel){
        super(name, job);
        this.superPower = superPower;
        this.cape = cape;
        this.powerLevel = powerLevel;

    }

    //modifies powerLevel 
    public void powerLevelModification(int newLevel) {
        this.powerLevel = newLevel;
    }

    //returns superPower
    public String getSuperPower(){
        return this.superPower;
    }

    //returns powerLevel
    public int getPowerLevel() {
        return this.powerLevel;
    }

    //returns whether the hero wears caps or not. 
    public boolean wearsCape(){
        return this.cape;
    }
    
    //Check the status
    public int checkSuperStatus(Person p1, Person p2){
        int sum = 0;

        if (p1 instanceof SuperHero) sum++;
        if (p2 instanceof SuperHero) sum+=2;

        return sum;
    }
}
