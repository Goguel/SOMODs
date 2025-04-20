package controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import dao.ConexaoFuncionario;
import javafx.scene.control.Alert;

public class MainSceneController {
	
	ConexaoFuncionario conF = new ConexaoFuncionario();
	Alert alert = new Alert(Alert.AlertType.ERROR);
	
	@FXML
	private Button btnlogin;
	@FXML
	private TextField txtUsername;
	@FXML
	private PasswordField txtpassword;

	public void onLoginClick() throws IOException {
		if(txtUsername.getText() != "" && txtpassword.getText() != "") {
			conF.entraFuncionario(txtUsername.getText(), txtpassword.getText());
		}else {
			alert.setContentText("Preencha todos os campos. Não deixe nenhum em branco");
			alert.show();
		}
	}
}
