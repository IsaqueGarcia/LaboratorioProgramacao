package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import input.ChavesInput;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ChaveRepository {

	public void InserirChave(ChavesInput input) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn;
			conn = DriverManager.getConnection("jdbc:mysql://lbsumare.mysql.uhserver.com/lbsumare", "aluno2020",
					"@Aluno2020");

			String query = "INSERT INTO Chave "
					+ "(identificador, localChave, codigoBarras, dataRegistrada, responsavel) "
					+ "VALUES(?, ?, ?, ?, ?)";

			try (PreparedStatement stmt = conn.prepareStatement(query)) {
				stmt.setString(1, input.getIdentificador());
				stmt.setString(2, input.getLocal());
				stmt.setInt(3, input.getCodigoBarras());
				stmt.setTimestamp(4, (Timestamp) input.getDataRegistrada());
				stmt.setString(5, input.getResponsavel() == " " ? null : input.getResponsavel());

				stmt.executeUpdate();
				conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("Chave gravada com sucesso!");
	}

	public ObservableList<Map> getChaves() {
		ObservableList<Map> chaves = FXCollections.observableArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn;
			conn = DriverManager.getConnection("jdbc:mysql://lbsumare.mysql.uhserver.com/lbsumare", "aluno2020",
					"@Aluno2020");

			String query = "SELECT * FROM Chave";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.executeQuery();
			while (stmt.getResultSet().next()) {
				Map<String, String> chave = new HashMap<String, String>();
				chave.put("identificador", stmt.getResultSet().getString("identificador"));
				chave.put("local", stmt.getResultSet().getString("localChave"));
				chave.put("codigoBarras", String.valueOf(stmt.getResultSet().getInt("codigoBarras")));
				chave.put("dataRegistrada", String.valueOf(stmt.getResultSet().getTimestamp("dataRegistrada")));
				chave.put("responsavel", stmt.getResultSet().getString("responsavel"));

				chaves.add(chave);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return chaves;
	}

	public ChavesInput getChavePeloCodigo(Integer codigoBarras) {
		ChavesInput chave = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn;
			conn = DriverManager.getConnection("jdbc:mysql://lbsumare.mysql.uhserver.com/lbsumare", "aluno2020",
					"@Aluno2020");

			String query = "SELECT * FROM Chave where codigoBarras = ?";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, codigoBarras);
			stmt.executeQuery();
			while (stmt.getResultSet().next()) {
				chave = new ChavesInput(null, stmt.getResultSet().getString("identificador"),
						stmt.getResultSet().getString("localChave"), stmt.getResultSet().getInt("codigoBarras"),
						stmt.getResultSet().getTimestamp("dataRegistrada"),
						stmt.getResultSet().getString("responsavel"));
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return chave;
	}

}
