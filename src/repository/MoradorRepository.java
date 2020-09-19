package repository;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;

import input.ColaboradorInput;
import input.MoradorInput;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MoradorRepository {

	public void InserirMorador(MoradorInput input) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn;
			conn = DriverManager.getConnection("jdbc:mysql://lbsumare.mysql.uhserver.com/lbsumare",
					"aluno2020",
					"@Aluno2020");
			
			String query = "INSERT INTO morador "
					+ "(UnidadeNome, Senha, Situacao, Celular, Email, Correspondencia, Interfonar, Andar, Vagas, Funcionario, Data, Arquivo, img) "
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			try(PreparedStatement stmt = conn.prepareStatement(query)){
				stmt.setString(1, input.getUnidadeMorador());
				stmt.setString(2, input.getSenha());
				stmt.setString(3, input.getSituacao());
				stmt.setString(4, input.getTelefone());
				stmt.setString(5, input.getEmail());
				stmt.setString(6, input.getCorrespondencia());
				stmt.setString(7, input.getInterfone());
				stmt.setString(8,null);
				stmt.setString(9, input.getVaga());
				stmt.setString(10,null);
				stmt.setTimestamp(11, input.getData());
				stmt.setString(12,null);
				
				
				//Inserindo foto
				FileInputStream foto = new FileInputStream(input.getFoto());
				stmt.setBlob(13, foto);
				
				stmt.executeUpdate();
				conn.close();
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Morador gravado!");	
	}
	
	public ObservableList<Map> getMoradores(){
		ObservableList<Map> moradores = FXCollections.observableArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn;
			conn = DriverManager.getConnection("jdbc:mysql://lbsumare.mysql.uhserver.com/lbsumare",
					"aluno2020",
					"@Aluno2020");
			
			String query = "SELECT * FROM morador";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.executeQuery();
			while(stmt.getResultSet().next()) {
				Map<String, String> morador = new HashMap<String, String>();
				morador.put("id", String.valueOf(stmt.getResultSet().getInt("id")));
				morador.put("unidadeMorador", stmt.getResultSet().getString("UnidadeNome"));
				morador.put("situacao", stmt.getResultSet().getString("Situacao"));
				morador.put("telefone", stmt.getResultSet().getString("Celular"));
				morador.put("email", stmt.getResultSet().getString("Email"));
				morador.put("correios", stmt.getResultSet().getString("Correspondencia"));
				morador.put("interfone", stmt.getResultSet().getString("Interfonar"));
				morador.put("vagas", stmt.getResultSet().getString("Vagas"));
				moradores.add(morador);
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return moradores;
	}
	
	
	public MoradorInput getPorId(Integer id) {
		MoradorInput morador = new MoradorInput();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn;
			conn = DriverManager.getConnection("jdbc:mysql://lbsumare.mysql.uhserver.com/lbsumare",
					"aluno2020",
					"@Aluno2020");
			
			String query = "SELECT * FROM morador WHERE id = " + id.toString() ;
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.executeQuery();
			while(stmt.getResultSet().next()) {
				morador.setId(stmt.getResultSet().getInt("id"));
				morador.setUnidadeMorador(stmt.getResultSet().getString("UnidadeNome"));
				morador.setEmail(stmt.getResultSet().getString("Email"));
				morador.setTelefone(stmt.getResultSet().getString("Celular"));
				morador.setSenha(stmt.getResultSet().getString("Senha"));
				morador.setVaga(stmt.getResultSet().getString("Vagas"));
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return morador;
	}
	
}
