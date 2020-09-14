package gui;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HomeViewController {
	
	@FXML
	private Button btCadastrar;
	
	@FXML
	private Button btSair;
	
	@FXML
	private Label nomeColaborador;
	
	@FXML
	private Label atividade;
	
	@FXML
	private Label localTrabalho;
	
	@FXML
	public void onBtCadastrarAction(ActionEvent event){
        try {
			Parent parent = FXMLLoader.load(getClass().getResource("Cadastro.fxml"));
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
	
	@FXML
	public void onBtSairAction(){
		Platform.exit();
	}
}
