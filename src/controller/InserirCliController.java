package controller;

import java.io.IOException;

import application.Main;
import dao.ConexaoCliente;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class InserirCliController {
	
	Alert alert = new Alert(Alert.AlertType.ERROR);
	Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
	Alert alert3 = new Alert(Alert.AlertType.ERROR);
	Main m = new Main();
	ConexaoCliente conC = new ConexaoCliente();
	
	@FXML
	private TextField txtNomeCli;
	@FXML
	private TextField txtCPFCli;
	@FXML
	private TextField txtTelCli;
	@FXML
	private TextField txtEndCli;
	@FXML
	private TextField txtEmaCli;
	@FXML
	private Button btnAplicar;
	@FXML
	private Button btnVoltar;
	
	public InserirCliController() {
		alert.setContentText("Preencha todos os campos. Não deixe nenhum em branco");
		alert2.setContentText("Cliente inserido no sistema com suscesso");
		alert3.setContentText("Um cliente com este CPF já está cadastrado no sistema");
	}

	public void onAplicarClick() throws IOException {
		if(txtNomeCli.getText() != "" && txtCPFCli.getText().toString() != "" && txtTelCli.getText().toString() != "" && txtEndCli.getText().toString() != "" && txtEmaCli.getText().toString() != "") {
			if(!conC.buscaCliente(txtCPFCli.getText())) {
				conC.insereCliente(txtNomeCli.getText().toString(), txtCPFCli.getText().toString(), txtTelCli.getText().toString(), txtEndCli.getText().toString(), txtEmaCli.getText().toString());
				alert2.show();
				m.changeScene("GerCli.fxml");
			}else alert3.show();
		}else alert.show();
	}
	
	public void onVoltarClick() throws IOException {
		m.changeScene("GerCli.fxml");
	}
}
