package com.kylemiles.mockdraftsjdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kylemiles.mockdraftsjdbc.dao.TeamDao;
import com.kylemiles.mockdraftsjdbc.model.entity.Team;
import com.kylemiles.mockdraftsjdbc.model.entity.TeamNeeds;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultTeamService implements TeamService {
	
	@Autowired
	private TeamDao teamDao;
	
	
	public DefaultTeamService(TeamDao teamDao) {
		this.teamDao = teamDao;
	}

	@Override
	public List<TeamNeeds> getTeamNeeds() {
		log.info("Service fetch Teams");
		
		List<TeamNeeds> teams = teamDao.getTeamNeeds();
		return teams;
	}

	@Override
	public List<Team> getAllTeams() {
		log.info("Service fetch Teams");
		
		List<Team> teams = teamDao.getAllTeams();
		return teams;
	}

}
