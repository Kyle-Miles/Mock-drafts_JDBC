package com.kylemiles.mockdraftsjdbc.model.dto;

import com.kylemiles.mockdraftsjdbc.model.entity.Position;
import com.kylemiles.mockdraftsjdbc.model.entity.Year;

import lombok.Builder;

@Builder
public record PlayerDTO(
		
		Long playerPK,
		String playerName,
		Position position,
		String college,
		int rank,
		Year year
		
		) {

}
