package com.kylemiles.mockdraftsjdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.kylemiles.mockdraftsjdbc.entity.Draft;
import com.kylemiles.mockdraftsjdbc.entity.Pick;
import com.kylemiles.mockdraftsjdbc.entity.Round;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultDraftDao implements DraftDao {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<Draft> getDrafts() {
		log.info("Dao fetch Draft");
		
		String sql = "SELECT * FROM draft";
		
		return jdbcTemplate.query(sql, new RowMapper<>() {
			@Override
			public Draft mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				return Draft.builder()
						.draftPK(rs.getLong("draft_pk"))
						.round(Round.valueOf(rs.getString("round")))
						.pick(Pick.valueOf(rs.getString("pick")))
						.build();
			}
		});
	}

}
