package TheSelfishGene;
public class Club extends Battle {
    public Men bf; //the guy is the one who called the club
    Club(Men me){//constructor
        bf=me;
        //bf = Boyfriend: current man
    }

    public void meet() {
        //Main function of CLUb()
        //makes people copulate
/*
        int ill=(int)Math.floor(Math.random()*(100-0+1)+0);
        if (ill<= bf.get_exp()){
            //if ill is <= expactancy of the male kill him and end the thread
            tmpm.add(bf);
            return;
        }
        */

        Women gf;
        synchronized (women_l) {
            if (maxw == 0) {
                //if no woman u don0t do anything
                return;
            }

            //taking a random girl from girl list (picking her index)
            int min = 0;
            int max = maxw - 1;
            int random_girl = (int) Math.floor(Math.random() * (max - min + 1) + min);


            gf = women_l.remove(random_girl);
            //gf = curren Woman
            maxw--;
            women_l.add(gf);
/*           
            //same as for the man
            ill=(int)Math.floor(Math.random()*(100-0+1)+0);
            if (ill<= gf.get_exp()){
                tmpw.add(gf);
                return;
                */

        }


        int h1 = 0;
        int h2 = 0;

        //randomly decide if it's a boy or a girl
        int child = (int) Math.floor(Math.random() * (2 - 1 + 1) + 1);//1 = woman, 2 = men

        //is the child's gonna have a mutation?
        int mutate = (int) Math.floor(Math.random() * (100 - 0 + 1) + 0);//if this number less than mutation, it mutates
        
        /*
        getting the maximum and minimum of the expactancy of the father and mother
        int max = Math.max(bf.get_exp(),gf.get_exp() );
        int min = Math.min(bf.get_exp(),gf.get_exp());
        */
        //depending on the matching:
        //Each type of people has it's unique id which sum will give a new id.
        //based on the result it will do something
        switch (bf.Id() + gf.Id()) {
            case 4:
                //coy + philaderers
                h1 = 0;
                h2 = 0;
                break;

            case 5:
                //fast + philanderers
                h1 = a - b;
                h2 = a;
                switch (child) { //is it a boy or a girl?
                    case 1: //girl
                        if (mutate<=mut) {
                            cntc++; //the child is a different from mother
                            Coy girl = new Coy();
                            // for random death delete line above and uncomment line below
                            //Coy girl = new Coy((int)Math.floor(Math.random()*(max-min+1)+min));
                            women_l.add(girl);
                        } else {    //same type of mother
                            cnts++;
                            Fast girl = new Fast();
                            // for random death delete line above and uncomment line below
                            //Coy Fast = new Fast((int)Math.floor(Math.random()*(max-min+1)+min));
                            women_l.add(girl);
                        }
                        break;
                    case 2://boy
                        if (mutate<=mut) {
                            cntf++;//the child is a different from father
                            Faithfull boy = new Faithfull();
                            // for random death delete line above and uncomment line below
                            //Faithfull girl = new Faithfull((int)Math.floor(Math.random()*(max-min+1)+min));
                            men_l.add(boy);
                        } else {    //same type of father
                            cntp++;
                            Philanderers boy = new Philanderers();
                            // for random death delete line above and uncomment line below
                            //Philandereres girl = new Philanderers((int)Math.floor(Math.random()*(max-min+1)+min));
                            men_l.add(boy);
                        }
                        break;
                }
                break;

            case 7:
                //coy + faithfull
                h1 = (a - b) / 2 - c;
                h2 = (a - b) / 2 - c;

                switch (child) {
                    case 1://girl
                        if (mutate<=mut) {
                            cnts++;
                            Fast girl = new Fast();
                            // for random death delete line above and uncomment line below
                            //Fast girl = new Fast((int)Math.floor(Math.random()*(max-min+1)+min));
                            women_l.add(girl);
                        } else {
                            cntc++;
                            Coy girl = new Coy();
                            // for random death delete line above and uncomment line below
                            //Coy girl = new Coy((int)Math.floor(Math.random()*(max-min+1)+min));
                            women_l.add(girl);
                        }
                        break;
                    case 2://boy
                        if (mutate<=mut) {
                            cntp++;
                            Philanderers boy = new Philanderers();
                            // for random death delete line above and uncomment line below
                            //Philanderers girl = new Philanderers((int)Math.floor(Math.random()*(max-min+1)+min));
                            men_l.add(boy);
                        } else {
                            cntf++;
                            Faithfull boy = new Faithfull();
                            // for random death delete line above and uncomment line below
                            //Faithfull girl = new Faithfull((int)Math.floor(Math.random()*(max-min+1)+min));
                            men_l.add(boy);
                        }
                        break;
                }
                break;

            case 8:
                //fast + faithfull
                h1 = (a - b) / 2;
                h2 = (a - b) / 2;
                switch (child) {
                    case 1:
                        if (mutate<=mut) {
                            cntc++;
                            Coy girl = new Coy();
                            // for random death delete line above and uncomment line below
                            //Coy girl = new Coy((int)Math.floor(Math.random()*(max-min+1)+min));
                            women_l.add(girl);
                        } else {
                            cnts++;
                            Fast girl = new Fast();
                            // for random death delete line above and uncomment line below
                            //Fast girl = new Fast((int)Math.floor(Math.random()*(max-min+1)+min));
                            women_l.add(girl);
                        }
                        break;
                    case 2:
                        if (mutate<=mut) {
                            cntp++;
                            Philanderers boy = new Philanderers();
                            // for random death delete line above and uncomment line below
                            //Philanderers girl = new Philanderers((int)Math.floor(Math.random()*(max-min+1)+min));
                            men_l.add(boy);
                        } else {
                            cntf++;
                            Faithfull boy = new Faithfull();
                            // for random death delete line above and uncomment line below
                            //Faithfull girl = new Faithfull((int)Math.floor(Math.random()*(max-min+1)+min));
                            men_l.add(boy);
                        }
                        break;
                }
                break;
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
