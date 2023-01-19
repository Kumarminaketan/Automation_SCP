package util;

import java.io.File;

public class Latest_Modified_file {

	public File filepath() {
		
	
		File dir = new File("C:\\Users\\FQ495BQ\\OneDrive - EY\\Documents\\Automation docs\\Working project\\SCP_QA\\configuration");



		File[] files = dir.listFiles();
		if (files == null || files.length == 0) {



		}



		File lastModifiedFile = files[0];
		for (int i = 1; i < files.length; i++) {
		if (lastModifiedFile.lastModified() < files[i].lastModified()) {
		lastModifiedFile = files[i];
		}
		}
		System.out.println(lastModifiedFile);
		return lastModifiedFile;
		

	}

}
