package gui;

import com.mysql.jdbc.StringUtils;

import input.FuncionarioInput;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import repository.LoginRepository;
import util.Popup;


public class LoginViewController {

	@FXML
	private Button btEntrar;
	
	@FXML
	private TextField inputLogin;
	
	@FXML
	private PasswordField inputSenha;

	
	LoginRepository repo = new LoginRepository();
	
	static FuncionarioInput result = new FuncionarioInput();

	@FXML
	public void onBtEnterAction(ActionEvent event){
        try {
        	
        	 result = repo.validarLogin(inputLogin.getText(), CadastrarFuncionarioViewController.criptografar(inputSenha.getText()));
        	 
        	if(!StringUtils.isNullOrEmpty(inputLogin.getText()) && !StringUtils.isNullOrEmpty(inputSenha.getText()) ){
        		
            	if(result.getLogin().equals(inputLogin.getText()) && result.getSenha().equals(CadastrarFuncionarioViewController.criptografar(inputSenha.getText()))){
        			Parent parent = FXMLLoader.load(getClass().getResource("Home.fxml"));
        			Scene scene = new Scene(parent);
        			Stage stage = new Stage();
        			stage.setScene(scene);
        			stage.show();
        			((Node)(event.getSource())).getScene().getWindow().hide();
            	}else {
            		Popup.infoDialog("Info", "Informações", "Usuário ou senha invalido!");
            	}
        		
        	}
        	


        }
        catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	public static String retornarFuncionario(){
		return result.getNomeCompleto();
	}
	
	public static String retornarTipoConta() {
		return result.getTipoDeConta();
	}

	public static String retornarDiretoria() {
		return result.getDiretoria();
	}
	
}
