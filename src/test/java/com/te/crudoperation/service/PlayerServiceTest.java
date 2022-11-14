package com.te.crudoperation.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.te.crudoperation.dao.PlayerRepo;
import com.te.crudoperation.dto.PlayerDto;
import com.te.crudoperation.dto.PlayerLoginDto;
import com.te.crudoperation.dto.PlayerRegisterDto;

@RunWith(SpringRunner.class)

@SpringBootTest(classes = PlayerServiceImpl.class)
@ContextConfiguration
class PlayerServiceTest {

	@Mock
	private PlayerService service;
	@MockBean
	private PlayerRepo repo;

	PlayerRegisterDto dto1;

	ModelMapper mapper = new ModelMapper();

	@Test
	public void testRegister() {
		dto1 = new PlayerRegisterDto("AC001", "rahul", "India", "0010");
		PlayerRegisterDto dto2 = new PlayerRegisterDto("AC001", "rahul", "India", "0010");

		when(service.register(dto1)).thenReturn(dto2);
		assertEquals(dto1, dto2);

	}

	@Test
	public void testLogin() {

		PlayerRegisterDto dto4 = new PlayerRegisterDto("ABC001", "Kahul", "India", "0010");
		PlayerLoginDto dto3 = new PlayerLoginDto("ABC001", "0010");

		when(service.login(dto3)).thenReturn(dto4);
		assertEquals(dto3.getPlayerId(), service.login(dto3).getPlayerId());
	}

	@Test
	public void testdelete() {
		String playerId = "ABC005";
		PlayerDto dto = new PlayerDto(playerId);
		PlayerRegisterDto dto5 = new PlayerRegisterDto("ABC005", "Southee", "New Zealand", "0010");

		when(service.delete(dto)).thenReturn(dto);
		assertEquals("ABC005", service.delete(dto));

	}

}

/*
 * @Test public void testGetOne() { PlayerDto dto = new PlayerDto("ABC006");
 * PlayerDto dto2 = new PlayerDto("ABC0045"); Player map = mapper.map(dto2,
 * Player.class); Player map2 = mapper.map(map, Player.class);
 * when(repo.findById(map)).thenReturn(map);
 * 
 * Player map = mapper.map(dto, Player.class); Player map2 = mapper.map(dto2,
 * Player.class); when(repo.save(map)).thenReturn(map); assertEquals(map,
 * repo.save(map)); }
 */
