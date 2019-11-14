package com.mycompany.securit;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

public class Banco {
    private final DadosConexao dadosConexao;
    private final JdbcTemplate jdbcTemplate;
    
    public Banco(){
        dadosConexao = new DadosConexao();

        jdbcTemplate = new JdbcTemplate(dadosConexao.getDataSource());
    }
    
    public String validateLogin(String login, String senha){
        List lista = jdbcTemplate.queryForList(
                "SELECT * FROM Client WHERE email = ?", login
        );
        return "Logado";
        /* if(lista.size() >= 1){
            lista.get(0);
            if(senha.equals(senha)){
                return "Logado";
            } else {
                return "Senha inválida";
            }
        } else {
            return "Login Inválido";
        } */
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
