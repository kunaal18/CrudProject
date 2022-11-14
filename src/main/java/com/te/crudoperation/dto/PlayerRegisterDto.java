package com.te.crudoperation.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerRegisterDto {
	@NotNull(message = "Player id must not be null")

	private String playerId;
	@NotEmpty
	private String playerName;
	@NotBlank
	private String playerCountry;
	@Min(4)
	@Max(10)
	private String playerPassword;
}
