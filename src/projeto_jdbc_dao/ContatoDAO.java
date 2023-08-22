package projeto_jdbc_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import projeto_jdbc_bd.ConnectionFactory;
import projeto_jdbc_modelo.Contato;

public class ContatoDAO {
	
	private Connection connection;

	public ContatoDAO(Connection connection) {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	
     public void insere(Contato contato) throws SQLException {
    	 
    	 String sql = "insert into contatos" + "	(nome,email,endereco,dataNascimento)" + 
    				" values	(?,?,?,?)";
    	PreparedStatement stmt = connection.prepareStatement(sql);
    	// passa os parâmetros pra consulta
    	stmt.setString(1, contato.getNome());
    	stmt.setString(2, contato.getEmail());
    	stmt.setString(3, contato.getEndereco());
    	stmt.setDate(4, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
    				// executa
    	stmt.execute();
    	stmt.close();
    	System.out.println("Gravado!");
    	connection.close();
    	 
     }	
	
	 public void altera(Contato contato) throws SQLException {
		
		    // cria um comando que será executado
			String sql = "update contatos set nome = ? where id = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			// define valores que serão passados como parâmetros
			stmt.setString(1, contato.getNome());
			stmt.setLong(2, contato.getId());
			stmt.execute();
			stmt.close();
			System.out.println("Alteração realizada!");
			connection.close();
	 }
	 
	 public void listar() throws SQLException {
		 PreparedStatement stmt = connection.prepareStatement("select * from contatos");
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
        connection.close();
		 
	 }
	 
	 public void excluir(Contato contato) throws SQLException {
		 String sql = "delete from contatos where id=? ";
			// cria o comando que será executado
			PreparedStatement stmt = connection.prepareStatement(sql);
			// passa o parâmetro pra consulta
			stmt.setLong(1, contato.getId());
			stmt.execute();
			stmt.close();
			System.out.println("Exclusão realizada!");
			connection.close();
		 
	 } 
	
	
	

}
