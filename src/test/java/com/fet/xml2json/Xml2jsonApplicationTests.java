package com.fet.xml2json;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fet.xml2json.service.IConvert;

@SpringBootTest
class Xml2jsonApplicationTests {
	private Logger logger = LogManager.getLogger(this.getClass().getName());
	@Autowired
	IConvert convert;
/*
	@Test
	public void testReadXmlToString() {
		String result = "";

		try {
			result = convert.readXmlToString("D:\\gitHub\\XmlConvert2Json\\xml\\test1.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			result = e.toString();
		}
		
		System.out.println(result);
	}

	
	@Test
	public void convert2Json() {
		try {
			convert.convert2Json(convert.readXmlToString("D:\\gitHub\\XmlConvert2Json\\xml\\test1.xml"));
		} catch (IOException e) {
			logger.debug(e.toString());
		}
		catch (JSONException e) {
			logger.debug(e.toString());
		}
	}
	*/
	@Test
	public void vaildXml() {
		logger.debug("***** In vaildXml ****");
		
		
		Boolean result = convert.checkXmlFormat("D:\\gitHub\\XmlConvert2Json\\xml\\xsd\\handset_fix.xsd", "D:\\gitHub\\XmlConvert2Json\\xml\\test1.xml");
		logger.debug("***** check result****"+result);
	}

}
