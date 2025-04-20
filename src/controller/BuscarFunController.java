package controller;

import java.io.IOException;

import application.Main;
import dao.ConexaoFuncionario;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BuscarFunController {
	
	Alert alert = new Alert(Alert.AlertType.ERROR);
	Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
	Alert alert3 = new Alert(Alert.AlertType.ERROR);
	Main m = new Main();
	ConexaoFuncionario conF = new ConexaoFuncionario();
	
	@FXML
	private TextField txtBuscaFun;
	@FXML
	private Button btnBuscar;
	@FXML
	private Button btnVoltar;
	@FXML
	private Label lblInsereCod;
	@FXML
	private Label lblNomeFun;
	@FXML
	private Label lblCPFFun;
	@FXML
	private Label lblTelefoneFun;
	@FXML
	private Label lblEnderecoFun;
	@FXML
	private Label lblEmailFun;
	@FXML
	private Label lblCodFun;
	@FXML
	private Label lblNomeFun1;
	@FXML
	private Label lblCPFFun1;
	@FXML
	private Label lblTelefoneFun1;
	@FXML
	private Label lblEnderecoFun1;
	@FXML
	private Label lblEmailFun1;
	@FXML
	private Label lblCodFun1;
	
	public BuscarFunController() {
		alert.setContentText("Preencha todos os campos. Não deixe nenhum em branco");
		alert2.setContentText("Funcionário inserido no sistema com suscesso");
		alert3.setContentText("Funcionário não cadastrado no sistema");
	}

	public void onBuscarClick() throws IOException {
		if(txtBuscaFun.getText() != "") {
			if(conF.buscaFuncionario(Integer.parseInt(txtBuscaFun.getText()))){
				lblInsereCod.setOpacity(0);
			   	btnBuscar.setOpacity(0);
			   	txtBuscaFun.setOpacity(0);
			   	lblNomeFun.setText("Nome do funcionário:");
			   	lblCPFFun.setText("CPF do funcionário:");
			   	lblTelefoneFun.setText("Telefone do funcionário:");
			   	lblEnderecoFun.setText("Endereço do funcionário:");
			   	lblEmailFun.setText("Email do funcionário:");
			   	lblCodFun.setText("Código do funcionário:" );
			   	lblNomeFun1.setText(conF.selecionaNomeFunc(Integer.parseInt(txtBuscaFun.getText())));
			   	lblCPFFun1.setText(conF.selecionaCPFFunc(Integer.parseInt(txtBuscaFun.getText())));
			   	lblTelefoneFun1.setText(conF.selecionaTelefoneFunc(Integer.parseInt(txtBuscaFun.getText())));
			   	lblEnderecoFun1.setText(conF.selecionaEnderecoFunc(Integer.parseInt(txtBuscaFun.getText())));
			   	lblEmailFun1.setText(conF.selecionaEmailFunc(Integer.parseInt(txtBuscaFun.getText())));
			   	lblCodFun1.setText(conF.selecionaCodFunc(Integer.parseInt(txtBuscaFun.getText())));
			   	
			}else {
				alert3.show();
			}
		}else alert.show();				
	}
	
	public void onVoltarClick() throws IOException {
		m.changeScene("GerFun.fxml");
	}
}
