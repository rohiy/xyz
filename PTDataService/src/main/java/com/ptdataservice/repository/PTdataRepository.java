package com.ptdataservice.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ptdataservice.model.PTData;

@Repository
public class PTdataRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional(readOnly = true)
	public List<PTData> findAll() {
		return jdbcTemplate.query("select * from ptp_get_kit_headerdata", new UserRowMapper());

	}

	@Transactional(readOnly = true)
	public PTData findUserById(int id) {
		return jdbcTemplate.queryForObject("select * from ptp_get_kit_headerdata where id=?", new Object[] { id }, new UserRowMapper());
	}

}

class UserRowMapper implements RowMapper<PTData>

{

	@Override
	public PTData mapRow(ResultSet rs, int rowNum) throws SQLException {
		PTData user = new PTData();
		user.setId(rs.getInt("id"));
		user.setName(rs.getString("name"));
		user.setEmail(rs.getString("email"));
		return user;

	}

}
