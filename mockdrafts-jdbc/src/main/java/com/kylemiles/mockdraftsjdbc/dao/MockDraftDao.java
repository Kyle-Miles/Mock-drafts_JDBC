package com.kylemiles.mockdraftsjdbc.dao;

import java.util.List;

import com.kylemiles.mockdraftsjdbc.model.dto.MockDraftDTO;
import com.kylemiles.mockdraftsjdbc.model.dto.MockDraftDTOById;
import com.kylemiles.mockdraftsjdbc.model.entity.MockDraft;
import com.kylemiles.mockdraftsjdbc.model.entity.Pick;
import com.kylemiles.mockdraftsjdbc.model.entity.Round;
import com.kylemiles.mockdraftsjdbc.model.entity.TeamName;

public interface MockDraftDao {

	List<MockDraft> getMockDrafts();
	
	MockDraftDTOById createMockDraft(Long teamId, Long draftId, Long playerId);
	
	MockDraftDTO altCreateMockDraft(TeamName team, Round round, Pick pick, int rank);

	MockDraftDTO updateMockDraft(Long id, TeamName team, Round round, Pick pick, int rank);

	List<MockDraft> getMockDraftByTeamName(TeamName team);

	List<MockDraft> getMockDraftByRoundAndPick(Round round, Pick pick);

	List<MockDraft> getMockDraftByRound(Round round);

}
