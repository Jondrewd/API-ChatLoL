package com.projetospring.adapters.out;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.projetospring.domain.model.Champions;
import com.projetospring.domain.ports.ChampionsRepository;

@Repository
public class ChampionsJdbcRepository implements ChampionsRepository{

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Champions> championsRowMapper;
    
    public ChampionsJdbcRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
        this.championsRowMapper = (rs, rowNum) -> new Champions(
            rs.getLong("id"),
            rs.getString("name"),
            rs.getString("role"),
            rs.getString("lore"),
            rs.getString("image_url")      
        );
    }

    @Override
    public List<Champions> findAll() {
        return jdbcTemplate.query("SELECT * FROM CHAMPIONS ", championsRowMapper);
    }

    @Override
    public Optional<Champions> findById(Long id) {
        String sql = "SELECT * FROM CHAMPIONS WHERE ID = ?";
        List<Champions> champions = jdbcTemplate.query(sql, championsRowMapper, id);
        return champions.stream().findFirst();
    }
    
}
