package input;

import java.sql.Timestamp;

import javafx.scene.image.Image;

public class ColaboradorInput {

	private Integer id;
	private String nomeCompleto;
	private String email;
	private String telefone;
	private String postoTrabalho;
	private String atividade;
	private String usuario;
	private String senha;
	private String img;
	private Timestamp dataHora;
	private Image imgBD;
	
	
	public ColaboradorInput() {
	}



	public ColaboradorInput(String nomeCompleto, String email, String telefone, String postoTrabalho, String atividade,
			String usuario, String senha, String img, Timestamp dataHora) {
		super();
		this.nomeCompleto = nomeCompleto;
		this.email = email;
		this.telefone = telefone;
		this.postoTrabalho = postoTrabalho;
		this.atividade = atividade;
		this.usuario = usuario;
		this.senha = senha;
		this.img = img;
		this.dataHora = dataHora;
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



	public String getPostoTrabalho() {
		return postoTrabalho;
	}



	public void setPostoTrabalho(String postoTrabalho) {
		this.postoTrabalho = postoTrabalho;
	}



	public String getAtividade() {
		return atividade;
	}



	public void setAtividade(String atividade) {
		this.atividade = atividade;
	}



	public String getUsuario() {
		return usuario;
	}



	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}



	public String getSenha() {
		return senha;
	}



	public void setSenha(String senha) {
		this.senha = senha;
	}



	public String getImg() {
		return img;
	}



	public void setImg(String img) {
		this.img = img;
	}



	public Timestamp getDataHora() {
		return dataHora;
	}



	public void setDataHora(Timestamp dataHora) {
		this.dataHora = dataHora;
	}



	public Image getImgBD() {
		return imgBD;
	}



	public void setImgBD(Image imgBD) {
		this.imgBD = imgBD;
	}

	
	
}
