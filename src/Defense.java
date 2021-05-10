/**
 * @author Philippe
 */
public class Defense {
    private String name;
    private String type; // the type of the attack influences the damages received
    private String element; // fire, air, water, etc

    /**
     * create a new defense
     * @param name
     * @param type
     */
    public Defense(String name, String type) {
        this.name = name;
        this.type = type;
    }

    /**
     * @return name of the defense
     */
    public String getName() {
        return name;
    }

    /**
     * @return type of the defense
     */
    public String getType() {
        return type;
    }

    /**
     * @return element of defense
     */
    public String getEle() {
        return element;
    }
}
