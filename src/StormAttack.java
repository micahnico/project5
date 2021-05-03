//Philippe
public class StormAttack extends Attack{
    public StormAttack(String name, String element) {
        super(name, element);
    }

    /**
     * This contains the algorith that will determine the number of damages done by an attack
     * In function fo the opponent and the defense proposed by the opponent
     * It returns an int which is the damages done after the calculation.
     * We can use that with a simple takeDamage(int h) for the fights.
     * @author Philippe
     * @param opponent
     * @param def
     * @return int: the damages done by the attack
     */
    public int damage(Pokemon opponent, Defense def) {
        int damage = 0;

        if (def.getType().equals("shell")) {
            damage += 15;
        }

        if (def.getType().equals("shield")) {
            damage += 25;
        }

        if (def.getType().equals("simple")) {
            damage += 45;
        }

        if(opponent.getTypePokemon().equals(super.getEle())){
            damage -= 10;
        }

        return damage;
    }
}
