package TheSelfishGene;

public interface Men extends Runnable{

    public int Id();

    public void ChangeHealth(int k);

    @Override
    public void run();

    public boolean check_health(int k);

}
