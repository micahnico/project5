public class SuperPotion extends Item{
	
	public SuperPotion(String name, int price) {
		super(name, price);
	}
	
	@Override
	public void use(Pokemon p) {
		if(p.getCurrentHealth() > 0) {
			p.addHealth(25);
		}
		else {
			System.out.println("Sorry, Pokemon must be revived in order to use Super Potion.");
		}
	}

}
