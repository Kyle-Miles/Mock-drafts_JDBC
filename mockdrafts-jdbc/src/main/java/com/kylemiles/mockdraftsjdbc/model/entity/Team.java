package com.kylemiles.mockdraftsjdbc.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Team {
	
	public Team(Long teamPK) {
		super();
		this.teamPK = teamPK;
	}
	
	public Team(TeamName teamname) {
		super();
		this.teamname = teamname;
	}

	private Long teamPK;
	private TeamName teamname;
	private Conference teamConference;
	private Division teamDivision;

}
