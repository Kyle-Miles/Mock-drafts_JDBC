package com.kylemiles.mockdraftsjdbc.model.dto;

import java.time.LocalDateTime;

import lombok.Builder;

@Builder
public record MockDraftDTOById(
		
		Long id,
		LocalDateTime published,
		Long teamId,
		Long draftId,
		Long playerId
		
		) {

}
