package Teste.log;


import java.io.IOException;
import java.sql.SQLException;



public class Principal {

	public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException, InterruptedException {
	
		//CAPTURA OS DADOS DA MAQUINA DO USUÁRIO
		GeradorDeLogs g = new GeradorDeLogs();
		
		//GERA OS LOGS E GRAVA NO COMPUTADOR
		g.log();
	
	}

}