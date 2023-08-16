package projeto_jdbc_bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeletaContato {

	public static void main(String[] args) throws SQLException {
		// cria a conexão com o Banco de Dados
		Connection con = new ConnectionFactory().getConnection();
		String sql = "delete from contatos where id=? ";
		// cria o comando que será executado
		PreparedStatement stmt = con.prepareStatement(sql);
		// passa o parâmetro pra consulta
		stmt.setString(1, "2");
		stmt.execute();
		stmt.close();
		System.out.println("Exclusão realizada!");
		con.close();
	}
}
