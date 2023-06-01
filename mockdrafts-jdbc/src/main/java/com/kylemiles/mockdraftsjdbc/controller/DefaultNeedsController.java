package com.kylemiles.mockdraftsjdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.kylemiles.mockdraftsjdbc.model.entity.Needs;
import com.kylemiles.mockdraftsjdbc.service.NeedsService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultNeedsController implements NeedsController {
	
	@Autowired
	private NeedsService needsService;
	
	public DefaultNeedsController(NeedsService needsService) {
		this.needsService = needsService;
	}

	@Override
	public List<Needs> getNeeds() {
		log.info("Controller fetch Needs");
		return needsService.getNeeds();
	}

}
