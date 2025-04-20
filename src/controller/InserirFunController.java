package controller;

import java.io.IOException;

import application.Main;
import dao.ConexaoFuncionario;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class InserirFunController {
	
	Alert alert = new Alert(Alert.AlertType.ERROR);
	Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
	Alert alert3 = new Alert(Alert.AlertType.ERROR);
	Main m = new Main();
	ConexaoFuncionario conF = new ConexaoFuncionario();
	
	@FXML
	private TextField txtNomeFun;
	@FXML
	private TextField txtCPFFun;
	@FXML
	private TextField txtTelFun;
	@FXML
	private TextField txtEndFun;
	@FXML
	private TextField txtEmaFun;
	@FXML
	private Button btnAplicar;
	@FXML
	private Button btnVoltar;
	
	public InserirFunController() {
		alert.setContentText("Preencha todos os campos. Não deixe nenhum em branco");
		alert3.setContentText("Um funcionário com este CPF já está cadastrado no sistema");
	}

	public void onAplicarClick() throws IOException {
		if(txtNomeFun.getText() != "" && txtCPFFun.getText().toString() != "" && txtTelFun.getText().toString() != "" && txtEndFun.getText().toString() != "" && txtEmaFun.getText().toString() != "") {
			if(!conF.buscaCPFFuncionario(txtCPFFun.getText())) {
				conF.insereFuncionario(txtNomeFun.getText().toString(), txtCPFFun.getText().toString(), txtTelFun.getText().toString(), txtEndFun.getText().toString(), txtEmaFun.getText().toString());
				alert2.setContentText("O código do novo funcionário é: "+conF.selecionaCod(txtCPFFun.getText()));
				alert2.show();
				m.changeScene("GerFun.fxml");
			}else alert3.show();
		}else alert.show();
	}
	
	public void onVoltarClick() throws IOException {
		m.changeScene("GerFun.fxml");
	}
}
