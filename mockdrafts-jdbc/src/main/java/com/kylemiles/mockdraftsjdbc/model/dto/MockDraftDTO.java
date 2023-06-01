package com.kylemiles.mockdraftsjdbc.model.dto;

import java.time.LocalDateTime;

import com.kylemiles.mockdraftsjdbc.model.entity.Pick;
import com.kylemiles.mockdraftsjdbc.model.entity.Round;
import com.kylemiles.mockdraftsjdbc.model.entity.TeamName;

import lombok.Builder;

@Builder
public record MockDraftDTO(
		
		Long id,
		LocalDateTime published,
		TeamName team,
		Round round,
		Pick pick,
		int rank
		
		) {

}
