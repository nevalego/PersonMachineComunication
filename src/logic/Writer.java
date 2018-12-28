package logic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Writer {

	BufferedWriter bw = null;

	public void export(List<Customer> registrados) {

		try {
			bw = new BufferedWriter(new FileWriter(new File("src/files/clientes.dat")));

			for (Customer client : registrados) {

				bw.write(client.getUsername() + "@" + client.getPassword() + "\n");
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public void invoice(Party p) {

		try {
			bw = new BufferedWriter(new FileWriter(new File("src/files/"+p.getCustomer().getTelephone()+p.getDate()+".txt")));
			
			bw.write(p.getBill());
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
