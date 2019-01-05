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

		String date = p.getDate().split("a")[0];
		String[] newdate = date.split("/");
		
		BufferedWriter bw = null;
		String fileName = "src/files/"+String.valueOf(p.getCustomer().getTelephone()+newdate[0]+newdate[1]+newdate[2]);

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
