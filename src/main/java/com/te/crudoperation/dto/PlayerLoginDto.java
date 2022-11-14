package com.te.crudoperation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PlayerLoginDto {

	private String playerId;
	private String playerPassword;

}
