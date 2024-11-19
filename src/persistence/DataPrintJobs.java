package persistence;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import models.PrintJob;
import models.User;

public class DataPrintJobs {

	private static DataPrintJobs instance;
	private PrintJob[] printJobDB;
	private User admin;
	private User user;
	private Date fechaRecibo;
	private DataPrintJobs() {

		fechaRecibo=new Date();
		SimpleDateFormat formatoFecha=new SimpleDateFormat("dd/MM/yyyy", new Locale("es", "AR"));
		String fechaFormateada = formatoFecha.format(fechaRecibo);
		String userName = "user1";
		String userName1="user2";
		user = DataUser.getLoggedUser(userName);
		DataUser.getInstance();
		admin = DataUser.getAdmin();
		printJobDB = new PrintJob[20];
		printJobDB[0] = new PrintJob(1, "Calculo I", "22", "Recibido", "byn", fechaFormateada, "", "", user,
				admin);
		printJobDB[1]=new PrintJob(2, "Calculo II", "5", "Pendiente", "byn", fechaFormateada, "", "", user,
				admin);
		printJobDB[2]=new PrintJob(3, "Fisica I", "22", "Recibido", "byn", fechaFormateada, "", "",DataUser.getLoggedUser(userName1),
				admin);
		
		// { recibido,ejecución,terminado,entregado)}
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
