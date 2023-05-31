package com.kylemiles.mockdraftsjdbc.dao;

import java.util.List;

import com.kylemiles.mockdraftsjdbc.dto.PlayerDTO;
import com.kylemiles.mockdraftsjdbc.entity.Player;
import com.kylemiles.mockdraftsjdbc.entity.Position;
import com.kylemiles.mockdraftsjdbc.entity.Year;

public interface PlayerDao {

	List<Player> getPlayers();

	Player updatePlayer(Player updatedPlayer);

	void deletePlayer(Long deleteId);

	Player getPlayerById(Long id);

	List<Player> getPlayersByPosition(Position position);

	List<Player> getPlayersByName(String name);

	PlayerDTO createPlayer(String playerName, Position position, String college, int rank, Year year);

	PlayerDTO altUpdatePlayer(Long id, String playerName, Position position, String college, int rank, Year year);

	List<Player> getPlayersByClassYear(Year year);

}
