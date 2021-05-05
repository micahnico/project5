public abstract class Item {
	
	private String name;
	private int price;
	
	public Item(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	// returns item name
	public String getName() {
		return name;
	}

	// returns item price
	public int getPrice() {
		return price;
	}
	
	public abstract void use(Pokemon p);
	
}
