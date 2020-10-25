package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FuncionarioRepository {

	public ObservableList<Map> getFuncionarios(){
		ObservableList<Map> funcionarios = FXCollections.observableArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn;
			conn = DriverManager.getConnection("jdbc:mysql://lbsumare.mysql.uhserver.com/lbsumare",
					"aluno2020",
					"@Aluno2020");
			
			String query = "SELECT * FROM ??????";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.executeQuery();
			while(stmt.getResultSet().next()) {
				Map<String, String> funcionario = new HashMap<String, String>();
				funcionario.put("col_nome", String.valueOf(stmt.getResultSet().getInt("NomeCompleto")));
				funcionario.put("col_telefone", stmt.getResultSet().getString("Telefone"));
				funcionario.put("col_email", stmt.getResultSet().getString("Email"));
				funcionario.put("col_tipoConta", stmt.getResultSet().getString("TipoConta"));
				funcionario.put("col_diretoria", stmt.getResultSet().getString("Diretoria"));
				funcionarios.add(funcionario);
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return funcionarios;
	}
	
}
