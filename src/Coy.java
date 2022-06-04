public class Coy extends Women{
    private static int cntc = 0;
    public int num;
    private int health=0;
    Coy (){
        cntc++;
        super.cntw++;
    }
    public int countc(){
        return cntc;
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
