package com.te.crudoperation.service;

import java.util.List;

import com.te.crudoperation.dto.PlayerDto;
import com.te.crudoperation.dto.PlayerLoginDto;
import com.te.crudoperation.dto.PlayerRegisterDto;
import com.te.crudoperation.entity.Player;

public interface PlayerService {
	public PlayerRegisterDto register(PlayerRegisterDto registerdto);

	public PlayerRegisterDto login(PlayerLoginDto logindto);

	public Player getPlayerById(PlayerDto playerdto);

	public PlayerDto delete(PlayerDto playerdto);

	public List<Player> getAll();

	public PlayerRegisterDto update(PlayerRegisterDto update);

}
