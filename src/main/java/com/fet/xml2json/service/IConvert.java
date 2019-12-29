package com.fet.xml2json.service;

import java.io.IOException;

//負責做資料格式轉換
public interface IConvert {
	//"裡可以有' '但不能有'\n'
	public Boolean checkXmlFormat (String strInputPath);
	public void convert2Json(String xmlImput,String jsonOutput);
	public Boolean checkJsonFormat (String strInputPath);
	public String readXmlToString (String strXmlPath) throws IOException;
}
