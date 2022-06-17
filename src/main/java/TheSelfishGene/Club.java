package TheSelfishGene;
public class Club extends Battle {

    public Men bf=new Men();

    Club(Men me){bf=me;}

    public void meet(){

        //System.out.println(women_l.size());
        Women gf = new Women();
        synchronized (women_l){
            if (maxw==0){
                //System.out.println(women_l.size());
                return;
            }
            int min = 0;
            int max = maxw-1;

            int random_girl = (int)Math.floor(Math.random()*(max-min+1)+min);
            gf = women_l.remove(random_girl);
            maxw--;
            women_l.add(gf);
        }

        int h1=0 ;
        int h2=0;
        int child = (int)Math.floor(Math.random()* (2-1+1)+1);
        int mutate = (int)Math.floor(Math.random()* (100-0+1)+0);
        if (Faithfull.class.isAssignableFrom(bf.getClass())){
            if (Coy.class.isAssignableFrom(gf.getClass())){
                h1= (a-b)/2-c;
                h2= (a-b)/2-c;

                if (child == 1){

                    if (mutate<= mut){
                        cnts++;
                        Fast girl = new Fast();
                        women_l.add(girl);
                    }else{
                        cntc++;
                        Coy girl = new Coy();
                        women_l.add(girl);
                    }

                }else{
                    if (mutate<= mut){
                        cntp++;
                        Philanderers boy = new Philanderers();
                        men_l.add(boy);
                    }else {
                        cntf++;
                        Faithfull boy = new Faithfull();
                        men_l.add(boy);
                    }
                }
            }else{
                h1= (a-b)/2;
                h2= (a-b)/2;
                if (child == 1){
                    if (mutate<= mut){
                        cntc++;
                        Coy girl = new Coy();
                        women_l.add(girl);
                    }else {
                        cnts++;
                        Fast girl = new Fast();
                        women_l.add(girl);
                    }
                }else{
                    if (mutate<= mut){
                        cntp++;
                        Philanderers boy = new Philanderers();
                        men_l.add(boy);
                    }else {
                        cntf++;
                        Faithfull boy = new Faithfull();
                        men_l.add(boy);
                    }
                }

            }

        }else{
            if (Coy.class.isAssignableFrom(gf.getClass())){
                h1 = 0;
                h2 = 0;
            }else{
                h1 = a-b;
                h2 = a;
                if (child == 1){
                    if (mutate<= mut){
                        Coy girl = new Coy();
                        women_l.add(girl);
                        cntc++;
                    }else {
                        Fast girl = new Fast();
                        women_l.add(girl);
                        cnts++;
                    }
                }else{
                    if (mutate<= mut){
                        Faithfull boy = new Faithfull();
                        men_l.add(boy);
                        cntf++;
                    }else {
                        Philanderers boy = new Philanderers();
                        men_l.add(boy);
                        cntp++;
                    }
                }
            }

        }
        bf.ChangeHealth(h2-year);
        gf.ChangeHealth(h1-year);
        if (bf.check_health(deathm)){
            tmpm.add(bf);
        }
        if (gf.check_health(deathw)){
            tmpw.add(gf);
        }

    }

}
