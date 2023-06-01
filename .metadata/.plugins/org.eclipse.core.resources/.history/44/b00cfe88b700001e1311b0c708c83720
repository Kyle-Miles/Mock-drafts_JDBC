package com.kylemiles.mockdraftsjdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kylemiles.mockdraftsjdbc.dao.DraftDao;
import com.kylemiles.mockdraftsjdbc.entity.Draft;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultDraftService implements DraftService {
	
	@Autowired
	private DraftDao draftDao;
	
	
	public DefaultDraftService(DraftDao draftDao) {
		this.draftDao = draftDao;
	}

	@Override
	public List<Draft> getDrafts() {
		log.info("Service fetch Draft");
		
		List<Draft> drafts = draftDao.getDrafts();
		return drafts;
	}

}
