package com.kylemiles.mockdraftsjdbc.entity;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TeamNeeds {
	
	private Team team;
	private Needs needs;

}