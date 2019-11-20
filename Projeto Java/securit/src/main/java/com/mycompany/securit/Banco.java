package com.mycompany.securit;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

public class Banco {
    private final DadosConexao dadosConexao;
    private final JdbcTemplate jdbcTemplate;
    private List client = new ArrayList();
    private List clientSystems = new ArrayList();
    private List clientSystemsId = new ArrayList();
    private CharSequence idCliente;
    
    public Banco(){
        dadosConexao = new DadosConexao();

        jdbcTemplate = new JdbcTemplate(dadosConexao.getDataSource());
    }
    
    public String validateLogin(String login, String senha){
        client = jdbcTemplate.queryForList(
                "SELECT idClient FROM Client WHERE email = ? and pswd = ?", login, senha
        );
        
       
         if(client.size() >= 1){
                idCliente = client.get(0).toString().substring(10).replace("}", "");
                consultarSistemas();
                return "Logado";
            
        } else {
            return "Login Inválido";
        }
    }
    
    public List getClientSystems() {
        return clientSystems;
    }

    public List getClientSystemsId() {
        return clientSystemsId;
    }
    
    public void consultarSistemas(){
        List result;
        
        result = jdbcTemplate.queryForList(
                "SELECT idServer, name FROM Server WHERE FK_client = ?", idCliente
        );
        
                
        result.forEach(sistema -> {
            
            String sis = sistema.toString();
            String id = sis.substring(sis.indexOf("=")+1, sis.indexOf(","));
            String name = sis.substring(sis.lastIndexOf("=")+1,sis.indexOf("}"));
            
            clientSystemsId.add(id);
            clientSystems.add(name);
        });
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
    
    
    
    
    
    // testando a classe
//    public static void main(String[] args) {
//        Banco bd = new Banco();
//        String f = bd.validateLogin("fernanda.esteves@bandtec.com", "12345678");
//        System.out.println(f);
//        
//        System.out.println(bd.getClientSystems());
//        System.out.println(bd.getClientSystemsId());
//    }
//
//    
    
    
    
    
    
}
