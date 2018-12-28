package logic;

import java.util.ArrayList;
import java.util.List;

public class PartyOrganizer {

	private List<Customer> registrados = new ArrayList<Customer>();
	private List<Item> items;
	private List<Party> parties = new ArrayList<>();

	private Reader reader = new Reader();
	private Writer writer = new Writer();

	public PartyOrganizer(String file) {
		items = reader.loadFile(file);
		registrados= reader.loadClients("src/files/clientes.dat");
	}

	public List<Item> getItems() {
		return items;
	}

	public void createParty(Party p) {
		parties.add(p);
		
	}
	public void registerClient(Customer c) {
			
			registrados.add(c);
			exportRegisterClients();
			System.out.println(c.toString());
	}

	public void exportRegisterClients() {
		writer.export(registrados);
	}
	
	public boolean existsUser(String username) {
		for(Customer r : registrados) {
			if( r.getUsername().equals(username)) {
				return true;
			}
		}
		return false;
	}
	
	public Customer getCustomerByUsername(String username) {
		for(Customer c : registrados) {
			if(c.getUsername().equals(username))
				return c;
		}
		return null;
	}

	public Item getByName(String itemName) {
		for(Item i : items) {
			if(i.getName().equals(itemName))
				return i;
		}
		return null;
	}

	public void createInvoiceFile(Party p) {
		writer.invoice(p);
	}
}
