package persistence;

import models.PrintJob;
import models.User;

public class DataPrintJobs {

	private static DataPrintJobs instance;
	private PrintJob[] printJobDB;
	private User admin;
	private User user;

	private DataPrintJobs() {

		String userName = "user1";
		user = DataUser.getLoggedUser(userName);
		admin = DataUser.getInstance().getAdmin();
		printJobDB = new PrintJob[20];
		printJobDB[0] = new PrintJob(1, "Calculo I", "22", "estado", "byn", "10/10/24", "12/10/24", "15/10/24", user,
				admin);

	}

	// SINGLETON
	public static DataPrintJobs getInstance() {
		if (instance == null) {
			instance = new DataPrintJobs();

		}
		return instance;
	}

	public PrintJob[] getPrintJobDB() {
		int counter = 0;
		for (PrintJob printJob : printJobDB) {
			if (printJob != null) {
				counter++;
			}
		}
		PrintJob[] allJobs = new PrintJob[counter];
		int index = 0;
		for (PrintJob printJob : printJobDB) {
			if (printJob != null) {
				allJobs[index] = printJob;
				index++;
			}
		}

		return allJobs;
	}

	public void setPrintJobDB(PrintJob[] printJobDB) {
		this.printJobDB = printJobDB;
	}

}
