package com.te.crudoperation.entity;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
public class Player {

//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int Id;
//	private String playerId = "TYC00" + Id;
	@Id
	@NotNull(message = "Player id must not be null")
	private String playerId;

	private String playerName;

	private String playerCountry;

	private String playerPassword;
}
