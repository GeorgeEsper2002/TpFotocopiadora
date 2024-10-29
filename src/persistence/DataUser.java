package persistence;

import models.User;

public class DataUser {

	private static DataUser instance;
	private User[] userDB;

	private DataUser() {

		userDB = new User[10];

		userDB[0] = new User("admin", "admin", 0);
		userDB[1] = new User("user1", "user1", 1);
		userDB[2] = new User("user2", "user2", 1);

	}

	// SINGLETON
	public static DataUser getInstance() {
		if (instance == null) {
			instance = new DataUser();

		}
		return instance;
	}
	
	
	public  User[] getUsers() {
		
		return userDB;
	}
	
	

}
