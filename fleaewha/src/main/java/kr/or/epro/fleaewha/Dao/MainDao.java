package kr.or.epro.fleaewha.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.epro.fleaewha.Dto.MainDto;
import static kr.or.epro.fleaewha.Dao.MainDaoSqls.*;

@Repository
public class MainDao {
/*
	 private NamedParameterJdbcTemplate jdbc;
	 private SimpleJdbcInsert insertAction;
	 private RowMapper<MainDto> rowMapper = BeanPropertyRowMapper.newInstance(MainDto.class);

	    public MainDao(DataSource dataSource) {
	        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	        this.insertAction = new SimpleJdbcInsert(dataSource)
	                .withTableName("Product")
	                .usingGeneratedKeyColumns("title");
	    }
	    */
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<MainDto> rowMapper = BeanPropertyRowMapper.newInstance(MainDto.class);
	  
	public MainDao(DataSource dataSource) {
		this.jdbc=new NamedParameterJdbcTemplate(dataSource);
		this.insertAction=new SimpleJdbcInsert(dataSource).withTableName("Product");
	}
	
	public List<MainDto> selectAll(){
		return jdbc.query(SELECT_DATA,Collections.<String,Object>emptyMap(),rowMapper);
	}
}
