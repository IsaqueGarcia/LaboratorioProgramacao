package gui;

import input.FuncionarioInput;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import repository.FuncionarioRepository;

public class CadastrarFuncionarioViewController {

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
	private ComboBox<String> diretoria;
	@FXML
	private ComboBox<String> tipoDeconta
	;

//	@FXML
//	private TableView<Map> tbFuncionario;
//	
//	@FXML
//	private TableColumn colId;
//	@FXML
//	private TableColumn colNome;
//	@FXML
//	private TableColumn colEmail;
//	@FXML
//	private TableColumn colTelefone;
//	@FXML
//	private TableColumn colTipoConta;
//	@FXML
//	private TableColumn colDiretoria;
	
	
	FuncionarioRepository r = new FuncionarioRepository();

	public void cadastrarColaborador(ActionEvent event) {
		try {

//			FuncionarioInput input = new FuncionarioInput(null,nomeCompleto.getText(), email.getText(), telefone.getText(),
//					diretoria.getValue(),tipoDeconta.getValue(), login.getText(), senha.getText());
//			r.InserirFuncionario(input);
			
			nomeCompleto.setText("");
			email.setText("");
			telefone.setText("");
			login.setText("");
			senha.setText("");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
}
