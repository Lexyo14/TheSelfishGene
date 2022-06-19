package TheSelfishGene;

public class Fast implements Women {
    public int num;
    private int health=0;

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
