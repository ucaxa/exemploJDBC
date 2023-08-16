package projeto_jdbc_bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import projeto_jdbc_modelo.Contato;

public class ListaContatos {

	public static void main(String[] args) throws SQLException {
		//cria a conexão com o BD
		Connection con = new ConnectionFactory().getConnection();
        //cria o comando que será executado
		PreparedStatement stmt = con.prepareStatement("select * from contatos");
		//executa a consulta e seta o resultado no ResultSet
		ResultSet rs = stmt.executeQuery();
        //Criação da lista de contatos e atribuiçoes dos valores vindos do BD
		List<Contato> contatos = new ArrayList<Contato>();
		while (rs.next()) {
			Contato contato = new Contato();
			contato.setId(rs.getLong("id"));
			contato.setNome(rs.getString("nome"));
			contato.setEmail(rs.getString("email"));
			contato.setEndereco(rs.getString("endereco"));
			contatos.add(contato);
		}
		rs.close();
		stmt.close();
        //exibe o id e o nome dos contatos cadastrados
		for (Contato contato : contatos) {
			System.out.println(contato.getId() + " - " + contato.getNome());
		}

	}

}
