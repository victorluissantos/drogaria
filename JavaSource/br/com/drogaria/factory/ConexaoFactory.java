package br.com.drogaria.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
	private static final String USUARIO = "forlife";
	private static final String SENHA = "temp-123";
	private static final String URL = "jdbc:mysql://www.db4free.net/drogaria";

	public static Connection conectar() throws SQLException {
		//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);

		return conexao;
	}
	
	public static void main (String[] arg){
		try {
			Connection conexao = ConexaoFactory.conectar();
			System.out.println("Conexão realizada com sucesso !");
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			System.out.println("Não foi possivel realizar a conexão !");
			ex.printStackTrace();
		}
	}
}
