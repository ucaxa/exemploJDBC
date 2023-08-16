package projeto_jdbc_testeDeConexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteDeConexao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection con =	
					DriverManager.getConnection("jdbc:mysql://localhost/fj21",  "root","root");
			System.out.println("Conectado");  
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

