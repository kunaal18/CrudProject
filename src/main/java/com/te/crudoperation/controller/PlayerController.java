package com.te.crudoperation.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.crudoperation.dto.PlayerDto;
import com.te.crudoperation.dto.PlayerLoginDto;
import com.te.crudoperation.dto.PlayerRegisterDto;
import com.te.crudoperation.dto.ResponseDto;
import com.te.crudoperation.entity.Player;
import com.te.crudoperation.service.PlayerService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class PlayerController {
	@Autowired
	private PlayerService service;

	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody @Valid PlayerRegisterDto registerdto) {
		if (service.register(registerdto) != null) {
			log.info("Register is done");
			return new ResponseEntity<>(new ResponseDto(false, "Registered Successfully", registerdto), HttpStatus.OK);
		} else {
			log.info("Something went wrong");
			return new ResponseEntity<>(new ResponseDto(true, "Something went Wrong", registerdto),
					HttpStatus.BAD_REQUEST);
		}

	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody PlayerLoginDto logindto) {
		if (logindto.getPlayerId().startsWith("ABC")) {
			PlayerRegisterDto login = service.login(logindto);
			boolean equals = login.getPlayerPassword().equals(logindto.getPlayerPassword());
			if (equals == true) {
				log.info("Login is done");

				return new ResponseEntity<>(new ResponseDto(false, "Login Successfully", login), HttpStatus.OK);
			}
		}
		log.info("Invalid Credentials for login");

		return new ResponseEntity<>(new ResponseDto(true, "Invalid Credentials", logindto), HttpStatus.BAD_REQUEST);

	}

	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(PlayerDto playerdto) {
		if (service.delete(playerdto) != null) {
			log.info("Deleted Successfully");

			return new ResponseEntity<>(new ResponseDto(false, "Deleted Successfully", null), HttpStatus.OK);
		}
		return new ResponseEntity<>(new ResponseDto(true, "Id not found ", null), HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/list")
	public List<Player> getAll() {
		List<Player> all = service.getAll();
		return all;
	}

	@PutMapping("/update")
	public ResponseEntity<?> update(PlayerRegisterDto updatedata) {

		if (service.update(updatedata) != null) {
			return new ResponseEntity<>(new ResponseDto(false, "Updated Successfully", updatedata), HttpStatus.OK);
		} else
			return new ResponseEntity<>(new ResponseDto(true, "id not found in DB", null), HttpStatus.BAD_GATEWAY);
	}

	@PostMapping("/getone")
	public ResponseEntity<?> getOne(PlayerDto getone) {
		if (service.getPlayerById(getone) != null) {// i'm giving whole data by giving only id it is not a good for real world
												// project
			return new ResponseEntity<>(new ResponseDto(false, "Success", service.getPlayerById(getone)), HttpStatus.OK);
		}
		return new ResponseEntity<>(new ResponseDto(true, "Id Not found", null), HttpStatus.BAD_REQUEST);
	}

}
