package com.fet.xml2json.service;

//負責檔案讀寫，確認正確性
public interface IDataAccess {

	public Boolean isExist (String strInputPath);
	public Boolean canRead (String strInputPath);
	public Boolean isXml (String strInputPath);
	public Boolean canWrite(String strOutputPath);
	
	
}
