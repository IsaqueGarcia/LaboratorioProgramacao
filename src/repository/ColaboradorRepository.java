package repository;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;

import input.ColaboradorInput;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



public class ColaboradorRepository {

	public void InserirColaborador(ColaboradorInput input) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn;
			conn = DriverManager.getConnection("jdbc:mysql://lbsumare.mysql.uhserver.com/lbsumare",
					"aluno2020",
					"@Aluno2020");
			
			String query = "INSERT INTO Colaborador "
					+ "(NomeCompleto, Email, Telefone, PostoTrabalho, Atividade, Usuario, Senha, img, DataHora) "
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			try(PreparedStatement stmt = conn.prepareStatement(query)){
				stmt.setString(1, input.getNomeCompleto());
				stmt.setString(2, input.getEmail());
				stmt.setString(3, input.getTelefone());
				stmt.setString(4, input.getPostoTrabalho());
				stmt.setString(5, input.getAtividade());
				stmt.setString(6, input.getUsuario());
				stmt.setString(7, input.getSenha());
				stmt.setTimestamp(9,input.getDataHora());
				
				//Inserindo foto
				FileInputStream foto = new FileInputStream(input.getImg());
				stmt.setBlob(8, foto);
				
				stmt.executeUpdate();
				conn.close();
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Colaborador gravado!");	
	}
	
	public ObservableList<Map> getColaboradores(){
		ObservableList<Map> colaboradores = FXCollections.observableArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn;
			conn = DriverManager.getConnection("jdbc:mysql://lbsumare.mysql.uhserver.com/lbsumare",
					"aluno2020",
					"@Aluno2020");
			
			String query = "SELECT * FROM Colaborador";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.executeQuery();
			while(stmt.getResultSet().next()) {
				Map<String, String> colaborador = new HashMap<String, String>();
				colaborador.put("col_id", String.valueOf(stmt.getResultSet().getInt("id")));
				colaborador.put("col_nome", stmt.getResultSet().getString("NomeCompleto"));
				colaborador.put("col_email", stmt.getResultSet().getString("Email"));
				colaborador.put("col_atividade", stmt.getResultSet().getString("Atividade"));
				colaborador.put("col_telefone", stmt.getResultSet().getString("Telefone"));
				colaborador.put("col_localTrabalho", stmt.getResultSet().getString("PostoTrabalho"));
				colaboradores.add(colaborador);
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return colaboradores;
	}
	
	public ColaboradorInput getPorId(Integer id) {
		ColaboradorInput colaborador = new ColaboradorInput();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn;
			conn = DriverManager.getConnection("jdbc:mysql://lbsumare.mysql.uhserver.com/lbsumare",
					"aluno2020",
					"@Aluno2020");
			
			String query = "SELECT * FROM Colaborador WHERE id = " + id.toString() ;
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.executeQuery();
			while(stmt.getResultSet().next()) {
				colaborador.setId(stmt.getResultSet().getInt("id"));
				colaborador.setNomeCompleto(stmt.getResultSet().getString("NomeCompleto"));
				colaborador.setEmail(stmt.getResultSet().getString("Email"));
				colaborador.setAtividade(stmt.getResultSet().getString("Atividade"));
				colaborador.setTelefone(stmt.getResultSet().getString("Telefone"));
				colaborador.setPostoTrabalho(stmt.getResultSet().getString("PostoTrabalho"));
				colaborador.setUsuario(stmt.getResultSet().getString("Usuario"));
				colaborador.setSenha(stmt.getResultSet().getString("Senha"));
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return colaborador;
	}
	
	
}
