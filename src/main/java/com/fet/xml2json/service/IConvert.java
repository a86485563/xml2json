package com.fet.xml2json.service;

import java.io.IOException;

import org.json.JSONException;

//負責做資料格式轉換
public interface IConvert {
	//"裡可以有' '但不能有'\n'
	public Boolean checkXmlFormat (String xsdPath, String xmlPath);
	public String convert2Json(String xmlImput);
	//public String readXmlToString (String strXmlPath) throws IOException;
}
