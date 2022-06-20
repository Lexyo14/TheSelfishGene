package TheSelfishGene;

public interface Men extends Runnable{

    public int Id();
    
    //just to not create an error when running 
    //public int get_exp(){return 5;}
    
    public void ChangeHealth(int k);

    @Override
    public void run();

    public boolean check_health(int k);

}
