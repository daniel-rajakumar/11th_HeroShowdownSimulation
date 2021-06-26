public class Person {
    private String name, job;

    Person(String name, String job){
        this.name = name;
        this.job = job;
    }

    public String getName(){return this.name;}
    public String getJob(){return this.job;}

    //random num (0 -> max)
    public static int getRandom(int max) {
        return (int)(Math.random()*max);
    }
}
