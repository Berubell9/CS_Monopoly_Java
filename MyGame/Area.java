public class Area {
    private String name, type;
    private int value;
    private boolean owner;

    public Area(String n, String t, int v) {
        this.name = n;
        this.type = t;
        this.value = v;
        this.owner = false;
    }

    public void setOwner(boolean o) {
        this.owner = o;
    }

    public String getName() {
        return this.name;
    }
    public String getType() {
        return this.type;
    }
    public int getValue() {
        return this.value;
    }
    public boolean getOwner() {
        return this.owner;
    }

}
