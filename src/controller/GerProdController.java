package controller;

import java.io.IOException;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class GerProdController {
	
	@FXML
	private Button btnVoltar;
	@FXML
	private Button btnbtnInsProd;
	@FXML
	private Button btnBusProd;
	@FXML
	private Button btnAltProd;
	@FXML
	private Button btnRemProd;
	
	Main m = new Main();
	
	public void onInsProdClick() throws IOException {
		m.changeScene("InserirProd.fxml");
	}
	
	public void onBusProdClick() throws IOException {
		m.changeScene("BuscarProd.fxml");	
	}
	
	public void onAltProdClick() throws IOException {
		m.changeScene("OqueAlterarProd.fxml");
	}
	
	public void onRemProdClick() throws IOException {
		m.changeScene("RemoverProd.fxml");
	}
	
	public void onVoltarClick() throws IOException {
		m.changeScene("AfterLogin.fxml");
	}
}

