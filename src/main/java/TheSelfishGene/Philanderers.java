package TheSelfishGene;

public class Philanderers implements Men {
    public int num;
    private int health=0;


    public int Id(){
        return 3;
    }



    public void ChangeHealth(int k){
        health+=k;
    }


    public void run() {
        Club ne = new Club(this);
        ne.meet();

    }


    public boolean check_health(int k){
        if (health<k){
            return true;
        }else{
            return false;
        }

    }
}
