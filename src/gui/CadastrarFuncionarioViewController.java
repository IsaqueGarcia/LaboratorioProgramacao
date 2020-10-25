package gui;

import java.math.BigInteger;
import java.net.URL;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;

import input.FuncionarioInput;
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
import repository.FuncionarioRepository;
import util.UtilMask;

public class CadastrarFuncionarioViewController implements Initializable{

	@FXML
	private TextField id;
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
	private Button btLimpar;
	@FXML
	private ComboBox<String> diretoria;
	@FXML
	private ComboBox<String> tipoDeconta
	;

	@FXML
	private TableView<Map> tbFuncionario;
	
	@FXML
	private TableColumn colId;
	@FXML
	private TableColumn colNome;
	@FXML
	private TableColumn colEmail;
	@FXML
	private TableColumn colTelefone;
	@FXML
	private TableColumn colTipoConta;
	@FXML
	private TableColumn colDiretoria;
	
	FuncionarioRepository r = new FuncionarioRepository();

	public void cadastrarFuncionario(ActionEvent event) {
		try {

			FuncionarioInput input = new FuncionarioInput(!id.getText().isEmpty() ? Integer.parseInt(id.getText()) : null,nomeCompleto.getText().toUpperCase(), email.getText(), telefone.getText(),
					diretoria.getValue(),tipoDeconta.getValue(), login.getText(), this.criptografar(senha.getText()));
			r.InserirFuncionario(input);
			
			nomeCompleto.setText("");
			email.setText("");
			telefone.setText("");
			login.setText("");
			senha.setText("");
			id.setText("");
			
			carregaTabelaFuncionarios();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	public void limparCampos(ActionEvent event){
		nomeCompleto.setText("");
		email.setText("");
		telefone.setText("");
		login.setText("");
		senha.setText("");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		funcionarioOutraTela();
		carregaDiretoria();
		carregaTipoConta();
		carregaTabelaFuncionarios();
		UtilMask.foneField(this.telefone);
	}
	
	public void carregaTipoConta(){
		ArrayList<String> tipoDeContas = new ArrayList<>();

		tipoDeContas.add("COORDENADOR");
		tipoDeContas.add("DIRETOR");
		tipoDeContas.add("PROFESSOR");
		tipoDeContas.add("RH");

		ObservableList<String> obsTipoConta = FXCollections.observableArrayList(tipoDeContas);
		this.tipoDeconta.setItems(obsTipoConta);
	}
	
	public void carregaDiretoria() {
		ArrayList<String> diretorias = new ArrayList<>();

		diretorias.add("ADMINISTRACAO");
		diretorias.add("CIENCIAS CONTABEIS");
		diretorias.add("DIREITO");
		diretorias.add("PEDAGOGIA");
		diretorias.add("SISTEMAS DE INFORMACAO");
		diretorias.add("MARKETING");
		diretorias.add("RECURSOS HUMANOS");
		diretorias.add("GESTAO FINANCEIRA");
		diretorias.add("LOGISTICA");

		ObservableList<String> obsDiretoria = FXCollections.observableArrayList(diretorias);
		this.diretoria.setItems(obsDiretoria);

	}
	
	public static String criptografar(String senha) {
		String retorno = "";
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
			retorno = hash.toString(16);
		} catch (Exception e) {
			System.out.println("ERRO  NA CRIPTOGRAFIA .: " + e.getMessage());
		}

		return retorno;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void carregaTabelaFuncionarios() {
		colId.setCellValueFactory(new MapValueFactory("col_id"));
		colNome.setCellValueFactory(new MapValueFactory("col_nome"));
		colEmail.setCellValueFactory(new MapValueFactory("col_email"));
		colDiretoria.setCellValueFactory(new MapValueFactory("col_diretoria"));
		colTelefone.setCellValueFactory(new MapValueFactory("col_telefone"));
		colTipoConta.setCellValueFactory(new MapValueFactory("col_tipo_conta"));
		
		tbFuncionario.setItems(r.carregaTbFuncionarios());
	}
	
	@FXML
	public void visualizarDados(MouseEvent event) {
		if(event.getClickCount() == 2) {
			FuncionarioInput funcionario = r.getFuncionarioPorId(Integer.parseInt(tbFuncionario.getSelectionModel().getSelectedItem().get("col_id").toString()));
			nomeCompleto.setText(funcionario.getNomeCompleto());
			email.setText(funcionario.getEmail());
			telefone.setText(funcionario.getTelefone());
			login.setText(funcionario.getLogin());
			senha.setText(funcionario.getSenha());
			id.setText(funcionario.getId().toString());
		}
	}
	
	public void funcionarioOutraTela() {
		if(BuscarUsuarioViewController.funcionarioInput != null) {
			nomeCompleto.setText(BuscarUsuarioViewController.getNomeCompleto());
			email.setText(BuscarUsuarioViewController.getEmail());
			telefone.setText(BuscarUsuarioViewController.getTelefone());
			login.setText(BuscarUsuarioViewController.getLogin());
			senha.setText(BuscarUsuarioViewController.getSenha());
			id.setText(BuscarUsuarioViewController.getFuncionarioId().toString());
			tipoDeconta.setValue(BuscarUsuarioViewController.getTipoConta());
			diretoria.setValue(BuscarUsuarioViewController.getDiretoria());
		}
	}

	
}