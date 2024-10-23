package persistence;

import models.User;
import models.PrintJob;

public class DataBase{
	
	private static DataBase instance;
	private User[] userDB;
	private PrintJob[] printJobDB;
	
	private DataBase(){
		
		userDB=new User[10];
		printJobDB=new PrintJob[20];
		
		userDB[0]=new User("admin","admin",0);
		userDB[1]=new User("user1","user1",1);
		userDB[2]=new User("user2","user2",1);
		
		printJobDB[0]=new PrintJob(1,"descripcion",22,"estado","byn","10/10/24","12/10/24","15/10/24");
	}
	
	// SINGLETON
	public static DataBase getInstance() {
		if(instance==null) {
			instance=new DataBase();
			
			
		}
		return instance;
	} 
}