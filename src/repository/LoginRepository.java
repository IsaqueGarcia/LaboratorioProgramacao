package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import input.ColaboradorInput;



public class LoginRepository {

	
	public ColaboradorInput validarLogin(String usuario,String senha){
		ColaboradorInput colaborador = null;
		String id = "";
		String nomeCompleto = "";
		String email = "";
		String telefone = "";
		String postoTrabalho = "";
		String atividade = "";
		String imgPath = "";
		String resultadoLogin = ""; 
		String resultadoSenha = "";
		String dataHora = "";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn;
			conn = DriverManager.getConnection("jdbc:mysql://lbsumare.mysql.uhserver.com/lbsumare", "aluno2020", "@Aluno2020");
			
			String query = "SELECT * FROM Colaborador where Usuario = ? AND Senha = ?";
			
			
			PreparedStatement ps;
			ps = conn.prepareStatement(query);
			ps.setString(1, usuario);
			ps.setString(2, senha);
			ResultSet rs;
			rs = ps.executeQuery();
			
			while(rs.next()){
				 id = rs.getString("id");
				 nomeCompleto = rs.getString("NomeCompleto");
				 email = rs.getString("Email");
				 telefone = rs.getString("Telefone");
				 postoTrabalho = rs.getString("PostoTrabalho");
				 atividade = rs.getString("Atividade");
				 imgPath = rs.getString("img");
				 resultadoLogin = rs.getString("Usuario");
				 resultadoSenha = rs.getString("Senha");
				 dataHora = rs.getString("DataHora");
			}
			
			colaborador = new ColaboradorInput(nomeCompleto, email, telefone, postoTrabalho, atividade, resultadoLogin, resultadoSenha, imgPath, new Timestamp(System.currentTimeMillis()));
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return colaborador;
	}
	
}
