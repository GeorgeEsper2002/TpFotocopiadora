package persistence;

import models.PrintJob;
import models.User;
import service.UserService;

public class DataBaseLogic {

	// Definir los metodos como estaticos
	// FindAll,Save,Edit,Delete.

	// Find all users
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

	// Save user in database
	public static void saveUser(User user1) {
		User[] userDB = DataUser.getInstance().getUserDB();
		User[] userDB1 = new User[userDB.length + 1];
		int index = 0;
		for (User user : userDB) {

			userDB1[index] = user;
			index++;

		}
		userDB1[index] = user1;
		DataUser.getInstance().setUserDB(userDB1);
	}

	// Delete User
	public static String deleteUser(String userName) {
		User[] userDB = DataUser.getInstance().getUserDB();
		int deleteIndex = 0;
		for (int i = 0; i < userDB.length; i++) {
			if (userDB[i].getName().equals(userName)) {
				deleteIndex = i;
			}
		}
		User[] userDB1 = new User[userDB.length - 1];
		int index = 0;
		for (int i = 0; i < userDB1.length; i++) {
			if (i != deleteIndex) {
				userDB1[index] = userDB[i];
				index++;
			}
		}

		DataUser.getInstance().setUserDB(userDB1);

		return "Usuario eliminado con exito";
	}

	public static User editUser(String userName, String role, boolean state) {
		User[] userDB = DataUser.getInstance().getUserDB();
		User user = new User();
		for (int i = 0; i < userDB.length; i++) {
			if (userDB[i].getName().equals(userName)) {
				user = userDB[i];
				user.setName(userName);
				user.setRole(role);
				user.setState(state);
			}
		}

		return user;
	}

	// Find all Jobs
	public static PrintJob[] findAllJobs() {
		PrintJob[] jobs = DataPrintJobs.getInstance().getPrintJobDB();
		return jobs;

	}

	public static void savePrintJob(PrintJob job) {
		PrintJob[] printJobDB = DataPrintJobs.getInstance().getPrintJobDB();
		PrintJob[] printJobDB1 = new PrintJob[printJobDB.length + 1];
		int index = 0;
		for (PrintJob job1 : printJobDB) {
			printJobDB1[index] = job1;
			index++;

		}
		printJobDB1[index] = job;
		DataPrintJobs.getInstance().setPrintJobDB(printJobDB1);
	}

	public static String deletePrintJob(int jobId) {
		PrintJob[] jobDB = DataPrintJobs.getInstance().getPrintJobDB();
		int indexDelete = 0;
		for (int i = 0; i < jobDB.length; i++) {
			if (jobDB[i].getId() == jobId) {
				indexDelete = i;
				break;
			}
		}
		PrintJob[] newjobDB = new PrintJob[jobDB.length - 1];
		int newIndex = 0;
		for (int i = 0; i < newjobDB.length; i++) {
			if (i != indexDelete) {
				newjobDB[newIndex] = jobDB[i];
				newIndex++;
			}
		}

		DataPrintJobs.getInstance().setPrintJobDB(newjobDB);

		return "Trabajo eliminado con exito.";

	}

	// Set Job
	// Delete Job

	public static PrintJob editPrintJob(int printJobId, String description, String copies, String quality) {
		PrintJob[] jobs = DataPrintJobs.getInstance().getPrintJobDB();
		PrintJob job = new PrintJob();
		for (int i = 0; i < jobs.length; i++) {
			if (jobs[i].getId() == printJobId) {
				job.setDescription(description);
				job.setCopies(copies);
				job.setQuality(quality);
			}
		}

		return job;
	}

	public static PrintJob[] getPrintJobsByUser(String userName) {

		User user = UserService.getUser(userName);
		PrintJob[] printJobDB = DataPrintJobs.getInstance().getPrintJobDB();
		int index = 0;
		int counter = 0;
		String name = user.getName();
		for (int i = 0; i < printJobDB.length; i++) {
			if (printJobDB[i].getUser().getName().equals(name)) {
				counter++;
			}
		}
		PrintJob[] printJobUser = new PrintJob[counter];

		for (PrintJob job : printJobDB) {
			if (job.getUser().getName().equals(name)) {
				printJobUser[index] = job;
				index++;
			}

		}
		return printJobUser;
	}

}
