package projeto_jdbc_bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AlteraContato {

	public static void main(String[] args) throws SQLException {
		// cria uma conexão com o Banco de Dados
		Connection con = new ConnectionFactory().getConnection();
		// cria um comando que será executado
		String sql = "update contatos set nome = ? where id = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		// define valores que serão passados como parâmetros
		stmt.setString(1, "Mariana");
		stmt.setString(2, "2");
		stmt.execute();
		stmt.close();
		System.out.println("Alteração realizada!");
		con.close();

	}

}
