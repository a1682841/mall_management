package com.mall.entry;

import lombok.Data;

@Data
public class ResponseDTO {

	private String messgae;

	public ResponseDTO() {
	}

	public ResponseDTO(String messgae) {
		this.messgae = messgae;
	}
}
