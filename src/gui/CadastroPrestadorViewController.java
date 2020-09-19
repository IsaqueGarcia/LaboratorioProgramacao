package gui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;

import input.PrestadorInput;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import repository.PrestadorRepository;

public class CadastroPrestadorViewController implements Initializable {

	@FXML
	private ImageView foto;
	@FXML
	private TextField nomeCompleto;
	@FXML
	private TextField email;
	@FXML
	private TextField login;
	@FXML
	private PasswordField senha;
	@FXML
	private ComboBox<String> atividade;
	@FXML
	private ComboBox<String> postoTrabalho;
	@FXML
	private TableView<Map> tbTerceiro;
	@FXML
	private TableColumn colId;
	@FXML
	private TableColumn colNome;
	@FXML
	private TableColumn colEmail;
	@FXML
	private TableColumn colAtividade;
	@FXML
	private TableColumn colPostoTrabalho;
	
	@FXML
	private Button btSelecionarFoto;

	@FXML
	private Button btCadastrarPrestador;
	
	File arquivoSelecionado;

	String pathImage = "";

	PrestadorRepository r = new PrestadorRepository();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		carregaAtividades();
		carregaLocalTrabalho();
		carregarTabelaPrestadores();
	}
	
	
	public void cadastrarPrestador(ActionEvent event) {
		try {
			
			PrestadorInput input = new PrestadorInput(null,
					nomeCompleto.getText(),
					email.getText(),
					postoTrabalho.getValue(),
					atividade.getValue(),
					login.getText(),
					senha.getText(),
					pathImage,
					new Timestamp(System.currentTimeMillis()));
			
			r.InserirPrestador(input);
			
			nomeCompleto.setText("");
			email.setText("");
			login.setText("");
			senha.setText("");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	
	

	public void carregaAtividades() {
		ArrayList<String> atividades = new ArrayList<>();

		atividades.add("ENCANADOR");
		atividades.add("ELETRICISTA");
		atividades.add("DIARISTA");
		atividades.add("JARDINEIRO");

		ObservableList<String> obsAtividades = FXCollections.observableArrayList(atividades);
		atividade.setItems(obsAtividades);

	}

	public void carregaLocalTrabalho() {
		ArrayList<String> localTrabalhoLista = new ArrayList<>();

		localTrabalhoLista.add("SANTANA - SAO PAULO");
		localTrabalhoLista.add("EUSEBIO - BUTATA");
		localTrabalhoLista.add("SUMARE - SAO PAULO");

		ObservableList<String> obsLocalTrabalho = FXCollections.observableArrayList(localTrabalhoLista);
		postoTrabalho.setItems(obsLocalTrabalho);

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
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void carregarTabelaPrestadores() {
		colId.setCellValueFactory(new MapValueFactory("col_id"));
		colNome.setCellValueFactory(new MapValueFactory("col_nome"));
		colEmail.setCellValueFactory(new MapValueFactory("col_email"));
		colAtividade.setCellValueFactory(new MapValueFactory("col_atividade"));
		colPostoTrabalho.setCellValueFactory(new MapValueFactory("col_localTrabalho"));
		
		tbTerceiro.setItems(r.getPrestadores());
	}
	
	
	@FXML
	public void visualizarDados(MouseEvent event) {
		if(event.getClickCount() == 2) {
			//System.out.println(tbColaborador.getSelectionModel().getSelectedItem());
			PrestadorInput prestador = r.getPorId(Integer.parseInt(tbTerceiro.getSelectionModel().getSelectedItem().get("col_id").toString()));
			nomeCompleto.setText(prestador.getNomeCompleto());
			email.setText(prestador.getEmail());
			login.setText(prestador.getUsuario());
			senha.setText(prestador.getSenha());
		}
	}

}
