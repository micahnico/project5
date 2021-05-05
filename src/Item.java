
public abstract class Item {
	
	private String name;
	private int price;
	
	/**
	 * creates a new item and gives it a name and price
	 * @param name 
	 * @param price
	 * JoshSpicher
	 */
	public Item(String name, int price) {
		this.name = name;
		this.price = price;
	}
	/**
	 * 
	 * @return the name of the item
	 * JoshSpicher
	 * 
	 */
	// returns item name
	public String getName() {
		return name;
	}
	/**
	 * 
	 * @return the price of the item
	 * JoshSpicher
	 */
	// returns item price
	public int getPrice() {
		return price;
	}
	/**
	 * 
	 * @param p the name of the pokemon you would like to use the item on
	 * JoshSpicher
	 */
	public abstract void use(Pokemon p);
	
}
