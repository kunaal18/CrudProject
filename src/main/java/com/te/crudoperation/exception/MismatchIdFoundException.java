package com.te.crudoperation.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Getter
public class MismatchIdFoundException extends RuntimeException {
	private String msg;
}
