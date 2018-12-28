package logic;

public class Customer {

	private String NIF;
	private String name;
	private String telephone;
	private String surname;
	private String username;
	private String password;
	
	public Customer() {
	}
	
	public String getTelephone() {
		return telephone;
	}
	
	public void setTelephone(String t) {
		this.telephone=t;
	}
	
	public String getNIF() {
		return NIF;
	}
	
	public void setNIF(String NIF) {
		this.NIF=NIF;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void logIn(String username,String pass) {
		setUsername(username);
		setPassword(pass);
	}
	
	public boolean isLogged() {
		return username!=null;
	}


	@Override
	public String toString() {
		return "Customer : " + NIF+" " + name +" "+telephone+" "+ surname 
				+ " @" + username + " *" + password+"*";
	}
	
	
	
	
}

