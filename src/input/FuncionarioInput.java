package input;

import javafx.scene.control.Button;

public class FuncionarioInput {


	private Integer id;
	private String nomeCompleto;
	private String email;
	private String telefone;
	private String diretoria;
	private String tipoDeConta;
	private String login;
	private String senha;

	
	public FuncionarioInput() {
		
	}
	
	public FuncionarioInput(Integer id, String nomeCompleto, String email, String telefone, String diretoria,
			String tipoDeConta, String login, String senha) {
		super();
		this.id = id;
		this.nomeCompleto = nomeCompleto;
		this.email = email;
		this.telefone = telefone;
		this.diretoria = diretoria;
		this.tipoDeConta = tipoDeConta;
		this.login = login;
		this.senha = senha;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getDiretoria() {
		return diretoria;
	}

	public void setDiretoria(String diretoria) {
		this.diretoria = diretoria;
	}

	public String getTipoDeConta() {
		return tipoDeConta;
	}

	public void setTipoDeConta(String tipoDeConta) {
		this.tipoDeConta = tipoDeConta;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
