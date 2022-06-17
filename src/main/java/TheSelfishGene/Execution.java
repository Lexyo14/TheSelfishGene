package TheSelfishGene;

public class Execution implements Runnable{

    //this thread permits to run the UI while running the program.

    Thread Execution;

    public void run(){
        System.out.println("Executing the Simulator...");
        Battle b = new Battle();
        System.out.println(b.exe(5,9,2,5,5,5,5,30,10,-30,-30,10,7,10));
    }



}
