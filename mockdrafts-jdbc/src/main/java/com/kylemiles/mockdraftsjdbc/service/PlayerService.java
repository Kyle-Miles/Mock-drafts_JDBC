package com.kylemiles.mockdraftsjdbc.service;

import java.util.List;

import com.kylemiles.mockdraftsjdbc.entity.Player;
import com.kylemiles.mockdraftsjdbc.entity.Position;

public interface PlayerService {
	
	List<Player> getPlayers();
	
	Player createPlayer(String playerName, Position position, String college, int rank);

	Player updatePlayer(Player updatedPlayer);

	void deletePlayer(Long deleteId);
	
	Player altUpdatePlayer(Long id, String playerName, Position position, String college, int rank);

	Player getPlayerById(Long id);

	List<Player> getPlayersByPosition(Position position);

}
