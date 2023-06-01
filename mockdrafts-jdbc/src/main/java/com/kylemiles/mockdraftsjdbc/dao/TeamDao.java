package com.kylemiles.mockdraftsjdbc.dao;

import java.util.List;

import com.kylemiles.mockdraftsjdbc.model.entity.Team;
import com.kylemiles.mockdraftsjdbc.model.entity.TeamNeeds;

public interface TeamDao {

	List<TeamNeeds> getTeamNeeds();

	List<Team> getAllTeams();

}
