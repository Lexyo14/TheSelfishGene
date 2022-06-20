package TheSelfishGene;

public class Fast implements Women {
    public int num;
    private int health=0;
    /*
    // exp is a variable for random death
    public int exp;
    Faithfull(int exp){
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
        return 2;
    }

    public boolean check_health(int k){

        if (health<k){
            return true;
        }else{
            return false;
        }

    }

}
