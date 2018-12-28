package logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {

	public List<Item> loadFile(String file) {

		BufferedReader br = null;
		String[] line = null;
		List<Item> items = new ArrayList<Item>();

		try {
			br = new BufferedReader(new FileReader(file));

			while (br.ready()) {
				line = br.readLine().split("@");
				ItemCategory cat;
				
				try{
					cat = ItemCategory.valueOf(line[1]);
				}catch(IllegalArgumentException il) {
					cat=ItemCategory.Others;
				}
				
				Item i = new Item(line[0], cat, line[2], line[3],
						Double.parseDouble(line[4]), 
						Double.parseDouble(line[5]));
				System.out.println(i.toString());
						
				items.add(i);

			}
			
			return items;

		} catch (FileNotFoundException e) {
			System.out.println("Problems loading file");
		} catch (IOException e) {
			System.out.println("I/O problems while loading file");
		}finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return null;
	}

	public List<Customer> loadClients(String file) {
		BufferedReader br = null;
		String[] line = null;
		List<Customer> cs = new ArrayList<Customer>();

		try {
			br = new BufferedReader(new FileReader(file));

			while (br.ready()) {
				line = br.readLine().split("@");
				Customer c=new Customer();
				
				c.setUsername(line[0]);
				c.setPassword(line[1]);
				
				System.out.println(c.toString());
						
				cs.add(c);

			}
			
			return cs;

		} catch (FileNotFoundException e) {
			System.out.println("Problems loading customers file");
		} catch (IOException e) {
			System.out.println("I/O problems while loading customers file");
		}finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return cs;

		
	}

}
