package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import input.ColaboradorInput;
import input.FuncionarioInput;



public class LoginRepository {

	
	public FuncionarioInput validarLogin(String usuario,String senha){
		FuncionarioInput funcionario = null;
		Integer id = null;
		String nomeCompleto = "";
		String email = "";
		String telefone = "";
		String resultadoLogin = ""; 
		String resultadoSenha = "";
		String tipoConta = "";
		String diretoria= "";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn;
			conn = DriverManager.getConnection("jdbc:mysql://lbsumare.mysql.uhserver.com/lbsumare", "aluno2020", "@Aluno2020");
			
			String query = "SELECT * FROM Funcionario where Login = ? AND Senha = ?";
			
			
			PreparedStatement ps;
			ps = conn.prepareStatement(query);
			ps.setString(1, usuario);
			ps.setString(2, senha);
			ResultSet rs;
			rs = ps.executeQuery();
			
			while(rs.next()){
				 id = Integer.parseInt(rs.getString("Id"));
				 nomeCompleto = rs.getString("Nome_Completo");
				 email = rs.getString("Email");
				 telefone = rs.getString("Telefone");
				 resultadoLogin = rs.getString("Login");
				 resultadoSenha = rs.getString("Senha");
				 tipoConta = rs.getString("Tipo_Conta");
				 diretoria = rs.getString("Diretoria");
			}
			
			funcionario = new FuncionarioInput(id, nomeCompleto, email, telefone, diretoria, tipoConta, resultadoLogin, resultadoSenha);
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return funcionario;
	}
	
}
