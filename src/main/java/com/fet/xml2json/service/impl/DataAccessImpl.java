package com.fet.xml2json.service.impl;

import java.io.File;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.fet.xml2json.service.IDataAccess;

@Service
public class DataAccessImpl implements IDataAccess {

	@Override
	public Boolean isExist(String strInputPath) {
	       // Get the file 
        File f = new File(strInputPath); 
  
        // Check if the specified file 
        // Exists or not 
       return f.exists();
	}

	@Override
	public Boolean canRead(String strInputPath) {
		 File f = new File(strInputPath); 
		  
	        // Check if the specified file 
	        // Can Read or not 
	       return f.canRead();
	}


	// send data to AEM DB 
	@Override
	public Boolean storeToDB(String jsonString) {
		Boolean result = false;
		Random rd = new Random();
		result = rd.nextBoolean();
		
		return result;
	}

	@Override
	public Boolean canWrite(String strOutputPath) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean getXml() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
