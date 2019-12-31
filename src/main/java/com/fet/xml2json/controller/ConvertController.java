package com.fet.xml2json.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fet.xml2json.response.StoreResultResponse;
import com.fet.xml2json.service.IConvert;

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
	
	@CrossOrigin
	@PostMapping(value = "/v1/getxmltoaem")
	public StoreResultResponse convert() {
		StoreResultResponse response = new StoreResultResponse();
		try {
			convert.convert2Json(convert.readXmlToString("D:\\gitHub\\XmlConvert2Json\\xml\\test1.xml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}
}
