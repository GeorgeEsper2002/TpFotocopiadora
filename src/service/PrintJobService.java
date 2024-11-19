package service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import models.PrintJob;
import models.User;
import persistence.DataBaseLogic;
import persistence.DataPrintJobs;
import persistence.DataUser;

public class PrintJobService {

	// Function to create a new printjob
	public static String createPrintJob(User user, String description, String copies, String quality) {

		int nmbrCopies = 0;
		Date entryDate;
		entryDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", new Locale("es", "AR"));
		String formatedDate = dateFormat.format(entryDate);

		try {
			if (copies.length() <= 3) {
				nmbrCopies = Integer.parseInt(copies);
			}
			if (description.isEmpty() || nmbrCopies <= 0) {
				return "Error campos erroneos";
			}

			if (!printJobExists(description)) {
				return "ERROR,Trabajo existente";
			}
			PrintJob job = new PrintJob();
			job.setDescription(description);
			job.setId(createId(job));
			job.setState("Pendiente");
			job.setHandler(DataUser.getAdmin());
			job.setEntryDate(formatedDate);
			job.setCopies(copies);
			job.setUser(user);
			job.setQuality(quality);
			DataBaseLogic.savePrintJob(job);
			return "Trabajo creado con exito";
		} catch (NumberFormatException e) {
			return "Debes ingresar un numero.";
		}
	}

	// Function to check if a printJob exists
	public static boolean printJobExists(String description) {
		PrintJob[] data = DataPrintJobs.getInstance().getPrintJobDB();

		for (PrintJob job : data) {
			if (job.getDescription().equals(description)) {
				return false;
			}
		}

		return true;
	}

	// Function to create an id
	public static int createId(PrintJob job) {
		PrintJob[] printJobDB = DataPrintJobs.getInstance().getPrintJobDB();
		int idGreater = 0;
		for (PrintJob job1 : printJobDB) {
			if (job1.getId() > idGreater) {
				idGreater = job1.getId();
			}
		}

		return idGreater + 1;
	}

	public static String[][] listPrintJob() {
		PrintJob[] printJobDB = DataPrintJobs.getInstance().getPrintJobDB();
		String[][] dataPrintJob = new String[printJobDB.length][10];
		for (int i = 0; i < printJobDB.length; i++) {
			dataPrintJob[i][0] = String.valueOf(printJobDB[i].getId());
			dataPrintJob[i][1] = printJobDB[i].getDescription();
			dataPrintJob[i][2] = String.valueOf(printJobDB[i].getCopies());
			dataPrintJob[i][3] = printJobDB[i].getState();
			dataPrintJob[i][4] = printJobDB[i].getQuality();
			dataPrintJob[i][5] = printJobDB[i].getEntryDate();
			dataPrintJob[i][6] = printJobDB[i].getFinishDate();
			dataPrintJob[i][7] = printJobDB[i].getDeliveryDate();
			dataPrintJob[i][8] = printJobDB[i].getUser().getName();
			dataPrintJob[i][9] = printJobDB[i].getHandler().getName();

		}
		return dataPrintJob;

	}

	public static String[][] listPrintJobsbyUser(String userName) {
		PrintJob[] printJobDB = DataBaseLogic.getPrintJobsByUser(userName);
		String[][] dataPrintJob = new String[printJobDB.length][11];
		for (int i = 0; i < printJobDB.length; i++) {
			dataPrintJob[i][0] = String.valueOf(printJobDB[i].getId());
			dataPrintJob[i][1] = printJobDB[i].getDescription();
			dataPrintJob[i][2] = String.valueOf(printJobDB[i].getCopies());
			dataPrintJob[i][3] = printJobDB[i].getState();
			dataPrintJob[i][4] = printJobDB[i].getQuality();
			dataPrintJob[i][5] = printJobDB[i].getEntryDate();
			dataPrintJob[i][6] = printJobDB[i].getFinishDate();
			dataPrintJob[i][7] = printJobDB[i].getDeliveryDate();
			dataPrintJob[i][8] = printJobDB[i].getUser().getName();
			dataPrintJob[i][9] = printJobDB[i].getHandler().getName();

		}
		return dataPrintJob;

	}

	public static PrintJob getJobById(int PrintJobId) {
		PrintJob[] printJobDB = DataPrintJobs.getInstance().getPrintJobDB();
		for (PrintJob job : printJobDB) {
			if (job.getId() == PrintJobId) {
				return job;
			}
		}

		return null;
	}

	public static void updatePrintJobState(int printJobId, String newState) {
		// TODO Auto-generated method stub
		PrintJob[] printJobDB = DataPrintJobs.getInstance().getPrintJobDB();
		
		Date fechaRecibo = new Date();
		SimpleDateFormat formatoFecha=new SimpleDateFormat("dd/MM/yyyy", new Locale("es", "AR"));
		String fechaFormateada = formatoFecha.format(fechaRecibo);
		for (PrintJob job : printJobDB) {
			if (job.getId() == printJobId) {
				job.setState(newState);
				if(newState.equals("Finalizado")) {
					job.setFinishDate(fechaFormateada);
				}
				else if(newState.equals("Entregado")) {
					job.setDeliveryDate(fechaFormateada);
				}
				DataBaseLogic.savePrintJob(job);
			}

		}
		
	
	}

	public static String[][] listPrintJobsByState(String selectedState) {
		PrintJob[] printJobDB = DataPrintJobs.getInstance().getPrintJobDB();
		int counter = 0;
		for (PrintJob job : printJobDB) {
			if (job.getState().equals(selectedState)) {
				counter++;
			}
		}
		String[][] filteredPrintJobs = new String[counter][11];
		int index = 0;
		for (int i = 0; i < printJobDB.length; i++) {
			if (printJobDB[i].getState().equals(selectedState)) {
				filteredPrintJobs[index][0] = String.valueOf(printJobDB[i].getId());
				filteredPrintJobs[index][1] = printJobDB[i].getDescription();
				filteredPrintJobs[index][2] = String.valueOf(printJobDB[i].getCopies());
				filteredPrintJobs[index][3] = printJobDB[i].getState();
				filteredPrintJobs[index][4] = printJobDB[i].getQuality();
				filteredPrintJobs[index][5] = printJobDB[i].getEntryDate();
				filteredPrintJobs[index][6] = printJobDB[i].getFinishDate();
				filteredPrintJobs[index][7] = printJobDB[i].getDeliveryDate();
				filteredPrintJobs[index][8] = printJobDB[i].getUser().getName();
				filteredPrintJobs[index][9] = printJobDB[i].getHandler().getName();
				index++;
			}
		}

		return filteredPrintJobs;
	}

}
