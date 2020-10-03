package repository;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import input.ColaboradorInput;
import input.PrestadorInput;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

public class PrestadorRepository {

	public void InserirPrestador(PrestadorInput input) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn;
			conn = DriverManager.getConnection("jdbc:mysql://lbsumare.mysql.uhserver.com/lbsumare",
					"aluno2020",
					"@Aluno2020");
			
			String query = "INSERT INTO Prestadores "
					+ "(NomeCompleto, Email, PostoTrabalho, Atividade, Login, Senha, Foto, Data, Arquivo) "
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			try(PreparedStatement stmt = conn.prepareStatement(query)){
				stmt.setString(1, input.getNomeCompleto());
				stmt.setString(2, input.getEmail());
				stmt.setString(3, input.getPostoTrabalho());
				stmt.setString(4, input.getAtividade());
				stmt.setString(5, input.getUsuario());
				stmt.setString(6, input.getSenha());
				stmt.setTimestamp(8, input.getDataHora());
				stmt.setTimestamp(9,null);
				
				//Inserindo foto
				FileInputStream foto = new FileInputStream(input.getImg());
				stmt.setBlob(7, foto);
				
				stmt.executeUpdate();
				conn.close();
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Prestador gravado!");	
	}
	
	
	public ObservableList<Map> getPrestadores(){
		ObservableList<Map> prestadores = FXCollections.observableArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn;
			conn = DriverManager.getConnection("jdbc:mysql://lbsumare.mysql.uhserver.com/lbsumare",
					"aluno2020",
					"@Aluno2020");
			
			String query = "SELECT * FROM Prestadores";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.executeQuery();
			while(stmt.getResultSet().next()) {
				Map<String, String> prestador = new HashMap<String, String>();
				prestador.put("col_id", String.valueOf(stmt.getResultSet().getInt("id")));
				prestador.put("col_nome", stmt.getResultSet().getString("NomeCompleto"));
				prestador.put("col_email", stmt.getResultSet().getString("Email"));
				prestador.put("col_atividade", stmt.getResultSet().getString("Atividade"));
				prestador.put("col_localTrabalho", stmt.getResultSet().getString("PostoTrabalho"));
				prestadores.add(prestador);
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return prestadores;
	}
	
	
	public PrestadorInput getPorId(Integer id) {
		PrestadorInput prestador = new PrestadorInput();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn;
			conn = DriverManager.getConnection("jdbc:mysql://lbsumare.mysql.uhserver.com/lbsumare",
					"aluno2020",
					"@Aluno2020");
			
			String query = "SELECT * FROM Prestadores WHERE id = " + id.toString() ;
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.executeQuery();
			while(stmt.getResultSet().next()) {
				prestador.setId(stmt.getResultSet().getInt("id"));
				prestador.setNomeCompleto(stmt.getResultSet().getString("NomeCompleto"));
				prestador.setEmail(stmt.getResultSet().getString("Email"));
				prestador.setAtividade(stmt.getResultSet().getString("Atividade"));
				prestador.setPostoTrabalho(stmt.getResultSet().getString("PostoTrabalho"));
				prestador.setUsuario(stmt.getResultSet().getString("Login"));
				prestador.setSenha(stmt.getResultSet().getString("Senha"));
				
				//Convertendo img de blob para imageView	
				Blob imgBlob = stmt.getResultSet().getBlob("Foto");
				InputStream blobToImg = imgBlob.getBinaryStream();
				BufferedImage imgBuffered = ImageIO.read(blobToImg);
				Image image = SwingFXUtils.toFXImage(imgBuffered, null);
				prestador.setImgBD(image);
				
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return prestador;
	}
	
}
