package com.kylemiles.mockdraftsjdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kylemiles.mockdraftsjdbc.dao.PlayerDao;
import com.kylemiles.mockdraftsjdbc.model.dto.PlayerDTO;
import com.kylemiles.mockdraftsjdbc.model.entity.Player;
import com.kylemiles.mockdraftsjdbc.model.entity.Position;
import com.kylemiles.mockdraftsjdbc.model.entity.Year;

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
	public PlayerDTO createPlayer(String playerName, Position position, String college, int rank, Year year) {
		log.info("Service create Players");
		
		PlayerDTO player = playerDao.createPlayer(playerName, position, college, rank, year);
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
	public PlayerDTO altUpdatePlayer(Long id, String playerName, Position position, String college, int rank, Year year) {
		log.info("Service update Players");
		
		PlayerDTO player = playerDao.altUpdatePlayer(id, playerName, position, college, rank, year);
		return player;
	}

	@Override
	public Player getPlayerById(Long id) {
		log.info("Service fetch Players");
		
		Player player = playerDao.getPlayerById(id);
		return player;
	}

	@Override
	public List<Player> getPlayersByPosition(Position position) {
		log.info("Service fetch Players");
		
		List<Player> players = playerDao.getPlayersByPosition(position);
		return players;
	}

	@Override
	public List<Player> getPlayersByName(String name) {
		log.info("Service fetch Players");
		
		List<Player> players = playerDao.getPlayersByName(name);
		return players;
	}

	@Override
	public List<Player> getPlayersByClassYear(Year year) {
		log.info("Service fetch Players");
		
		List<Player> players = playerDao.getPlayersByClassYear(year);
		return players;
	}

	@Override
	public void deletePlayerByClassYear(Year year) {
		log.info("Service delete Players");
		
		playerDao.deletePlayerByClassYear(year);
		
	}

}
