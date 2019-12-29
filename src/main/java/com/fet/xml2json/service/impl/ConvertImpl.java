package com.fet.xml2json.service.impl;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import com.fet.xml2json.service.IConvert;

@Service
public class ConvertImpl implements IConvert {

	@Override
	public Boolean checkXmlFormat(String strInputPath) {
		
		return null;
	}

	@Override
	public void convert2Json(String xmlImput,String jsonOutput) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean checkJsonFormat(String strInputPath) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String readXmlToString(String strXmlPath) throws IOException {
		return FileUtils.readFileToString(new File(strXmlPath), "UTF-8");
	}

	
}
