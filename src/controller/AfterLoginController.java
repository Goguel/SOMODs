package controller;

import java.io.IOException;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class AfterLoginController {
	
	Alert alert = new Alert(Alert.AlertType.INFORMATION);
	
	@FXML
	private Button btnGerCli;
	@FXML
	private Button btnGerFun;
	@FXML
	private Button btnGerPro;
	@FXML
	private Button btnGerVen;
	@FXML
	private Button btnLogOut;
	
	Main m = new Main();
	
	public void onGerCliClick() throws IOException {
		m.changeScene("GerCli.fxml");
	}
	
	public void onGerFunClick() throws IOException {
		alert.setContentText("Faça login novamente");
		alert.show();
		m.changeScene("Confirmacao.fxml");
	}	
	
	public void onGerProClick() throws IOException {
		m.changeScene("GerProd.fxml");
	}
	
	public void onGerVenClick() throws IOException {
		m.changeScene("GerVen.fxml");
	}
	
	public void onLogOutClick(ActionEvent event) throws IOException {
		m.changeScene("MainScene.fxml");
	}
}
