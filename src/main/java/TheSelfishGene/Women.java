package TheSelfishGene;

public interface Women {

    //just to not create an error when running 
    //public int get_exp(){return 5;}
    public int Id();

    public void ChangeHealth(int k);

    public boolean check_health(int k);

}
