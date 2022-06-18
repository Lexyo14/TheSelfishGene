package TheSelfishGene;

import java.util.*;
public class Battle {

    public static Stack<Men> men_l = new Stack<Men>();
    public static Stack<Women> women_l= new Stack<>();
    public static Stack<Men> tmpm = new Stack<>();
    public static Stack<Women> tmpw = new Stack<>();
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

    Battle(){
        men_l = new Stack<Men>();
        women_l = new Stack<Women>();
        tmpm = new Stack<Men>();
        tmpw = new Stack<Women>();
    }

    public String exe(int a, int b , int c, int p, int f, int co, int s, int rep, int year, int deathm, int deathw, int stability, int aprox,int mut) {
        System.out.println(women_l);
        this.aprox=stabilityApproximation;
        this.year=year;
        this.deathm=deathRateMan;
        this.deathw=deathRateWoman;
        this.a=a;
        this.b=b;
        this.c=c;
        this.stability=stability;
        this.mut=mutationPercentage;
        cntp=philanderersMan;
        cntf=faithfulMan;
        cntc=cowWoman;
        cnts=fastWoman;
        //create the initiale set of men and women in lists
        for (int i = 0; i<faithfulMan; i++) {
            Faithfull faith = new Faithfull();
            men_l.add(faith);
        }
        for (int i = 0; i<philanderersMan; i++ ){
            Philanderers ph = new Philanderers();
            men_l.add(ph);
        }
        for (int i = 0; i<cowWoman; i++ ){
            Coy coy = new Coy();
            women_l.add(coy);
        }
        for (int i = 0; i<fastWoman; i++ ){
            Fast fast = new Fast();
            women_l.add(fast);
        }

        //list of ratios:
        // ratios = { Ratio_Faithful/total, Ratio_Philanderers/total, Ratio_Coy/total, Ratio_Fast/total };
        ratios = new Float[]{(cntf/(faithfulMan+philanderersMan+cowWoman+fastWoman)) * 100, (cntp/(faithfulMan+philanderersMan+cowWoman+fastWoman)) * 100,(cntc/(faithfulMan+philanderersMan+cowWoman+fastWoman))*100,(cnts/(faithfulMan+philanderersMan+cowWoman+fastWoman))*100};

        int stable = 0; //if this is equal to Stability, then the program stops
        //tmpm.addAll(men_l);
        //tmpw.addAll(women_l);

        for (int j =0; j<repetitions;j++){
            maxw = women_l.size();
            maxm = men_l.size();
            Thread[] ThreadListMan = new Thread[maxm]; //array of thread of size number of man
            for (int k=0; k<maxm; k++) {
                Men m = men_l.get(k);
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

            //stability check based on the previous generations:
            //System.out.println(cnts + " "+ cntc + " " +" "+ cntp + " "+ cntf+" "+ men_l.size() + " "+ women_l.size());
            if ((ratios[0]-stabilityApproximation) < ((cntf)/(men_l.size()+ women_l.size()))*100 && ((cntf)/(men_l.size()+ women_l.size()))*100 < (ratios[0]+stabilityApproximation)){
                if ((ratios[1]-stabilityApproximation)<((cntp)/(men_l.size()+ women_l.size()))*100 && ((cntp)/(men_l.size()+ women_l.size()))*100 < ratios[1]+stabilityApproximation){
                    if (ratios[2]-stabilityApproximation < ((cntc)/(women_l.size()+ men_l.size()))*100 && ((cntc)/(women_l.size()+ men_l.size()))*100 < ratios[2]+stabilityApproximation){
                        if (ratios[3]-stabilityApproximation< ((cnts)/(women_l.size()+ men_l.size()))*100 && ratios[3]+stabilityApproximation > ((cnts)/(women_l.size()+ men_l.size()))*100){
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
                String Faith = String.format("%.02f", ratios[0]);
                String Phil= String.format("%.2f", ratios[1]);
                String Co=String.format("%.2f", ratios[2]);
                String Fas = String.format("%.2f", ratios[3]);
                Float sum= ratios[0]+ratios[1]+ratios[2]+ratios[3];
                return "faithfull " +  Faith +"%" + " philanderersMan " +Phil + "%" + " coy " + Co + "%" + " fast " + Fas + "%" + " Total percentace should be: 100 and it'fastWoman " + sum;
            }

        }

        return "unstable";




    }




}
