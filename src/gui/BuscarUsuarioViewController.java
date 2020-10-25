package gui;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import input.FuncionarioInput;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.control.cell.PropertyValueFactory;
import repository.FuncionarioRepository;

public class BuscarUsuarioViewController implements Initializable{

	@FXML
	private TextField txtPesquisar;
	@FXML
	private Button btnPesquisar;
	@FXML
	private TableView<Map> tbFuncionarios;
	@FXML
	private TableColumn colNome;
	@FXML
	private TableColumn colTelefone;
	@FXML
	private TableColumn colEmail;
	@FXML
	private TableColumn colTipoConta;
	@FXML
	private TableColumn colDiretoria;
	@FXML
	private TableColumn colBtn;
	
	private ObservableList<Map>  listaFuncionarios;
	
	FuncionarioRepository r = new FuncionarioRepository();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.carregarTabelaFuncionarios();
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void carregarTabelaFuncionarios() {
		Button btn = new Button("Deletar");
		
		colNome.setCellValueFactory(new MapValueFactory("col_nome"));
		colTelefone.setCellValueFactory(new MapValueFactory("col_telefone"));
		colEmail.setCellValueFactory(new MapValueFactory("col_email"));
		colTipoConta.setCellValueFactory(new MapValueFactory("col_tipoConta"));
		colDiretoria.setCellValueFactory(new MapValueFactory("col_diretoria"));
		//colBtn.setCellValueFactory();
		
		tbFuncionarios.setItems(r.getFuncionarios());
		listaFuncionarios = r.getFuncionarios();
	}
	
	public void buscarFuncionario() {
		if(txtPesquisar.getText().equals("")) {
			this.carregarTabelaFuncionarios();
		}else {
			ObservableList<Map> listaAposBusca = FXCollections.observableArrayList();
			for(Map map : listaFuncionarios) {
				if(map.get("col_nome").equals(txtPesquisar.getText().toUpperCase())) {
					Map<String, String> funcionario = new HashMap<String, String>();
					funcionario.put("col_nome", map.get("col_nome").toString());
					funcionario.put("col_telefone", map.get("col_telefone").toString());
					funcionario.put("col_email", map.get("col_email").toString());
					funcionario.put("col_tipoConta", map.get("col_tipoConta").toString());
					funcionario.put("col_diretoria", map.get("col_diretoria").toString());
					listaAposBusca.add(funcionario);
				}
				
			}
			tbFuncionarios.setItems(listaAposBusca);
		}
	}
	

	public TextField getTxtPesquisar() {
		return txtPesquisar;
	}


	public void setTxtPesquisar(TextField txtPesquisar) {
		this.txtPesquisar = txtPesquisar;
	}


	public Button getBtnPesquisar() {
		return btnPesquisar;
	}


	public void setBtnPesquisar(Button btnPesquisar) {
		this.btnPesquisar = btnPesquisar;
	}


	public TableView<Map> getTbFuncionarios() {
		return tbFuncionarios;
	}


	public void setTbFuncionarios(TableView<Map> tbFuncionarios) {
		this.tbFuncionarios = tbFuncionarios;
	}


	public TableColumn getColNome() {
		return colNome;
	}


	public void setColNome(TableColumn colNome) {
		this.colNome = colNome;
	}


	public TableColumn getColTelefone() {
		return colTelefone;
	}


	public void setColTelefone(TableColumn colTelefone) {
		this.colTelefone = colTelefone;
	}


	public TableColumn getColEmail() {
		return colEmail;
	}


	public void setColEmail(TableColumn colEmail) {
		this.colEmail = colEmail;
	}


	public TableColumn getColTipoConta() {
		return colTipoConta;
	}


	public void setColTipoConta(TableColumn colTipoConta) {
		this.colTipoConta = colTipoConta;
	}


	public TableColumn getColDiretoria() {
		return colDiretoria;
	}


	public void setColDiretoria(TableColumn colDiretoria) {
		this.colDiretoria = colDiretoria;
	}


	public ObservableList<Map> getListaFuncionarios() {
		return listaFuncionarios;
	}


	public void setListaFuncionarios(ObservableList<Map> listaFuncionarios) {
		this.listaFuncionarios = listaFuncionarios;
	}
	
	
	
	
}
