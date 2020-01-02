package com.fet.xml2json.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fet.xml2json.model.DataModel;
import com.fet.xml2json.model.ResultResponse;
import com.fet.xml2json.service.IConvert;
import com.fet.xml2json.service.IDataAccess;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;
@RestController
public class ConvertController {

	/** Logger. */
	private Logger logger = LogManager.getLogger(this.getClass().getName());
	
	@Autowired
	private IConvert convert;
	
	@Autowired
	private IDataAccess dataAccess;
	
	@CrossOrigin
	@PostMapping(value = "/v1/getxmltoaem",produces = "application/json")
	public ResultResponse getXmlToAem() throws IOException {
		ResultResponse response = new ResultResponse();
		response.setExecStatus(0);
		DataModel myData = new DataModel();
		//檢查取得xml是否順利
		logger.info("****** start to get xml ******");
		response.setExecStatus(1);
		String strXml = dataAccess.readXmlToString("D:\\gitHub\\XmlConvert2Json\\xml\\test1.xml");
		if(strXml!="") {
			myData.setXml(strXml);
			logger.info("****** get xml success ******");
		}
		else
		{
			logger.info("****** get xml fail ******");
			return response;
		}
		response.setExecStatus(2);
		logger.info("****** start to convert2Json ******");
		String strJson = convert.convert2Json(myData.getXml());
		if(strJson != "") 
		{
			myData.setJson(strJson);
			logger.info("****** convert2Json success ******");
			response.setToJsonStatus(true);
		}
		else 
		{
			logger.info("****** convert2Json fail ******");
			response.setToJsonStatus(false);
			return response;
		}
		response.setExecStatus(3);
		if (dataAccess.storeToDB(myData.getJson())) 
		{
			logger.info("****** storeToDB success ******");
			response.setStoreStatus(true);
		}
		else {
			logger.info("****** storeToDB fail ******");
			response.setStoreStatus(false);
			return response;
		}
		response.setExecStatus(4);
		logger.info("****** complete  getXmlToAem ******");
		
		return response;
	
	}
}
