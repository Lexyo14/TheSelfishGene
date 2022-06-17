public class Faithfull extends Men implements Runnable{
    public int num;
    private int health=0;

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
