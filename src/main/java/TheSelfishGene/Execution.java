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
    int a;
    int b;
    int c;
    //int expectancy
    
    //add an expactancy int in execution
    public Execution(int a, int b, int c, int numberPhilanderers, int numberFaithful, int numberCow, int numberFast, int fDeathRate,
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
        this.a = a;
        this.b =b;
        this.c = c;
    }

    public void run(){
        System.out.println("Executing the Simulator...");
        Battle battle = new Battle();
        System.out.println(battle.exe(a,b,c,numberPhilanderers,numberFaithful,numberCow,numberFast,rep,year,mDeathRate,fDeathRate,stability,approx,mut));
    }
//p = philanderers year = how many time passes between //deathm = die variable of man //stability = how many times has to be stable //aprox = stability approximation
    //mut = percentage of being


}
