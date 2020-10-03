package gui;

import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;

import org.omg.CORBA.Current;

import input.ChavesInput;
import input.MoradorInput;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.input.MouseEvent;
import repository.ChaveRepository;

public class ChaveViewController implements Initializable {
	
	@FXML
	private TextField identificadorChave;
	
	@FXML
	private ComboBox<String> local;
	
	@FXML
	private TextField codigoBarras;
	
	@FXML
	private TextField codigoBarrasPesquisa;
	
	@FXML
	private Button salvar;
	
	@FXML
	private Button limpar;
	
	@FXML
	private Button pesquisar;
	
	//Tabela responsavel por listar as chaves cadastradas
	@FXML
	private TableView<Map> tabelaChave;
	
	@FXML
	private TableColumn colIdentificador;
	
	@FXML
	private TableColumn colLocal;
	
	@FXML
	private TableColumn colCodigoBarras;
	
	@FXML
	private TableColumn colDataRegistrada;
	
	@FXML
	private TableColumn colResponsavel;
	
	//Tabela responsavel por trazer o retorno da pesquisa
	
	
	@FXML
	private TextField txtIdentificadorPesquisa;
	
	@FXML
	private TextField txtLocalPesquisa;
	
	@FXML
	private TextField txtCodigoBarrasPesquisa;
	
	@FXML
	private TextField txtDataRegistradaPesquisa;
	
	@FXML
	private TextField txtResponsavelPesquisa;

	
	private ChaveRepository repo = new ChaveRepository();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.carregaLocalizacao();
		this.carregarTabelaChaves();
		
	}
	
	public void carregaLocalizacao() {
		ArrayList<String> localizacoes = new ArrayList<>();
		
		localizacoes.add("Subsolo");
		localizacoes.add("Terreo");
		localizacoes.add("1° Andar");
		localizacoes.add("2° Andar");
		localizacoes.add("3° Andar");

		ObservableList<String> obsLocalizacoes = FXCollections.observableArrayList(localizacoes);
		this.local.setItems(obsLocalizacoes);

	}
	
	@FXML
	public void limparCampos(ActionEvent event){
		identificadorChave.setText("");
		codigoBarras.setText("");
	}
	
	@FXML
	public void gravarChave(ActionEvent event){
		try{
			ChavesInput chave = new ChavesInput(null, identificadorChave.getText(), local.getValue(), Integer.parseInt(codigoBarras.getText()), new Timestamp(System.currentTimeMillis()), " ");
			System.out.println(chave.toString());
			repo.InserirChave(chave);
		}catch (Exception e) {
			System.out.println("Error::" + e.getMessage());
		}
	}
	
	@FXML
	public void pesquisarChave(ActionEvent event){
		try{
			txtIdentificadorPesquisa.setText("");
			txtLocalPesquisa.setText("");
			txtResponsavelPesquisa.setText("");
			txtDataRegistradaPesquisa.setText("");
			txtCodigoBarrasPesquisa.setText("");
			
			ChavesInput chave = repo.getChavePeloCodigo(Integer.parseInt(codigoBarrasPesquisa.getText()));
			txtIdentificadorPesquisa.setText(chave.getIdentificador());
			txtLocalPesquisa.setText(chave.getLocal());
			txtResponsavelPesquisa.setText(chave.getResponsavel() == null ? " " : chave.getResponsavel());
			txtDataRegistradaPesquisa.setText(chave.getDataRegistrada().toString());
			txtCodigoBarrasPesquisa.setText(chave.getCodigoBarras().toString());
		}catch (Exception e) {
			System.out.println("ERRO::" + e.getMessage());
		}
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void carregarTabelaChaves() {
		try{
			colIdentificador.setCellValueFactory(new MapValueFactory("identificador"));
			colLocal.setCellValueFactory(new MapValueFactory("local"));
			colCodigoBarras.setCellValueFactory(new MapValueFactory("codigoBarras"));
			colDataRegistrada.setCellValueFactory(new MapValueFactory("dataRegistrada"));
			colResponsavel.setCellValueFactory(new MapValueFactory("responsavel"));

			
			tabelaChave.setItems(repo.getChaves());
		}catch (Exception e) {
			// TODO: handle exception
		}
	}


}
