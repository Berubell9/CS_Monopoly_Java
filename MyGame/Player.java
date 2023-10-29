import java.util.ArrayList;

public class Player {
    private String name;
    private int totalDicePlayer, money;
    private ArrayList<Area> Property;

    public Player(String n){
        this.name = n;
        this.money = 2000;
        this.totalDicePlayer = 0;
        Property = new ArrayList<Area>();
    }

    public void setLocation(int l) {
        this.totalDicePlayer = l;
    }

    public int getLocation() {
        return this.totalDicePlayer;
    }
    public String getName() {
        return this.name;
    }
    public int getMoney() {
        return this.money;
    }

    public void increaseMoney(int money) {
        this.money += money;
    }
    public void decreaseMoney(int money) {
        this.money -= money;
    }

    public void buy(Area a) {
        checkMoneyTobuy(a.getValue());
        decreaseMoney(a.getValue());
        Property.add(a);
    }

    public ArrayList<Area> getProperty(){
        return this.Property;
    }

    public boolean checkOwnerLand(Area a){
        return Property.contains(a);
    }

    public boolean checkMoneyTobuy(int landValue) {
        if(this.money >= landValue){
            return true;
        }
        // event not buy
        return false;
    }
}
