public class MysteryEvent {
    private String name, type;
    private int value;

    public MysteryEvent(String n, String t, int v) {
        this.name = n;
        this.type = t;
        this.value = v;
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
}