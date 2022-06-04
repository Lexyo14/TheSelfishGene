public class Faithfull extends Men implements Runnable{
    private static int cntf = 0;
    public int num;
    private int health=0;
    Faithfull (){
        cntf++;
        super.cntm++;
    }
    public int countf(){
        return cntf;
    }

    public void run(){
        Club ne = new Club(this);
        ne.meet();
    }

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