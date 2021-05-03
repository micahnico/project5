//Philippe
abstract public class Attack {
    private String name;
    private String element; // fire, air, etc

    public Attack(String name, String element) {
        this.name = name;
        this.element = element;
    }

    public String getName() {
        return name;
    }

    public String getEle() {
        return element;
    }

    abstract int damage(Pokemon opponent, Defense def);
}
