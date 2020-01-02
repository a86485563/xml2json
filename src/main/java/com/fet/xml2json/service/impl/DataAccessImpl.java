package com.fet.xml2json.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.fet.xml2json.service.IDataAccess;

@Service
public class DataAccessImpl implements IDataAccess {

	private Logger logger = LogManager.getLogger(this.getClass().getName());

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
	public String readXmlToString(String strXmlPath) {
		logger.info("****** In readXmlToString ******");
		logger.info("****** strXmlPath: " + strXmlPath + " ******");
		try {
			String result = FileUtils.readFileToString(new File(strXmlPath), "UTF-8");
			logger.info("****** result: " + result + " ******");

			return result;
		} catch (IOException e) {
			logger.info("****** readXmlToString fail " + e.toString() + " ******");
			return "";
		}
		
	}
}
