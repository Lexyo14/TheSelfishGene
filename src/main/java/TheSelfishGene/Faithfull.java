package TheSelfishGene;

public class Faithfull implements Men {
    public int num;
    private int health=0;
    public int Id(){
        return 6;
    }
    public void run(){
        Club ne = new Club(this);
        ne.meet();
    }

    public void ChangeHealth(int k){
        health+=k;
    }

    public boolean check_health(int k){

        if (health<k){
            return true;
        }else{
            return false;
        }

    }


}
