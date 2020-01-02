package com.fet.xml2json.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fet.xml2json.service.IConvert;

@Service
public class ConvertImpl implements IConvert {
	private Logger logger = LogManager.getLogger(this.getClass().getName());

	@Override
	public Boolean checkXmlFormat(String xsdPath, String xmlPath) {

		try {
			SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = factory.newSchema(new File(xsdPath));
			Validator validator = schema.newValidator();
			validator.validate(new StreamSource(new File(xmlPath)));
		} catch (IOException | SAXException e) {
			System.out.println("Exception: " + e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public String convert2Json(String xmlInput) {
		// Read the student.xml
		String result = "";
		// String data = FileUtils.readFileToString(new File(xmlImput), "UTF-8");
		logger.info("****** In  convert2Json  ******");

		JSONObject jObject = XML.toJSONObject(xmlInput);
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		Object json;
		try {
			json = mapper.readValue(jObject.toString(), Object.class);
		} catch (IOException e) {
			logger.info("****** " + e.toString() + " *******");
			return "";
		}
		try {
			result = mapper.writeValueAsString(json);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			logger.info("****** " + e.toString() + " *******");
			return "";
		}

		logger.info("****** result: " + result + " ******");
		return result;

	}

}
