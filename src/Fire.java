
public class Fire extends Pokemon {

	private final String TYPE = "fire";

	public Fire(String name){
		super(name);
	}

	// attack for fire pokemon
	@Override
	public void attack() {

	}



	public int storm(Pokemon opponent, String def){
		int damage = 0;

		if (def.equals("shell")){
			damage += 15;
		}

		if (def.equals("shield")){
			damage  += 25;
		}

		if (def.equals("simple")){
			damage  += 45;
		}

		if(opponent.getType().equals(TYPE)){
			damage -= 10;
		}

		return damage;
	}

	public int blast(Pokemon opponent, String def){
		int damage = 0;

		if (def.equals("shell")){
			damage += 10;
		}

		if (def.equals("shield")){
			damage  += 10;
		}

		if (def.equals("simple")){
			damage  += 25;
		}

		if(opponent.getType().equals(TYPE)){
			damage -= 10;
		}

		return damage;
	}

	public int charge(Pokemon opponent, String def){
		int damage = 0;

		if (def.equals("shell")){
			damage += 5;
		}

		if (def.equals("shield")){
			damage  += 5;
		}

		if (def.equals("simple")){
			damage  += 0;
		}

		if(opponent.getType().equals(TYPE)){
			damage -= 10;
		}

		return damage;
	}

}
