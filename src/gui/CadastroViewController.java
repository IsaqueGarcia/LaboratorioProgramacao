package gui;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

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
	
	File arquivoSelecionado;

	
	public void cadastrarColaborador(ActionEvent event){
		try{

			//String pathImage = StringUtils.isEmpty(arquivoSelecionado.getPath()) ? " " : arquivoSelecionado.getPath().replace("\\", "\\\\");

			
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}

	}
	
	
	public void selecionaArquivo(ActionEvent event){
		FileChooser fc = new FileChooser();
		arquivoSelecionado = fc.showOpenDialog(null);
		
		if(arquivoSelecionado != null){
			String pathImage = arquivoSelecionado.getPath().replace("\\", "\\\\");
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
	}
	
	public void carregaAtividades(){
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
	
	public void carregaLocalTrabalho(){
		ArrayList<String> localTrabalhoLista = new ArrayList<>();
		
		localTrabalhoLista.add("SANTANA - SAO PAULO");
		localTrabalhoLista.add("EUSEBIO - BUTATA");
		
		ObservableList<String> obsLocalTrabalho = FXCollections.observableArrayList(localTrabalhoLista);
		localTrabalho.setItems(obsLocalTrabalho);
		
	}

}
