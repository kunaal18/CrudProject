package com.te.crudoperation.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.te.crudoperation.dto.PlayerRegisterDto;
import com.te.crudoperation.entity.Player;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class PlayerRepoTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}

	@Mock
	private PlayerRepo dao;

	@Autowired
	private ModelMapper mapper;

	@Test
	void registerTest() {
		PlayerRegisterDto dto = new PlayerRegisterDto("ABC12", "Kunal", "kun@khs.com", "1212");
		Player player = mapper.map(dto, Player.class);
		when(dao.save(player)).thenReturn(player);
		assertEquals(player, dao.save(player));
	}

}
