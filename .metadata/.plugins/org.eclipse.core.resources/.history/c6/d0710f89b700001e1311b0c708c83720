package com.kylemiles.mockdraftsjdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kylemiles.mockdraftsjdbc.dao.NeedsDao;
import com.kylemiles.mockdraftsjdbc.entity.Needs;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultNeedsService implements NeedsService {
	
	@Autowired
	private NeedsDao needsDao;
	
	
	public DefaultNeedsService(NeedsDao needsDao) {
		this.needsDao = needsDao;
	}

	@Override
	public List<Needs> getNeeds() {
		log.info("Service fetch Needs");
		
		List<Needs> needs = needsDao.getNeeds();
		return needs;
	}

}
