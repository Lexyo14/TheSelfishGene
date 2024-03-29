package TheSelfishGene;

import java.util.*;
public class Battle {

    public static Stack<Men> men_l = new Stack<Men>();
    public static Stack<Women> women_l = new Stack<Women>();
    public static Stack<Men> tmpm = new Stack<Men>();
    public static Stack<Women> tmpw = new Stack<Women>();
    public static int a;
    public static int b;
    public static int c;
    public static int year;
    public static int deathm;
    public static int deathw;
    public static int stability;
    public static Float[] ratios;
    public static int aprox;
    public static int maxw=0;
    public static int maxm=0;
    public static float cntp=0;
    public static float cntf=0;
    public static float cntc=0;
    public static float cnts=0;
    public static int mut;
    //public static int expectancy

    /*
    Battle(){
        men_l = new Stack<Men>();
        women_l = new Stack<Women>();
        tmpm = new Stack<Men>();
        tmpw = new Stack<Women>();
    }
    */
    //add an int expectancy
    public String exe(int a, int b , int c, int numberPhilanderers, int numberFaithful, int numberCow, int numberFast, int rep, int year, int deathm, int deathw, int stability, int aprox,int mut) {

        men_l.clear();
        women_l.clear();
        tmpm.clear();
        tmpw.clear();

        //this.expectancy=expectancy
        this.aprox=aprox;
        this.year=year;
        this.deathm=deathm;
        this.deathw=deathw;
        this.a=a;
        this.b=b;
        this.c=c;
        this.stability=stability;
        this.mut=mut;
        cntp=numberPhilanderers;
        cntf=numberFaithful;
        cntc=numberCow;
        cnts=numberFast;

        Main.controller.updatePopChart((int)cntp, (int)cntf, (int)cntc, (int)cnts);
        Main.controller.updateTotalPopDisplay((int)(cntp+cntf+cntc+cnts),0);
        //create the initiale set of men and women in lists
        for (int i = 0; i<numberFaithful; i++) {
            Faithfull faith = new Faithfull();
            //for random death remove line above and uncomment line bellow
            //Fast Faithfull = new Faithfull((int)Math.floor(Math.random()*(expactancy-0+1)+0));
            men_l.add(faith);
        }
        for (int i = 0; i<numberPhilanderers; i++ ){
            Philanderers ph = new Philanderers();
            //for random death remove line above and uncomment line bellow
            //Philanderers fast = new Philanderers((int)Math.floor(Math.random()*(expactancy-0+1)+0));
            men_l.add(ph);
        }
        for (int i = 0; i<numberCow; i++ ){
            Coy coy = new Coy();
            //for random death remove line above and uncomment line bellow
            //Coy fast = new Coy((int)Math.floor(Math.random()*(expactancy-0+1)+0));
            women_l.add(coy);
        }
        for (int i = 0; i<numberFast; i++ ){
            Fast fastWoman1 = new Fast();
            //for random death remove line above and uncomment line bellow
            //Fast fast = new Fast((int)Math.floor(Math.random()*(expactancy-0+1)+0));
            women_l.add(fastWoman1);
        }

        //list of ratios:
        // ratios = { Ratio_Faithful/total, Ratio_Philanderers/total, Ratio_Coy/total, Ratio_Fast/total };
        ratios = new Float[]{(cntf/(numberFaithful+numberPhilanderers+numberCow+numberFast)) * 100, (cntp/(numberFaithful+numberPhilanderers+numberCow+numberFast)) * 100,(cntc/(numberFaithful+numberPhilanderers+numberCow+numberFast))*100,(cnts/(numberFaithful+numberPhilanderers+numberCow+numberFast))*100};

        int stable = 0; //if this is equal to Stability, then the program stops
        //tmpm.addAll(men_l);
        //tmpw.addAll(women_l);

        for (int j =0; j<rep;j++){
            Main.controller.updateProgressBar(j,rep);
            maxw = women_l.size();//total number of woman
            maxm = men_l.size();
            Thread[] ThreadListMan = new Thread[maxm]; //array of thread of size number of man
            for (int k=0; k<maxm; k++) {
                Men m = men_l.get(k); //m = men_l[k]
                Thread Man = new Thread(m);
                Man.start();
                ThreadListMan[k]=Man;
            }


            //syncghronizing all newly created threads
            for (int k=0; k<maxm; k++){
                try {
                    ThreadListMan[k].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }



            //removin all dead man /not by index
            for (Men men : tmpm) {
                men_l.remove(men);
                if (Faithfull.class.isAssignableFrom(men.getClass())) {
                    cntf--;
                } else {
                    cntp--;
                }
            }
            tmpm.clear();

            //removin all dead woman /not by index
            for (Women women : tmpw) {
                women_l.remove(women);
                if (Fast.class.isAssignableFrom(women.getClass())) {
                    cnts--;
                } else {
                    cntc--;
                }
            }
            tmpw.clear();

            Main.controller.updatePopChart((int)cntp, (int)cntf, (int)cntc, (int)cnts);//updates pop chart
            Main.controller.updateTotalPopDisplay((int)(cntp+cntf+cntc+cnts),j);//updates total pop chart

            int[] rawValue = {((int)cntp), (int)cntf, (int)cntc, (int)cnts};
            Main.controller.addRawValues(rawValue);

            //stability check based on the previous generations:
            //System.out.println(cnts + " "+ cntc + " " +" "+ cntp + " "+ cntf+" "+ men_l.size() + " "+ women_l.size());
            if ((ratios[0]-aprox) < ((cntf)/(men_l.size()+ women_l.size()))*100 && ((cntf)/(men_l.size()+ women_l.size()))*100 < (ratios[0]+aprox)){
                if ((ratios[1]-aprox)<((cntp)/(men_l.size()+ women_l.size()))*100 && ((cntp)/(men_l.size()+ women_l.size()))*100 < ratios[1]+aprox){
                    if (ratios[2]-aprox < ((cntc)/(women_l.size()+ men_l.size()))*100 && ((cntc)/(women_l.size()+ men_l.size()))*100 < ratios[2]+aprox){
                        if (ratios[3]-aprox< ((cnts)/(women_l.size()+ men_l.size()))*100 && ratios[3]+aprox > ((cnts)/(women_l.size()+ men_l.size()))*100){
                            stable++;
                            ratios = new Float[]{((cntf)/(men_l.size()+ women_l.size()))*100,((cntp)/(men_l.size()+ women_l.size()))*100,((cntc)/(women_l.size()+ men_l.size()))*100,((cnts)/(women_l.size()+ men_l.size()))*100};

                        }else{
                            ratios = new Float[]{((cntf)/(men_l.size()+ women_l.size()))*100,((cntp)/(men_l.size()+ women_l.size()))*100,((cntc)/(women_l.size()+ men_l.size()))*100,((cnts)/(women_l.size()+ men_l.size()))*100};
                            stable=0;
                        }


                    }else{
                        ratios = new Float[]{((cntf)/(men_l.size()+ women_l.size()))*100,((cntp)/(men_l.size()+ women_l.size()))*100,((cntc)/(women_l.size()+ men_l.size()))*100,((cnts)/(women_l.size()+ men_l.size()))*100};
                        stable=0;
                    }

                }else{
                    ratios = new Float[]{((cntf)/(men_l.size()+ women_l.size()))*100,((cntp)/(men_l.size()+ women_l.size()))*100,((cntc)/(women_l.size()+ men_l.size()))*100,((cnts)/(women_l.size()+ men_l.size()))*100};
                    stable=0;
                }

            }else{
                ratios = new Float[]{((cntf)/(men_l.size()+ women_l.size()))*100,((cntp)/(men_l.size()+ women_l.size()))*100,((cntc)/(women_l.size()+ men_l.size()))*100,((cnts)/(women_l.size()+ men_l.size()))*100};
                stable=0;
            }
            if (stable>=stability){
                String Faith = String.format("%.2f", ratios[0]);
                String Phil= String.format("%.2f", ratios[1]);
                String Co=String.format("%.2f", ratios[2]);
                String Fas = String.format("%.2f", ratios[3]);
                Float sum= ratios[0]+ratios[1]+ratios[2]+ratios[3];
                Main.controller.eventStable(j);
                return "faithfull: " +  Faith +"%" + " philanderers: " +Phil + "%" + " coy: " + Co + "%" + " fast: "
                        + Fas + "%\n" +
                        "Correctness: " + sum + "%";
            }

        }

        Main.controller.eventUnstable(rep);
        return "Unstable";




    }




}
