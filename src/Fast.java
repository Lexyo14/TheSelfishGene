public class Fast extends Women {
    private static int cnts = 0;
    public int num;
    private int health=0;
    Fast (){
        cnts++;
        super.cntw++;
    }
    public int countc(){
        return cnts;
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
