package controller;

import java.io.IOException;

import application.Main;
import dao.ConexaoCliente;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class NovoNomeCliController {
	
	Alert alert = new Alert(Alert.AlertType.ERROR);
	Alert alert2 = new Alert(Alert.AlertType.ERROR);
	Alert alert3 = new Alert(Alert.AlertType.CONFIRMATION);
	Main m = new Main();
	ConexaoCliente conC = new ConexaoCliente();
	
	@FXML
	private Button btnVoltar;
	@FXML
	private TextField txtNovoNomeCli;
	@FXML
	private TextField txtBuscaCli;
	@FXML
	private Button btnAplicar;
	
	public NovoNomeCliController() {
		alert.setContentText("Preencha todos os campos. Não deixe nenhum em branco");
		alert2.setContentText("Cliente não cadastrado no sistema");
		alert3.setContentText("Nome alterado com suscesso");
	}
	
	public void onAplicarClick() throws IOException {
		if(txtBuscaCli.getText() != "") {
			if(txtNovoNomeCli.getText() != "") {
				if(conC.buscaCliente(txtBuscaCli.getText())){
				conC.alteraCliente(txtBuscaCli.getText(), txtNovoNomeCli.getText(), 1);
				alert3.show();
				m.changeScene("OqueAlterarCli.fxml");
				}else alert2.show();
			}else alert.show();
		} else alert.show();
	}
	
	public void onVoltarClick() throws IOException {
		m.changeScene("OqueAlterarCli.fxml");
	}
}
