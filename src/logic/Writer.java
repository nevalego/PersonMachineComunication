package logic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Writer {

	public void export(List<Customer> registrados) {

		BufferedWriter bw = null;
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

		BufferedWriter bw = null;
		String date = String.valueOf(p.getDate().getDay() + p.getDate().getMonth() + p.getDate().getYear()
				+ p.getDate().getHours() + p.getDate().getMinutes());
		String fileName = "src/files/"+String.valueOf(p.getCustomer().getTelephone() + date);

		try {
			bw = new BufferedWriter(new FileWriter(new File(fileName + ".txt")));

			bw.write(p.getBill());

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

}
