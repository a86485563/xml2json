package com.fet.xml2json;



import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fet.xml2json.service.IConvert;

@SpringBootTest
class Xml2jsonApplicationTests {
	private Logger logger = LogManager.getLogger(this.getClass().getName());
	@Autowired
	IConvert convert;
	
	@Test
	public void testReadXmlToString() {
		String result = "";
				
		try {
			result = convert.readXmlToString("D:\\git\\gitHub\\xml\\test1.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
		result = e.toString();
		}
		System.out.println(result);
	}

}
