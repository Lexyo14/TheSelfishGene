package TheSelfishGene;

public class Fast extends Women {
    public int num;
    private int health=0;

    public void ChangeHealth(int k){
        health+=k;
    }

    @Override
    public boolean check_health(int k){

        if (health<k){
            return true;
        }else{
            return false;
        }

    }

}
