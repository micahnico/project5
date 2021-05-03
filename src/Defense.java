// Philippe
public class Defense {
    private String name;
    private String type; // the type of the attack influences the damages received
    private String element; // fire, air, water, etc

    public Defense(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getEle() {
        return element;
    }
}
