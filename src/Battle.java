import java.util.*;
public class Battle {
    public static Stack<Men> men_l= new Stack<Men>();
    public static Stack<Women> women_l = new Stack<Women>();
    public static Stack<Men> tmpm= new Stack<Men>();
    public static Stack<Women> tmpw = new Stack<Women>();
    public static int a;
    public static int b;
    public static int c;
    public void exe(int a, int b , int c, int p, int f,int co, int s,int rep) {
        this.a=a;
        this.b=b;
        this.c=c;
        //create the initiale set of men and women in lists
        for (int i = 0; i<f; i++ ){
            Faithfull faith = new Faithfull();
            men_l.add(faith);
        }
        for (int i = 0; i<p; i++ ){
            Philanderers phil = new Philanderers();
            men_l.add(phil);
        }
        for (int i = 0; i<co; i++ ){
            Coy coy = new Coy();
            women_l.add(coy);
        }
        for (int i = 0; i<s; i++ ){
            Fast fast = new Fast();
            women_l.add(fast);
        }

        int stable = 0;

        for (int j =0; j<rep;j++){

            tmpm.addAll(men_l);
            tmpw.addAll(women_l);
            Stack<Thread> th = new Stack();
            for (int k=0; k<men_l.size(); k++) {
                Men m = men_l.get(k);
                Thread mythread = new Thread(m);
                mythread.start();
                th.add(mythread);
            }
            for (int k=0; k< th.size(); k++){
                try {
                    th.get(k).join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            men_l.clear();
            women_l.clear();
            men_l.addAll(tmpm);
            women_l.addAll(tmpw);
            tmpm.clear();
            tmpw.clear();
        }

        //men_l.printList();
        //women_l.printList();
        System.out.println(men_l.size() + " " + women_l.size());




    }




}
