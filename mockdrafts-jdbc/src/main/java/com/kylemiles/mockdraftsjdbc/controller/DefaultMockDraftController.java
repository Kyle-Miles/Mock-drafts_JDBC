package com.kylemiles.mockdraftsjdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.kylemiles.mockdraftsjdbc.model.dto.MockDraftDTO;
import com.kylemiles.mockdraftsjdbc.model.dto.MockDraftDTOById;
import com.kylemiles.mockdraftsjdbc.model.entity.MockDraft;
import com.kylemiles.mockdraftsjdbc.model.entity.Pick;
import com.kylemiles.mockdraftsjdbc.model.entity.Round;
import com.kylemiles.mockdraftsjdbc.model.entity.TeamName;
import com.kylemiles.mockdraftsjdbc.service.MockDraftService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultMockDraftController implements MockDraftController {
	
	@Autowired
	private MockDraftService draftService;
	
	public DefaultMockDraftController(MockDraftService draftService) {
		this.draftService = draftService;
	}

	@Override
	public List<MockDraft> getMockDrafts() {
		log.info("Controller fetch Mock Drafts");
		return draftService.getMockDrafts();
	}

	@Override
	public MockDraftDTOById createMockDraft(Long teamId, Long draftId, Long playerId) {
		log.info("Controller create Mock Draft");
		return draftService.createMockDraft(teamId, draftId, playerId);
	}

	@Override
	public MockDraftDTO altCreateMockDraft(TeamName team, Round round, Pick pick, int rank) {
		log.info("Controller create Mock Draft");
		return draftService.altCreateMockDraft(team, round, pick, rank);
	}

	@Override
	public MockDraftDTO updateMockDraft(Long id, TeamName team, Round round, Pick pick, int rank) {
		log.info("Controller update Mock Draft");
		return draftService.updateMockDraft(id, team, round, pick, rank);
	}

	@Override
	public List<MockDraft> getMockDraftsByTeamName(TeamName team) {
		log.info("Controller fetch Mock Drafts");
		return draftService.getMockDraftsByTeamName(team);
	}

	@Override
	public List<MockDraft> getMockDraftsByRoundAndPick(Round round, Pick pick) {
		log.info("Controller fetch Mock Drafts");
		return draftService.getMockDraftsByRoundAndPick(round, pick);
	}

	@Override
	public List<MockDraft> getMockDraftsByRound(Round round) {
		log.info("Controller fetch Mock Drafts");
		return draftService.getMockDraftByRound(round);
	}

}
