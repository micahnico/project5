/**
 * @author Philippe
 */
abstract public class Attack {
    private String name;
    private String element; // fire, air, etc

    public Attack(String name, String element) {
        this.name = name;
        this.element = element;
    }

    /**
     * @return name of the attack
     */
    public String getName() {
        return name;
    }

    /**
     * @return the element of the attack
     */
    public String getEle() {
        return element;
    }

    /**
     * calculates the damage on a pokemon
     * @param opponent
     * @param def
     * @return
     */
    abstract int damage(Pokemon opponent, Defense def);
}
