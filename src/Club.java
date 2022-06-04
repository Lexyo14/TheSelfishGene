public class Club extends Battle {
    public Men bf=new Men();

    Club(Men me){
        bf=me;
    }

    public void meet(){

        //System.out.println(women_l.size());
        Women gf = new Women();
        synchronized (women_l){
            if (women_l.size()==0){
                //System.out.println(women_l.size());
                return;
            }
            int min = 0;
            int max = women_l.size() - 1;

            int random_girl = (int)Math.floor(Math.random()*(max-min+1)+min);
            gf = women_l.remove(random_girl);
        }

        int h1=0 ;
        int h2=0;
        int child = (int)Math.floor(Math.random()* (2-1+1)+1);
        if (Faithfull.class.isAssignableFrom(bf.getClass())){
            if (Coy.class.isAssignableFrom(gf.getClass())){
                h1= (a-b)/2-c;
                h2= (a-b)/2-c;

                if (child == 1){
                    Coy girl = new Coy();
                    tmpw.add(girl);
                }else{
                    Faithfull boy = new Faithfull();
                    tmpm.add(boy);
                }
            }else{
                h1= (a-b)/2;
                h2= (a-b)/2;
                if (child == 1){
                    Fast girl = new Fast();
                    tmpw.add(girl);
                }else{
                    Faithfull boy = new Faithfull();
                    tmpm.add(boy);
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
                    Fast girl = new Fast();
                    tmpw.add(girl);
                }else{
                    Philanderers boy = new Philanderers();
                    tmpm.add(boy);
                }
            }

        }
        bf.ChangeHealth(h2-10);
        gf.ChangeHealth(h1-10);
        if (bf.check_health(-30)){
            tmpm.remove(bf);
        }
        if (gf.check_health(-30)){
            tmpw.remove(gf);
        }

    }

}
