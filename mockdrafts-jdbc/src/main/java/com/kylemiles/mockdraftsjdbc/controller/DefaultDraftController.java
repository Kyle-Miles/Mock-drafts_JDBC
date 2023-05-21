package com.kylemiles.mockdraftsjdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.kylemiles.mockdraftsjdbc.entity.Draft;
import com.kylemiles.mockdraftsjdbc.service.DraftService;
import com.kylemiles.mockdraftsjdbc.service.NeedsService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultDraftController implements DraftController {
	
	@Autowired
	private DraftService draftService;
	
	public DefaultDraftController(DraftService draftService) {
		this.draftService = draftService;
	}

	@Override
	public List<Draft> getDrafts() {
		log.info("Controller fetch Drafts");
		return draftService.getDrafts();
	}

}
