package com.kylemiles.mockdraftsjdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.kylemiles.mockdraftsjdbc.model.entity.Team;
import com.kylemiles.mockdraftsjdbc.model.entity.TeamNeeds;
import com.kylemiles.mockdraftsjdbc.service.TeamService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultTeamController implements TeamController {
	
	@Autowired
	private TeamService teamService;
	
	public DefaultTeamController(TeamService teamService) {
		this.teamService = teamService;
	}

	@Override
	public List<TeamNeeds> getTeamNeeds() {
		log.info("Controller fetch Teams");
		return teamService.getTeamNeeds();
	}

	@Override
	public List<Team> getAllTeams() {
		log.info("Controller fetch Teams");
		return teamService.getAllTeams();
	}

}
