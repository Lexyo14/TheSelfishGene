package TheSelfishGene;

public class Coy implements Women{
    private int health=0;
    /*
    //exp is a variable for random death
    public int exp;

    Coy(int exp){
        this.exp=exp;
    }
    
    public int get_exp(){
        return this.exp;
    }
    */

    public void ChangeHealth(int k){
        health+=k;
    }

    public int Id(){
        return 1;
    }


    public boolean check_health(int k){
        if (health<k){
            return true;
        }else{
            return false;
        }

    }


}
