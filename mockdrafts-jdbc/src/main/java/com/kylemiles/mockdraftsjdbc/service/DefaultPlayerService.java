package com.kylemiles.mockdraftsjdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kylemiles.mockdraftsjdbc.dao.PlayerDao;
import com.kylemiles.mockdraftsjdbc.entity.Player;
import com.kylemiles.mockdraftsjdbc.entity.Position;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultPlayerService implements PlayerService {
	
	@Autowired
	private PlayerDao playerDao;
	
	
	public DefaultPlayerService(PlayerDao playerDao) {
		this.playerDao = playerDao;
	}

	@Override
	public List<Player> getPlayers() {

		log.info("Service fetch Players");
		
		List<Player> players = playerDao.getPlayers();
		return players;
	}

	@Override
	public Player createPlayer(String playerName, Position position, String college, int rank) {
		log.info("Service create Players");
		
		Player player = playerDao.createPlayer(playerName, position, college, rank);
		return player;
	}

	@Override
	public Player updatePlayer(Player updatedPlayer) {
		log.info("Service update Players");
		
		Player player = playerDao.updatePlayer(updatedPlayer);
		return player;
	}

	@Override
	public void deletePlayer(Long deleteId) {
		log.info("Service delete Players");
		
		playerDao.deletePlayer(deleteId);
		
	}

	@Override
	public Player altUpdatePlayer(Long id, String playerName, Position position, String college, int rank) {
		log.info("Service update Players");
		
		Player player = playerDao.altUpdatePlayer(id, playerName, position, college, rank);
		return player;
	}

	@Override
	public Player getPlayerById(Long id) {
		log.info("Service fetch Players");
		
		Player player = playerDao.getPlayerById(id);
		return player;
	}

}
