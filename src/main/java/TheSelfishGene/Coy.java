package TheSelfishGene;

public class Coy implements Women{
    private int health=0;

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
