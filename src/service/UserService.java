package service;

import models.User;
import persistence.DataBaseLogic;
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
	
	
	
	
	
	
	
	

}
