package persistence;

import models.User;

public class DataBaseLogic {

	// Definir los metodos como estaticos
	// FindAll,Save,Edit,Delete.

	public static User[] findAllUsers() {

		User[] userDB = DataUser.getInstance().getUserDB();
		int counter = 0;
		for (User user : userDB) {
			if (user != null) {
				if (user.isState() != false) {
					counter++;

				}
			}

		}
		User[] usersActivated = new User[counter];
		int index = 0;
		for (User user : userDB) {
			if (user != null) {
				if (user.isState()) {
					usersActivated[index] = user;
					index++;
				}
			}
		}
		return usersActivated;

	}

	public static void saveUser(User user1) {
		User[] userDB = DataUser.getInstance().getUserDB();
		User[] userDB1= new User[userDB.length+1];
		int index=0;
		for(User user:userDB) {
			
			userDB1[index]=user;
			index++;
		
		}
		userDB1[index]=user1;
		DataUser.getInstance().setUserDB(userDB1);
	}

}
