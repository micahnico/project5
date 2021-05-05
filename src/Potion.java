
public class Potion extends Item {
	
	public Potion(String name, int price) {
		super(name, price);
	}
	
	@Override
	public void use(Pokemon p) {
		if(p.getCurrentHealth() > 0) {
			p.addHealth(10);
		}
		else {
			System.out.println("Sorry, Pokemon must be revived in order to use Potion.");
		}
	}
	

}
