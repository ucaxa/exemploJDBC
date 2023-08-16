package projeto_jdbc_bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

public class InsereContato {

	public static void main(String[] args) throws SQLException {
		// cria a conexão com o Banco de Dados
		Connection con = new ConnectionFactory().getConnection();
		// cria um comando
		String sql = "insert into contatos" + "	(nome,email,endereco,dataNascimento)" + 
		" values	(?,?,?,?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		// passa os parâmetros pra consulta
		stmt.setString(1, "Maria");
		stmt.setString(2, "maria@gmail.com.br");
		stmt.setString(3, "R.	Vergueiro	3186	cj57");
		stmt.setDate(4, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
		// executa
		stmt.execute();
		stmt.close();
		System.out.println("Gravado!");
		con.close();
	}
}
