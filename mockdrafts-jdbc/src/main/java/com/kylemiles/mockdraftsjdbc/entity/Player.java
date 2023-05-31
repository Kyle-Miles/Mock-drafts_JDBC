package com.kylemiles.mockdraftsjdbc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Player {
	
	
	
	public Player(Long playerPK) {
		super();
		this.playerPK = playerPK;
	}
	
	public Player(int rank) {
		super();
		this.rank = rank;
	}

	private Long playerPK;
	private String playerName;
	private Position position;
	private String college;
	private int rank;
	private String year;
	

}
