package controller;

import java.io.IOException;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import dao.ConexaoFuncionario;
import javafx.scene.control.Alert;

public class ConfirmacaoController {
	
	ConexaoFuncionario conF = new ConexaoFuncionario();
	Alert alert = new Alert(Alert.AlertType.ERROR);
	Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
	Main m = new Main();
	
	@FXML
	private Button btnlogin;
	@FXML
	private TextField txtUsername;
	@FXML
	private PasswordField txtpassword;

	/*public void onLoginClick(ActionEvent event) throws IOException {
		checkLogin();
	}*/
	
	public void onLoginClick() throws IOException {
		if(txtUsername.getText() != "" && txtpassword.getText() != "") {
			if(txtUsername.getText().equals("1") && txtpassword.getText().equals("00000000000")) {
				m.changeScene("GerFun.fxml");
				alert2.setContentText("Autenticado com suscesso");
				alert2.show();
			}else {
				alert.setContentText("Credenciais erradas");
				alert.show();
			}
			
		}else {
			alert.setContentText("Preencha todos os campos. Não deixe nenhum em branco");
			alert.show();
		}
	}
}
