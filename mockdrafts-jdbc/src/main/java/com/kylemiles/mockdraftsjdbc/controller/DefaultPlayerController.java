package com.kylemiles.mockdraftsjdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.kylemiles.mockdraftsjdbc.entity.Player;
import com.kylemiles.mockdraftsjdbc.entity.Position;
import com.kylemiles.mockdraftsjdbc.service.PlayerService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultPlayerController implements PlayerController {
	
	@Autowired
	private PlayerService playerService;
	
	public DefaultPlayerController(PlayerService playerService) {
		this.playerService = playerService;
	}

	@Override
	public List<Player> getPlayers() {
		log.info("Controller fetch Players");
		return playerService.getPlayers();
	}

	@Override
	public Player createPlayer(String playerName, Position position, String college, int rank) {
		log.info("Controller create Players");
		return playerService.createPlayer(playerName, position, college, rank);
	}

	@Override
	public Player updatePlayer(Player updatedPlayer) {
		log.info("Controller update Players");
		return playerService.updatePlayer(updatedPlayer);
	}

	@Override
	public void deletePlayer(Long deleteId) {
		log.info("Controller delete Players");
		playerService.deletePlayer(deleteId);
		
	}

	@Override
	public Player altUpdatePlayer(Long id, String playerName, Position position, String college, int rank) {
		log.info("Controller update Players");
		return playerService.altUpdatePlayer(id, playerName, position, college, rank);
	}

	@Override
	public Player getPlayerById(Long id) {
		log.info("Controller fetch Players");
		return playerService.getPlayerById(id);
	}

}