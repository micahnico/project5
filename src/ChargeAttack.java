//Philippe
public class ChargeAttack extends Attack{
    public ChargeAttack(String name, String element) {
        super(name, element);
    }

    public int damage(Pokemon opponent, Defense def) {
        int damage = 0;

        if (def.getType().equals("shell")) {
            damage += 5;
        }

        if (def.getType().equals("shield")) {
            damage += 5;
        }

        if (def.getType().equals("simple")) {
            damage += 0;
        }

        if(opponent.getTypePokemon().equals(super.getEle())){
            damage -= 2;
        }

        return damage;
    }
}
