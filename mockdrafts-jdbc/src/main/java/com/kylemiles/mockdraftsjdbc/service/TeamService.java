package com.kylemiles.mockdraftsjdbc.service;

import java.util.List;

import com.kylemiles.mockdraftsjdbc.model.entity.Team;
import com.kylemiles.mockdraftsjdbc.model.entity.TeamNeeds;

public interface TeamService {

	List<TeamNeeds> getTeamNeeds();

	List<Team> getAllTeams();

}
