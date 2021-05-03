//Philippe
public class BlastAttack extends Attack{
    public BlastAttack(String name, String element) {
        super(name, element);
    }

    public int damage(Pokemon opponent, Defense def) {
        int damage = 0;

        if (def.getType().equals("shell")) {
            damage += 10;
        }

        if (def.getType().equals("shield")) {
            damage += 10;
        }

        if (def.getType().equals("simple")) {
            damage += 25;
        }

        if(opponent.getTypePokemon().equals(super.getEle())){
            damage -= 5;
        }

        return damage;
    }
}
