package com.fet.xml2json.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultResponse {
	//根據toJson狀態、儲存狀態分 重新toJson、重新存。
	private boolean toJsonStatus;
	private boolean storeStatus;
	//執行階段
	//0 for do nothing
	//1 for get xml 
	//2 for tojson
	//3 for storeToDB
	//4 for success
	private int execStatus;
	
}
