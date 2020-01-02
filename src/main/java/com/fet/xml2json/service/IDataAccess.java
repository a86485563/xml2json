package com.fet.xml2json.service;

import java.io.IOException;

//負責檔案讀寫，確認正確性
public interface IDataAccess {

	public Boolean isExist (String strInputPath);
	public Boolean canRead (String strInputPath);
	public Boolean canWrite(String strOutputPath);	
	
	
	/**
	 * call AEM api to store in AEM system
	 * @param jsonString
	 * @return store Result
	 */
	public Boolean storeToDB(String jsonString);
	
	/**
	 * call DimApi to get xml
	 * @param strXmlPath path for xml
	 * @return store Result
	 */
	public String readXmlToString (String strXmlPath) ;
}
