package persistence;

import models.User;

public class DataUser {

	private static DataUser instance;
	private User[] userDB;

	private DataUser() {

		userDB = new User[10];

		userDB[0] = new User("admin", "admin", "0", true);
		userDB[1] = new User("user1", "user1", "1", true);
		userDB[2] = new User("user2", "user2", "1", true);

	}

	public User[] getUserDB() {
		int counter = 0;
		for (User user : userDB) {
			if (user != null) {

				counter++;

			}

		}

		User[] allUsers = new User[counter];
		int index = 0;
		for (User user : userDB) {
			if (user != null) {

				allUsers[index] = user;
				index++;

			}
		}
		return allUsers;
	}

	public void setUserDB(User[] userDB) {
		this.userDB = userDB;
	}

	// SINGLETON
	public static DataUser getInstance() {
		if (instance == null) {
			instance = new DataUser();

		}
		return instance;
	}

	public static User getAdmin() {
		User admin = getInstance().userDB[0];
		return admin;
	}

	// Function to get logged user
	public static User getLoggedUser(String userName) {
		User[] userDB1 = DataUser.getInstance().getUserDB();
		for (User user : userDB1) {
			if (user.getName().equals(userName)) {
				return user;
			}
		}

		return null;
	}

}
