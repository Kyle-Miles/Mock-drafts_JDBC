package com.kylemiles.mockdraftsjdbc.dao;

import java.util.List;

import com.kylemiles.mockdraftsjdbc.entity.Team;
import com.kylemiles.mockdraftsjdbc.entity.TeamNeeds;

public interface TeamDao {

	List<TeamNeeds> getTeamNeeds();

	List<Team> getAllTeams();

}
