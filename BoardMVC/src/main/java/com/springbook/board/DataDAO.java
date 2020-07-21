package com.springbook.board;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.zaxxer.hikari.HikariDataSource;

public class DataDAO {		
	private JdbcTemplate jt;

	public void setDataSource(HikariDataSource dataSource) {		
		this.jt = new JdbcTemplate(dataSource);
	}
	
	public void getData() {
		String sql = " SELECT * FROM t_board ";		
		jt.query(sql, new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {				
				while(rs.next()) {
					String title = rs.getNString("title");
					System.out.println("title : " + title);
				}				
				return null;
			}			
		});
	}
}
