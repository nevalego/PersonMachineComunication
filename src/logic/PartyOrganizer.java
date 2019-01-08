package logic;

import java.util.ArrayList;
import java.util.List;

public class PartyOrganizer {

	private List<Customer> registered = new ArrayList<Customer>();
	private List<Item> items;
	private List<Party> parties = new ArrayList<>();

	private Reader reader = new Reader();
	private Writer writer = new Writer();

	public PartyOrganizer(String file) {
		items = reader.loadFile(file);
		registered= reader.loadClients("src/files/clientes.dat");
	}

	public List<Item> getItems() {
		return items;
	}

	public void createParty(Party p) {
		parties.add(p);
		
	}
	public void registerClient(Customer c) {
			
			registered.add(c);
			exportRegisterClients();
			System.out.println(c.toString());
	}

	public void exportRegisterClients() {
		writer.export(registered);
	}
	
	public boolean existsUser(String username) {
		for(Customer r : registered) {
			if( r.getUsername().equals(username)) {
				return true;
			}
		}
		return false;
	}
	
	public Customer getCustomerByUsername(String username) {
		for(Customer c : registered) {
			if(c.getUsername().equals(username))
				return c;
		}
		return null;
	}

	/**
	 * Exports a file contaninig the bill
	 * @param Party p
	 */
	public void createInvoiceFile(Party p) {
		writer.invoice(p);
	}
}
