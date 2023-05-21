package com.kylemiles.mockdraftsjdbc.dao;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.kylemiles.mockdraftsjdbc.dao.DefaultPlayerDao.SqlParams;
import com.kylemiles.mockdraftsjdbc.dto.MockDraftDTO;
import com.kylemiles.mockdraftsjdbc.dto.MockDraftDTOById;
import com.kylemiles.mockdraftsjdbc.entity.Conference;
import com.kylemiles.mockdraftsjdbc.entity.Division;
import com.kylemiles.mockdraftsjdbc.entity.Draft;
import com.kylemiles.mockdraftsjdbc.entity.MockDraft;
import com.kylemiles.mockdraftsjdbc.entity.Needs;
import com.kylemiles.mockdraftsjdbc.entity.Pick;
import com.kylemiles.mockdraftsjdbc.entity.Player;
import com.kylemiles.mockdraftsjdbc.entity.Position;
import com.kylemiles.mockdraftsjdbc.entity.Rank;
import com.kylemiles.mockdraftsjdbc.entity.Round;
import com.kylemiles.mockdraftsjdbc.entity.Team;
import com.kylemiles.mockdraftsjdbc.entity.TeamName;
import com.kylemiles.mockdraftsjdbc.entity.TeamNeeds;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultMockDraftDao implements MockDraftDao {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	private DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	@Override
	public List<MockDraft> getMockDrafts() {
		log.info("Dao fetch Mock Draft");
		
		String sql = "SELECT * FROM mock_draft "
				+ "INNER JOIN team "
				+ "ON mock_draft.team_pk = team.team_pk "
				+ "INNER JOIN draft "
				+ "ON mock_draft.draft_pk = draft.draft_pk "
				+ "INNER JOIN player "
				+ "ON mock_draft.player_pk = player.player_pk";
		
		return jdbcTemplate.query(sql, new RowMapper<>() {
			@Override
			public MockDraft mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				
				return MockDraft.builder()
						.mockDraftPK(rs.getLong("mock_draft_pk"))
						.published(LocalDateTime.parse(rs.getString("published"), format))
						.team(Team.builder()
								.teamPK(rs.getLong("team_pk"))
								.teamname(TeamName.valueOf(rs.getString("team_name")))
								.teamConference(Conference.valueOf(rs.getString("team_conference")))
								.teamDivision(Division.valueOf(rs.getString("team_division")))
								.build())
						.draft(Draft.builder()
								.draftPK(rs.getLong("draft_pk"))
								.round(Round.valueOf(rs.getString("round")))
								.pick(Pick.valueOf(rs.getString("pick")))
								.build())
						.player(Player.builder()
								.playerPK(rs.getLong("player_pk"))
								.playerName(rs.getString("player_name"))
								.position(Position.valueOf(rs.getString("position")))
								.college(rs.getString("college"))
								.rank(rs.getInt("ovr_rank"))
								.build())
						.build();
			}
		});
	}

	@Override
	public MockDraftDTOById createMockDraft(Long teamId, Long draftId, Long playerId) {
		log.info("Dao create Mock Draft");
		
		SqlParams sqlParams = new SqlParams();
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		sqlParams.sql = "INSERT INTO mock_draft "
				+ "(team_pk, "
				+ "draft_pk, "
				+ "player_pk) "
				+ "VALUES (:team_pk, :draft_pk , :player_pk) ";
		
		sqlParams.source.addValue("team_pk", teamId);
		sqlParams.source.addValue("draft_pk", draftId);
		sqlParams.source.addValue("player_pk", playerId);
		
		jdbcTemplate.update(sqlParams.sql, sqlParams.source, keyHolder); {
			
			return MockDraftDTOById.builder()
					.id(keyHolder.getKey().longValue())
					.published(LocalDateTime.now())
					.teamId(teamId)
					.draftId(draftId)
					.playerId(playerId)
					.build();
		
		}
	}
	
	class SqlParams {
		String sql;
		MapSqlParameterSource source = new MapSqlParameterSource();
	}
	
	@Override
	public MockDraftDTO altCreateMockDraft(TeamName team, Round round, Pick pick, int rank) {
		log.info("Dao create Mock Draft");
		
		SqlParams sqlParams = new SqlParams();
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		sqlParams.sql = "INSERT INTO mock_draft "
				+ "(team_pk, draft_pk, player_pk) "
				+ "SELECT t.team_pk, d.draft_pk, p.player_pk "
				+ "FROM team t "
				+ "JOIN draft d ON d.round = :{round} AND d.pick = :pick "
				+ "JOIN player p ON p.ovr_rank = :ovr_rank "
				+ "WHERE  t.team_name = :team_name";
		
		sqlParams.source.addValue("team_name", team.toString());
		sqlParams.source.addValue("round", round.toString());
		sqlParams.source.addValue("pick", pick.toString());
		sqlParams.source.addValue("ovr_rank", rank);
		
	
		jdbcTemplate.update(sqlParams.sql, sqlParams.source, keyHolder); {
			
			return MockDraftDTO.builder()
					.id(keyHolder.getKey().longValue())
					.published(LocalDateTime.now())
					.team(team)
					.round(round)
					.pick(pick)
					.rank(rank)
					.build();
		
		}
	}

}