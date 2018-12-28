package logic;

import java.util.Date;
import java.util.HashMap;
import java.util.Set;

public class Party {

	private HashMap<Item, Integer> selectedItemsUnits = new HashMap<>();

	private Customer customer = new Customer();
	private Date date = new Date();
	private int attendance = 10;
	private double finalPrice = 0.0;
	private String comments = "";

	public Party() {
	}

	public void addItem(Item i, int units) {

		if (itemIsInParty(i)) {
			int unitsInOrder = selectedItemsUnits.get(i);
			selectedItemsUnits.put(i, units + unitsInOrder);

		} else {
			selectedItemsUnits.put(i, units);
		}
		calculateFinalPrice();
		System.out.println(toString());
		System.out.println(getBill());

	}

	private boolean itemIsInParty(Item i) {

		for (Item item : selectedItemsUnits.keySet()) {
			if (item.getCode().equals(i.getCode()))
				return true;
		}
		return false;
	}

	public void deleteItem(Item i, int units) {
		int total = selectedItemsUnits.get(i);
		int result = total - units;
		if (result <= 0) {
			selectedItemsUnits.remove(i, total);
		} else {
			selectedItemsUnits.put(i, total - units);
		}
		calculateFinalPrice();
		System.out.println(toString());
		System.out.println(getBill());
	}

	private void calculateFinalPrice() {
		finalPrice = 0.0;
		double numGroups = attendance / 10;
		for (Item i : selectedItemsUnits.keySet()) {
			finalPrice += i.getUnitPrice() * selectedItemsUnits.get(i) + i.getGroupPrice() * numGroups;
		}
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

	public void setCustomer(Customer c) {
		this.customer = c;
	}

	public Customer getCustomer() {
		return customer;
	}

	public double getWithDiscount() {
		return finalPrice * 0.15;
	}

	public void clearOrder() {
		selectedItemsUnits.clear();
	}

	public boolean confirm() {

		return true;
	}

	@Override
	public String toString() {
		return "Party items : \n" + itemsSelected() + "\n Customer " + customer + "\n Date " + date + "\n Attendants: "
				+ attendance + "\nFinalPrice " + finalPrice + " €";
	}

	private String itemsSelected() {
		String res = "";

		for (Item i : selectedItemsUnits.keySet()) {
			res += "(" + selectedItemsUnits.get(i) + ") " + i.getName() + " " + i.getUnitPrice() + " €/unit "
					+ i.getGroupPrice() + " €/group\n ";

		}
		return res;
	}

	public String getBill() {
		StringBuilder sb = new StringBuilder();
		sb.append("PARTY BILL\n------------------\n");
		String cus = "** CUSTOMER: " + customer.getName() + " " + customer.getSurname();

		if (customer.isLogged()) {
			cus += " (Registered customer: " + customer.getUsername() + ")";
		}
		sb.append(cus + "\n");
		sb.append("** NIF: " + customer.getNIF());

		sb.append("** PARTY DATE AND TIME: " + date.getDay() + "/" + date.getMonth() + "/" + (1900 + date.getYear())
				+ " a las " + date.getHours() + ":" + date.getMinutes());
		sb.append("** NUMBER OF ATTENDANTS: " + attendance);

		sb.append(
				"PRODUCTS:   NAME / CODE / UNITS  / TOTAL PRODUCT\n-------------------------------------------------------------------------------");

		// TODO ... por categorias

		sb.append("COMMENTS\n-------------------------");
		sb.append(comments);

		String price = "TOTAL BILL ";
		if (customer.isLogged()) {
			price += "WITH CUSTOMER DISCOUNT: " + String.valueOf(finalPrice) + " - "
					+ String.valueOf(finalPrice - getWithDiscount()) + " = " + String.valueOf(getWithDiscount());
		} else
			price += String.valueOf(finalPrice);
		sb.append(price + " €");

		return sb.toString();
	}

}
