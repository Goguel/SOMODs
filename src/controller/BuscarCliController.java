package controller;

import java.io.IOException;

import application.Main;
import dao.ConexaoCliente;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BuscarCliController {
	
	Alert alert = new Alert(Alert.AlertType.ERROR);
	Alert alert2 = new Alert(Alert.AlertType.ERROR);
	Main m = new Main();
	ConexaoCliente conC = new ConexaoCliente();
	
	@FXML
	private TextField txtBuscaCli;
	@FXML
	private Button btnBuscar;
	@FXML
	private Button btnVoltar;
	@FXML
	private Label lblInsereCPF;
	@FXML
	private Label lblNomeCli;
	@FXML
	private Label lblCPFCli;
	@FXML
	private Label lblTelefoneCli;
	@FXML
	private Label lblEnderecoCli;
	@FXML
	private Label lblEmailCli;
	@FXML
	private Label lblNomeCli1;
	@FXML
	private Label lblCPFCli1;
	@FXML
	private Label lblTelefoneCli1;
	@FXML
	private Label lblEnderecoCli1;
	@FXML
	private Label lblEmailCli1;
	
	public BuscarCliController() {
		alert.setContentText("Preencha todos os campos. Não deixe nenhum em branco");
		alert2.setContentText("Cliente não cadastrado no sistema");
	}

	public void onBuscarClick() throws IOException {
		if(txtBuscaCli.getText() != "") {
			if(conC.buscaCliente(txtBuscaCli.getText())){
				lblInsereCPF.setOpacity(0);
			   	btnBuscar.setOpacity(0);
			   	txtBuscaCli.setOpacity(0);
			   	lblNomeCli.setText("Nome do cliente:");
			   	lblCPFCli.setText("CPF do cliente:");
			   	lblTelefoneCli.setText("Telefone do cliente:");
			   	lblEnderecoCli.setText("Endereço do cliente:");
			   	lblEmailCli.setText("Email do cliente:");
			   	lblNomeCli1.setText(conC.selecionaNomeCliente(txtBuscaCli.getText()));
			   	lblCPFCli1.setText(conC.selecionaCPFCliente(txtBuscaCli.getText()));
			   	lblTelefoneCli1.setText(conC.selecionaTelefoneCliente(txtBuscaCli.getText()));
			   	lblEnderecoCli1.setText(conC.selecionaEnderecoCliente(txtBuscaCli.getText()));
			   	lblEmailCli1.setText(conC.selecionaEmailCliente(txtBuscaCli.getText()));
			   	
			}else {
				alert2.show();
			}
		}else alert.show();				
	}
	
	public void onVoltarClick() throws IOException {
		m.changeScene("GerCli.fxml");
	}
}
