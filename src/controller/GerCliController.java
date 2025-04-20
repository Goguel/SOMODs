package controller;

import java.io.IOException;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class GerCliController {
	
	@FXML
	private Button btnVoltar;
	@FXML
	private Button btnbtnInsCli;
	@FXML
	private Button btnBusCli;
	@FXML
	private Button btnAltCli;
	@FXML
	private Button btnRemCli;
	
	Main m = new Main();
	
	public void onInsCliClick() throws IOException {
		m.changeScene("InserirCli.fxml");
	}
	
	public void onBusCliClick() throws IOException {
		m.changeScene("BuscarCli.fxml");	
	}
	
	public void onAltCliClick() throws IOException {
		m.changeScene("OqueAlterarCli.fxml");
	}
	
	public void onRemCliClick() throws IOException {
		m.changeScene("RemoverCli.fxml");
	}
	
	public void onVoltarClick() throws IOException {
		m.changeScene("AfterLogin.fxml");
	}
}
