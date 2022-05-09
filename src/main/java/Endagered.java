public class Endagered implements DatabaseManagement{
    private int id;
    private String name;
    private String age;
    private String health;

    private String healthy;
    private String ill;
    private String okay;

    private String newborn;
    private String young;
    private String adult;



    public Endagered(int id, String name, String health, String age){
        this.id=id;
        this.name=name;
        this.health=health;
        this.age=age;
    }


    @Override
    public void save() {


    }
}