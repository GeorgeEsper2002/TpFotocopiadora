package service;


import models.PrintJob;
import models.User;
import persistence.DataBaseLogic;
import persistence.DataPrintJobs;
import persistence.DataUser;


public class PrintJobService {

	// Function to create a new printjob
	public static String createPrintJob(User user, String description, String copies, String quality) {

		int nmbrCopies = 0;

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
			job.setState("Recibido");
			job.setHandler(DataUser.getAdmin());
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

	
	
	public static String[][] listPrintJob(){
		PrintJob[] printJobDB=DataPrintJobs.getInstance().getPrintJobDB();
		String[][] dataPrintJob=new String[printJobDB.length][10];
		for(int i = 0;i < printJobDB.length;i++) {
			dataPrintJob[i][0]=String.valueOf(printJobDB[i].getId());
			dataPrintJob[i][1]=printJobDB[i].getDescription();
			dataPrintJob[i][2]=String.valueOf(printJobDB[i].getCopies());
			dataPrintJob[i][3]=printJobDB[i].getState();
			dataPrintJob[i][4]=printJobDB[i].getQuality();
			dataPrintJob[i][5]=printJobDB[i].getEntryDate();
			dataPrintJob[i][6]=printJobDB[i].getFinishDate();
			dataPrintJob[i][7]=printJobDB[i].getDeliveryDate();
			dataPrintJob[i][8]=printJobDB[i].getUser().getName();
			dataPrintJob[i][9]=printJobDB[i].getHandler().getName();
			
		}
		return dataPrintJob;
		
		
		
	}
	
	public static String[][] listPrintJobsbyUser(String userName){
		PrintJob[] printJobDB=DataBaseLogic.getPrintJobsByUser(userName);
		String[][] dataPrintJob=new String[printJobDB.length][10];
		for(int i = 0;i < printJobDB.length;i++) {
			dataPrintJob[i][0]=String.valueOf(printJobDB[i].getId());
			dataPrintJob[i][1]=printJobDB[i].getDescription();
			dataPrintJob[i][2]=String.valueOf(printJobDB[i].getCopies());
			dataPrintJob[i][3]=printJobDB[i].getState();
			dataPrintJob[i][4]=printJobDB[i].getQuality();
			dataPrintJob[i][5]=printJobDB[i].getEntryDate();
			dataPrintJob[i][6]=printJobDB[i].getFinishDate();
			dataPrintJob[i][7]=printJobDB[i].getDeliveryDate();
			dataPrintJob[i][8]=printJobDB[i].getUser().getName();
			dataPrintJob[i][9]=printJobDB[i].getHandler().getName();
			
		}
		return dataPrintJob;
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
