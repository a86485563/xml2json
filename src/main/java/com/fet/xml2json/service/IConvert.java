package com.fet.xml2json.service;

//負責做資料格式轉換
public interface IConvert {
	//"裡可以有' '但不能有'\n'
	public Boolean checkXmlFormat (String strInputPath);
	public void convert2Json(String strInputPath,String strOutputPath);
	public Boolean checkJsonFormat (String strInputPath);
}
