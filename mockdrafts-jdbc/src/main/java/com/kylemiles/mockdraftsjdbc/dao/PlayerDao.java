package com.kylemiles.mockdraftsjdbc.dao;

import java.util.List;

import com.kylemiles.mockdraftsjdbc.entity.Player;
import com.kylemiles.mockdraftsjdbc.entity.Position;

public interface PlayerDao {

	List<Player> getPlayers();

	Player createPlayer(String playerName, Position position, String college, int rank);

	Player updatePlayer(Player updatedPlayer);

	void deletePlayer(Long deleteId);

	Player altUpdatePlayer(Long id, String playerName, Position position, String college, int rank);

	Player getPlayerById(Long id);

}
