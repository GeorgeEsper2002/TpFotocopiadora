package persistence;

import models.PrintJob;
import models.User;

public class DataPrintJobs {

	private static DataPrintJobs instance;
	private PrintJob[] printJobDB;

	private DataPrintJobs() {
		printJobDB = new PrintJob[20];
		printJobDB[0] = new PrintJob(1, "descripcion", 22, "estado", "byn", "10/10/24", "12/10/24", "15/10/24", null);

	}

	// SINGLETON
	public static DataPrintJobs getInstance() {
		if (instance == null) {
			instance = new DataPrintJobs();

		}
		return instance;
	}

	public PrintJob[] getPrintJobDB() {
		return printJobDB;
	}

	public void setPrintJobDB(PrintJob[] printJobDB) {
		this.printJobDB = printJobDB;
	}
	

}
