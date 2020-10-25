package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import input.ColaboradorInput;
import input.FuncionarioInput;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HomeViewController implements Initializable{
		
	@FXML
	private Button btCadastrar;
	
	@FXML
	private Button btSair;
	
	@FXML 
	private Button btCadastrarPrestador;
	
	@FXML
	private Button btProtocolo;
	
	@FXML
	private Button btBuscarFuncionario;
	
	@FXML
	private Button btChaves;
	
	@FXML
	private Label nomeFuncionario;
	
	@FXML
	private Label tipoConta;
	
	@FXML
	private Label diretoria;
	
	FuncionarioInput funcionario;
	
	@FXML
	public void onBtCadastrarAction(ActionEvent event){
        try {
			Parent parent = FXMLLoader.load(getClass().getResource("Cadastro.fxml"));
			Scene scene = new Scene(parent);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	@FXML
	public void onBtCadastrarPrestador(ActionEvent event){
        try {
			Parent parent = FXMLLoader.load(getClass().getResource("CadastroPrestador.fxml"));
			Scene scene = new Scene(parent);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	@FXML
	public void onBtBuscarFuncionario(ActionEvent event){
        try {
			Parent parent = FXMLLoader.load(getClass().getResource("BuscarUsuario.fxml"));
			Scene scene = new Scene(parent);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	@FXML
	public void onBtChave(ActionEvent event){
        try {
			Parent parent = FXMLLoader.load(getClass().getResource("Chaves.fxml"));
			Scene scene = new Scene(parent);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	@FXML
	public void onBtProtocolo(ActionEvent event){
        try {
			Parent parent = FXMLLoader.load(getClass().getResource("Protocolo.fxml"));
			Scene scene = new Scene(parent);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	@FXML
	public void onBtSairAction(){
		Platform.exit();
	}
	
	public void carregarInformacoes(String nome,String tipoConta, String diretoria){
		try{
			this.nomeFuncionario.setText("Nome do funcionário: " + nome);
			this.tipoConta.setText("Tipo de conta: " + tipoConta);
			this.diretoria.setText("Diretoria: " + diretoria);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	@SuppressWarnings("static-access")
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		LoginViewController login = new LoginViewController();
		this.carregarInformacoes(login.retornarFuncionario(), login.retornarTipoConta(), login.retornarDiretoria());
	}

	
}
