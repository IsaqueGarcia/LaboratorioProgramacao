package input;

import java.sql.Timestamp;
import java.util.Date;

public class ChavesInput {

	private Integer id;
	private String identificador;
	private String local;
	private Integer codigoBarras;
	private Timestamp dataRegistrada;
	private String responsavel;
	
	public ChavesInput(){
		
	}
	
	/**
	 * @param id
	 * @param identificador
	 * @param local
	 * @param codigoBarras
	 * @param dataRegistrada
	 * @param responsavel
	 */
	public ChavesInput(Integer id, String identificador, String local, Integer codigoBarras, Timestamp dataRegistrada,
			String responsavel) {
		super();
		this.id = id;
		this.identificador = identificador;
		this.local = local;
		this.codigoBarras = codigoBarras;
		this.dataRegistrada = dataRegistrada;
		this.responsavel = responsavel;
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
	 * @return the identificador
	 */
	public String getIdentificador() {
		return identificador;
	}
	/**
	 * @param identificador the identificador to set
	 */
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	/**
	 * @return the local
	 */
	public String getLocal() {
		return local;
	}
	/**
	 * @param local the local to set
	 */
	public void setLocal(String local) {
		this.local = local;
	}
	/**
	 * @return the codigoBarras
	 */
	public Integer getCodigoBarras() {
		return codigoBarras;
	}
	/**
	 * @param codigoBarras the codigoBarras to set
	 */
	public void setCodigoBarras(Integer codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	/**
	 * @return the dataRegistrada
	 */
	public Date getDataRegistrada() {
		return dataRegistrada;
	}
	/**
	 * @param dataRegistrada the dataRegistrada to set
	 */
	public void setDataRegistrada(Timestamp dataRegistrada) {
		this.dataRegistrada = dataRegistrada;
	}
	/**
	 * @return the responsavel
	 */
	public String getResponsavel() {
		return responsavel;
	}
	/**
	 * @param responsavel the responsavel to set
	 */
	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ChavesInput [id=" + id + ", identificador=" + identificador + ", local=" + local + ", codigoBarras="
				+ codigoBarras + ", dataRegistrada=" + dataRegistrada + ", responsavel=" + responsavel + "]";
	}
	
	
	
}
