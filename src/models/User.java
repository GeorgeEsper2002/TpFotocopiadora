package models;

public class User {

	private String name;
	private String password;
	private int role;// 0-Admin 1-User
	private String state;// Deactivated-Activated
	
	
	

	public User(String name, String password, int role, String state) {
		super();
		this.name = name;
		this.password = password;
		this.role = role;
		this.state = state;
	}


	public User() {
	
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getRole() {
		return role;
	}


	public void setRole(int role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "User [name=" + name +"Password: " +password +"]";
	}


	
	
	
	
	
}
