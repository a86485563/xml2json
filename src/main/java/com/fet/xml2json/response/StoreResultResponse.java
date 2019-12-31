package com.fet.xml2json.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreResultResponse {
	private String execXml;
	private String toJsonStatus;
	private String storeStatus;
	//根據toJson狀態、儲存狀態分 重新toJson、重新存。
	private String execStatus;
	
}
