package com.te.crudoperation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDto {
	private boolean error;
	private String msg;
	private Object obj;
}
