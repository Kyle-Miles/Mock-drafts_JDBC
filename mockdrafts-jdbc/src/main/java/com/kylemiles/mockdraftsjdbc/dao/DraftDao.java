package com.kylemiles.mockdraftsjdbc.dao;

import java.util.List;

import com.kylemiles.mockdraftsjdbc.model.entity.Draft;

public interface DraftDao {

	List<Draft> getDrafts();

}
