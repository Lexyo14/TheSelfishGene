public class Philanderers extends Men implements Runnable {
    private static int cntp = 0;
    public int num;
    private int health=0;
    Philanderers (){
        cntp++;
        super.cntm++;
    }

    public int countp(){
        return cntp;
    }
    public void ChangeHealth(int k){
        health+=k;
    }

    @Override
    public void run() {
        Club ne = new Club(this);
        ne.meet();

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