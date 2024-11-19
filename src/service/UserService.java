package service;

import models.User;
import persistence.DataBaseLogic;
import persistence.DataUser;
// Aca va estar toda la logica relacionada con la manipulacion de usuarios
public class UserService {
	
	public static String createUser(String name, String password, String role) {
		
		if(name.isEmpty() || password.isEmpty()) {
			
			return "ERROR completar campos.";
		}
		if(!userExists(name)) {
			return "ERROR, el usuario ya existe";
		}
		User user=new User();
		user.setName(name);
		user.setPassword(password);
		user.setRole(role);
		user.setState(true);
		DataBaseLogic.saveUser(user);
		return "Usuario creado con exito.";
		
		
	}
	
	private static boolean userExists(String name) {
		
		User[] users = DataBaseLogic.findAllUsers();
		for (User user:users) {
			if(user.getName().equals(name)) {
				return false;
			}
		}
		
		return true;
	}
	
	// Do matrix that contains user,state,role
	public static String[][] listUsers() {
		User[] userDB=DataUser.getInstance().getUserDB();
		String[][] userData=new String[userDB.length][3];
		
		for(int i = 0; i<userDB.length;i++){
			//UserName
			userData[i][0]=userDB[i].getName();
			// Role
			if(userDB[i].getRole().equals("0")) {
				userData[i][2]="Admin";
			}
			else {
				userData[i][2]="Usuario";
			}
			
			// State
			if(userDB[i].isState()==true) {
				userData[i][1]="Activado";
			}
			else {
				userData[i][1]="Desactivado";
			}
		}
		
		
		
		return userData;
	}
	
	public static User getUser(String userName) {
		User[] userDB=DataUser.getInstance().getUserDB();
		for(User user:userDB) {
			if(user.getName().equals(userName)) {
				return user;
			}
		}
		return null;
	}
	
	
	
	
	

}
