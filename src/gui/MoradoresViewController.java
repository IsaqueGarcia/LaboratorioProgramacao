package gui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;

import input.ColaboradorInput;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import repository.MoradorRepository;

public class MoradoresViewController implements Initializable {

	@FXML
	private TextField unidadeMorador;

	@FXML
	private ComboBox<String> situacao;

	@FXML
	private TextField telefone;

	@FXML
	private TextField email;

	@FXML
	private ComboBox<String> correspondecias;

	@FXML
	private ComboBox<String> interfone;

	@FXML
	private TextField vaga;

	@FXML
	private ComboBox<String> localizacao;

	@FXML
	private TextField senha;

	@FXML
	private Button btSalvar;

	@FXML
	private Button btNovo;

	@FXML
	private ImageView foto;

	@FXML
	private TableView<Map> tabela;

	@FXML
	private TableColumn tbId;
	
	@FXML
	private TableColumn tbUnidadeMorador;

	@FXML
	private TableColumn tbSituacao;

	@FXML
	private TableColumn tbContato;

	@FXML
	private TableColumn tbEmail;

	@FXML
	private TableColumn tbCorreios;

	@FXML
	private TableColumn tbInterfone;

	@FXML
	private TableColumn tbVagas;

	@FXML
	private Button btSelecionarFoto;
	
	File arquivoSelecionado;

	String pathImage = "";

	MoradorRepository repo = new MoradorRepository();

	@FXML
	public void cadastrarMorador(ActionEvent event){
		try{
			MoradorInput morador = new MoradorInput(null, unidadeMorador.getText(), situacao.getValue(), telefone.getText(),
					email.getText(), correspondecias.getValue(), interfone.getValue(), vaga.getText(), localizacao.getValue(), senha.getText(), pathImage, new Timestamp(System.currentTimeMillis()));
			
			repo.InserirMorador(morador);
		}catch(Exception e){
			System.out.println("ERRO AO TENTAR SALVAR MORADOR:: " + e.getMessage());
		}
	}
	
	@FXML
	public void limparCampos(ActionEvent event){
		unidadeMorador.setText("");
		telefone.setText("");
		email.setText("");
		vaga.setText("");
		senha.setText("");
	}

	public void selecionaArquivo(ActionEvent event) {
		FileChooser fc = new FileChooser();
		arquivoSelecionado = fc.showOpenDialog(null);

		if (arquivoSelecionado != null) {
			pathImage = arquivoSelecionado.getPath().replace("\\", "\\\\");
			System.out.println(pathImage);
			Image image = null;
			try {
				image = new Image(new FileInputStream(pathImage));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			foto.setImage(image);
			foto.setFitWidth(130);
			foto.setFitHeight(138);
		} else {
			System.out.println("Arquivo inv�lido!");
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		carregaSituacao();
		carregaCorrespondencia();
		carregaInterfone();
		carregaLocalizacao();
		carregarTabelaMoradores();
	}

	public void carregaSituacao() {
		ArrayList<String> situacoes = new ArrayList<>();

		situacoes.add("Proprietario");
		situacoes.add("Convidado");
		situacoes.add("Inquilino");

		ObservableList<String> obsSituacoes = FXCollections.observableArrayList(situacoes);
		this.situacao.setItems(obsSituacoes);

	}

	public void carregaCorrespondencia() {
		ArrayList<String> correspondecias = new ArrayList<>();

		correspondecias.add("Sim");
		correspondecias.add("Nao");

		ObservableList<String> obsCorrespondecia = FXCollections.observableArrayList(correspondecias);
		this.correspondecias.setItems(obsCorrespondecia);

	}

	public void carregaInterfone() {
		ArrayList<String> interfoneOps = new ArrayList<>();

		interfoneOps.add("Sim");
		interfoneOps.add("Nao");

		ObservableList<String> obsInterfone = FXCollections.observableArrayList(interfoneOps);
		this.interfone.setItems(obsInterfone);

	}

	public void carregaLocalizacao() {
		ArrayList<String> localizacoes = new ArrayList<>();

		localizacoes.add("Subterranea - Acesso A");
		localizacoes.add("Subterranea - Acesso B");
		localizacoes.add("Subterranea - Acesso C");
		localizacoes.add("Subterranea - Acesso D");

		ObservableList<String> obsLocalizacoes = FXCollections.observableArrayList(localizacoes);
		this.localizacao.setItems(obsLocalizacoes);

	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void carregarTabelaMoradores() {
		tbUnidadeMorador.setCellValueFactory(new MapValueFactory("unidadeMorador"));
		tbSituacao.setCellValueFactory(new MapValueFactory("situacao"));
		tbContato.setCellValueFactory(new MapValueFactory("telefone"));
		tbEmail.setCellValueFactory(new MapValueFactory("email"));
		tbCorreios.setCellValueFactory(new MapValueFactory("correios"));
		tbInterfone.setCellValueFactory(new MapValueFactory("interfone"));
		tbVagas.setCellValueFactory(new MapValueFactory("vagas"));
		tbId.setCellValueFactory(new MapValueFactory("id"));
		
		tabela.setItems(repo.getMoradores());
	}

	
	@FXML
	public void visualizarDados(MouseEvent event) {
		if(event.getClickCount() == 2) {
			//System.out.println(tbColaborador.getSelectionModel().getSelectedItem());
			MoradorInput morador = repo.getPorId(Integer.parseInt(tabela.getSelectionModel().getSelectedItem().get("id").toString()));
			unidadeMorador.setText(morador.getUnidadeMorador());
			email.setText(morador.getEmail());
			telefone.setText(morador.getTelefone());
			senha.setText(morador.getSenha());
			vaga.setText(morador.getVaga());
			situacao.setValue(morador.getSituacao());
			correspondecias.setValue(morador.getCorrespondencia());
			interfone.setValue(morador.getInterfone());
			localizacao.setValue(morador.getLocalizacao());
			foto.setImage(morador.getImgBD());
		}
	}
}
