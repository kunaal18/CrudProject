package com.te.crudoperation.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.te.crudoperation.dao.PlayerRepo;
import com.te.crudoperation.dto.PlayerDto;
import com.te.crudoperation.dto.PlayerLoginDto;
import com.te.crudoperation.dto.PlayerRegisterDto;
import com.te.crudoperation.entity.Player;
import com.te.crudoperation.exception.MismatchIdFoundException;
import com.te.crudoperation.exception.ResourceNotFoundException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PlayerServiceImpl implements PlayerService {
	@Autowired
	private PlayerRepo repo;

	ModelMapper mapper = new ModelMapper();

	@Override
	public PlayerRegisterDto register(PlayerRegisterDto registerdto) {
		if (registerdto.getPlayerId().startsWith("ABC")) {
			if (registerdto.getPlayerPassword().length() > 3) {
				Player map = mapper.map(registerdto, Player.class);
				Player save = repo.save(map);
				log.info("Registered");
				return mapper.map(save, PlayerRegisterDto.class);
			} else {
				throw new MismatchIdFoundException(
						"Password Length be greater than 3 :" + registerdto.getPlayerPassword());

			}
		}
		throw new ResourceNotFoundException("Id must starts with ABC: " + registerdto.getPlayerId());

	}

	@Override
	public PlayerRegisterDto login(PlayerLoginDto logindto) {
		Player find = repo.findById(logindto.getPlayerId())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid playerId"));
		if (find.getPlayerPassword().equals(logindto.getPlayerPassword())) {
			return mapper.map(find, PlayerRegisterDto.class);
		} else {
			throw new ResourceNotFoundException("Invalid password " + logindto.getPlayerPassword());
		}
	}

	@Override
	public Player getPlayerById(PlayerDto playerdto) {
		Player findById = repo.findById(playerdto.getPlayerId())
				.orElseThrow(() -> new ResourceNotFoundException("Id not found " + playerdto.getPlayerId()));
		return findById;
	}

	@Override
	public PlayerDto delete(PlayerDto playerdto) {
		if (playerdto.getPlayerId().startsWith("ABC")) {
			Player find = repo.findById(playerdto.getPlayerId())
					.orElseThrow(() -> new ResourceNotFoundException("Player Id not found in DB"));
//orElseThrow present in Optional class
			PlayerDto map = mapper.map(find, PlayerDto.class);
			repo.delete(find);
			return map;
		} else
			throw new ResourceNotFoundException("Id did not start with ABC :" + playerdto.getPlayerId());

	}

	@Override
	public List<Player> getAll() {
		List<Player> list = (List<Player>) repo.findAll();

		return list;
	}

	@Override
	public PlayerRegisterDto update(PlayerRegisterDto update) {
		String id = update.getPlayerId();
		Player find = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Id not found :" + update.getPlayerId()));
		if (update.getPlayerPassword().length() > 3) {
			Player map = mapper.map(update, Player.class);
			Player save = repo.save(map);
			return mapper.map(save, PlayerRegisterDto.class);
		}
		throw new MismatchIdFoundException("Password length must be greater than 3" + update.getPlayerPassword());
	}

}
