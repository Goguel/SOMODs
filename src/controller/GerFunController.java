package controller;

import java.io.IOException;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class GerFunController {
	
	@FXML
	private Button btnVoltar;
	@FXML
	private Button btnbtnInsFun;
	@FXML
	private Button btnBusFun;
	@FXML
	private Button btnAltFun;
	@FXML
	private Button btnRemFun;
	
	Main m = new Main();
	
	public void onInsFunClick() throws IOException {
		m.changeScene("InserirFun.fxml");
	}
	
	public void onBusFunClick() throws IOException {
		m.changeScene("BuscarFun.fxml");	
	}
	
	public void onAltFunClick() throws IOException {
		m.changeScene("OqueAlterarFun.fxml");
	}
	
	public void onRemFunClick() throws IOException {
		m.changeScene("RemoverFun.fxml");
	}
	
	public void onVoltarClick() throws IOException {
		m.changeScene("AfterLogin.fxml");
	}
}

