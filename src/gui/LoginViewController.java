package gui;

import java.io.IOException;

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


public class LoginViewController {

	@FXML
	private Button btEntrar;
	
	@FXML
	private TextField inputLogin;
	
	@FXML
	private PasswordField inputSenha;

	
	@FXML
	public void onBtEnterAction(ActionEvent event){
        try {
			Parent parent = FXMLLoader.load(getClass().getResource("Home.fxml"));
			Scene scene = new Scene(parent);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
			((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	

	
}
