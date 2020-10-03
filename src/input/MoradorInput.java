package input;

import java.sql.Timestamp;

import javafx.scene.image.Image;

public class MoradorInput {

	private Integer id;
	private String unidadeMorador;
	private String situacao;
	private String telefone;
	private String email;
	private String correspondencia;
	private String interfone;
	private String vaga;
	private String localizacao;
	private String senha;
	private String foto;
	private Timestamp data;
	private Image imgBD;
	
	public MoradorInput(){
		
	}
	
	
	
	/**
	 * @param id
	 * @param unidadeMorador
	 * @param situacao
	 * @param telefone
	 * @param email
	 * @param correspondencia
	 * @param interfone
	 * @param vaga
	 * @param localizacao
	 * @param senha
	 * @param foto
	 */
	public MoradorInput(Integer id, String unidadeMorador, String situacao, String telefone, String email,
			String correspondencia, String interfone, String vaga, String localizacao, String senha, String foto, Timestamp data) {
		super();
		this.id = id;
		this.unidadeMorador = unidadeMorador;
		this.situacao = situacao;
		this.telefone = telefone;
		this.email = email;
		this.correspondencia = correspondencia;
		this.interfone = interfone;
		this.vaga = vaga;
		this.localizacao = localizacao;
		this.senha = senha;
		this.foto = foto;
		this.data = data;
	}



	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the unidadeMorador
	 */
	public String getUnidadeMorador() {
		return unidadeMorador;
	}
	/**
	 * @param unidadeMorador the unidadeMorador to set
	 */
	public void setUnidadeMorador(String unidadeMorador) {
		this.unidadeMorador = unidadeMorador;
	}
	/**
	 * @return the situacao
	 */
	public String getSituacao() {
		return situacao;
	}
	/**
	 * @param situacao the situacao to set
	 */
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	/**
	 * @return the telefone
	 */
	public String getTelefone() {
		return telefone;
	}
	/**
	 * @param telefone the telefone to set
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the correspondencia
	 */
	public String getCorrespondencia() {
		return correspondencia;
	}
	/**
	 * @param correspondencia the correspondencia to set
	 */
	public void setCorrespondencia(String correspondencia) {
		this.correspondencia = correspondencia;
	}
	/**
	 * @return the interfone
	 */
	public String getInterfone() {
		return interfone;
	}
	/**
	 * @param interfone the interfone to set
	 */
	public void setInterfone(String interfone) {
		this.interfone = interfone;
	}
	/**
	 * @return the vaga
	 */
	public String getVaga() {
		return vaga;
	}
	/**
	 * @param vaga the vaga to set
	 */
	public void setVaga(String vaga) {
		this.vaga = vaga;
	}
	/**
	 * @return the localizacao
	 */
	public String getLocalizacao() {
		return localizacao;
	}
	/**
	 * @param localizacao the localizacao to set
	 */
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}
	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}
	/**
	 * @return the foto
	 */
	public String getFoto() {
		return foto;
	}
	/**
	 * @param foto the foto to set
	 */
	public void setFoto(String foto) {
		this.foto = foto;
	}



	/**
	 * @return the data
	 */
	public Timestamp getData() {
		return data;
	}



	/**
	 * @param data the data to set
	 */
	public void setData(Timestamp data) {
		this.data = data;
	}



	public Image getImgBD() {
		return imgBD;
	}



	public void setImgBD(Image imgBD) {
		this.imgBD = imgBD;
	}
	
	
	
}
