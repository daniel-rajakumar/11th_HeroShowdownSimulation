
public class NormalGuy extends Person {

    private static final String[] firstName = {"Lynden", "Khloe", "Israel", "Billie", "Kaeden", "Hal", "Kristie", "Lorna", "Armaan", "Keeleigh"};
    private static final String[] lastName = {"Dillon", "Chung", "Parkes", "Crossley", "Brooks", "Solomon", "Gallegos", "Davila", "Clark", "Cousins"};

    private static final String[] job = {"Anthropologist", "Balerina","Chef","Dog Catcher", "Entomologist", "Farmer", "Grocer"};
    
    NormalGuy(String name, String job){
        super(name, job);
    }

    //default constructor with randome values
    NormalGuy(){
        super(
            firstName[getRandom(firstName.length)] + " " + lastName[getRandom(lastName.length)], 
            job[getRandom(job.length)]
            );
    }

}

