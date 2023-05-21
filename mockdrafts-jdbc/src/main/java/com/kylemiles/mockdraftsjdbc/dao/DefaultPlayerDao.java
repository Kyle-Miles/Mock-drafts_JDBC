package com.kylemiles.mockdraftsjdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.kylemiles.mockdraftsjdbc.entity.Player;
import com.kylemiles.mockdraftsjdbc.entity.Position;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultPlayerDao implements PlayerDao {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<Player> getPlayers() {

		log.info("Dao fetch Players");
		
		String sql = "SELECT * FROM player";
		
		
		return jdbcTemplate.query(sql, new RowMapper<>() {
			@Override
			public Player mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				return Player.builder()
						.playerPK(rs.getLong("player_pk"))
						.playerName(rs.getString("player_name"))
						.position(Position.valueOf(rs.getString("position")))
						.college(rs.getString("college"))
						.rank(rs.getInt("ovr_rank"))
						.build();
			}      
		});
	}

	@Override
	public Player createPlayer(String playerName, Position position, String college, int rank) {
		log.info("Dao create Players");
		
		SqlParams sqlParams = new SqlParams();
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		sqlParams.sql = "INSERT INTO player "
				+ "(player_name, "
				+ "position, "
				+ "college, "
				+ "ovr_rank) "
				+ "VALUES (:player_name, :position, :college, :ovr_rank)";
		
		sqlParams.source.addValue("player_name", playerName);
		sqlParams.source.addValue("position", position.toString());
		sqlParams.source.addValue("college", college);
		sqlParams.source.addValue("ovr_rank", rank);
			
		jdbcTemplate.update(sqlParams.sql, sqlParams.source, keyHolder); {
			
				
		return Player.builder()
				.playerPK(keyHolder.getKey().longValue())
				.playerName(playerName)
				.position(position)
				.college(college)
				.rank(rank)
				.build();
		}
	}
	
	class SqlParams {
		String sql;
		MapSqlParameterSource source = new MapSqlParameterSource();
	}

	@Override
	public Player updatePlayer(Player updatedPlayer) {
		log.info("Dao update Players");
		String sql = "UPDATE player "
				+ "SET "
				+ "player_name = :player_name, "
				+ "position = :position, "
				+ "college = :college, "
				+ "ovr_rank = :ovr_rank "
				+ "WHERE player_pk = :player_pk";
		
		Map <String, Object> params = new HashMap<>();
		params.put("player_name", updatedPlayer.getPlayerName());
		params.put("position", updatedPlayer.getPosition().toString());
		params.put("college", updatedPlayer.getCollege());
		params.put("ovr_rank", updatedPlayer.getRank());
		params.put("player_pk", updatedPlayer.getPlayerPK());
		
		if (jdbcTemplate.update(sql, params) == 0) {
			throw new NoSuchElementException("Update failed... player id: " + updatedPlayer.getPlayerPK() + " doesn't exist... ");
		}
		return Player.builder()
				.playerPK(updatedPlayer.getPlayerPK())
				.playerName(updatedPlayer.getPlayerName())
				.college(updatedPlayer.getCollege())
				.rank(updatedPlayer.getRank())
				.build();
	}

	@Override
	public void deletePlayer(Long deleteId) {
		log.info("Dao delete Players");
		
		String sql = "DELETE FROM player "
				+ "WHERE player_pk = :player_pk";
		
		Map <String, Object> params = new HashMap<>();
		
		params.put("player_pk", deleteId);
		
		if (jdbcTemplate.update(sql, params) == 0) {
			throw new NoSuchElementException("Delete failed... player id: " + deleteId + " doesn't exist... ");
		} else {
			System.out.println("Player with id: " + deleteId + " was successfully deleted! ");
		}
		
	}
	
	@Override
	public Player altUpdatePlayer(Long id, String playerName, Position position, String college, int rank) {
		log.info("Dao update Players");
		
		String sql = "UPDATE player "
				+ "SET "
				+ "player_name = :player_name, "
				+ "position = :position, "
				+ "college = :college, "
				+ "ovr_rank = :ovr_rank "
				+ "WHERE player_pk = :player_pk";
		
		Map <String, Object> params = new HashMap<>();
		params.put("player_name", playerName);
		params.put("position", position.toString());
		params.put("college", college);
		params.put("ovr_rank", rank);
		params.put("player_pk", id);
		
		if (jdbcTemplate.update(sql, params) == 0) {
			throw new NoSuchElementException("Update failed... player id: " + id + " doesn't exist... ");
		}
		return Player.builder()
				.playerPK(id)
				.playerName(playerName)
				.college(college)
				.rank(rank)
				.build();
	}

	@Override
	public Player getPlayerById(Long id) {
		log.info("Dao fetch Players");
		
		String sql = "SELECT * FROM player "
				+ "WHERE player_pk = :player_pk";
		
		Map<String, Object> params = new HashMap<>();
		params.put("player_pk", id);
		
		return jdbcTemplate.query(sql, params, new PlayerResultSetExtractor());
	}
	
	public class PlayerResultSetExtractor implements ResultSetExtractor<Player> {

		@Override
		public Player extractData(ResultSet rs) throws SQLException, DataAccessException {
			rs.next();
			
			return Player.builder()
					.playerPK(rs.getLong("player_pk"))
					.playerName(rs.getString("player_name"))
					.position(Position.valueOf(rs.getString("position")))
					.college(rs.getString("college"))
					.rank(rs.getInt("ovr_rank"))
					.build();
		}
		
	}

}
