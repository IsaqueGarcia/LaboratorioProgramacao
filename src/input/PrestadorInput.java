package input;

import java.sql.Blob;
import java.sql.Timestamp;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PrestadorInput {

	private Integer id;
	private String nomeCompleto;
	private String email;
	private String postoTrabalho;
	private String atividade;
	private String usuario;
	private String senha;
	private Image img;
	private Timestamp dataHora;
	
	
	public PrestadorInput() {
		
	}

	public PrestadorInput(Integer id, String nomeCompleto, String email, String postoTrabalho, String atividade,
			String usuario, String senha, Image img, Timestamp dataHora) {
		super();
		this.id = id;
		this.nomeCompleto = nomeCompleto;
		this.email = email;
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
	public Image getImg() {
		return img;
	}
	public void setImg(Image img) {
		this.img = img;
	}
	public Timestamp getDataHora() {
		return dataHora;
	}
	public void setDataHora(Timestamp dataHora) {
		this.dataHora = dataHora;
	}
	
	
	
	
	
}
