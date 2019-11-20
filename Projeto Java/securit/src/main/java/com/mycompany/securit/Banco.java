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
    
    private String idCpu;
    private String idHD;
    private String idRam;
    
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
 
    public Boolean consultarComponenteSistema(String idServer){
        List result;
        
        result = jdbcTemplate.queryForList(
                "SELECT * FROM ServerComponents WHERE FK_Server = ?", idServer
        );
        
        if(result.size() >= 1){      
        result.forEach(componentes -> {
            System.out.println(componentes);
            
            String sis = componentes.toString();
            String id = sis.substring(sis.indexOf("=")+1, sis.indexOf(","));
            
            if(sis.contains("HD")){
                idHD = id;
//                System.out.println(id + "hd");
            } 
            else if(sis.contains("CPU")){
                idCpu = id;
//                System.out.println(id + "CPU");;
            }
            else {
                idRam = id;
//                System.out.println(id + "ram");;
            }
        });
        
            return true;
        } else {
            return false;
        }
    }
    
    
    
    public String getIdCpu() {
        return idCpu;
    }

    public String getIdHD() {
        return idHD;
    }

    public String getIdRam() {
        return idRam;
    }
    
    public void insertComponent(String nomeComponente, String size, String idSistema){
        jdbcTemplate.update(
                "INSERT INTO ServerComponents (name, size, FK_Server) "
                        + "VALUES(?, ?, ?)",
                nomeComponente, size, idSistema);
    }
    
    
    public void insertComponentLogs(Integer sistemaId, 
            Integer component, Integer componenteId){
        
        jdbcTemplate.update(
                "INSERT INTO ServerLog "
                        + "(value, date_time, FK_Server, FK_ServerComponents)"
                        + "VALUES(?, ?, ?, ?)",
                component, LocalDateTime.now(), sistemaId, componenteId);
    }
    

// =============== testando a classe
    
//    public static void main(String[] args) {
//        Banco bd = new Banco();
//        String f = bd.validateLogin("fernanda.esteves@bandtec.com", "12345678");
//        System.out.println(f);
//        
//        System.out.println(bd.getClientSystems());
//        System.out.println(bd.getClientSystemsId());
//        bd.consultarComponenteSistema("7");
//    }

    
    
    
    
    
    
}
