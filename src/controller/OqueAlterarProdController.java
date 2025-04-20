package controller;

import java.io.IOException;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class OqueAlterarProdController {

	Main m = new Main();
	
	@FXML
	private Button btnVoltar;
	@FXML
	private Button btnNome;
	@FXML
	private Button btnValor;
	@FXML
	private Button btnRestante;
	
	public void onAltNomeClick() throws IOException {
		m.changeScene("NovoNomeProd.fxml");
	}
	public void onAltValorClick() throws IOException {
		m.changeScene("NovoValorProd.fxml");
	}
	public void onAltRestanteClick() throws IOException {
		m.changeScene("NovoRestanteProd.fxml");
	}
	public void onVoltarClick() throws IOException {
		m.changeScene("GerProd.fxml");
	}
}
