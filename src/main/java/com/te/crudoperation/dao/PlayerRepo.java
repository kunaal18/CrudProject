package com.te.crudoperation.dao;

import org.springframework.data.repository.CrudRepository;

import com.te.crudoperation.entity.Player;

public interface PlayerRepo extends CrudRepository<Player, String> {

	public Player findByPlayerId(String playerId);

}
