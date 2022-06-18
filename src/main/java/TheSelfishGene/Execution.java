package TheSelfishGene;

public class Execution extends Thread{

    //this thread permits to run the UI while running the program.


    public void run(){
        System.out.println("Executing the Simulator...");
        Battle b = new Battle();
        System.out.println(b.exe(5,9,2,5,5,5,5,30,10,-30,-30,10,7,10));
    }
//p = philanderers year = how many time passes between //deathm = die variable of man //stability = how many times has to be stable //aprox = stability approximation
    //mut = percentage of being


}
