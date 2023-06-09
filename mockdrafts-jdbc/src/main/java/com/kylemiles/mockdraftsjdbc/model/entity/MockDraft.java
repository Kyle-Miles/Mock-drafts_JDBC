package com.kylemiles.mockdraftsjdbc.model.entity;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class MockDraft {
	
	private Long mockDraftPK;
	private LocalDateTime published;
	
	@Autowired
	private Team team;
	
	@Autowired
	private Draft draft;
	
	@Autowired
	private Player player;
	
	public MockDraft(Team team, Draft draft, Player player) {
		this.team = team;
		this.draft = draft;
		this.player = player;
		
	}
	

}
