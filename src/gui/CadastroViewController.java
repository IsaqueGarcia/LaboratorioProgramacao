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
import repository.ColaboradorRepository;

public class CadastroViewController implements Initializable {

	@FXML
	private TextField nomeCompleto;
	@FXML
	private TextField email;
	@FXML
	private TextField telefone;
	@FXML
	private TextField login;
	@FXML
	private TextField senha;
	@FXML
	private Button btCadastrar;
	@FXML
	private ComboBox<String> atividade;
	@FXML
	private ComboBox<String> localTrabalho;
	@FXML
	private ImageView foto;
	@FXML
	private Button selecionarFoto;
	@FXML
	private TableView<Map> tbColaborador;
	@FXML
	private TableColumn colId;
	@FXML
	private TableColumn colNome;
	@FXML
	private TableColumn colEmail;
	@FXML
	private TableColumn colTelefone;
	@FXML
	private TableColumn colAtividade;
	@FXML
	private TableColumn colLocalDeTrabalho;
	

	File arquivoSelecionado;
	
	String pathImage = "";
	
	ColaboradorRepository r = new ColaboradorRepository();

	public void cadastrarColaborador(ActionEvent event) {
		try {

			ColaboradorInput input = new ColaboradorInput(nomeCompleto.getText(), email.getText(), telefone.getText(),
					localTrabalho.getValue(),atividade.getValue(), login.getText(), senha.getText(), pathImage,  new Timestamp(System.currentTimeMillis()));
			r.InserirColaborador(input);
			
			nomeCompleto.setText("");
			email.setText("");
			telefone.setText("");
			login.setText("");
			senha.setText("");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

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
		carregaAtividades();
		carregaLocalTrabalho();
		carregarTabelaColaboradores();
	}

	public void carregaAtividades() {
		ArrayList<String> atividades = new ArrayList<>();

		atividades.add("Estagiario");
		atividades.add("Diretor TI");
		atividades.add("Engenheiro de software");
		atividades.add("Arquiteto de redes");
		atividades.add("Desenvolvedor Junior");
		atividades.add("Desenvolvedor pleno");
		atividades.add("Desenvolvedor senior");
		atividades.add("Gerente TI");
		atividades.add("Negocios");
		atividades.add("Suporte TI");
		atividades.add("Q&A");

		ObservableList<String> obsAtividades = FXCollections.observableArrayList(atividades);
		atividade.setItems(obsAtividades);

	}

	public void carregaLocalTrabalho() {
		ArrayList<String> localTrabalhoLista = new ArrayList<>();

		localTrabalhoLista.add("SANTANA - SAO PAULO");
		localTrabalhoLista.add("EUSEBIO - BUTATA");

		ObservableList<String> obsLocalTrabalho = FXCollections.observableArrayList(localTrabalhoLista);
		localTrabalho.setItems(obsLocalTrabalho);

	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void carregarTabelaColaboradores() {
		colId.setCellValueFactory(new MapValueFactory("col_id"));
		colNome.setCellValueFactory(new MapValueFactory("col_nome"));
		colEmail.setCellValueFactory(new MapValueFactory("col_email"));
		colAtividade.setCellValueFactory(new MapValueFactory("col_atividade"));
		colTelefone.setCellValueFactory(new MapValueFactory("col_telefone"));
		colLocalDeTrabalho.setCellValueFactory(new MapValueFactory("col_localTrabalho"));
		
		tbColaborador.setItems(r.getColaboradores());
	}
	
	@FXML
	public void visualizarDados(MouseEvent event) {
		if(event.getClickCount() == 2) {
			//System.out.println(tbColaborador.getSelectionModel().getSelectedItem());
			ColaboradorInput colaborador = r.getPorId(Integer.parseInt(tbColaborador.getSelectionModel().getSelectedItem().get("col_id").toString()));
			nomeCompleto.setText(colaborador.getNomeCompleto());
			email.setText(colaborador.getEmail());
			telefone.setText(colaborador.getTelefone());
			login.setText(colaborador.getUsuario());
			senha.setText(colaborador.getSenha());
			atividade.setValue(colaborador.getAtividade());
			localTrabalho.setValue(colaborador.getPostoTrabalho());
			foto.setImage(colaborador.getImgBD());
		}
	}
	
}
