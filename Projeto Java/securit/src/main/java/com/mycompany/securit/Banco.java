package com.mycompany.securit;

import java.time.LocalDateTime;
import org.springframework.jdbc.core.JdbcTemplate;

public class Banco {
    private DadosConexao dadosConexao;
    private JdbcTemplate jdbcTemplate;
    
    public Banco(){
        dadosConexao = new DadosConexao();

        jdbcTemplate = new JdbcTemplate(dadosConexao.getDataSource());
    }
    
    
    public void insertComp(
            Integer sistemaId, Integer disk, Integer memory, Integer cpu,
            Integer diskId, Integer memoryId, Integer cpuId){
        jdbcTemplate.update(
                "INSERT INTO ServerLog (value, date_time, FK_Server, FK_ServerComponents)"
                        + "VALUES(?, ?, ?, ?)",
                disk, LocalDateTime.now(), sistemaId, diskId
        );
        
        jdbcTemplate.update(
                "INSERT INTO ServerLog (value, date_time, FK_Server, FK_ServerComponents)"
                        + "VALUES(?, ?, ?, ?)",
                memory, LocalDateTime.now(), sistemaId, memoryId
        );
        
        jdbcTemplate.update(
                "INSERT INTO ServerLog (value, date_time, FK_Server, FK_ServerComponents)"
                        + "VALUES(?, ?, ?, ?)",
                cpu, LocalDateTime.now(), sistemaId, cpuId
        );
    }
}
