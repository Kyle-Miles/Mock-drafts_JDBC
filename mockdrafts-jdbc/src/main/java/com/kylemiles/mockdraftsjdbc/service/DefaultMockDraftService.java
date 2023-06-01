package com.kylemiles.mockdraftsjdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kylemiles.mockdraftsjdbc.dao.MockDraftDao;
import com.kylemiles.mockdraftsjdbc.model.dto.MockDraftDTO;
import com.kylemiles.mockdraftsjdbc.model.dto.MockDraftDTOById;
import com.kylemiles.mockdraftsjdbc.model.entity.MockDraft;
import com.kylemiles.mockdraftsjdbc.model.entity.Pick;
import com.kylemiles.mockdraftsjdbc.model.entity.Round;
import com.kylemiles.mockdraftsjdbc.model.entity.TeamName;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultMockDraftService implements MockDraftService {
	
	@Autowired
	private MockDraftDao draftDao;
	
	
	public DefaultMockDraftService(MockDraftDao draftDao) {
		this.draftDao = draftDao;
	}

	@Override
	public List<MockDraft> getMockDrafts() {
		log.info("Service fetch Mock Draft");
		
		List<MockDraft> drafts = draftDao.getMockDrafts();
		return drafts;
	}

	@Override
	public MockDraftDTOById createMockDraft(Long teamId, Long draftId, Long playerId) {
		log.info("Service create Mock Draft");
		
		MockDraftDTOById mockDraft = draftDao.createMockDraft(teamId, draftId, playerId);
		return mockDraft;
	}

	@Override
	public MockDraftDTO altCreateMockDraft(TeamName team, Round round, Pick pick, int rank) {
		log.info("Service create Mock Draft");
		
		MockDraftDTO mockDraft = draftDao.altCreateMockDraft(team, round, pick, rank);
		return mockDraft;
	}

	@Override
	public MockDraftDTO updateMockDraft(Long id, TeamName team, Round round, Pick pick, int rank) {
		log.info("Service create Mock Draft");
		
		MockDraftDTO mockDraft = draftDao.updateMockDraft(id, team, round, pick, rank);
		return mockDraft;
	}

	@Override
	public List<MockDraft> getMockDraftsByTeamName(TeamName team) {
		log.info("Service fetch Mock Draft");
		
		List<MockDraft> drafts = draftDao.getMockDraftByTeamName(team);
		return drafts;
	}

	@Override
	public List<MockDraft> getMockDraftsByRoundAndPick(Round round, Pick pick) {
		log.info("Service fetch Mock Draft");
		
		List<MockDraft> drafts = draftDao.getMockDraftByRoundAndPick(round, pick);
		return drafts;
	}

	@Override
	public List<MockDraft> getMockDraftByRound(Round round) {
		log.info("Service fetch Mock Draft");
		
		List<MockDraft> drafts = draftDao.getMockDraftByRound(round);
		return drafts;
	}

}
