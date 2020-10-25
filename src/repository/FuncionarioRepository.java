package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;

import input.FuncionarioInput;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;

public class FuncionarioRepository {

	public ObservableList<Map> getFuncionarios(){
		ObservableList<Map> funcionarios = FXCollections.observableArrayList();
		Button btn = new Button();
		btn.setText("DELETAR");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn;
			conn = DriverManager.getConnection("jdbc:mysql://lbsumare.mysql.uhserver.com/lbsumare",
					"aluno2020",
					"@Aluno2020");
			
			String query = "SELECT * FROM Funcionario";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.executeQuery();
			while(stmt.getResultSet().next()) {
				Map<String, String> funcionario = new HashMap<String, String>();
				funcionario.put("col_id", String.valueOf(stmt.getResultSet().getInt("Id")));
				funcionario.put("col_nome", stmt.getResultSet().getString("Nome_Completo"));
				funcionario.put("col_telefone", stmt.getResultSet().getString("Telefone"));
				funcionario.put("col_email", stmt.getResultSet().getString("Email"));
				funcionario.put("col_tipoConta", stmt.getResultSet().getString("Tipo_Conta"));
				funcionario.put("col_diretoria", stmt.getResultSet().getString("Diretoria"));
				funcionarios.add(funcionario);
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return funcionarios;
	}
	
	public void InserirFuncionario(FuncionarioInput input) {	
		
		try {
			if(input.getId() != null){
				this.atualizarFuncionario(input);
				return;
			}
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn;
			conn = DriverManager.getConnection("jdbc:mysql://lbsumare.mysql.uhserver.com/lbsumare",
					"aluno2020",
					"@Aluno2020");
			
			String query = "INSERT INTO Funcionario "
					+ "(Nome_Completo, Email, Telefone, Diretoria, Tipo_Conta, Login, Senha) "
					+ "VALUES( ?, ?, ?, ?, ?, ?, ?)";
			
			try(PreparedStatement stmt = conn.prepareStatement(query)){
				stmt.setString(1, input.getNomeCompleto());
				stmt.setString(2, input.getEmail());
				stmt.setString(3, input.getTelefone());
				stmt.setString(4, input.getDiretoria());
				stmt.setString(5, input.getTipoDeConta());
				stmt.setString(6, input.getLogin());
				stmt.setString(7, input.getSenha());
				
				stmt.executeUpdate();
				conn.close();
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Funcionario gravado!");	
	}
	
	public ObservableList<Map> carregaTbFuncionarios(){
		ObservableList<Map> funcionarios = FXCollections.observableArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn;
			conn = DriverManager.getConnection("jdbc:mysql://lbsumare.mysql.uhserver.com/lbsumare",
					"aluno2020",
					"@Aluno2020");
			
			String query = "SELECT * FROM Funcionario";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.executeQuery();
			while(stmt.getResultSet().next()) {
				Map<String, String> funcionario = new HashMap<String, String>();
				funcionario.put("col_id", String.valueOf(stmt.getResultSet().getInt("Id")));
				funcionario.put("col_nome", stmt.getResultSet().getString("Nome_Completo"));
				funcionario.put("col_email", stmt.getResultSet().getString("Email"));
				funcionario.put("col_diretoria", stmt.getResultSet().getString("Diretoria"));
				funcionario.put("col_telefone", stmt.getResultSet().getString("Telefone"));
				funcionario.put("col_tipo_conta", stmt.getResultSet().getString("Tipo_Conta"));
				funcionarios.add(funcionario);
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return funcionarios;
	}
	
	public FuncionarioInput getFuncionarioPorId(Integer id) {
		FuncionarioInput funcionario = new FuncionarioInput();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn;
			conn = DriverManager.getConnection("jdbc:mysql://lbsumare.mysql.uhserver.com/lbsumare",
					"aluno2020",
					"@Aluno2020");
			
			String query = "SELECT * FROM Funcionario WHERE Id = " + id.toString();
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.executeQuery();
			while(stmt.getResultSet().next()) {
				funcionario.setId(stmt.getResultSet().getInt("Id"));
				funcionario.setNomeCompleto(stmt.getResultSet().getString("Nome_Completo"));
				funcionario.setEmail(stmt.getResultSet().getString("Email"));
				funcionario.setDiretoria(stmt.getResultSet().getString("Diretoria"));
				funcionario.setTelefone(stmt.getResultSet().getString("Telefone"));
				funcionario.setTipoDeConta(stmt.getResultSet().getString("Tipo_Conta"));
				funcionario.setLogin(stmt.getResultSet().getString("Login"));
				funcionario.setSenha(stmt.getResultSet().getString("Senha"));
				
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return funcionario;
	}
	
	

	public void atualizarFuncionario(FuncionarioInput input){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn;
			conn = DriverManager.getConnection("jdbc:mysql://lbsumare.mysql.uhserver.com/lbsumare",
					"aluno2020",
					"@Aluno2020");
			
			String query = "UPDATE Funcionario "
					+ "SET Nome_Completo = ? ,Email = ?, Telefone = ?, Diretoria = ?, Tipo_Conta = ?, Login = ?, Senha = ? "
					+ "WHERE Id = ?";
			
			try(PreparedStatement stmt = conn.prepareStatement(query)){
				stmt.setString(1, input.getNomeCompleto());
				stmt.setString(2, input.getEmail());
				stmt.setString(3, input.getTelefone());
				stmt.setString(4, input.getDiretoria() == null ? " " : input.getDiretoria());
				stmt.setString(5, input.getTipoDeConta() == null ? " " : input.getTipoDeConta());
				stmt.setString(6, input.getLogin());
				stmt.setString(7, input.getSenha());
				stmt.setInt(8, input.getId());
				
				stmt.executeUpdate();
				conn.close();
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Funcionario atualizado!");	
	}
	
	public void deletarFuncionarioPeloId(Integer id){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn;
			conn = DriverManager.getConnection("jdbc:mysql://lbsumare.mysql.uhserver.com/lbsumare",
					"aluno2020",
					"@Aluno2020");
			
			String query = "DELETE FROM Funcionario WHERE Id = ?";
			
			try(PreparedStatement stmt = conn.prepareStatement(query)){
				stmt.setInt(1, id);
				
				stmt.executeUpdate();
				conn.close();
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Funcionario deletado!");	
	}
	
	
}
