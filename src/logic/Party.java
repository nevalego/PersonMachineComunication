package logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Party {

	private HashMap<Item, Integer> selectedItemsUnits = new HashMap<>();

	private Customer customer = new Customer();
	private Date date = new Date();
	private int attendance = 10;
	private double finalPrice = 0.0;
	private String comments = "";

	/**
	 * Add an item to the party reservation
	 * @param Item i
	 * @param int units
	 */
	public void addItem(Item i, int units) {

		//Checking if the item has been already chosen for the party reservation
		if (itemIsInParty(i)) {
			int unitsInOrder = selectedItemsUnits.get(i);
			// Adding the new number of units to the ones already chosen
			selectedItemsUnits.put(i, units + unitsInOrder);

		} else {
			// Adding the new product
			selectedItemsUnits.put(i, units);
		}
		// Recalculate total
		calculateFinalPrice();
		
		System.out.println(getBill());

	}

	/**
	 * Delete an specified number of units of an item from the party reservation
	 * @param Item i
	 * @param int units
	 */
	public void deleteItem(Item i, int units) {
		// Number of units of this item that are reserved
		int total = selectedItemsUnits.get(i);
		// Resting reserved and removed
		int result = total - units;
		// Remove all reserved (or more)
		if (result <= 0) {
			// Remove item
			selectedItemsUnits.remove(i, total);
		} else {
			// Update the number of units left for that item
			selectedItemsUnits.put(i, total - units);
		}
		// Recalculate total
		calculateFinalPrice();
		
		System.out.println(getBill());
	}

	private void calculateFinalPrice() {
		finalPrice = 0.0;
		double numGroups = attendance / 10;
		for (Item i : selectedItemsUnits.keySet()) {
			finalPrice += i.getUnitPrice() * selectedItemsUnits.get(i) + i.getGroupPrice() * numGroups;
		}
	}
	
	private boolean itemIsInParty(Item i) {

		for (Item item : selectedItemsUnits.keySet()) {
			if (item.getCode().equals(i.getCode()))
				return true;
		}
		return false;
	}

	private List<Item> getDrinkItems() {
		List<Item> drinks = new ArrayList<Item>();
		for (Item i : selectedItemsUnits.keySet()) {
			if (i.getCategory().equals(ItemCategory.Drink))
				drinks.add(i);
		}
		return drinks;
	}

	private List<Item> getFoodItems() {
		List<Item> food = new ArrayList<Item>();
		for (Item i : selectedItemsUnits.keySet()) {
			if (i.getCategory().equals(ItemCategory.Food))
				food.add(i);
		}
		return food;
	}

	private List<Item> getPlaceItems() {
		List<Item> places = new ArrayList<Item>();
		for (Item i : selectedItemsUnits.keySet()) {
			if (i.getCategory().equals(ItemCategory.Place))
				places.add(i);
		}
		return places;
	}

	private List<Item> getDecoItems() {
		List<Item> decos = new ArrayList<Item>();
		for (Item i : selectedItemsUnits.keySet()) {
			if (i.getCategory().equals(ItemCategory.Decoration))
				decos.add(i);
		}
		return decos;
	}

	private List<Item> getOtherItems() {
		List<Item> other = new ArrayList<Item>();
		for (Item i : selectedItemsUnits.keySet()) {
			if (i.getCategory().equals(ItemCategory.Others))
				other.add(i);
		}
		return other;
	}

	public void setAttendance(int people) {
		attendance = people;
		calculateFinalPrice();
	}

	public int getAttendance() {
		return attendance;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public double getFinalPrice() {
		calculateFinalPrice();
		return finalPrice;
	}

	public Set<Item> getSelectedItems() {
		return selectedItemsUnits.keySet();
	}

	public HashMap<Item, Integer> getSelectedItemsUnits() {
		return selectedItemsUnits;
	}

	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Provides the final price of the reservation applying the registered user's 15% discount
	 * @return double discounted total
	 */
	public double getWithDiscount() {
		return finalPrice * 0.85;
	}

	/**
	 * Removes all items for the party
	 */
	public void clearOrder() {
		selectedItemsUnits.clear();
	}

	
	/**
	 *	Provides the party bill in text format  
	 * @return String bill
	 */
	public String getBill() {
		StringBuilder sb = new StringBuilder();
		sb.append("PARTY BILL\n------------------\n");
		String cus = "** CUSTOMER: " + customer.getName() + " " + customer.getSurname();

		if (customer.isLogged()) {
			cus += " (Registered customer: " + customer.getUsername() + ")";
		}
		sb.append(cus + "\n");
		sb.append("** NIF: " + customer.getNIF() + "\n");

		sb.append("** PARTY DATE AND TIME: " + date.getDay() + "/" + date.getMonth() + "/" + (1900 + date.getYear())
				+ " a las " + date.getHours() + ":" + date.getMinutes() + "\n");
		sb.append("** NUMBER OF ATTENDANTS: " + attendance + "\n");

		sb.append(
				"PRODUCTS:   NAME / CODE / UNITS  / TOTAL PRODUCT\n-------------------------------------------------------------------------------\n");

		sb.append(itemsBill(getDecoItems()));
		sb.append(itemsBill(getDrinkItems()));
		sb.append(itemsBill(getFoodItems()));
		sb.append(itemsBill(getPlaceItems()));
		sb.append(itemsBill(getOtherItems()));
		
		sb.append("\nCOMMENTS\n-------------------------\n");
		sb.append(comments+"\n");

		String price = "TOTAL BILL ";
		if (customer.isLogged()) {
			price += "WITH CUSTOMER DISCOUNT: " + String.valueOf(finalPrice) + " - "
					+ String.valueOf(finalPrice - getWithDiscount()) + " = " + String.valueOf(getWithDiscount());
		} else
			price += String.valueOf(finalPrice);
		sb.append(price + " €\n");

		return sb.toString();
	}

	/**
	 * Provides a text for the bill with all items in the list 
	 * @param list of items
	 * @return String text 
	 */
	private String itemsBill(List<Item> list) {
		String items="";
		for(Item i :list ) {
			int units= getSelectedItemsUnits().get(i);
			items+=i.getName()+" / "+i.getCode()+" / "+String.valueOf(units)+" / "+String.valueOf(units*i.getPrice());
		}
		return items;
	}

}
