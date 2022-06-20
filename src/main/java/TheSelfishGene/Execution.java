package TheSelfishGene;

public class Execution extends Thread{
    //this thread permits to run the UI while running the program.

    int numberPhilanderers;
    int numberFaithful;
    int numberCow;
    int numberFast;
    int fDeathRate;
    int mDeathRate;
    int mut;
    int approx;
    int rep;
    int year;
    int stability;
    //int expectancy
    
    //add an expactancy int in execution
    public Execution(int numberPhilanderers, int numberFaithful, int numberCow, int numberFast, int fDeathRate,
                     int mDeathRate, int mut, int approx, int rep, int year, int stability){
        this.numberPhilanderers = numberPhilanderers;
        this.numberFaithful = numberFaithful;
        this.numberCow = numberCow;
        this.numberFast = numberFast;
        this.mDeathRate = -mDeathRate;
        this.fDeathRate = -fDeathRate;
        this.mut = mut;
        this.approx = approx;
        this.rep = rep;
        this.year = year;
        this.stability = stability;
    }

    public void run(){
        System.out.println("Executing the Simulator...");
        Battle b = new Battle();
        System.out.println(b.exe(5,9,2,numberPhilanderers,numberFaithful,numberCow,numberFast,rep,year,mDeathRate,fDeathRate,stability,approx,mut));
    }
//p = philanderers year = how many time passes between //deathm = die variable of man //stability = how many times has to be stable //aprox = stability approximation
    //mut = percentage of being


}
